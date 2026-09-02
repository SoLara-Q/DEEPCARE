package com.deepcare.modules.prescription.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.prescription.entity.PrescriptionRecord;
import com.deepcare.modules.prescription.mapper.PrescriptionRecordMapper;
import com.deepcare.modules.prescription.service.PrescriptionRecordService;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionRecordServiceImpl extends ServiceImpl<PrescriptionRecordMapper, PrescriptionRecord>
        implements PrescriptionRecordService {
}
