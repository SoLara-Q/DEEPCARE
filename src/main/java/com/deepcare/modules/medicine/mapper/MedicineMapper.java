package com.deepcare.modules.medicine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepcare.modules.medicine.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {
}
