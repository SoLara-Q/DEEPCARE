package com.deepcare.modules.medicine.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.medicine.entity.Medicine;
import com.deepcare.modules.medicine.service.MedicineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController extends CrudController<Medicine> {
    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @Override
    protected IService<Medicine> service() {
        return service;
    }
}
