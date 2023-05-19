package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;

import static com.company.cosmetics.models.common.Errors.*;


public class ShampooImpl extends ProductBase implements Shampoo {
    private int milliliters;
    private UsageType usageType;

    public void setMilliliters(int milliliters) {
        if (milliliters < 0)
            throw new IllegalArgumentException(NEGATIVE_MILLILITERS_ERROR);
        this.milliliters = milliliters;
    }

    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType usageType) {
        super(name, brand, price, gender);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }


    @Override
    public String print() {
        String print = String.format("#%s %s%n #Price: $%.2f%n #Gender: %s%n #Milliliters: %s%n #Usage: %s%n===", getName(), getBrand(), getPrice(), getGender(), getMilliliters(), getUsage());
        return print;
    }

    @Override
    public int getMilliliters() {
        return milliliters;
    }

    @Override
    public UsageType getUsage() {
        return usageType;
    }
}
