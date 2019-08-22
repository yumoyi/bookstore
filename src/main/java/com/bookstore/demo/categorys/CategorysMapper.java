package com.bookstore.demo.categorys;

import com.bookstore.demo.po.Categorys;
import com.bookstore.demo.po.CategorysExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategorysMapper {
    int countByExample(CategorysExample example);

    int deleteByExample(CategorysExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(Categorys record);

    int insertSelective(Categorys record);

    List<Categorys> selectByExample(CategorysExample example);

    Categorys selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") Categorys record, @Param("example") CategorysExample example);

    int updateByExample(@Param("record") Categorys record, @Param("example") CategorysExample example);

    int updateByPrimaryKeySelective(Categorys record);

    int updateByPrimaryKey(Categorys record);
}