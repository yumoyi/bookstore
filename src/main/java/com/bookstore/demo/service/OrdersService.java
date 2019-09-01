package com.bookstore.demo.service;

import com.bookstore.demo.po.OrderPage;
import com.bookstore.demo.po.Orderdetail;
import com.bookstore.demo.po.Orders;
import com.bookstore.demo.po.OrdersExample;
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
     * @return 带分页的订单信息
     */
    PageInfo<Orders> findAllByPage(Orders orders, int page, int size);

    /**
     * 带分页的订单查询(OrderPage)
     * @param orders
     * @param page
     * @param size
     * @return 订单信息
     */
    PageInfo<OrderPage> findAllByPage2(Orders orders, int page, int size);

    /**
     * 更新订单信息(订单状态)
     * @param orders
     * @return 判断是否修改成功
     */
    Integer orderUp(Orders orders);

    /**
     * 订单详情查询
     * @param orderdetail
     * @param page
     * @param size
     * @return 订单详情信息
     */
    PageInfo<Orderdetail> orderAll(Orderdetail orderdetail, int page, int size);

    /**
     * 统计有多少订单
     * @param ordersExample
     * @return 订单总数
     */
    Integer countOrders(OrdersExample ordersExample);
}
