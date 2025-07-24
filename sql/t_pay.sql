create table t_pay
(
    id          int unsigned auto_increment
        primary key,
    pay_no      varchar(50)                                not null comment '支付流水号',
    order_no    varchar(50)                                not null comment '订单流水号',
    user_id     int              default 1                 null comment '用户账号ID',
    amount      decimal(8, 2)    default 9.90              not null comment '交易金额',
    deleted     tinyint unsigned default '0'               not null comment '删除标志, 默认0不删除,1删除',
    create_time timestamp        default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp        default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '支付交易表';