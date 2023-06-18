package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.AddProductToCategoryCommand;
import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AddProductToCategoryCommandTests {
    private String productName = "product";
    private String brandName = "brand";
    private String categoryName = "category";
    private double price = 4.00;
    private ProductRepositoryImpl productRepository;
    private AddProductToCategoryCommand addProductToCategoryCommand;
    private List<String> parameters;

    @BeforeEach
    public void Arrange() {
        productRepository = new ProductRepositoryImpl();
        addProductToCategoryCommand = new AddProductToCategoryCommand(productRepository);
        parameters = new ArrayList<>();
    }

    @Test
    public void execute_Should_AddProductToCategory_When_ValidParameters() {
        //Arrange
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        productRepository.createCategory(categoryName);
        parameters.add(categoryName);
        parameters.add(productName);
        //Act
        addProductToCategoryCommand.execute(parameters);
        //Assert
        Assertions.assertTrue(productRepository.findCategoryByName(categoryName)
                .getProducts().contains(productRepository.findProductByName(productName)));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        //Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> {
            addProductToCategoryCommand.execute(parameters);
        });
    }
}
