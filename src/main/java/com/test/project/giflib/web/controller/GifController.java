package com.test.project.giflib.web.controller;

import com.test.project.giflib.model.Gif;
import com.test.project.giflib.service.CategoryService;
import com.test.project.giflib.service.GifService;
import com.test.project.giflib.web.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by g0ng0n
 */
@Controller
public class GifController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GifService gifService;


    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap){
        List<Gif> list = new ArrayList<>();
        modelMap.put("gifs", list);
        return "home";
    }

    // URL => Http://localhost:8080/gif/android-explosion
    @RequestMapping("/gif/{gifId}")
    public String gifDetails(@PathVariable Long gifId, ModelMap modelMap){

        Gif gif = gifService.findById(gifId);

        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/gifs/{gifId}.gif")
    @ResponseBody
    public byte[] gifImage(@PathVariable Long gifId){
        // Return image data as byte array of the gif whose id is gifid



        return gifService.findById(gifId).getBytes();
    }

    @RequestMapping(value = "/gifs", method = RequestMethod.POST)
    public String addGif(Gif gif, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes){
        // TODO: Upload new GIF if data is valid
        gifService.save(gif, file);

        // flash message for success
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("GIf Succesfully uploaded!", FlashMessage.Status.SUCCESS));
        // TODO: Redirect browser to new GIF's detail view

        return String.format("redirect:/gifs/%s", gif.getId());
    }

    @RequestMapping("/upload")
    public String formNewGif(Model model){

        model.addAttribute("gif", new Gif());
        model.addAttribute("categories", categoryService.findAll());

        return "gif/form";
    }




}
