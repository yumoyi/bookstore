package com.bookstore.demo.service;

import com.bookstore.demo.po.Categorys;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 14:44
 */
public interface CategorysService {

    /**
     * 带分页的全部分类查询
     * @param categorys
     * @param page
     * @param size
     * @return 带分页的分类信息
     */
    PageInfo<Categorys> findAllByPage(Categorys categorys,int page,int size);

    /**
     * 根据id删除分类
     * @param categoryId
     * @return 判断是否删除成功
     */
    Integer deleteById(Integer categoryId);

    /**
     * 添加分类
     * @param categorys
     * @return 判断是否添加成功
     */
    Integer add(Categorys categorys);

    /**
     * 修改分类
     * @param categorys
     * @return 判断是否修改成功
     */
    Integer update(Categorys categorys);

    /**
     * 不带分页的全部分类查询
     * @return 分类信息
     */
    List<Categorys> findAll();

    /**
     * 根据分类信息查询分类是否存在
     * @param categorys
     * @return 分类信息
     */
    Categorys findByCategorys(Categorys categorys);
}
