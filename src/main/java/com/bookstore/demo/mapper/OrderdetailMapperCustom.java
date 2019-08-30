package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Orderdetail;
import com.bookstore.demo.po.OrderdetailPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 10:32
 */
@Mapper
public interface OrderdetailMapperCustom {

    /**
     * 查询订单详情
     * @param orderdetail
     * @return
     */
    List<OrderdetailPage> orderAll(Orderdetail orderdetail);
}
