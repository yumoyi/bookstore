package com.bookstore.demo.service.serviceimpl;

import com.bookstore.demo.mapper.AdminMapperCustom;
import com.bookstore.demo.po.Admin;
import com.bookstore.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
/**
 * @author cy
 * @since 2019-08-30 9:18
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapperCustom adminMapperCustom;
    /**
     * 管理员登陆
     *
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        return adminMapperCustom.login(admin);
    }
}
