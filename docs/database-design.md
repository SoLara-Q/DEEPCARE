# DeepCare 数据库设计说明

## 1. 设计原则

数据库采用 MySQL 8.0 和 InnoDB。表名、字段名使用小写下划线命名；业务主键统一为自增 `BIGINT`；时间统一使用 `DATETIME`；金额/测量值使用 `DECIMAL`，避免浮点误差。建表 SQL 位于 `db/schema.sql`，可在 Navicat 或 MySQL 客户端执行。

## 2. 表清单

| 表名 | 中文名 | 主键 | 主要外键 |
| --- | --- | --- | --- |
| `user_account` | 用户账号 | `id` | 无 |
| `health_profile` | 健康档案 | `id` | `user_id -> user_account.id` |
| `vital_sign_record` | 生理指标记录 | `id` | `user_id -> user_account.id` |
| `consultation_record` | 问诊记录 | `id` | `user_id -> user_account.id` |
| `medicine` | 药品库 | `id` | 无 |
| `prescription_record` | 处方记录 | `id` | `user_id`、`consultation_id`、`medicine_id` |
| `ai_model_config` | AI 模型配置 | `id` | 无 |

## 3. 关键字段设计

### `user_account`

`username` 唯一且非空；`password_hash` 只保存哈希值；`status` 表示启停；`deleted` 用于逻辑删除。

### `health_profile`

`user_id` 唯一，保证一个用户只有一份当前档案；`height_cm`、`weight_kg` 使用两位小数；过敏史和慢性病史使用文本字段，允许记录多项内容。

### `vital_sign_record`

测量时间 `measured_at` 非空；体温、血氧使用 `DECIMAL`；心率、收缩压和舒张压使用整数；`(user_id, measured_at)` 联合索引支持按用户查看趋势。

### `consultation_record`

`question` 非空；`ai_summary`、`diagnosis`、`advice` 分开保存，便于后续展示和人工修订；`status` 初始值为 `CREATED`。

### `medicine` 与 `prescription_record`

药品基础信息与用户处方解耦。处方必须关联药品和用户，可选关联问诊记录；`dosage`、`frequency`、`duration_days` 和 `instructions` 组成可执行的用药说明。

### `ai_model_config`

只保存脱敏后的 `api_key_masked`，不保存真实密钥；真实密钥应使用环境变量或密钥管理系统。`provider`、`model_name` 和 `base_url` 支持后续接入不同模型服务。

## 4. 一致性与安全

- 外键默认阻止删除仍被业务数据引用的用户、药品和问诊记录。
- 账号删除使用逻辑删除；其他历史健康数据默认保留，以满足追溯需要。
- 建议生产环境为数据库账号配置最小权限，并定期备份。
- 健康、问诊和处方字段属于敏感信息，生产环境应加密传输并实施访问审计。
