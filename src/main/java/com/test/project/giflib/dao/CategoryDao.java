package com.test.project.giflib.dao;

import com.test.project.giflib.model.Category;

import java.util.List;

/**
 * Created by g0ng0n.
 */
public interface CategoryDao {

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Category category);
}
