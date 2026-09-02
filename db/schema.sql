CREATE DATABASE IF NOT EXISTS deepcare DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE deepcare;

CREATE TABLE IF NOT EXISTS user_account (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    display_name VARCHAR(64) NOT NULL,
    phone VARCHAR(32),
    email VARCHAR(128),
    status TINYINT NOT NULL DEFAULT 1 COMMENT '1启用，0停用',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted TINYINT NOT NULL DEFAULT 0
) ENGINE=InnoDB COMMENT='用户账号';

CREATE TABLE IF NOT EXISTS health_profile (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL UNIQUE,
    gender VARCHAR(16),
    birth_date DATE,
    blood_type VARCHAR(8),
    height_cm DECIMAL(5,2),
    weight_kg DECIMAL(5,2),
    allergy_history TEXT,
    chronic_diseases TEXT,
    emergency_contact VARCHAR(64),
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_profile_user FOREIGN KEY (user_id) REFERENCES user_account(id)
) ENGINE=InnoDB COMMENT='健康档案';

CREATE TABLE IF NOT EXISTS vital_sign_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    measured_at DATETIME NOT NULL,
    temperature_c DECIMAL(4,1),
    heart_rate SMALLINT,
    systolic_pressure SMALLINT,
    diastolic_pressure SMALLINT,
    blood_oxygen_pct DECIMAL(4,1),
    notes VARCHAR(500),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_vital_user_time (user_id, measured_at),
    CONSTRAINT fk_vital_user FOREIGN KEY (user_id) REFERENCES user_account(id)
) ENGINE=InnoDB COMMENT='生理指标记录';

CREATE TABLE IF NOT EXISTS consultation_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    question TEXT NOT NULL,
    ai_summary TEXT,
    diagnosis TEXT,
    advice TEXT,
    status VARCHAR(24) NOT NULL DEFAULT 'CREATED',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_consult_user FOREIGN KEY (user_id) REFERENCES user_account(id)
) ENGINE=InnoDB COMMENT='问诊记录';

CREATE TABLE IF NOT EXISTS medicine (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    generic_name VARCHAR(128),
    category VARCHAR(64),
    form VARCHAR(32),
    dosage VARCHAR(128),
    stock INT NOT NULL DEFAULT 0,
    unit VARCHAR(16),
    warning VARCHAR(500),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_medicine_name (name)
) ENGINE=InnoDB COMMENT='药品库';

CREATE TABLE IF NOT EXISTS prescription_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    consultation_id BIGINT,
    medicine_id BIGINT NOT NULL,
    dosage VARCHAR(128) NOT NULL,
    frequency VARCHAR(64) NOT NULL,
    duration_days INT,
    instructions VARCHAR(500),
    status VARCHAR(24) NOT NULL DEFAULT 'ACTIVE',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_prescription_user FOREIGN KEY (user_id) REFERENCES user_account(id),
    CONSTRAINT fk_prescription_consult FOREIGN KEY (consultation_id) REFERENCES consultation_record(id),
    CONSTRAINT fk_prescription_medicine FOREIGN KEY (medicine_id) REFERENCES medicine(id)
) ENGINE=InnoDB COMMENT='处方记录';

CREATE TABLE IF NOT EXISTS ai_model_config (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    provider VARCHAR(64) NOT NULL,
    model_name VARCHAR(128) NOT NULL,
    base_url VARCHAR(255),
    api_key_masked VARCHAR(64),
    enabled TINYINT NOT NULL DEFAULT 1,
    temperature DECIMAL(3,2) NOT NULL DEFAULT 0.30,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB COMMENT='AI模型配置';
