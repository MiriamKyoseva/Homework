package com.company.oop.cosmetics.tests.commands;
import com.company.oop.cosmetics.commands.CreateCategoryCommand;
import com.company.oop.cosmetics.commands.ShowCategoryCommand;
import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShowCategoryCommandTests {
    private String categoryName = "name";
    private ProductRepositoryImpl productRepository;
    private ShowCategoryCommand showCategoryCommand;
    private List<String> parameters;

    @BeforeEach
    public void Arrange() {
        productRepository = new ProductRepositoryImpl();
        showCategoryCommand = new ShowCategoryCommand(productRepository);
        parameters = new ArrayList<>();
    }

    @Test
    public void execute_Should_PrintCategory_When_ValidParameters() {
        //Arrange
        productRepository.createCategory(categoryName);
        parameters.add(categoryName);
        //Act and Assert
        assertEquals(productRepository.findCategoryByName(categoryName).print(),
                showCategoryCommand.execute(parameters));
    }

    @Test
    public void execute_Should_ThrowException_When_MissingParameters() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            showCategoryCommand.execute(parameters);
        });
    }
}
