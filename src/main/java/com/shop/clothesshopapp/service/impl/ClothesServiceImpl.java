package com.shop.clothesshopapp.service.impl;

import com.shop.clothesshopapp.dao.ClothesDao;
import com.shop.clothesshopapp.entity.Clothes;
import com.shop.clothesshopapp.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    private ClothesDao clothesDao;

    @Override
    public Clothes save(Clothes clothes) {
        return clothesDao.save(clothes);
    }

    @Override
    public List<Clothes> findAll() {
        return (List<Clothes>) clothesDao.findAll();
    }

    @Override
    public Optional<Clothes> findOne(Long id) {
        return clothesDao.findById(id);
    }


    @Override
    public void delete(Clothes clothes) {
        clothesDao.delete(clothes);
    }

    @Override
    public List<Clothes> findByCategory(String category) {
        List<Clothes> clothesList = clothesDao.findByCategory(category);
        return clothesList;
    }


}
