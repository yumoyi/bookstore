package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 10:30
 */
@Mapper
public interface BooksMapperCustom {
    /**
     * 根据名称,分类,是否在架查书籍
     * (信息为空时查所有书籍)
     * @param books
     * @return List<Books>
     */
    List<Books> findAllByBooks(Books books);

    /**
     * 查询所有书籍
     * @return books
     */
    List<Books> findAll();

    /**
     * 后台添加时根据书籍信息查询书籍是否存在
     * @param books
     * @return Books
     */
    Books findByBooks(Books books);
}
