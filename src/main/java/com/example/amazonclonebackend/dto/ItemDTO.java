package com.example.amazonclonebackend.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDTO implements Serializable {
    private String code;
    private String title;
    private String image;
    private Rating rating;
    private int qty;
    private BigDecimal unit_price;
    private String description;

    public enum Rating{
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    }

    public ItemDTO() {
    }

    public ItemDTO(String code, String title, String image, Rating rating, int qty, BigDecimal unit_price, String description) {
        this.code = code;
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.qty = qty;
        this.unit_price = unit_price;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", qty=" + qty +
                ", unit_price=" + unit_price +
                ", description='" + description + '\'' +
                '}';
    }
}
