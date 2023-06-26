package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;

import java.util.List;

public class AddProductToCategoryCommand implements Command {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String INVALID_ARGUMENTS = String.format("AddProductToCategory command expects %d parameters.", EXPECTED_NUMBER_OF_ARGUMENTS);

    private static final String PRODUCT_ADDED_TO_CATEGORY = "Product %s added to category %s!";

    private final ProductRepository productRepository;

    public AddProductToCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS)
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        String categoryNameToAdd = parameters.get(0);
        String productNameToAdd = parameters.get(1);

        return addProductToCategory(categoryNameToAdd, productNameToAdd);
    }

    private String addProductToCategory(String categoryName, String productName) {
        Category category = productRepository.findCategoryByName(categoryName);
        Product product = productRepository.findProductByName(productName);

        category.addProduct(product);

        return String.format(PRODUCT_ADDED_TO_CATEGORY, productName, categoryName);
    }

}
