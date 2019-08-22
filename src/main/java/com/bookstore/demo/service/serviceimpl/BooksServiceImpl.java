package com.bookstore.demo.service.serviceimpl;

import com.bookstore.demo.categorys.BooksMapper;
import com.bookstore.demo.categorys.BooksMapperCustom;
import com.bookstore.demo.po.Books;
import com.bookstore.demo.service.BooksService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 17:17
 */
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private BooksMapperCustom booksMapperCustom;

    /**
     * 带分页的全部书籍查询
     *
     * @param books
     * @param page
     * @param size
     * @return PageInfo<Books>
     */
    @Override
    public PageInfo<Books> findAllByPage(Books books, int page, int size) {
        PageHelper.startPage(page,size);
        List<Books> allByBooks = booksMapperCustom.findAllByBooks(books);
        PageInfo<Books> pageInfo = new PageInfo<Books>(allByBooks);
        return pageInfo;
    }

    /**
     * 不带分页的书籍查询
     *
     * @param books
     * @return
     */
    @Override
    public List<Books> finaAll(Books books) {
        List<Books> allByBooks = booksMapperCustom.findAllByBooks(books);
        return allByBooks;
    }


}
