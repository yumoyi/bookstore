package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class Orderdetail {
    /**
     * 订单项详情id
     */
    private Integer orderdetailId;

    /**
     * 订单项中书籍id
     */
    private Integer bookId;

    /**
     * 订单项中书籍数量
     */
    private Integer quantity;

    /**
     * 订单项小计
     */
    private Double subtotal;

    /**
     * 订单项属于某个订单id
     */
    private String orderId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍价格
     */
    private Double bookPrice;

    /**
     * 书籍图片地址
     */
    private String bookImage;
}