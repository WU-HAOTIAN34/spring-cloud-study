package com.atg.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class CircuitController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/circuit/get/{id}")
    public String testCircuit(@PathVariable("id") Integer id) {
        if (id==-4){
            throw new RuntimeException("testCircuit failed--------");
        } else if (id==999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "testCircuit called " + id + " *************** port: " + port;
    }

}
