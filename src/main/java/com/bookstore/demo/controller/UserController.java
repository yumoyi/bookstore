package com.bookstore.demo.controller;

import com.bookstore.demo.po.Users;
import com.bookstore.demo.service.UserService;
import com.bookstore.demo.utils.PhoneFormatCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cy
 * @since 2019-08-20 8:03
 */
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param users
     * @return users
     */
    @RequestMapping("login")
    public Users login(Users users){
        return userService.login(users);
    }

    /**
     * 发送验证码
     * @param telephone
     * @throws Exception
     */
    @RequestMapping("/sendCode")
    public void sendCode(String telephone, HttpServletResponse resp, HttpSession session) throws Exception {
        //判断手机号是否为空
        if(telephone==""||telephone==null) {
            resp.getWriter().println(3);
            //判断手机号是否合法
        }else if(!PhoneFormatCheckUtils.isPhoneLegal(telephone)) {
            resp.getWriter().println(1);
        }else{
            String code = userService.createSmsCode(telephone);
            session.setAttribute("telephone", telephone);
            session.setAttribute("code", code);
            resp.getWriter().println(2);
        }
    }
    //主界面注册按钮的跳转
    @RequestMapping("/register")
    public String register(Model model, Users user, HttpSession session, String telephone, String code) {

        //获取session的值
        String sysCode = (String)session.getAttribute("code");
        System.out.println(sysCode);
        String sysTel = (String)session.getAttribute("telephone");
        System.out.println(sysTel);
        if(sysCode.equals(code)&&sysTel.equals(telephone)) {
            userService.register(user);
            model.addAttribute("msg", "用户注册成功,请登录!");
        }
        else {
            model.addAttribute("msg", "用户注册失败,请重新注册!");
            return "jsp/info";
        }
        return "jsp/login";
    }


}
