/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AD
 */
public class CartDTO {

    private List<Item> items;

    public CartDTO() {
        items = new ArrayList<>();
    }

    public CartDTO(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    private Item getItemById(int id) {
        for (Item item : items) {
            if (item.getProduct().getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item newItem) {
        if (getItemById(newItem.getProduct().getId()) != null) {
            Item oldItem = getItemById(newItem.getProduct().getId());
            oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());
        } else {
            items.add(newItem);
        }
    }

    public void changeQuantity(int pid, int quantity) {
        Item item = getItemById(pid);
        item.setQuantity(quantity);
        if (quantity == 0) {
            removeItem(pid);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public float getTotalMoney() {
        float money = 0;
        for (Item item : items) {
            money += (item.getQuantity() * item.getProduct().getPrice());
        }
        return money;
    }

}
