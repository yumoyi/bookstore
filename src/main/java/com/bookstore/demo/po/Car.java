package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class Car {
    /**
     * 购物车id
     */
    private Integer carId;

    /**
     * 购物车中书籍id
     */
    private Integer bookId;

    /**
     * 购物车中每种书的数量
     */
    private Integer num;

    /**
     * 购物车中每种书价格小计
     */
    private Double carTotal;

    /**
     * 购物车属于某个用户id
     */
    private Integer userId;


}