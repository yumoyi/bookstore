package com.bookstore.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cy
 * @since 2019-08-24 12:01
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    /**
     * 后台页面起始页
     * @return 登录界面
     */
    @RequestMapping("/index")
    public String index(){
        return "admin/login";
    }

}
