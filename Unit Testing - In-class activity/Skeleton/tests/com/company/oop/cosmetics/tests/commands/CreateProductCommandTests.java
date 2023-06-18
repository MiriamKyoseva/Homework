package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateProductCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateProductCommandTests {
    private String productName = "product";
    private String brandName = "brand";
    private double price = 4.00;
    private String genderName = "unisex";
    private ProductRepositoryImpl productRepository;
    private CreateProductCommand createProductCommand;
    private List<String> parameters;

    @BeforeEach
    public void Arrange() {
        productRepository = new ProductRepositoryImpl();
        createProductCommand = new CreateProductCommand(productRepository);
        parameters = new ArrayList<>();
    }

    @Test
    public void execute_Should_AddNewProductToRepository_When_ValidParameters() {
        //Arrange
        parameters.add(productName);
        parameters.add(brandName);
        parameters.add("4.00");
        parameters.add(genderName);
        //Act
        createProductCommand.execute(parameters);
        //Assert
        assertTrue(productRepository.getProducts().stream().anyMatch(product -> product.getName().equals(productName)));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            createProductCommand.execute(parameters);
        });
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateProductName() {
        //Arrange
        parameters.add(productName);
        parameters.add(brandName);
        parameters.add("4.00");
        parameters.add(genderName);
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        //Act and Assert
        assertThrows(DuplicateEntityException.class, () -> {
            createProductCommand.execute(parameters);
        });
    }

    @Test
    public void tryParseDouble_Should_ThrowException_When_InvalidParameter() {
        //Arrange
        parameters.add(productName);
        parameters.add(brandName);
        parameters.add("four");
        parameters.add(genderName);
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            createProductCommand.execute(parameters);
        });
    }

    @Test
    public void tryParseGender_Should_ThrowException_When_InvalidParameter() {
        //Arrange
        parameters.add(productName);
        parameters.add(brandName);
        parameters.add("4.00");
        parameters.add("cat");
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            createProductCommand.execute(parameters);
        });
    }
}
