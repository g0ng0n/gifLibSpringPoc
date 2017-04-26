package com.test.project.giflib.service;

import com.test.project.giflib.model.Category;

import java.util.List;

/**
 * Created by g0ng0n.
 */
public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Category category);
}
