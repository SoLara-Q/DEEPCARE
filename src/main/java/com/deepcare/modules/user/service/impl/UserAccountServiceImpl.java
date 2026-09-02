package com.deepcare.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepcare.modules.user.entity.UserAccount;
import com.deepcare.modules.user.mapper.UserAccountMapper;
import com.deepcare.modules.user.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount>
        implements UserAccountService {
}
