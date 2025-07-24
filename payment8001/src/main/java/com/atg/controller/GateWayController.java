package com.atg.controller;


import com.atg.entity.Pay;
import com.atg.service.PayService;
import com.atg.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
@Slf4j
public class GateWayController {

    @Resource
    private PayService payService;

    @GetMapping("/get/{id}")
    public Result<Pay> getPay2(@PathVariable("id") Integer id) {
        log.info("get pay: {}", id);
        if (id==5) throw new RuntimeException("cuo");
        return Result.success(payService.get(id));
    }

}
