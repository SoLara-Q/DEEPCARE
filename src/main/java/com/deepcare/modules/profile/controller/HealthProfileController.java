package com.deepcare.modules.profile.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.profile.entity.HealthProfile;
import com.deepcare.modules.profile.service.HealthProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health-profiles")
public class HealthProfileController extends CrudController<HealthProfile> {
    private final HealthProfileService service;

    public HealthProfileController(HealthProfileService service) {
        this.service = service;
    }

    @Override
    protected IService<HealthProfile> service() {
        return service;
    }
}
