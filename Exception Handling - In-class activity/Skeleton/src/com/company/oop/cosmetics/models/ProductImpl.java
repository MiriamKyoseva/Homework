package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;

public class ProductImpl implements Product {
    private static final int MIN_PRODUCT_NAME_LENGTH = 3;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MIN_BRAND_NAME_LENGTH = 2;
    private static final int MAX_BRAND_NAME_LENGTH = 10;
    private static final String INVALID_PRODUCT_NAME_ERROR = String.format("Product name should be between %d and %d symbols.", MIN_PRODUCT_NAME_LENGTH, MAX_PRODUCT_NAME_LENGTH);
    private static final String INVALID_BRAND_NAME_ERROR = String.format("Brand name should be between %d and %d symbols.", MIN_BRAND_NAME_LENGTH, MAX_BRAND_NAME_LENGTH);
    private static final String INVALID_PRICE_ERROR = "Price cannot be negative or zero.";

    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH)
            throw new IllegalArgumentException(INVALID_PRODUCT_NAME_ERROR);
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        if (brand.length() < MIN_BRAND_NAME_LENGTH || brand.length() > MAX_BRAND_NAME_LENGTH)
            throw new IllegalArgumentException(INVALID_BRAND_NAME_ERROR);
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException(INVALID_PRICE_ERROR);
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                " #Price: $%.2f%n" +
                " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }

}
