package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.models.GenderType;

import java.util.List;

public class CreateProductCommand implements Command {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    private static final String INVALID_ARGUMENTS = String.format("CreateProduct command expects %d parameters.", EXPECTED_NUMBER_OF_ARGUMENTS);
    private static final String INVALID_PRICE = "Price should be a number.";
    private static final String INVALID_GENDER = "Gender should be one of Men, Women or Unisex.";
    private static final String PRODUCT_ALREADY_EXISTS = "Product %s already exists.";

    private static final String PRODUCT_CREATED = "Product with name %s was created!";

    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        if (parameters.size() < EXPECTED_NUMBER_OF_ARGUMENTS || parameters.size() > EXPECTED_NUMBER_OF_ARGUMENTS)
            throw new IllegalArgumentException(INVALID_ARGUMENTS);
        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price;
        GenderType gender;
        try {
            price = Double.parseDouble(parameters.get(2));
        } catch (Exception ex) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        try {
            gender = GenderType.valueOf(parameters.get(3).toUpperCase());
        } catch (Exception ex) {
            throw new IllegalArgumentException(INVALID_GENDER);
        }

        return createProduct(name, brand, price, gender);
    }

    private String createProduct(String name, String brand, double price, GenderType gender) {
        if (productRepository.productExist(name))
            throw new IllegalArgumentException(String.format(PRODUCT_ALREADY_EXISTS, name));

        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

}
