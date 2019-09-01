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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 17:14
 */
@Controller
@RequestMapping("/admin")
public class CategorysController {

    @Autowired
    private CategorysService categorysService;
    @Autowired
    private BooksService booksService;

    /**
     * 后台分类展示页面
     * @param categorys
     * @param model
     * @param page
     * @param size
     * @return 后台展示页面
     */
    @RequestMapping("/category")
    public String showcategorys(Categorys categorys,Model model,@RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="10")int size) {

        PageInfo<Categorys> pageinfo = categorysService.findAllByPage(categorys, page, size);

        if(pageinfo.getTotal()==0) {
            model.addAttribute("msg", "没有搜索到,暂无此分类!");
        }else {
            model.addAttribute("pageinfo", pageinfo);
        }
        model.addAttribute("categoryName", categorys.getCategoryName());

        return "admin/category";
    }


    /**
     * 后台添加分类功能
     * @param category
     * @param model
     * @return 添加成功重定向分类展示页面;失败给出提示
     */
    @RequestMapping("/category/add")
    public String categoryAdd(Categorys category,Model model) {
        if(category.getCategoryName()!=null&&category.getCategoryName()!="") {
            categorysService.add(category);
            return "redirect:";
        }else {
            model.addAttribute("msg", "分类名称不能为空");
            return "admin/category-add";
        }

    }

    /**
     * 检查添加分类时是否存在此分类
     * @param resp
     * @param categorys
     * @throws Exception
     */
    @RequestMapping("/findByCategory")
    @ResponseBody
    public void findCategoryAjax(HttpServletResponse resp,Categorys categorys) throws Exception {
        Categorys byCategory = categorysService.findByCategorys(categorys);
        if(byCategory==null) {
            resp.getWriter().println(1);
        }else {
            resp.getWriter().println(2);
        }
    }


    /**
     * 后台跳转到添加页面
     * @return 分类添加页面
     */
    @RequestMapping("/categoryadd")
    public String categoryadd() {
        return "admin/category-add";
    }


    /**
     * 删除分类
     * @param categoryId
     * @param model
     * @return 转发到分类页面
     */
    @RequestMapping("/categoryDel")
    public String categoryDel(Integer categoryId,Model model){
        Books books = new Books();
        books.setCategoryId(categoryId);
        List<Books> list = booksService.finaAll(books);
        if(list.size()!=0) {
            model.addAttribute("msg", "该分类中有商品不能删除");

        }else if(list.size()==0){
            categorysService.deleteById(categoryId);
        }
        return "forward:category";
    }

    /**
     * 跳转到分类更新页面
     * @param model
     * @param categorys
     * @return 分类更新页面
     */
    @RequestMapping("/categoryup")
    public String categoryUp(Model model,Categorys categorys) {
        model.addAttribute("categoryName",categorys.getCategoryName());
        model.addAttribute("categoryId", categorys.getCategoryId());
        return "admin/category-update";
    }

    /**
     * 更新分类
     * @param category
     * @return 重定向到后台分类展示页面
     */
    @RequestMapping("/categoryUp")
    public String adminkindup(Categorys category) {
        categorysService.update(category);
        return "redirect:category";
    }

}
