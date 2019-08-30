package com.bookstore.demo.mapper;

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
     * @return List<Orders>
     */
    List<Orders> findAllByOrders(Orders orders);

    /**
     * 查询订单(OrderPage)
     * @param orders
     * @return List<OrderPage>
     */
    List<OrderPage> findAllByOrders2(Orders orders);
}
