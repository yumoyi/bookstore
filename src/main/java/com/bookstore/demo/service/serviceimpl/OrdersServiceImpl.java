package com.bookstore.demo.service.serviceimpl;

import com.bookstore.demo.mapper.OrderdetailMapperCustom;
import com.bookstore.demo.mapper.OrdersMapper;
import com.bookstore.demo.mapper.OrdersMapperCustom;
import com.bookstore.demo.po.*;
import com.bookstore.demo.service.OrdersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-25 22:51
 */

@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersMapperCustom ordersMapperCustom;

    @Autowired
    private OrderdetailMapperCustom orderdetailMapperCustom;

    /**
     * 带分页的订单查询
     *
     * @param orders
     * @param page
     * @param size
     * @return pageInfo<Orders>
     */
    @Override
    public PageInfo<Orders> findAllByPage(Orders orders, int page, int size) {

        PageHelper.startPage(page,size);
        List<Orders> list = ordersMapperCustom.findAllByOrders(orders);
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 带分页的订单查询(OrderPage)
     * @param orders
     * @param page
     * @param size
     * @return pageInfo<Orders>
     */
    @Override
    public PageInfo<OrderPage> findAllByPage2(Orders orders, int page, int size) {

        PageHelper.startPage(page,size);
        List<OrderPage> list = ordersMapperCustom.findAllByOrders2(orders);
        PageInfo<OrderPage> pageInfo2 = new PageInfo<>(list);
        return pageInfo2;
    }

    /**
     * 更新订单信息(订单状态)
     *
     * @param orders
     * @return integer
     */
    @Override
    public Integer orderUp(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }

    /**
     * 订单详情查询
     *
     * @param orderdetail
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OrderdetailPage> orderAll(Orderdetail orderdetail, int page, int size) {

        PageHelper.startPage(page,size);
        List<OrderdetailPage> orderdetailPages = orderdetailMapperCustom.orderAll(orderdetail);
        PageInfo<OrderdetailPage> pageInfo = new PageInfo<>(orderdetailPages);
        return pageInfo;
    }

    /**
     * 统计有多少订单
     * @param ordersExample
     * @return integer
     */
    @Override
    public Integer countOrders(OrdersExample ordersExample) {
        return ordersMapper.countByExample(ordersExample);
    }
}
