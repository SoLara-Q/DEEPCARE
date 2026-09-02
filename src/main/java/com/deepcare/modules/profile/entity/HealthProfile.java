package com.deepcare.modules.profile.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("health_profile")
public class HealthProfile {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String gender;
    private LocalDate birthDate;
    private String bloodType;
    private BigDecimal heightCm;
    private BigDecimal weightKg;
    private String allergyHistory;
    private String chronicDiseases;
    private String emergencyContact;
    private LocalDateTime updatedAt;
}
