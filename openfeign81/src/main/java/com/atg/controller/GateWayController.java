package com.atg.controller;


import com.atg.entity.Pay;
import com.atg.feignApi.PayClient;
import com.atg.util.Result;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/gateway")
@Slf4j
public class GateWayController {

    @Resource
    private PayClient payClient;

    @GetMapping("/get/{id}")
    public Result<Pay> getPay(@PathVariable("id") Integer id) {
        return payClient.getPay2(id);
    }

}
