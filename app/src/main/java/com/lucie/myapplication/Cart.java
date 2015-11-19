package com.lucie.myapplication;

import java.util.List;

/**
 * Created by lucie on 11/20/15.
 */
public class Cart<Item> {
    private List<Item> items;

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getAllItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
