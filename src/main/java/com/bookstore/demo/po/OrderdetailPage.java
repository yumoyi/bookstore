package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class OrderdetailPage extends Orderdetail{

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