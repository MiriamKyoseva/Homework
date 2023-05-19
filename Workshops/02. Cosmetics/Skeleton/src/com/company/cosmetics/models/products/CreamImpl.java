package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;


public class CreamImpl extends ProductBase implements Cream {
    private ScentType scent;

    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        this.scent = scent;
    }

    @Override
    public ScentType getScent() {
        return scent;
    }

    @Override
    public String print() {
        String print = String.format("#%s %s%n #Price: $%.2f%n #Gender: %s%n #Scent: %s%n===", getName(), getBrand(), getPrice(), getGender(), getScent());
        return print;
    }
}


