package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Address;
import com.bookstore.demo.po.OrderPage;
import com.bookstore.demo.po.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 10:33
 */
@Mapper
public interface OrdersMapperCustom {
    /**
     * 查询订单
     * @param orders
     * @return 订单信息
     */
    List<Orders> findAllByOrders(Orders orders);

    /**
     * 查询订单(OrderPage)
     * @param orders
     * @return 订单信息
     */
    List<OrderPage> findAllByOrders2(Orders orders);

    /**
     * 查询收货人
     * @param orderId
     * @return 收货人信息
     */
    Orders selectAddress(String orderId);
}
