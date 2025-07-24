package com.atg.mapper;

import com.atg.entity.Storage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface StorageMapper extends Mapper<Storage> {

    void decreaseByProId(@Param("productId") Long productId, @Param("count") Integer count);
}