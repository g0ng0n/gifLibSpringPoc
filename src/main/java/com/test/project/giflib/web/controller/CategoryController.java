package com.test.project.giflib.web.controller;

import com.test.project.giflib.model.Category;
import com.test.project.giflib.model.Gif;
import com.test.project.giflib.service.CategoryService;
import com.test.project.giflib.web.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        modelMap.addAttribute("categories", categories);
        return "category/index";
    }

    @RequestMapping("/categories/{id}")
    public String getCategory(@PathVariable int id, ModelMap modelMap){
        Category category = new Category();
        modelMap.put("category", category);

        List<Gif> list = new ArrayList<>();
        modelMap.put("gifs", list);


        return "category";
    }

    @RequestMapping("categories/add")
    public String formNewCategory(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("colors", Color.values());

        return "category/form";
    }


    @RequestMapping("categories/{categoryId}/edit")
    public String formEditCategory(@PathVariable Long categoryId, Model model){
        // TODO: add model attributes  needed for edit form

        return "category/form";
    }


    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.PUT)
    public String updateCategory(Model model){
        // TODO: add

        return "category/form";
    }


    @RequestMapping(value= "/categories", method= RequestMethod.POST)
    public String addCategory(Category category){
        // TODO: Add category if valid data was received
        categoryService.save(category);

        // TODO: Redirect browser to /categories
        return "redirect:/categories" ;
    }

    @RequestMapping(value = "/categories/{categoryId}/delete", method = RequestMethod.DELETE )
    public String deleteCategory(@PathVariable Long categoryId){
        // TODO: Delete Category if it contains no GIFs

        // TODO: Redirect browser to /categories

        return "redirect:/categories";
    }



}
