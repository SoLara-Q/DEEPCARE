package com.deepcare.modules.consultation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("consultation_record")
public class ConsultationRecord {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String question;
    private String aiSummary;
    private String diagnosis;
    private String advice;
    private String status;
    private LocalDateTime createdAt;
}
