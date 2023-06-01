package com.imooc.imoocmall.service;

import com.imooc.imoocmall.model.pojo.Category;
import com.imooc.imoocmall.model.request.AddCategoryReq;

public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(Category category);
}
