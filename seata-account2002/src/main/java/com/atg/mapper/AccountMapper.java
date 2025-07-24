package com.atg.mapper;

import com.atg.entity.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

//@org.apache.ibatis.annotations.Mapper
public interface AccountMapper extends Mapper<Account> {

    void updateByUserId(@Param("id") Long id, @Param("money") Long money);
}