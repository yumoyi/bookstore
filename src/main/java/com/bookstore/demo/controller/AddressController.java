package com.bookstore.demo.controller;

import com.bookstore.demo.mapper.UsersMapper;
import com.bookstore.demo.po.Address;
import com.bookstore.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 跳转到用户收货人详情页面
     * @param model
     * @param userId
     * @return 收货人详情页面
     */
    @RequestMapping("/userAddress")
    public String userAddress(Model model,Integer userId){

        List<Address> addresses = userService.userAddress(userId);
        if(addresses.size()==0){
            model.addAttribute("msg","该用户暂无收货人!");
        }else{
            model.addAttribute("addresses",addresses);
        }
        return "admin/address";
    }



    @RequestMapping("/selectAddress")
    @ResponseBody
    public Address selectAddress(Integer addressId){
        Address address = userService.selectAddress(addressId);
        return address;
    }
}
