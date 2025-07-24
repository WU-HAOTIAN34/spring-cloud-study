package com.atg.controller;


import com.atg.service.StorageService;
import com.atg.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public Result<String> decrease(@RequestParam("productId") Long productId,
                                   @RequestParam("count") Integer count){
        log.info("decrease productId:{},count:{}", productId, count);
        storageService.decrease(productId, count);
        return Result.success("ok");
    }
}
