package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> productList;
    
    public ShoppingCart() {
        productList = new ArrayList<>();
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }
    
    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product is null.");
        productList.add(product);
    }
    
    public void removeProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product is null.");
        productList.remove(product);
    }
    
    public boolean containsProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product is null.");
        return productList.contains(product);
    }
    
    public double totalPrice() {
        double totalPrice = 0;
        for (Product kur : productList) {
            totalPrice += kur.getPrice();
        }
        return totalPrice;
    }
    
}
