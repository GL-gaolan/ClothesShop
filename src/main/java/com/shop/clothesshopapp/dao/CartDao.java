package com.shop.clothesshopapp.dao;

import com.shop.clothesshopapp.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface CartDao extends CrudRepository<ShoppingCart,Long> {

}
