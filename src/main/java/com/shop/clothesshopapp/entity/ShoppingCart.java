package com.shop.clothesshopapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String itemname;
    private Double price;
    private Integer qty;
    private Long clothesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }


    public Long getClothesId() {
        return clothesId;
    }

    public void setClothesId(Long clothesId) {
        this.clothesId = clothesId;
    }

    public ShoppingCart(Long id, String itemname, Double price, Integer qty, Long clothesId) {
        this.id = id;
        this.itemname = itemname;
        this.price = price;
        this.qty = qty;
        this.clothesId = clothesId;
    }


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", itemname='" + itemname + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", clothesId=" + clothesId +
                '}';
    }

    public ShoppingCart() {
    }

}
