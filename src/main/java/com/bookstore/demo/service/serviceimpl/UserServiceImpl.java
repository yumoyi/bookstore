package com.bookstore.demo.service.serviceimpl;

import com.aliyuncs.exceptions.ClientException;
import com.bookstore.demo.mapper.UsersMapper;
import com.bookstore.demo.mapper.UsersMapperCustom;
import com.bookstore.demo.po.Users;
import com.bookstore.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cy
 * @since 2019-08-20 8:05
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UsersMapperCustom usersMapperCustom;

    @Autowired
    private UsersMapper usersMapper;


    /**
     * 用户登录
     *
     * @param users
     * @return users
     */
    @Override
    public Users login(Users users) {
        return usersMapperCustom.selectByUser(users);
    }

    /**
     * 用户注册
     *
     * @param users
     * @return users
     */
    @Override
    public Integer register(Users users) {
        return usersMapper.insertSelective(users);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param users
     * @return users
     */
    @Override
    public Users selectByName(Users users) {
        return usersMapperCustom.selectByName(users);
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param users
     * @return users
     */
    @Override
    public Users selectById(Users users) {
        return usersMapperCustom.selectById(users);
    }

    /**
     * 修改用户信息
     *
     * @param users
     * @return integer
     */
    @Override
    public Integer update(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }

    /**
     * 生成手机验证码
     *
     * @param telephone
     * @return code
     */
    @Override
    public String createSmsCode(String telephone) throws ClientException {

        //生成4位随机数
        String code ="";
        for(int i=1;i<=6;i++){
            String code2 = (int)(Math.random()*10)+"";
            code = code + code2;
        }
        System.out.println("验证码:"+code);
        //SendUtils.sendSms(telephone,code);
        return code;
    }


}

