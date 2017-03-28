package com.test.project.giflib.controller;

import com.test.project.giflib.data.GifRepository;
import com.test.project.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by gonzalo.gisbert on 27/03/17.
 */
@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap){
        List<Gif> list = gifRepository.getAllGifs();
        modelMap.put("gifs", list);
        return "home";
    }

    // URL => Http://localhost:8080/gif/android-explosion
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){

        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    public GifRepository getGifRepository() {
        return gifRepository;
    }

    public void setGifRepository(GifRepository gifRepository) {
        this.gifRepository = gifRepository;
    }
}
