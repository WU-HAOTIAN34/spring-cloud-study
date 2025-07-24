package com.atg.controller;


import com.atg.service.AccountService;
import com.atg.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public Result decrease(@RequestParam("userId") Long userId,
                                   @RequestParam("money") Long money){
        accountService.decrease(userId, money);
        return Result.success("ok");
    }

}
