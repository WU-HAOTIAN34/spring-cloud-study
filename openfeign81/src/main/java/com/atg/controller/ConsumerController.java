package com.atg.controller;


import com.atg.entity.Pay;
import com.atg.entity.PayDTO;
import com.atg.feignApi.PayClient;
import com.atg.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/feign")
public class ConsumerController {

    @Resource
    private PayClient payClient;

    @GetMapping("/pay/get/{id}")
    public Result getPay(@PathVariable("id") Integer id){
        log.info("get pay id:{}", id);
        return payClient.getPay(id);
    }

    @GetMapping("/pay/getAll")
    public Result getPayAll(){
        log.info("get pay all");
        return payClient.getAllPay();
    }

    @GetMapping("/pay/add")
    public Result add(Pay pay){
        log.info("add pay:{}", pay);
        return payClient.add(pay);
    }

    @GetMapping("/pay/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        log.info("delete pay:{}", id);
        return payClient.delete(id);
    }

    @GetMapping("/pay/update")
    public Result update(PayDTO payDTO){
        log.info("update pay:{}", payDTO);
        return payClient.update(payDTO);
    }

    @GetMapping("/pay/info")
    public Result getInfo(){
        log.info("get pay info");
        String res = payClient.getInfo();
        return Result.success(res);
    }

    @GetMapping("/circuit/{id}")
    public String testCircuit(@PathVariable("id") Integer id){
        log.info("testCircuit called");
        String res = payClient.testCircuit(id);
        return res;
    }



}
