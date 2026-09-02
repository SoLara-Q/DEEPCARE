package com.deepcare.modules.consultation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.consultation.entity.ConsultationRecord;
import com.deepcare.modules.consultation.mapper.ConsultationRecordMapper;
import com.deepcare.modules.consultation.service.ConsultationRecordService;
import org.springframework.stereotype.Service;

@Service
public class ConsultationRecordServiceImpl extends ServiceImpl<ConsultationRecordMapper, ConsultationRecord>
        implements ConsultationRecordService {
}
