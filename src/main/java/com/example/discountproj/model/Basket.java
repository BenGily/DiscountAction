package com.example.discountproj.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
public class Basket {
    private List<LineItem> items;


    public Basket() {
        items = new ArrayList<>();
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public void removeItem(LineItem item) {
        items.remove(item);
    }

    public double calculateTotal() {

        double total = 0;
        for (LineItem item : items) {
            total += item.getPrice() * item.getQuantity();
            //System.out.println(item.getPrice());
        }
        return total;

    }

    public void clear() {
        items.clear();
        // Reset any other necessary state here
    }

    public List<LineItem> getItems() {
        return new ArrayList<>(items);
    }
}