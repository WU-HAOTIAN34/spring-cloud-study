package com.atg.controller;


import com.atg.entity.Order;
import com.atg.service.OrderService;
import com.atg.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order")
    public Result<Order> create(Order order) {
        log.info("创建订单");
        Order order1 = orderService.create(order);
        return Result.success(order1);
    }

}
