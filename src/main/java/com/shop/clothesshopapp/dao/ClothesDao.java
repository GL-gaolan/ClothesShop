package com.shop.clothesshopapp.dao;

import com.shop.clothesshopapp.entity.Clothes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothesDao extends CrudRepository<Clothes,Long>{
    List<Clothes> findByCategory(String category);
}
