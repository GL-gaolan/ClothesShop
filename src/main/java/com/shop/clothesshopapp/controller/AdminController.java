package com.shop.clothesshopapp.controller;

import com.shop.clothesshopapp.entity.Admin;
import com.shop.clothesshopapp.entity.Clothes;
import com.shop.clothesshopapp.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ClothesService clothesService;

    @RequestMapping("/")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/adminpro", method = RequestMethod.POST)
    public String login(Model model,
                        @ModelAttribute("admin") Admin admin) {
        System.out.println(admin.getPassword());
        System.out.println(admin.getUsername());
        if (admin.getUsername().equals("admin") && admin.getPassword().equals("admin")){
            return "admin";
        }
//        model.addAttribute("classActiveLogin", true);
        return "sorry";
    }

    @RequestMapping(value = "/adminpro/add", method = RequestMethod.POST)
    public String addClothesPost(
            @ModelAttribute("clothes") Clothes clothes, HttpServletRequest request) {

        System.out.println(clothes);

        clothesService.save(clothes);//generate id

        MultipartFile clothesImage = clothes.getClothesImage();

        try {
            byte[] bytes = clothesImage.getBytes();
            System.out.println(bytes);
            String name = clothes.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/clothes/" + name)));

            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:clothesList";
    }

    @RequestMapping(value = "/adminpro/add", method = RequestMethod.GET)
    public String addClothesGet(Model model) {
        Clothes clothes = new Clothes();
        model.addAttribute("clothes", clothes);
        System.out.println(clothes);
        return "admin_addClothes";
    }

    @RequestMapping(value = "/adminpro/clothesList", method = RequestMethod.GET)
    public String clothesList(Model model) {

        List<Clothes> clothesList = clothesService.findAll();
        for (Clothes c :
                clothesList) {
            System.out.println(c);
        }
        model.addAttribute("clothesList", clothesList);
        return "admin_clothesList";
    }

    @RequestMapping(value = "/adminpro/clothesInfo")
    public String clothesInfo(
            @RequestParam("id") Long id, Model model) {

        Clothes clothes = clothesService.findOne(id).orElse(null);
        model.addAttribute("clothes", clothes);
        return "admin_clothesInfo";
    }

    @RequestMapping(value = "/adminpro/updateClothes")
    public String updateClothes(@RequestParam("id") Long id, Model model) {
        Clothes clothes = clothesService.findOne(id).orElse(null);
        model.addAttribute("clothes", clothes);
        return "admin_update";
    }

    @RequestMapping(value = "/adminpro/updateClothes", method = RequestMethod.POST)
    public String updateClothesPost(@ModelAttribute("clothes") Clothes clothes,
                                    HttpServletRequest request) {
        clothesService.save(clothes);
        System.out.println("updateClothes...");
        MultipartFile clothesImage = clothes.getClothesImage();

        if (!clothesImage.isEmpty()) {
            try {
                byte[] bytes = clothesImage.getBytes();
                System.out.println(bytes);
                String name = clothes.getId() + ".png";
                Files.delete(Paths.get("src/main/resources/static/image/clothes/" + name));
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("src/main/resources/static/image/clothes/" + name)));

                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/admin/adminpro/clothesInfo?id=" + clothes.getId();
    }

    @RequestMapping(value = "/adminpro/deleteClothes")
    public String deleteClothes(@PathParam("id") Long id, Model model){

        Clothes clothes = clothesService.findOne(id).orElse(null);
        clothesService.delete(clothes);


        return  "redirect:clothesList";
    }
}