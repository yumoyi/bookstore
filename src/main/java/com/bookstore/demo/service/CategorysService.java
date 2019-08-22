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
     * @return
     */
    PageInfo<Categorys> findAllByPage(Categorys categorys,int page,int size);

    /**
     * 根据id删除分类
     * @param categoryId
     * @return Integer
     */
    Integer deleteById(Integer categoryId);

    /**
     * 添加分类
     * @param categorys
     * @return Integer
     */
    Integer add(Categorys categorys);

    /**
     * 修改分类
     * @param categorys
     * @return Integer
     */
    Integer update(Categorys categorys);

    /**
     * 不带分页的全部分类查询
     * @return categorys
     */
    List<Categorys> findAll();

    /**
     * 根据分类信息查询分类是否存在
     * @param categorys
     * @return categorys
     */
    Categorys findByCategorys(Categorys categorys);
}
