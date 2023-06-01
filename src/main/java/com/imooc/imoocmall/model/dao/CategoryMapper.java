package com.imooc.imoocmall.model.dao;

import com.imooc.imoocmall.model.pojo.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category row);

    int insertSelective(Category row);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category row);

    int updateByPrimaryKey(Category row);

    Category selectByName(String name);
}