package com.deepcare.modules.profile.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.profile.entity.HealthProfile;
import com.deepcare.modules.profile.mapper.HealthProfileMapper;
import com.deepcare.modules.profile.service.HealthProfileService;
import org.springframework.stereotype.Service;

@Service
public class HealthProfileServiceImpl extends ServiceImpl<HealthProfileMapper, HealthProfile>
        implements HealthProfileService {
}
