package com.shop.clothesshopapp.service.impl;

import com.shop.clothesshopapp.dao.CartDao;
import com.shop.clothesshopapp.entity.ShoppingCart;
import com.shop.clothesshopapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;


    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return cartDao.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return (List<ShoppingCart>) cartDao.findAll();
    }

    @Override
    public Optional<ShoppingCart> findOne(Long id) {
        return cartDao.findById(id);
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        cartDao.delete(shoppingCart);
    }
}
