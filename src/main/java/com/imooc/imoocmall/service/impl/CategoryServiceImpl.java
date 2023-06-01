package com.imooc.imoocmall.service.impl;

import com.imooc.imoocmall.exception.ImoocMallException;
import com.imooc.imoocmall.exception.ImoocMallExceptionEnum;
import com.imooc.imoocmall.model.dao.CategoryMapper;
import com.imooc.imoocmall.model.pojo.Category;
import com.imooc.imoocmall.model.request.AddCategoryReq;
import com.imooc.imoocmall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public void add(AddCategoryReq addCategoryReq) {
        Category category = new Category();
        category.setName(addCategoryReq.getName());
        // 将addCategory中的属性直接拷贝到category中
        BeanUtils.copyProperties(addCategoryReq, category);
        // 不用一个一个的set属性值了
        Category categoryOld = categoryMapper.selectByName(addCategoryReq.getName());
        // 判断原来有没有
        if (categoryOld != null) {
            // 如果为空说明之前有目录不允许创建
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTD);
        }
        int count = categoryMapper.insertSelective(category);
        if (count == 0) {
            throw new ImoocMallException(ImoocMallExceptionEnum.CREATE_FAILED);
        }


    }

    @Override
    public void update(Category updateCategory){
        if (updateCategory.getName() != null){
            Category categoryOld=categoryMapper.selectByName(updateCategory.getName());
            if (categoryOld !=null && !categoryOld.getId().equals(updateCategory.getId())){
                throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTD);
            }
        }
        int count = categoryMapper.updateByPrimaryKeySelective(updateCategory);
        if (count == 0){
            throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
        }
    }
}
