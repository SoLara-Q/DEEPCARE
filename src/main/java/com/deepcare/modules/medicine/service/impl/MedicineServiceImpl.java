package com.deepcare.modules.medicine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.medicine.entity.Medicine;
import com.deepcare.modules.medicine.mapper.MedicineMapper;
import com.deepcare.modules.medicine.service.MedicineService;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine>
        implements MedicineService {
}
