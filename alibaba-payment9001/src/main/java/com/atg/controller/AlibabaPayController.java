package com.atg.controller;



import com.atg.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
@Slf4j
public class AlibabaPayController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/{id}")
    public Result<String> test(@PathVariable("id") Integer id) {
        log.info("get id:{}", id);
        return Result.success("get id: "+id+" from port: "+port+" ");
    }

}
