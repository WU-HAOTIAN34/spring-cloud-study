package com.atg.controller;


import com.atg.feignApi.PayClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class CircuitController {

    @Resource
    private PayClient payClient;

    @GetMapping("/circuitbreaker/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myFallback")
    public String testCircuit(@PathVariable("id") Integer id){
        return payClient.testCircuit(id);
    }

    public String myFallback(Integer id, Throwable t) {
        return "服务忙，请稍后重试";
    }

    @GetMapping("/bulkhead1/{id}")
    @Bulkhead(name = "cloud-payment-service", fallbackMethod = "myFallback2", type = Bulkhead.Type.SEMAPHORE)
    public String testBulkhead1(@PathVariable("id") Integer id){
        return payClient.testCircuit(id);
    }

    public String myFallback2(Integer id, Throwable t) {
        return "服务忙，请稍后重试 Bulkhead.Type.SEMAPHORE";
    }

    @GetMapping("/bulkhead2/{id}")
    @Bulkhead(name = "cloud-payment-service", fallbackMethod = "myFallback3", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> testBulkhead2(@PathVariable("id") Integer id){

        return CompletableFuture.supplyAsync(() -> payClient.testCircuit(id));
    }

    public CompletableFuture<String> myFallback3(Integer id, Throwable t) {
        return CompletableFuture.supplyAsync(() -> "服务忙，请稍后重试 Bulkhead.Type.THREADPOOL");
    }

    @GetMapping("/ratelimiter/{id}")
    @RateLimiter(name = "cloud-payment-service", fallbackMethod = "myFallback4")
    public String testRateLimiter(@PathVariable("id") Integer id){
        return payClient.testCircuit(id);
    }

    public String myFallback4(Integer id, Throwable t) {
        return "服务忙，请稍后重试 已被限流";
    }

}
