package com.bookstore.demo.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author cy
 */
@Data
public class OrderPage extends Orders{

    /**
     * 订单收货人
     */
    private String addressName;

    /**
     * 订单的用户名称
     */
    private String userName;

}