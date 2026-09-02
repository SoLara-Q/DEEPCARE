package com.deepcare.modules.aimodel.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.aimodel.entity.AiModelConfig;
import com.deepcare.modules.aimodel.service.AiModelConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai-models")
public class AiModelConfigController extends CrudController<AiModelConfig> {
    private final AiModelConfigService service;

    public AiModelConfigController(AiModelConfigService service) {
        this.service = service;
    }

    @Override
    protected IService<AiModelConfig> service() {
        return service;
    }
}
