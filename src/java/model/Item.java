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
public class Item {
    
    private ProductsDTO product;
    private int sizeId;
    private int quantity;
    private float price;

    public Item(ProductsDTO product,int sizeId, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.sizeId = sizeId;
    }
    
}
