package com.bookstore.demo.mapper;

import com.aliyuncs.exceptions.ClientException;
import com.bookstore.demo.DemoApplication;
import com.bookstore.demo.po.Categorys;
import com.bookstore.demo.po.CategorysExample;
import com.bookstore.demo.po.Users;
import com.bookstore.demo.service.CategorysService;
import com.bookstore.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-19 16:03
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class CategorysMapperTest {

    @Autowired
    private CategorysMapper categorysMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CategorysService categorysService;

    @Test
    public void demo1test(){
        CategorysExample categorysExample = new CategorysExample();
        List<Categorys> categorys = categorysMapper.selectByExample(categorysExample);
        System.out.println(categorys);
    }

    @Test
    public void demo2test(){
        Users users = new Users();
        users.setUserName("yqq");
        users.setUserPassword("123");
        Users user =userService.login(users);
        if(user!=null){
            System.out.println(user);
        }else {
            System.out.println("yqq不存在");
        }
    }

    @Test
    public void demo3test(){
        Users users = new Users();
        users.setUserName("qq");
        users.setUserPassword("123");
        users.setUserPhone("111");
        Integer register = userService.register(users);
        System.out.println(register);
    }

    @Test
    public void demo4test(){
        Users users = new Users();
        users.setUserId(1);
        users.setUserPhone("1234444");
        Integer integer = userService.update(users);
        System.out.println(integer);
    }

    @Test
    public void demo5test(){
        Categorys categorys = new Categorys();
        categorys.setCategoryName("学");
        PageInfo<Categorys> allByPage = categorysService.findAllByPage(categorys,2,2);
        System.out.println(allByPage);
    }

    @Test
    public void demo6test(){
        Integer integer = categorysService.deleteById(9);
        System.out.println(integer);
    }
    @Test
    public void demo7test(){
        List<Categorys> all = categorysService.findAll();
        System.out.println(all);
    }
    @Test
    public void demo8test(){
        Categorys categorys = new Categorys();
        categorys.setCategoryName("小妖怪");
        Integer integer = categorysService.add(categorys);
        System.out.println(integer);
    }
    @Test
    public void demo9test(){
        Categorys categorys = new Categorys();
        categorys.setCategoryName("小妖怪");
        categorys.setCategoryId(10);
        Integer update = categorysService.update(categorys);
        System.out.println(update);
    }
    @Test
    public void demo10test(){
        Categorys categorys = new Categorys();
        categorys.setCategoryId(3);
        Categorys byName = categorysService.findByCategorys(categorys);
        System.out.println(byName);
    }

    @Test
    public void demo11test() throws ClientException {
        userService.createSmsCode("18630606138");
    }
}
