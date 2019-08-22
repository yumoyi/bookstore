package com.bookstore.demo.service;

import com.bookstore.demo.po.Books;
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
     * @return  PageInfo<Books>
     */
    PageInfo<Books> findAllByPage(Books books,int page,int size);

    /**
     * 不带分页的书籍查询
     * @param books
     * @return
     */
    List<Books> finaAll(Books books);
}
