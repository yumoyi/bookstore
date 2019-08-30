package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cy
 * @since 2019-08-20 10:28
 */
@Mapper
public interface AdminMapperCustom {

    /**
     * 管理员登录
     * @param admin
     * @return admin
     */
    Admin login(Admin admin);
}
