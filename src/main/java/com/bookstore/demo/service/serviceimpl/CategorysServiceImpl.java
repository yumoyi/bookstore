package com.bookstore.demo.service.serviceimpl;

import com.bookstore.demo.mapper.CategorysMapper;
import com.bookstore.demo.mapper.CategorysMapperCustom;
import com.bookstore.demo.po.Categorys;
import com.bookstore.demo.service.CategorysService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 14:44
 */
@Service
public class CategorysServiceImpl implements CategorysService {


    @Autowired
    private CategorysMapper categorysMapper;

    @Autowired
    private CategorysMapperCustom categorysMapperCustom;
    /**
     * 带分页的全部分类查询
     *
     * @param categorys
     * @param page
     * @param size
     * @return 带分页的分类信息
     */
    @Override
    public PageInfo<Categorys> findAllByPage(Categorys categorys, int page, int size) {

        PageHelper.startPage(page,size);
        List<Categorys> allByName = categorysMapperCustom.findAllByName(categorys);
        PageInfo<Categorys> pageInfo = new PageInfo<>(allByName);
        return pageInfo;
    }

    /**
     * 根据id删除分类
     *
     * @param categoryId
     * @return 判断是否删除成功
     */
    @Override
    public Integer deleteById(Integer categoryId) {
        return categorysMapper.deleteByPrimaryKey(categoryId);
    }

    /**
     * 添加分类
     *
     * @param categorys
     * @return 判断是否添加成功
     */
    @Override
    public Integer add(Categorys categorys) {
        return categorysMapper.insertSelective(categorys);
    }

    /**
     * 修改分类
     *
     * @param categorys
     * @return 判断是否修改成功
     */
    @Override
    public Integer update(Categorys categorys) {
        return categorysMapper.updateByPrimaryKeySelective(categorys);
    }

    /**
     * 不带分页的全部分类查询
     * @return 分类信息
     */
    @Override
    public List<Categorys> findAll() {
        return categorysMapperCustom.findAll();
    }

    /**
     * 根据分类信息查询分类是否存在
     *
     * @param categorys
     * @return 分类信息
     */
    @Override
    public Categorys findByCategorys(Categorys categorys) {
        return categorysMapperCustom.findByCategorys(categorys);
    }

}
