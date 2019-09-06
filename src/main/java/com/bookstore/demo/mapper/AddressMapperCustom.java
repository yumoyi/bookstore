package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 10:27
 */
@Mapper
public interface AddressMapperCustom {

    /**
     * 查询收货人
     * @param userId
     * @return 收货人信息
     */
    List<Address> userAddress(Integer userId);

}
