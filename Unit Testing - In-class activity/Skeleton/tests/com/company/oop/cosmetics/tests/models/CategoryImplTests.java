package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryImplTests {
    String ValidTestName = "testing";
    double price = 6.00;

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        //Assert
        assertEquals(ValidTestName, testCategory.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        //Act
        testCategory.addProduct(testProduct);
        //Assert
        assertNotNull(testCategory.getProducts());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        //Assert
        assertThrows(InvalidUserInputException.class, () -> {
            CategoryImpl testCategory = new CategoryImpl("te");
        });
    }

    //I have created a new test
    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        //Assert
        assertThrows(InvalidUserInputException.class, () -> {
            CategoryImpl testCategory = new CategoryImpl("testingLongerName");
        });
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        //Act
        testCategory.addProduct(testProduct);
        //Assert
        assertTrue(testCategory.getProducts().contains(testProduct));
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        //Act
        testCategory.addProduct(testProduct);
        testCategory.removeProduct(testProduct);
        //Assert
        assertFalse(testCategory.getProducts().contains(testProduct));
    }

    @Test
    public void removeProduct_Should_NotRemoveProductFromList_When_ProductDoesNotExist() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        ProductImpl testProductTwo = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        //Act
        testCategory.addProduct(testProduct);
        testCategory.removeProduct(testProductTwo);
        //Assert
        assertEquals(1, testCategory.getProducts().size());
    }

    //I have created a new test
    @Test
    public void print_Should_PrintNoProductMessage_When_CategoryContainsNoProducts() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        String Message = String.format(
                "#Category: %s%n" +
                        " #No product in this category",
                testCategory.getName());
        //Assert
        assertEquals(Message, testCategory.print());
    }

    //I have created a new test
    @Test
    void print_Should_PrintAllProductsInCategory_When_CategoryContainsProducts() {
        //Arrange
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        ProductImpl testProductTwo = new ProductImpl(ValidTestName, ValidTestName, price, GenderType.UNISEX);
        testCategory.addProduct(testProduct);
        testCategory.addProduct(testProductTwo);
        String correctPrint = String.format("#Category: %s%n", testCategory.getName())
                + testProduct.print()
                + String.format(" ===%n")
                + testProductTwo.print()
                + String.format(" ===%n");
        //Assert
        assertEquals(correctPrint, testCategory.print());
    }

}
