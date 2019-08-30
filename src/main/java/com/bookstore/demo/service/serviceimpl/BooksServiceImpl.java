package com.bookstore.demo.service.serviceimpl;

import com.bookstore.demo.mapper.BooksMapper;
import com.bookstore.demo.mapper.BooksMapperCustom;
import com.bookstore.demo.po.Books;
import com.bookstore.demo.po.BooksExample;
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
        PageInfo<Books> pageInfo = new PageInfo<>(allByBooks);
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

    /**
     * 后台书籍状态改变
     *
     * @param books
     * @return integer
     */
    @Override
    public Integer bookUpdate(Books books) {
        return booksMapper.updateByPrimaryKeySelective(books);
    }

    /**
     * 后台书籍添加
     *
     * @param books
     * @return
     */
    @Override
    public Integer add(Books books) {
        return booksMapper.insertSelective(books);
    }

    /**
     * 后台书籍<单个>详情信息查询
     *
     * @param bookId
     * @return book
     */
    @Override
    public Books find(Integer bookId) {
        return booksMapper.selectByPrimaryKey(bookId);
    }

    /**
     * 统计有多少书籍
     *
     * @param booksExample
     * @return integer
     */
    @Override
    public Integer countBooks(BooksExample booksExample) {
        return booksMapper.countByExample(booksExample);
    }


}
