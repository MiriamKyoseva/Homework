package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2 || name.length() > 15) throw new IllegalArgumentException("Category's name must be between 2 symbols and 15 symbols.");
        this.name = name;
    }

    public Category(String name) {
        products = new ArrayList<>();
        setName(name);
    }
    
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
    
    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product is null.");
        products.add(product);
    }
    
    public void removeProduct(Product product) {
        if (!products.contains(product)) throw new IllegalArgumentException("#Category: " + getName() + System.lineSeparator() + " #No product in this category");
        products.remove(product);
    }
    
    public String print() {
        StringBuilder category = new StringBuilder("#Category: " + getName());
        if (products.isEmpty()) return category + System.lineSeparator() + " #No product in this category";
        for (Product kur : products) {
            category.append(System.lineSeparator()).append(kur.print());
        }
        return String.valueOf(category);
    }
    
}
