package com.company.cosmetics.models;


import com.company.cosmetics.models.contracts.Category;
import com.company.cosmetics.models.contracts.Product;


import java.util.ArrayList;
import java.util.List;

import static com.company.cosmetics.models.common.Errors.*;

public class CategoryImpl implements Category {
    private static final int MIN_LENGTH_CATEGORY_NAME = 2;
    private static final int MAX_LENGTH_CATEGORY_NAME = 15;
    
    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() < MIN_LENGTH_CATEGORY_NAME || name.length() > MAX_LENGTH_CATEGORY_NAME)
            throw new IllegalArgumentException(String.format(CATEGORY_NAME_LENGTH_ERROR, MIN_LENGTH_CATEGORY_NAME, MAX_LENGTH_CATEGORY_NAME));
        this.name = name;
    }
    
    public CategoryImpl(String name) {
        products = new ArrayList<>();
        setName(name);
    }
    

    
    public List<Product> getProducts() {
        //If we return directly ArrayList products, because it is a reference type, we can then change the original ArrayList products
        //which is undesirable.
        //To ensure nothing changes in the original, we encapsulate it by returning a new ArrayList.
        return new ArrayList<>(products);
    }
    
    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException(PRODUCT_NULL_ERROR);
        products.add(product);
    }
    
    public void removeProduct(Product product) {
        if (!products.contains(product)) throw new IllegalArgumentException(PRODUCT_DOES_NOT_EXIST_ERROR);
        products.remove(product);
    }

    public String print() {
        StringBuilder category = new StringBuilder("#Category: " + getName());
        if (products.size() == 0) {
            return String.format("#Category: %s\n" +
                    " #No product in this category", name);
        }
        for (Product kur : products) {
            category.append(System.lineSeparator()).append(kur.print());
        }
        return String.valueOf(category);
    }
    
}
