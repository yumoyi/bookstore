package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Categorys;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 10:32
 */
@Mapper
public interface CategorysMapperCustom {


    /**
     * 根据名称查分类(名称为空查所有分类)
     * @param categorys
     * @return 分类信息
     */
    List<Categorys> findAllByName(Categorys categorys);


    /**
     * 查询所有分类
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
