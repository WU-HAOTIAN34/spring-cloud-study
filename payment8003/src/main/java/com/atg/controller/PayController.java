package com.atg.controller;


import com.atg.entity.Pay;
import com.atg.entity.PayDTO;
import com.atg.service.PayService;
import com.atg.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "支付模块")
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/add")
    @Operation(summary = "增加")
    public Result<Pay> add(@RequestBody Pay pay) {
        log.info("add new pay");
        pay.setDeleted((byte)0);
        int res = payService.add(pay);
        return Result.success(pay);
    }

    @PutMapping("/update")
    @Operation(summary = "更新")
    public Result<Pay> update(@RequestBody PayDTO payDTO) {
        log.info("update pay");
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        pay.setDeleted((byte)0);
        int res = payService.update(pay);
        return Result.success(pay);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除")
    public Result<Integer> delete(@PathVariable("id") Integer id) {
        log.info("delete pay");
        int res = payService.delete(id);
        return Result.success(id);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "查")
    public Result<Pay> getPay(@PathVariable("id") Integer id) {
        log.info("get pay: {}", id);
        if (id==5) throw new RuntimeException("cuo");
        return Result.success(payService.get(id));
    }

    @GetMapping("/getAll")
    @Operation(summary = "查所有")
    public Result<List<Pay>> getAllPay() {
        log.info("getAll pay");
        List<Pay> res = payService.getAll();
        return Result.success(res);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public String getInfo(@Value("${wuhaotian.info}") String infow){
        return infow+" port: "+port;
    }


}
