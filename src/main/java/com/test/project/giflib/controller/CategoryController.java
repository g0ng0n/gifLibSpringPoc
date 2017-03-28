package com.test.project.giflib.controller;

import com.test.project.giflib.data.CategoryRepository;
import com.test.project.giflib.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by gonzalo.gisbert on 28/03/17.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @RequestMapping(value = "/")
    public String listCategories(ModelMap modelMap){
        List<Category> list = categoryRepository.getAllCategories();
        modelMap.put("categories", list);
        return "categories";
    }

    @RequestMapping("/categories/{id}")
    public String getCategory(@PathVariable int id, ModelMap map){
        Category category = categoryRepository.findById(id);
        map.put("category", category);

        return "category";
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
