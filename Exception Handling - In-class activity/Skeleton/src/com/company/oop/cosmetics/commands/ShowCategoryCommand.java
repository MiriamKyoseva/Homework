package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.models.contracts.Category;

import java.util.List;

public class ShowCategoryCommand implements Command {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String INVALID_ARGUMENTS = String.format("ShowCategory command expects %d parameters.", EXPECTED_NUMBER_OF_ARGUMENTS);

    private final ProductRepository productRepository;

    public ShowCategoryCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS)
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        String categoryName = parameters.get(0);

        return showCategory(categoryName);
    }

    private String showCategory(String categoryName) {
        Category category = productRepository.findCategoryByName(categoryName);

        return category.print();
    }

}
