package com.atg.controller;


import com.atg.entity.Pay;
import com.atg.entity.PayDTO;
import com.atg.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    public static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/pay/get/{id}")
    public Result getPay(@PathVariable("id") Integer id){
        log.info("get pay id:{}", id);
        return restTemplate.getForObject(URL+"/pay/get/"+id, Result.class);
    }

    @GetMapping("/pay/getAll")
    public Result getPayAll(){
        log.info("get pay all");
        return restTemplate.getForObject(URL+"/pay/getAll", Result.class);
    }

    @GetMapping("/pay/add")
    public Result add(PayDTO payDTO){
        log.info("add pay:{}", payDTO);
        return restTemplate.postForObject(URL+"/pay/add", payDTO, Result.class );
    }

    @GetMapping("/pay/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        log.info("delete pay:{}", id);
        return restTemplate.exchange(URL+"/pay/delete/"+id, HttpMethod.DELETE, null, Result.class ).getBody();
    }

    @GetMapping("/pay/update")
    public Result update(PayDTO payDTO){
        log.info("update pay:{}", payDTO);
        return restTemplate.exchange(URL+"/pay/update", HttpMethod.PUT, new HttpEntity<>(payDTO), Result.class).getBody();
    }

    @GetMapping("/pay/info")
    public Result getInfo(){
        log.info("get pay info");
        String res = restTemplate.getForObject(URL+"/pay/info", String.class);
        return Result.success(res);
    }



}
