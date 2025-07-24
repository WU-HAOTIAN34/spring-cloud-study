package com.atg.service.impl;


import com.atg.mapper.AccountMapper;
import com.atg.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImp implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long id, Long money) {
        accountMapper.updateByUserId(id, money);
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
