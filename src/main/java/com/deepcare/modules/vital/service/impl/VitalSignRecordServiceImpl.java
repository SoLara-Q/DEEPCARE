package com.deepcare.modules.vital.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.vital.entity.VitalSignRecord;
import com.deepcare.modules.vital.mapper.VitalSignRecordMapper;
import com.deepcare.modules.vital.service.VitalSignRecordService;
import org.springframework.stereotype.Service;

@Service
public class VitalSignRecordServiceImpl extends ServiceImpl<VitalSignRecordMapper, VitalSignRecord>
        implements VitalSignRecordService {
}
