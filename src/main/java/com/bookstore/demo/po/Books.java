package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class Books {
    /**
     * 书籍id
     */
    private Integer bookId;

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

    /**
     * 书籍描述
     */
    private String bookDesc;

    /**
     * 书籍状态:
     *  1: 在架
     *  2: 未上架
     */
    private Integer bookFlag;

    /**
     * 书籍库存量
     */
    private Integer bookNum;

    /**
     * 书籍的分类id
     */
    private Integer categoryId;


}