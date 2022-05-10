package com.shop.clothesshopapp.controller;

import com.shop.clothesshopapp.entity.Clothes;
import com.shop.clothesshopapp.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ClothesService clothesService;

    @RequestMapping("/searchByCategory")
    public String searchByCategory(
            @RequestParam("category") String category,
            Model model){

        List<Clothes> clothesList = clothesService.findByCategory(category);
        model.addAttribute("clothesList",clothesList);

        return "user_ClothesList";

    }
}
