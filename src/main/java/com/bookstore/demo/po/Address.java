package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class Address {
    /**
     * 收货地址id
     */
    private Integer addressId;

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

    /**
     * 收货地址的用户id
     */
    private Integer userId;
}

