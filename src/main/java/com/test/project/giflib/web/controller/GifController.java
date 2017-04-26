package com.test.project.giflib.web.controller;

import com.test.project.giflib.model.Gif;
import com.test.project.giflib.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by g0ng0n
 */
@Controller
public class GifController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap){
        List<Gif> list = new ArrayList<>();
        modelMap.put("gifs", list);
        return "home";
    }

    // URL => Http://localhost:8080/gif/android-explosion
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){

        Gif gif = new Gif();
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping(value = "/gifs", method = RequestMethod.POST)
    public String addGif(@RequestParam MultipartFile file){
        // TODO: Upload new GIF if data is valid

        // TODO: Redirect browser to new GIF's detail view

        return null;
    }

    @RequestMapping("/upload")
    public String formNewGif(Model model){

        model.addAttribute("gif", new Gif());
        model.addAttribute("categories", categoryService.findAll());

        return "gif/form";
    }




}
