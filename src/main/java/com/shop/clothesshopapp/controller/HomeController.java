package com.shop.clothesshopapp.controller;


import com.shop.clothesshopapp.entity.Admin;
import com.shop.clothesshopapp.entity.Clothes;
import com.shop.clothesshopapp.entity.ShoppingCart;
import com.shop.clothesshopapp.service.CartService;
import com.shop.clothesshopapp.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ClothesService clothesService;

    @Autowired
    CartService cartService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/myAccount")
    public String myAccount(
            Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "admin_myAccount";
    }


    @RequestMapping("/userClothesList")
    public String userClothesList(Model model) {
        List<Clothes> clothesList = clothesService.findAll();
        for (Clothes c :
                clothesList) {
            System.out.println(c);
        }
        model.addAttribute("clothesList", clothesList);
        return "user_ClothesList";
    }

    @RequestMapping("/clothesDetail")
    public String clothesDetail(
            @PathParam("id") Long id,
            Model model) {
        Clothes clothes = clothesService.findOne(id).orElse(null);
        model.addAttribute("clothes", clothes);
        return "user_clothesDetail";
    }


    @RequestMapping(value = "/ShoppingCart", method = RequestMethod.POST)
    public String shoppingCart(Model model,
                               @PathParam("id") Long id,
                               HttpServletRequest request) {

        System.out.println("id" + id);
        Clothes clothes = clothesService.findOne(id).orElse(null);
        String name = clothes.getName();
        double price = clothes.getPrice();
//         <img th:src="'http://localhost:8080'+ @{/image/clothes/} + ${cartItem.id} +'.png'">

//          MultipartFile clothesImage = clothes.getClothesImage();


        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItemname(name);
        shoppingCart.setPrice(price);
        shoppingCart.setClothesId(id);

        System.out.println(shoppingCart);

        cartService.save(shoppingCart);

        return "redirect:/clothesDetail?id=" + clothes.getId();
    }

    @RequestMapping(value = "/ShoppingCart")
    public String shoppingCart(Model model) {

        System.out.println("shoppingcart....");
        List<ShoppingCart> cartAllItem = cartService.findAll();
        model.addAttribute("cartAllItem", cartAllItem);
        for (ShoppingCart c :
                cartAllItem) {
            System.out.println(c);
        }

        return "user_ShoppingCart";
    }

    @RequestMapping(value = "/Checkout")
    public String Checkout(@ModelAttribute("cartAllItem") ShoppingCart shoppingCart,
                           Model model) {
//        cartService.save(shoppingCart);
        List<ShoppingCart> cartAllItem = cartService.findAll();

        Double allPrice = Double.valueOf(0);
        for (ShoppingCart c :
                cartAllItem) {
            allPrice += c.getPrice();

        }
        model.addAttribute("allPrice", allPrice);
        System.out.println(allPrice);
//        shoppingCart.getPrice();
        return "user_checkout";
    }

    @RequestMapping(value = "/cartDelete")
    public String cartDelete(@PathParam("id") Long id,
                             Model model) {
        ShoppingCart item = cartService.findOne(id).orElse(null);
        cartService.delete(item);
        return "redirect:/ShoppingCart";

    }


}
