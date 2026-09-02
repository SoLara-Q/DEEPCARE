package com.deepcare.modules.aimodel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.aimodel.entity.AiModelConfig;
import com.deepcare.modules.aimodel.mapper.AiModelConfigMapper;
import com.deepcare.modules.aimodel.service.AiModelConfigService;
import org.springframework.stereotype.Service;

@Service
public class AiModelConfigServiceImpl extends ServiceImpl<AiModelConfigMapper, AiModelConfig>
        implements AiModelConfigService {
}
