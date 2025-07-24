package com.atg.service.impl;


import com.atg.mapper.StorageMapper;
import com.atg.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    public void decrease(Long productId, Integer count) {
        storageMapper.decreaseByProId(productId, count);
    }
}
