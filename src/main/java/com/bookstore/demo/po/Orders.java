package com.bookstore.demo.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author cy
 */
@Data
public class Orders {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单生成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    /**
     * 订单总计
     */
    private Double orderTotal;

    /**
     * 订单状态:
     * 1: 未付款
     * 2: 已付款
     * 3: 已发货
     * 4: 已完成
     */
    private Integer orderState;

    /**
     * 订单的用户id
     */
    private Integer userId;

    /**
     * 收货人
     */
    private String addressName;

    /**
     * 收货人电话
     */
    private String addressPhone;

    /**
     * 收货地址
     */
    private String addressAddress;


}