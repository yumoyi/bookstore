package com.bookstore.demo.controller;

import com.bookstore.demo.po.*;
import com.bookstore.demo.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author cy
 * @since 2019-08-28 23:27
 */

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private BooksService booksService;

    @Autowired
    private UserService userService;
    /**
     * 后台用户信息查询
     * @param users
     * @param model
     * @param page
     * @param size
     * @return 用户信息界面
     */
    @RequestMapping("/user")
    public String adminUser(Users users, Model model, @RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="5")int size){

        PageInfo<Users> pageInfo = adminUserService.findAllByPage(users,page,size);

        //判断搜索用户是否存在
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
        }else {
            model.addAttribute("msg","没有搜索到用户,请重新搜索!");
        }
        //数据回显
        model.addAttribute("userName",users.getUserName());

        return "admin/user";
    }


    /**
     * 管理员登录
     * @param admin
     * @return 重定向到后台主页面
     */
    @RequestMapping("login")
    public String login(Admin admin, Model model, HttpSession session){

        Admin login = adminService.login(admin);
        if(login==null){
            model.addAttribute("msg","用户名或者密码错误");
            model.addAttribute("adminName",admin.getAdminName());
            return "admin/login";
        }
        session.setAttribute("admin",login);
        return "redirect:main";
    }

    /**
     * 管理员退出登录
     * @param session
     * @return 登录界面
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "admin/login";
    }


    /**
     * 主页面的跳转
     * @param model
     * @return 后台主界面
     */
    @RequestMapping("/main")
    public String main(Model model, OrdersExample ordersExample, BooksExample booksExample, UsersExample usersExample,@RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="5")int size){
        Integer countOrders = ordersService.countOrders(ordersExample);
        model.addAttribute("countOrders",countOrders);

        Integer countBooks = booksService.countBooks(booksExample);
        model.addAttribute("countBooks",countBooks);

        Integer countUsers = userService.countUsers(usersExample);
        model.addAttribute("countUsers",countUsers);


        Orders orders = new Orders();
        orders.setOrderState(2);

        //返回的继承Orders类的OrderPage
        PageInfo<OrderPage> pageInfo = ordersService.findAllByPage2(orders, page, size);

        //判断搜索订单是否存在
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
        }
        return "admin/main";
    }


    @RequestMapping("/updatePassword")
    @ResponseBody //作用 把对象转成json字符串，并且回写浏览器
    public boolean updatePassword(Admin admin){
        try {
            adminService.update(admin);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Session域中获取管理员信息
     * @param session
     * @return 管理员信息
     */
    @RequestMapping("/selectPassword")
    @ResponseBody //作用 把对象转成json字符串，并且回写浏览器
    public Admin selectPassword(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        return admin;
    }

}
