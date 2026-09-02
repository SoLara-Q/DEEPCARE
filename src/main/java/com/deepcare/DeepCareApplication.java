package com.deepcare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
        "com.deepcare.modules.user.mapper",
        "com.deepcare.modules.profile.mapper",
        "com.deepcare.modules.vital.mapper",
        "com.deepcare.modules.consultation.mapper",
        "com.deepcare.modules.medicine.mapper",
        "com.deepcare.modules.prescription.mapper",
        "com.deepcare.modules.aimodel.mapper"
})
public class DeepCareApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeepCareApplication.class, args);
    }
}
