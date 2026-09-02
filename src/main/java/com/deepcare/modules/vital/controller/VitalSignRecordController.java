package com.deepcare.modules.vital.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.vital.entity.VitalSignRecord;
import com.deepcare.modules.vital.service.VitalSignRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vitals")
public class VitalSignRecordController extends CrudController<VitalSignRecord> {
    private final VitalSignRecordService service;

    public VitalSignRecordController(VitalSignRecordService service) {
        this.service = service;
    }

    @Override
    protected IService<VitalSignRecord> service() {
        return service;
    }
}
