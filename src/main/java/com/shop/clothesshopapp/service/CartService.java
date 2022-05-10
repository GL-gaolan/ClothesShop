package com.shop.clothesshopapp.service;

import com.shop.clothesshopapp.entity.Clothes;
import com.shop.clothesshopapp.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    ShoppingCart save(ShoppingCart shoppingCart);
    List<ShoppingCart> findAll();

    Optional<ShoppingCart> findOne(Long id);


    void delete(ShoppingCart shoppingCart);

}
