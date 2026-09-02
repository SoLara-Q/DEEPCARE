package com.deepcare.modules.medicine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("medicine")
public class Medicine {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String genericName;
    private String category;
    private String form;
    private String dosage;
    private Integer stock;
    private String unit;
    private String warning;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
