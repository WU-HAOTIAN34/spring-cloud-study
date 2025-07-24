package com.atg.controller;


import com.atg.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RefreshScope
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/nacos/consumer/get/{id}")
    public Result<String> testConsumer(@PathVariable("id") Integer id, @Value("${server.port}") String port) {
        Result forObject = restTemplate.getForObject("http://spring-cloud-alibaba-payment/nacos/get/"+id, Result.class);
        String str = forObject.getData().toString();
        return Result.success(str+" from port: "+port);
    }

    @Value("${atgui.info}")
    private String info;

    @GetMapping("/nacos/consumer/info")
    public Result<String> testConfig(@Value("${server.port}") String port) {
        return Result.success("get info: " + info +" from port: "+port);
    }


}
