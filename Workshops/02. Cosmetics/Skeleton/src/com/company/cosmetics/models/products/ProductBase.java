package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;

import static com.company.cosmetics.models.common.Errors.*;


public class ProductBase implements Product {
    protected int MIN_PRODUCT_NAME_LENGTH = 3;
    protected int MAX_PRODUCT_NAME_LENGTH = 10;
    protected int MIN_BRAND_NAME_LENGTH = 2;
    protected int MAX_BRAND_NAME_LENGTH = 10;

    protected String name;
    protected String brand;
    protected Double price;
    protected GenderType gender;

    public void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty())
            throw new IllegalArgumentException(NAME_EMPTY_ERROR);
        if (name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH)
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR, MIN_PRODUCT_NAME_LENGTH, MAX_PRODUCT_NAME_LENGTH));
        this.name = name;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank() || brand.isEmpty())
            throw new IllegalArgumentException(NAME_EMPTY_ERROR);
        if (brand.length() < MIN_BRAND_NAME_LENGTH || brand.length() > MAX_BRAND_NAME_LENGTH)
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR, MIN_BRAND_NAME_LENGTH, MAX_BRAND_NAME_LENGTH));
        this.brand = brand;
    }

    public void setPrice(Double price) {
        if (price < 0) throw new IllegalArgumentException(NEGATIVE_PRICE_ERROR);
        this.price = price;
    }

    ProductBase(String name, String brand, Double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        String print = String.format("#%s %s%n #Price: $%.2f%n #Gender: %s%n===", getName(), getBrand(), getPrice(), getGender());
        return print;
    }
}
