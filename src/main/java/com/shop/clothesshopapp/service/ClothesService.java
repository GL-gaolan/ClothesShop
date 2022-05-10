package com.shop.clothesshopapp.service;

import com.shop.clothesshopapp.entity.Clothes;

import java.util.List;
import java.util.Optional;

public interface ClothesService {

    Clothes save(Clothes clothes);

    List<Clothes> findAll();

    Optional<Clothes> findOne(Long id);

    void delete(Clothes clothes);


    List<Clothes> findByCategory(String category);

}
