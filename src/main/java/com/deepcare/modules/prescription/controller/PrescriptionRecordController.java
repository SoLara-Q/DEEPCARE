package com.deepcare.modules.prescription.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.prescription.entity.PrescriptionRecord;
import com.deepcare.modules.prescription.service.PrescriptionRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionRecordController extends CrudController<PrescriptionRecord> {
    private final PrescriptionRecordService service;

    public PrescriptionRecordController(PrescriptionRecordService service) {
        this.service = service;
    }

    @Override
    protected IService<PrescriptionRecord> service() {
        return service;
    }
}
