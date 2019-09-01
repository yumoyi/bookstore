package com.bookstore.demo.service;

import com.bookstore.demo.po.Books;
import com.bookstore.demo.po.BooksExample;
import com.bookstore.demo.po.OrdersExample;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 17:16
 */
public interface BooksService {
    /**
     * 带分页的书籍查询
     * @param books
     * @param page
     * @param size
     * @return 带分页的书籍信息
     */
    PageInfo<Books> findAllByPage(Books books,int page,int size);

    /**
     * 不带分页的书籍查询
     * @param books
     * @return 书籍信息
     */
    List<Books> finaAll(Books books);

    /**
     * 后台书籍状态改变
     * @param books
     * @return 判断是否改变书籍状态
     */
    Integer bookUpdate(Books books);

    /**
     * 后台书籍添加
     * @param books
     * @return 判断是否添加书籍
     */
    Integer add(Books books);

    /**
     * 后台书籍<单个>详情信息查询
     * @param bookId
     * @return 单个书籍信息
     */
    Books find(Integer bookId);
    /**
     * 统计有多少书籍
     * @param booksExample
     * @return 书籍总量
     */
    Integer countBooks(BooksExample booksExample);
}
