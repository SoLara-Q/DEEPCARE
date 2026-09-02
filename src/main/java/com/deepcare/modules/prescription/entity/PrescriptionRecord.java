package com.deepcare.modules.prescription.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("prescription_record")
public class PrescriptionRecord {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long consultationId;
    private Long medicineId;
    private String dosage;
    private String frequency;
    private Integer durationDays;
    private String instructions;
    private String status;
    private LocalDateTime createdAt;
}
