package com.bookstore.demo.controller;

import com.bookstore.demo.po.Books;
import com.bookstore.demo.po.Categorys;
import com.bookstore.demo.service.BooksService;
import com.bookstore.demo.service.CategorysService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author cy
 * @since 2019-08-20 17:15
 */
@Controller
@RequestMapping("/admin")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private CategorysService categorysService;

    @RequestMapping("/book")
    public String book(@RequestParam(value="bookFlag",required=true,defaultValue="1")Integer bookFlag, @RequestParam(value="categoryId",required=false)Integer categoryId, @RequestParam(value="bookName",required=false)String bookName, Model model, @RequestParam(value="page",required=true,defaultValue="1")int page, @RequestParam(value="size",required=true,defaultValue="5")int size) {
        Books books = new Books();
        books.setBookName(bookName);
        books.setCategoryId(categoryId);
        books.setBookFlag(bookFlag);
        PageInfo<Books> pageInfo = booksService.findAllByPage(books, page, size);

        //判断搜索书籍是否存在
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
        }else {
            model.addAttribute("msg","没有搜索到书籍,请重新搜索!");
        }
        //数据回显
        model.addAttribute("bookName",books.getBookName());
        model.addAttribute("categoryId",books.getCategoryId());
        //书籍列表

        List<Categorys> list = categorysService.findAll();
        model.addAttribute("categoryList", list);
        if(bookFlag==1) {
            return "admin/book";
        }
        else {
            return "admin/book-up";
        }
    }

    /**
     * 后台书籍下架
     * @param  bookId
     * @return
     */
    @RequestMapping("/bookDown")
    public String bookDown(Integer bookId){

        Books books = new Books();
        books.setBookId(bookId);
        books.setBookFlag(2);
        booksService.bookUpdate(books);
        return "redirect:book";
    }

    /**
     * 后台书籍上架
     * @param bookId
     * @return
     */
    @RequestMapping("/bookUp")
    public String bookUp(Integer bookId){

        Books books = new Books();
        books.setBookId(bookId);
        books.setBookFlag(1);
        booksService.bookUpdate(books);
        return "redirect:book?bookFlag=2";
    }


    /**
     * 跳转到添加的页面
     * @param model
     * @return
     */

    @RequestMapping("/bookadd")
    public String bookadd(Model model) {
        List<Categorys> list = categorysService.findAll();
        model.addAttribute("categoryList", list);
        return "admin/book-add";
    }


    /**
     * 后台书籍添加
     * @param book
     * @param bookImages
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/bookAdd",method = { RequestMethod.POST})
    public String bookadds(Books book, MultipartFile bookImages) throws IllegalStateException,Exception {
        //基本数据类型赋值
        book.setBookFlag(1);
        //上传文件类型
        //图片的原始名字
        String originalFilename = bookImages.getOriginalFilename();
        //图片新名字
        String name = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //图片后缀
        String exename = originalFilename.substring(originalFilename.lastIndexOf("."));

        //保存图片到本地磁盘
        File bookImage = new File("D:\\bookstore\\img\\"+name+exename);
        bookImages.transferTo(bookImage);
        //设置书籍图片信息
        book.setBookImage(name+exename);

        booksService.add(book);
        return"redirect:book";
    }




    /**
     * 后台书籍
     * 跳转到详情页面
     * @return
     */
    @RequestMapping("/bookAll")
    public String bookAll(Integer bookId,Model model) {

        Books books = booksService.find(bookId);
        model.addAttribute("book", books);

        List<Categorys> list = categorysService.findAll();
        model.addAttribute("categoryList", list);
        return "admin/book-update";

    }

    /**
     * 后台书籍更新
     * @param book
     * @param bookImages
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
     
    @RequestMapping(value="/bookUpdate")
    @ResponseBody
    public Map<String, Object> bookUpdate(Books book,@RequestParam(value="bookImages",required=false)MultipartFile bookImages) throws IllegalStateException, IOException {

        if(bookImages!=null) {
            //图片的原始名字
            String originalFilename = bookImages.getOriginalFilename();
            //图片新名字
            String name = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            //图片后缀
            String exename = originalFilename.substring(originalFilename.lastIndexOf("."));

            //保存图片到本地磁盘
            File bookImage = new File("D:\\bookstore\\img\\"+name+exename);
            bookImages.transferTo(bookImage);
            //设置书籍图片信息
            book.setBookImage(name+exename);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            booksService.bookUpdate(book);
            map.put("success", true);
            map.put("message", "操作成功");
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "操作失败");
        }
        return map;
    }


}
