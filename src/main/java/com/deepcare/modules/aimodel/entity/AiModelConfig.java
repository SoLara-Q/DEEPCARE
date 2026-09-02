package com.deepcare.modules.aimodel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("ai_model_config")
public class AiModelConfig {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String provider;
    private String modelName;
    private String baseUrl;
    private String apiKeyMasked;
    private Integer enabled;
    private BigDecimal temperature;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
