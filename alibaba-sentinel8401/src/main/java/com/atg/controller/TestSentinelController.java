package com.atg.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atg.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSentinelController {

    @GetMapping("/sentinel/testA")
    public Result<String> testA(){
        return Result.success("----------------test A");
    }

    @GetMapping("/sentinel/testB")
    public Result<String> testB(){
        return Result.success("----------------test B");
    }

    @GetMapping("/sentinel/testC/{id}")
    @SentinelResource(value = "testSentinelResource", blockHandler = "testHandler1", fallback = "testHandler2")
    public Result<String> testC(@PathVariable("id") Integer id,
                                @RequestParam(value = "p1", required = false) Integer p1,
                                @RequestParam(value = "p2", required = false) Integer p2) {
        if (id==0){
            throw new RuntimeException("aaaaaaaaaaa");
        }
        return Result.success("-----------------test C");
    }

    public Result<String> testHandler1(@PathVariable("id") Integer id, BlockException w){
        return Result.success("发生限流");
    }

    public Result<String> testHandler2(@PathVariable("id") Integer id, Throwable t){
        return Result.success("发生熔断");
    }

}
