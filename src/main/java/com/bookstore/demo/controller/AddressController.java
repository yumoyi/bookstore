package com.bookstore.demo.controller;

import com.bookstore.demo.mapper.UsersMapper;
import com.bookstore.demo.po.Address;
import com.bookstore.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-29 8:48
 */
@Controller
@RequestMapping("/admin")
public class AddressController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userAddress")
    public String userAddress(Model model,@RequestParam(value= "userId",required =false) Integer userId){

        List<Address> addresses = userService.userAddress(userId);
        model.addAttribute("addresses",addresses);
        return "admin/address";
    }
}
