package com.itheima.service;

import com.itheima.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    //新建分类
    void add(Category category);
//    列表查询
    List<Category> list();
//    根据id查询分类信息
    Category findById(Integer id);
}
