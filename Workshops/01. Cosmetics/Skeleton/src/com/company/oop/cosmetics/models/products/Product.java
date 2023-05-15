package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {

    private static final int MIN_LENGTH_PRODUCT_NAME = 3;
    private static final int MAX_LENGTH_PRODUCT_NAME = 10;
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < MIN_LENGTH_PRODUCT_NAME || name.length() > MAX_LENGTH_PRODUCT_NAME) throw new IllegalArgumentException("Product's name must be between 3 symbols and 10 symbols");
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand.length() < 2 || brand.length() > 10) throw new IllegalArgumentException("Brand's name must be between 2 symbols and 10 symbols");
        this.brand = brand;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }
    
    public String print() {
        String print = " #" + getName() + " " + getBrand() + System.lineSeparator() + " #Price: $" + String.format("%.2f", getPrice()) + System.lineSeparator() + " #Gender: " + getGender() + System.lineSeparator() + " ===";
        return print;
    }
    
}
