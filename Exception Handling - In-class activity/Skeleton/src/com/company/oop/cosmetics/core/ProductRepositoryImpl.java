package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String PRODUCT_DOES_NOT_EXIST = "Product %s does not exist.";
    private static final String CATEGORY_DOES_NOT_EXIST = "Category %s does not exist.";
    private static final String PRODUCT_ALREADY_EXISTS = "Product %s already exists.";
    private static final String CATEGORY_ALREADY_EXISTS = "Category %s already exists.";

    private final List<Product> products;
    private final List<Category> categories;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    @Override
    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findProductByName(String productName) {
        return getProducts().stream().filter(x -> x.getName().equalsIgnoreCase(productName)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(PRODUCT_DOES_NOT_EXIST, productName)));
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        return getCategories().stream().filter(x -> x.getName().equalsIgnoreCase(categoryName)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(CATEGORY_DOES_NOT_EXIST, categoryName)));
    }

    @Override
    public void createCategory(String categoryName) {
        if (categoryExist(categoryName))
            throw new IllegalArgumentException(String.format(CATEGORY_ALREADY_EXISTS, categoryName));
        this.categories.add(new CategoryImpl(categoryName));
    }

    @Override
    public void createProduct(String name, String brand, double price, GenderType gender) {
        if (productExist(name))
            throw new IllegalArgumentException(String.format(PRODUCT_ALREADY_EXISTS, name));
        this.products.add(new ProductImpl(name, brand, price, gender));
    }

    @Override
    public boolean categoryExist(String categoryName) {
        return getCategories().stream().anyMatch(category -> category.getName().equalsIgnoreCase(categoryName));
    }

    @Override
    public boolean productExist(String productName) {
        return getProducts().stream().anyMatch(product -> product.getName().equalsIgnoreCase(productName));
    }

}
