package com.test.project.giflib.web.controller;

import com.test.project.giflib.model.Category;
import com.test.project.giflib.model.Gif;
import com.test.project.giflib.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonzalo.gisbert on 28/03/17.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/categories")
    public String listCategories(ModelMap modelMap){

        List<Category> categories = categoryService.findAll();

        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/categories/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap){
        Category category = new Category();
        modelMap.put("category", category);

        List<Gif> list = new ArrayList<>();
        modelMap.put("gifs", list);


        return "category";
    }



}
