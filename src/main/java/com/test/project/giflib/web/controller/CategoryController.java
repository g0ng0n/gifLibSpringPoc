package com.test.project.giflib.web.controller;

import com.test.project.giflib.model.Category;
import com.test.project.giflib.model.Gif;
import com.test.project.giflib.service.CategoryService;
import com.test.project.giflib.web.Color;
import com.test.project.giflib.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by g0ng0n.
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

        if (!model.containsAttribute("category")){

            model.addAttribute("category", new Category());

        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action", "/categories");
        model.addAttribute("heading", "New Category");
        model.addAttribute("submit", "Add");
        return "category/form";
    }


    @RequestMapping("categories/{categoryId}/edit")
    public String formEditCategory(@PathVariable Long categoryId, Model model){


        if (!model.containsAttribute("category")){

            model.addAttribute("category", categoryService.findById(categoryId));

        }
        model.addAttribute("colors", Color.values());
        model.addAttribute("action", String.format("/categories/%s", categoryId));
        model.addAttribute("heading", "Edit Category");
        model.addAttribute("submit", "Update");

        return "category/form";
    }


    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.PUT)
    public String updateCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){

            // Include Validation errors upon redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category", result);

            // Add Category if invalid was received
            redirectAttributes.addFlashAttribute("category", category);

            redirectAttributes.addFlashAttribute("flash",
                    new FlashMessage("Error while adding the new category", FlashMessage.Status.FAILURE));

            // Redirect back to the form
            return String.format("redirect:/categories/%s/edit", category.getId());
        }

        // Add category if valid data was received
        categoryService.save(category);

        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Category Successfully Updated", FlashMessage.Status.SUCCESS));
        // Redirect browser to /categories
        return "redirect:/categories" ;
    }


    @RequestMapping(value= "/categories", method= RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){

            // Include Validation errors upon redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category", result);

            // Add Category if invalid was received
            redirectAttributes.addFlashAttribute("category", category);

            redirectAttributes.addFlashAttribute("flash", new FlashMessage("Error while adding the new category", FlashMessage.Status.FAILURE));

            // Redirect back to the form
            return "redirect:/categories/add";
        }

        // TODO: Add category if valid data was received
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Category successfully Added", FlashMessage.Status.SUCCESS));
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
