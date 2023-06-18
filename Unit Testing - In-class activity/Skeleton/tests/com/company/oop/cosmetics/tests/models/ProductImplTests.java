package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductImplTests {
    private String validTestName = "shampoo";
    private String validTestBrand = "nivea";
    private double testPrice = 6.00;
    private GenderType testGender = GenderType.UNISEX;

    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        ProductImpl testProduct = new ProductImpl(validTestName, validTestBrand, testPrice, testGender);
        assertEquals(validTestName, testProduct.getName());
    }

    @Test
    public void constructor_Should_InitializeBrand_When_ArgumentsAreValid() {
        ProductImpl testProduct = new ProductImpl(validTestName, validTestBrand, testPrice, testGender);
        assertEquals(validTestBrand, testProduct.getBrand());
    }

    @Test
    public void constructor_Should_InitializePrice_When_ArgumentsAreValid() {
        ProductImpl testProduct = new ProductImpl(validTestName, validTestBrand, testPrice, testGender);
        assertEquals(testPrice, testProduct.getPrice());
    }

    @Test
    public void constructor_Should_InitializeGender_When_ArgumentsAreValid() {
        ProductImpl testProduct = new ProductImpl(validTestName, validTestBrand, testPrice, testGender);
        assertEquals(testGender, testProduct.getGender());
    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class, () -> {
            ProductImpl testProduct = new ProductImpl("te", validTestBrand, testPrice, testGender);
        });

    }

    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected() {
        assertThrows(InvalidUserInputException.class, () -> {
            ProductImpl testProduct = new ProductImpl("testingLongerName", validTestBrand, testPrice, testGender);
        });
    }

    @Test
    public void constructor_Should_ThrowException_When_BrandIsShorterThanExpected() {
        assertThrows(InvalidUserInputException.class, () -> {
            ProductImpl testProduct = new ProductImpl(validTestName, "t", testPrice, testGender);
        });
    }

    @Test
    public void constructor_Should_ThrowException_When_BrandIsLongerThanExpected() {
        assertThrows(InvalidUserInputException.class, () -> {
            ProductImpl testProduct = new ProductImpl(validTestName, "testingLongerBrand", testPrice, testGender);
        });
    }

    @Test
    public void print_Should_PrintAllInformation() {
        //Arrange
        ProductImpl testProduct = new ProductImpl(validTestName, validTestBrand, testPrice, testGender);
        String correctPrint = String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                testProduct.getName(),
                testProduct.getBrand(),
                testProduct.getPrice(),
                testProduct.getGender());
        //Assert
        assertEquals(correctPrint, testProduct.print());
    }
}
