package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryImplTests {
    String ValidTestName = "testing";

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        assertEquals(ValidTestName, testCategory.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        testCategory.addProduct(testProduct);
        assertNotNull(testCategory.getProducts());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class, () -> {
            CategoryImpl testCategory = new CategoryImpl("te");
        });
    }

    //I have created a new test
    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        assertThrows(InvalidUserInputException.class, () -> {
            CategoryImpl testCategory = new CategoryImpl("testingLongerName");
        });
    }

    @Test
    public void addProduct_Should_AddProductToList() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        testCategory.addProduct(testProduct);
        assertTrue(testCategory.getProducts().contains(testProduct));
    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        testCategory.addProduct(testProduct);
        testCategory.removeProduct(testProduct);
        assertFalse(testCategory.getProducts().contains(testProduct));
    }

    @Test
    public void removeProduct_Should_NotRemoveProductFromList_When_ProductDoesNotExist() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        ProductImpl testProductTwo = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        testCategory.addProduct(testProduct);
        testCategory.removeProduct(testProductTwo);
        assertEquals(1, testCategory.getProducts().size());
    }

    //I have created a new test
    @Test
    public void print_Should_PrintNoProductMessage_When_CategoryContainsNoProducts() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        String Message = String.format(
                "#Category: %s%n" +
                        " #No product in this category",
                testCategory.getName());
        assertEquals(Message, testCategory.print());
    }

    //I have created a new test
    @Test
    void print_Should_PrintAllProductsInCategory_When_CategoryContainsProducts() {
        CategoryImpl testCategory = new CategoryImpl(ValidTestName);
        ProductImpl testProduct = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        ProductImpl testProductTwo = new ProductImpl(ValidTestName, ValidTestName, 6, GenderType.UNISEX);
        testCategory.addProduct(testProduct);
        testCategory.addProduct(testProductTwo);
        String correctPrint = String.format("#Category: %s%n", testCategory.getName())
                + testProduct.print()
                + String.format(" ===%n")
                + testProductTwo.print()
                + String.format(" ===%n");
        assertEquals(correctPrint, testCategory.print());
    }

}
