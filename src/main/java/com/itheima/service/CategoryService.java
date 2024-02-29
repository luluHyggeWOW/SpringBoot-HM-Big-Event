package com.itheima.service;

import com.itheima.pojo.Category;
import org.springframework.stereotype.Service;

public interface CategoryService {
    //新建分类
    void add(Category category);
}
