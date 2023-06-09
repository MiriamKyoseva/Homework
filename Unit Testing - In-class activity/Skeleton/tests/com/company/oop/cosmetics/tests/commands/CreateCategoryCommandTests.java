package com.company.oop.cosmetics.tests.commands;

import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.DuplicateEntityException;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCategoryCommandTests {
    private String categoryName = "category";
    private ProductRepositoryImpl productRepository;
    private CreateCategoryCommand createCategoryCommand;
    private List<String> parameters;

    @BeforeEach
    public void Arrange() {
        productRepository = new ProductRepositoryImpl();
        createCategoryCommand = new CreateCategoryCommand(productRepository);
        parameters = new ArrayList<>();
    }

    @Test
    public void execute_Should_AddNewCategoryToRepository_When_ValidParameters() {
        //Arrange
        parameters.add(categoryName);
        //Act
        createCategoryCommand.execute(parameters);
        //Assert
        assertTrue(productRepository.getCategories().stream().anyMatch(category ->
                category.getName().equals(categoryName)
        ));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            createCategoryCommand.execute(parameters);
        });
    }

    @Test
    public void execute_Should_ThrowException_When_DuplicateCategoryName() {
        //Arrange
        productRepository.createCategory(categoryName);
        parameters.add(categoryName);
        //Act and Assert
        assertThrows(DuplicateEntityException.class, () -> {
            createCategoryCommand.execute(parameters);
        });
    }

}
