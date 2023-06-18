package com.company.oop.cosmetics.tests.core;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.contracts.Category;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryImplTests {

    String productName = "product";
    String categoryName = "category";
    String brandName = "brand";
    double price = 4.00;

    ProductRepositoryImpl productRepository;

    @BeforeEach
    public void Arrange() {
        productRepository = new ProductRepositoryImpl();
    }

    @Test
    public void constructor_Should_InitializeProducts() {
        //Act
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        //Assert
        assertEquals(1, productRepository.getProducts().size());
    }

    @Test
    public void constructor_Should_InitializeCategories() {
        //Act
        productRepository.createCategory(categoryName);
        //Assert
        assertEquals(1, productRepository.getCategories().size());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
        //Arrange
        productRepository.createCategory(categoryName);
        //Act
        List<Category> testCategories = productRepository.getCategories();
        //Assert
        assertNotSame(testCategories, productRepository.getCategories());
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
        //Arrange
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        //Act
        List<Product> testProducts = productRepository.getProducts();
        //Assert
        assertNotSame(testProducts, productRepository.getProducts());
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {
        //Arrange
        productRepository.createCategory(categoryName);
        //Assert
        assertTrue(productRepository.categoryExist(categoryName));
    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {
        //Assert
        assertFalse(productRepository.categoryExist(categoryName));
    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {
        //Arrange
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        //Assert
        assertTrue(productRepository.productExist(productName));
    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {
        //Assert
        assertFalse(productRepository.productExist(productName));
    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {
        //Arrange
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        //Assert
        assertTrue(productRepository.productExist(productName));
    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {
        //Arrange
        productRepository.createCategory(categoryName);
        //Assert
        assertTrue(productRepository.categoryExist(categoryName));
    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {
        //Arrange
        productRepository.createCategory(categoryName);
        //Assert
        assertEquals(productRepository.getCategories().get(0), productRepository.findCategoryByName(categoryName));
    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            productRepository.findCategoryByName(categoryName);
        });
    }

    @Test
    public void findProductByName_Should_ReturnProduct_When_Exists() {
        //Arrange
        productRepository.createProduct(productName, brandName, price, GenderType.UNISEX);
        //Assert
        assertEquals(productRepository.getProducts().get(0), productRepository.findProductByName(productName));
    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            productRepository.findProductByName(productName);
        });
    }

}
