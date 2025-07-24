package com.atg.service;


import com.atg.entity.Pay;

import java.util.List;

public interface PayService {

    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay get(Integer id);

    List<Pay> getAll();

}
