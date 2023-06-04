package com.imooc.imoocmall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.imoocmall.model.pojo.Category;
import com.imooc.imoocmall.model.request.AddCategoryReq;

public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(Category category);

    void delete(Integer id);

    PageInfo<Category> listForAdmin(Integer pageNum, Integer pageSize);
}
