package com.deepcare.modules.consultation.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.consultation.entity.ConsultationRecord;
import com.deepcare.modules.consultation.service.ConsultationRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationRecordController extends CrudController<ConsultationRecord> {
    private final ConsultationRecordService service;

    public ConsultationRecordController(ConsultationRecordService service) {
        this.service = service;
    }

    @Override
    protected IService<ConsultationRecord> service() {
        return service;
    }
}
