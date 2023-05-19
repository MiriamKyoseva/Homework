package com.company.cosmetics.models.common;

public class Errors {
    public static final String NAME_EMPTY_ERROR =
            "Name cannot be empty";
    public static final String NAME_LENGTH_ERROR =
            "Name must be between %d and %d symbols";
    public static final String NEGATIVE_PRICE_ERROR =
            "Price cannot be negative";
    public static final String NEGATIVE_MILLILITERS_ERROR =
            "Milliliters cannot  be negative";
    public static final String CATEGORY_NAME_LENGTH_ERROR =
            "Category's name must be between %d and %d symbols";
    public static final String PRODUCT_NULL_ERROR =
            "Product cannot be null";
    public static final String PRODUCT_DOES_NOT_EXIST_ERROR =
            "Product does not exist in this category";
    public static final String INGREDIENTS_NULL_ERROR =
            "Ingredients cannot be null";
}
