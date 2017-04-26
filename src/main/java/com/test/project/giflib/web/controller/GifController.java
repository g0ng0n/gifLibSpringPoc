package com.test.project.giflib.web.controller;

import com.test.project.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by g0ng0n
 */
@Controller
public class GifController {


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

}
