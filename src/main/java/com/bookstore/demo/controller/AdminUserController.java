package com.bookstore.demo.controller;

import com.bookstore.demo.po.*;
import com.bookstore.demo.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param userName
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/user")
    public String adminUser(@RequestParam(value= "userName",required =false) String userName, Model model, @RequestParam(value="page",required=false,defaultValue="1")int page, @RequestParam(value="size",required=false,defaultValue="5")int size){

        Users users = new Users();
        users.setUserName(userName);
        PageInfo<Users> pageInfo = adminUserService.findAllByPage(users,page,size);

        //判断搜索用户是否存在
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
        }else {
            model.addAttribute("msg","没有搜索到用户,请重新搜索!");
        }
        //数据回显
        model.addAttribute("userName",userName);

        return "admin/user";
    }


    /**
     * 管理员登录
     * @param admin
     * @return
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
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "admin/login";
    }


    /**
     * 主页面的跳转
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String main(Model model, OrdersExample ordersExample, BooksExample booksExample, UsersExample usersExample,@RequestParam(value="page",required=false,defaultValue="1")int page, @RequestParam(value="size",required=false,defaultValue="5")int size){
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

}
