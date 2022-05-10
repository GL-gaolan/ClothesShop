package com.shop.clothesshopapp.entity;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String size;
    private double price;

    @Column(columnDefinition = "text")
    private String description;

    /**
     * file
     */
    @Transient
    private MultipartFile clothesImage;

    public Clothes() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getClothesImage() {
        return clothesImage;
    }

    public void setClothesImage(MultipartFile clothesImage) {
        this.clothesImage = clothesImage;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", clothesImage=" + clothesImage +
                '}';
    }
}
