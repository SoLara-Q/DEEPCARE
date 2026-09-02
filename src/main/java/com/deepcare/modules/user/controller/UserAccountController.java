package com.deepcare.modules.user.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deepcare.common.api.CrudController;
import com.deepcare.modules.user.entity.UserAccount;
import com.deepcare.modules.user.service.UserAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserAccountController extends CrudController<UserAccount> {
    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @Override
    protected IService<UserAccount> service() {
        return service;
    }
}
