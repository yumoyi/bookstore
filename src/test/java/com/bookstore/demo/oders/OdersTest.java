package com.bookstore.demo.oders;

import com.bookstore.demo.DemoApplication;
import com.bookstore.demo.mapper.OrdersMapperCustom;
import com.bookstore.demo.po.Orders;
import com.bookstore.demo.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-25 23:14
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class OdersTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersMapperCustom ordersMapperCustom;

    @Test
    public void demo1test(){
        Orders orders = new Orders();
        PageInfo<Orders> allByPage = ordersService.findAllByPage(orders, 0, 6);
        System.out.println(allByPage);

    }

    @Test
    public void demo2test(){
        Orders orders = new Orders();
        List<Orders> allByOrders = ordersMapperCustom.findAllByOrders(orders);
        System.out.println(allByOrders);
    }
}
