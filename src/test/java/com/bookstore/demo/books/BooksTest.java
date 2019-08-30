package com.bookstore.demo.books;

import com.bookstore.demo.DemoApplication;
import com.bookstore.demo.po.Books;
import com.bookstore.demo.service.BooksService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;
import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 20:02
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class BooksTest {

    @Autowired
    private BooksService booksService;

    @Test
    public void demo1test(){
        Books books = new Books();
        books.setBookFlag(1);
        PageInfo<Books> allByPage = booksService.findAllByPage(books, 0, 6);
        System.out.println(allByPage);
    }

    @Test
    public void demo2test(){
        Books books = new Books();
        books.setBookFlag(1);
        books.setCategoryId(3);
        books.setBookName("正义");
        List<Books> booksList = booksService.finaAll(books);
        System.out.println(booksList);
    }
}
