package com.pzd.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pzd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "itcast";
    }
}
