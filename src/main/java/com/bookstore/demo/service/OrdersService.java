package com.bookstore.demo.service;

import com.bookstore.demo.po.*;
import com.github.pagehelper.PageInfo;

/**
 * @author cy
 * @since 2019-08-25 22:50
 */
public interface OrdersService {

    /**
     * 带分页的订单查询
     * @param orders
     * @param page
     * @param size
     * @return pageInfo<Orders>
     */
    PageInfo<Orders> findAllByPage(Orders orders, int page, int size);

    /**
     * 带分页的订单查询(OrderPage)
     * @param orders
     * @param page
     * @param size
     * @return pageInfo<Orders>
     */
    PageInfo<OrderPage> findAllByPage2(Orders orders, int page, int size);


    /**
     * 更新订单信息(订单状态)
     * @param orders
     * @return integer
     */
    Integer orderUp(Orders orders);

    /**
     * 订单详情查询
     * @param orderdetail
     * @param page
     * @param size
     * @return
     */
    PageInfo<OrderdetailPage> orderAll(Orderdetail orderdetail,int page,int size);

    /**
     * 统计有多少订单
     * @param ordersExample
     * @return integer
     */
    Integer countOrders(OrdersExample ordersExample);
}
