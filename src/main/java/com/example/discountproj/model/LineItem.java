package com.example.discountproj.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class LineItem {
    private String itemName;
    private double price;
    private int quantity;

    public LineItem() {
        // default constructor
    }

    public LineItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price){
        return this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method to get total price for the line item
    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "com.example.myapp.LineItem{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}