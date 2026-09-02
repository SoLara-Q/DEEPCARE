package com.deepcare.modules.vital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("vital_sign_record")
public class VitalSignRecord {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private LocalDateTime measuredAt;
    private BigDecimal temperatureC;
    private Integer heartRate;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private BigDecimal bloodOxygenPct;
    private String notes;
    private LocalDateTime createdAt;
}
