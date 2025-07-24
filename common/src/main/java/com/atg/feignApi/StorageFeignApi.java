package com.atg.feignApi;


import com.atg.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageFeignApi {

    @PostMapping("/storage/decrease")
    Result<String> decrease(@RequestParam("productId") Long productId,
                            @RequestParam("count") Integer count);

}
