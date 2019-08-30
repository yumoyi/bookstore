package com.bookstore.demo.controller;

import com.bookstore.demo.po.*;
import com.bookstore.demo.service.OrdersService;
import com.bookstore.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * @author cy
 * @since 2019-08-25 22:49
 */
@Controller
@RequestMapping("/admin")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    /**
     *  后台页面带分页展示
     * @param orderState
     * @param orderId
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/order")
    public String order(@RequestParam(value="orderState",required=false)Integer orderState, @RequestParam(value="orderId",required=false)String orderId,  Model model, @RequestParam(value="page",required=false,defaultValue="1")int page, @RequestParam(value="size",required=false,defaultValue="5")int size) {
        Orders orders = new Orders();
        orders.setOrderState(orderState);
        orders.setOrderId(orderId);

        //返回的继承Orders类的OrderPage
        PageInfo<OrderPage> pageInfo = ordersService.findAllByPage2(orders, page, size);

        //数据回显
        model.addAttribute("orderId",orders.getOrderId());
        model.addAttribute("orderState",orderState);

        //判断搜索订单是否存在
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
        }else {
            model.addAttribute("msg","没有搜索到订单,请重新搜索!");
        }
        if(orderState!=null) {
            if(orderState==2){
                return "admin/order-two";
            }else if(orderState==3){
                return "admin/order-three";
            }else if(orderState==4){
                return "admin/order-four";
            }else if(orderState==1){
                return "admin/order-one";
            }

        }
        return "admin/order";
    }


    /**
     * 更新订单的状态
     * @param orderId
     * @param orderState
     * @param model
     * @param index 1:跳转全部订单  2:跳转已付款订单
     * @return
     */
    @RequestMapping("/orderUpdate")
    public String orderUpdate(String orderId,Integer orderState,Model model,Integer index,@RequestParam(value = "userId",required=false) Integer userId){
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setOrderState(orderState);
        Integer orderUp = ordersService.orderUp(orders);
        if(orderUp==0){
            model.addAttribute("msg","更新订单状态失败!");
        }
        if(index!=null){
            if(index==3){
                return "redirect:userOrder?userId="+userId.toString();
            }

            return "redirect:order";
        }
        return "redirect:order?orderState=2";
    }

    /**
     * 查看订单详情
     * @param orderState
     * @param model
     * @param orderId
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/orderAll")
    public String orderAll(@RequestParam(value="orderState",required=false)Integer orderState,Model model,String orderId,@RequestParam(value="page",required=false,defaultValue="1")int page, @RequestParam(value="size",required=false,defaultValue="15")int size){

        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setOrderId(orderId);
        PageInfo<OrderdetailPage> pageInfo = ordersService.orderAll(orderdetail, page, size);
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
            model.addAttribute("orderId",orderId);
        }else {
            model.addAttribute("msg","没有搜索到订单,请重新搜索!");
        }
        model.addAttribute("orderState",orderState);
        return "admin/orderdetail";
    }


    @RequestMapping("/userOrder")
    public String userOrder(@RequestParam(value="userId",required=false)Integer userId,  Model model, @RequestParam(value="page",required=false,defaultValue="1")int page, @RequestParam(value="size",required=false,defaultValue="5")int size) {
        Orders orders = new Orders();
        orders.setUserId(userId);

        //返回的继承Orders类的OrderPage
        PageInfo<OrderPage> pageInfo = ordersService.findAllByPage2(orders, page, size);

        //判断搜索订单是否存在
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
        }else {
            model.addAttribute("msg","没有搜索到订单,请重新搜索!");
        }
        model.addAttribute("userId",userId);
        return "admin/user-order";
    }


    @RequestMapping("/userOrderAll")
    public String orderAll(Model model,Integer userId,String orderId,@RequestParam(value="page",required=false,defaultValue="1")int page, @RequestParam(value="size",required=false,defaultValue="15")int size){

        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setOrderId(orderId);
        PageInfo<OrderdetailPage> pageInfo = ordersService.orderAll(orderdetail, page, size);
        if(pageInfo.getTotal()!=0) {
            model.addAttribute("pageinfo", pageInfo);
            model.addAttribute("orderId",orderId);
        }else {
            model.addAttribute("msg","没有搜索到订单,请重新搜索!");
        }
        model.addAttribute("userId",userId);
        return "admin/user-orderdetail";
    }
}
