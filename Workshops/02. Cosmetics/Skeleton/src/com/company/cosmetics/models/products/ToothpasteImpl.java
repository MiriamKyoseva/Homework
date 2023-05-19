package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.List;

import static com.company.cosmetics.models.common.Errors.INGREDIENTS_NULL_ERROR;

public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private List<String> ingredients;

    public void setIngredients(List<String> ingredients) {
        if (ingredients == null)
            throw new IllegalArgumentException(INGREDIENTS_NULL_ERROR);
        this.ingredients = ingredients;
    }

    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name, brand, price, gender);
        setIngredients(ingredients);
    }

    @Override
    public String print() {
        //check if this works:
        String print = String.format("#%s %s%n #Price: $%.2f%n #Gender: %s%n #Ingredients: %s%n===", getName(), getBrand(), getPrice(), getGender(), getIngredients());
        return print;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }
}
