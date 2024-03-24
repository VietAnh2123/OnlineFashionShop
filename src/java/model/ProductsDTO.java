/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author AD
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDTO {
    
    private int id;
    private String name;
    private String description;
    private double price;
    private int discount;
    private int category_id;
    private String[] images;
    private String color;
    
    private int sizeID;
    private String sizeName;
    private int stock;

    public ProductsDTO(int id, String name, String description, double price, int discount, int category_id, String[] images, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.category_id = category_id;
        this.images = images;
        this.color = color;
    }
    
    
    
}
