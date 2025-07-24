package com.atg.feignApi;


import com.atg.entity.Pay;
import com.atg.entity.PayDTO;
import com.atg.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("cloud-gateway")
public interface PayClient {

    @PostMapping(value = "/pay/add")
    Result<Pay> add(@RequestBody Pay pay);

    @PutMapping(value = "/pay/update")
    Result<Pay> update(@RequestBody PayDTO payDTO);

    @DeleteMapping(value = "/pay/delete/{id}")
    Result<Integer> delete(@PathVariable("id") Integer id);

    @GetMapping("/pay/get/{id}")
    Result<Pay> getPay(@PathVariable("id") Integer id);

    @GetMapping("/pay/getAll")
    Result<List<Pay>> getAllPay();

    @GetMapping("/pay/info")
    String getInfo();

    @GetMapping("/circuit/get/{id}")
    String testCircuit(@PathVariable("id") Integer id);

    @GetMapping("/gateway/get/{id}")
    Result<Pay> getPay2(@PathVariable("id") Integer id);

}
