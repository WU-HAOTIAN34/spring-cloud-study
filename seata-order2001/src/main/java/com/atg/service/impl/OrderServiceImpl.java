package com.atg.service.impl;


import com.atg.entity.Order;
import com.atg.feignApi.AccountFeignApi;
import com.atg.feignApi.StorageFeignApi;
import com.atg.mapper.OrderMapper;
import com.atg.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.plaf.RootPaneUI;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountFeignApi accountFeignApi;

    @Resource
    private StorageFeignApi storageFeignApi;


    @GlobalTransactional(name = "seata_test", rollbackFor = Exception.class)
    public Order create(Order order){
        String xid = RootContext.getXID();
        System.out.println("-----------开始创建订单-------------xid: "+xid);
        int insert = orderMapper.insert(order);
        if (insert > 0){
            Order select = orderMapper.select(order).get(0);
            storageFeignApi.decrease(select.getProductId(), select.getCount());
            accountFeignApi.decrease(select.getUserId(), select.getMoney());
            select.setStatus(1);
            orderMapper.updateByPrimaryKey(select);
        }
        return order;
    }


}
