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

    ProductRepositoryImpl productRepository;

    @BeforeEach
    public void Arrange() {
        productRepository = new ProductRepositoryImpl();
    }

    @Test
    public void constructor_Should_InitializeProducts() {
        //Act
        productRepository.createProduct("product", "brand", 4, GenderType.UNISEX);
        //Assert
        assertEquals(1, productRepository.getProducts().size());
    }

    @Test
    public void constructor_Should_InitializeCategories() {
        //Act
        productRepository.createCategory("category");
        //Assert
        assertEquals(1, productRepository.getCategories().size());
    }

    @Test
    public void getCategories_Should_ReturnCopyOfCollection() {
        //Arrange
        productRepository.createCategory("category");
        //Act
        List<Category> testCategories = productRepository.getCategories();
        //Assert
        assertNotSame(testCategories, productRepository.getCategories());
    }

    @Test
    public void getProducts_Should_ReturnCopyOfCollection() {
        //Arrange
        productRepository.createProduct("product", "brand", 4, GenderType.UNISEX);
        //Act
        List<Product> testProducts = productRepository.getProducts();
        //Assert
        assertNotSame(testProducts, productRepository.getProducts());
    }

    @Test
    public void categoryExists_Should_ReturnTrue_When_CategoryExists() {
        //Arrange
        productRepository.createCategory("category");
        //Assert
        assertTrue(productRepository.categoryExist("category"));
    }

    @Test
    public void categoryExists_Should_ReturnFalse_When_CategoryDoesNotExist() {
        //Assert
        assertFalse(productRepository.categoryExist("category"));
    }

    @Test
    public void productExists_Should_ReturnTrue_When_ProductExists() {
        //Arrange
        productRepository.createProduct("product", "brand", 4, GenderType.UNISEX);
        //Assert
        assertTrue(productRepository.productExist("product"));
    }

    @Test
    public void productExists_Should_ReturnFalse_When_ProductDoesNotExist() {
        //Assert
        assertFalse(productRepository.productExist("product"));
    }

    @Test
    public void createProduct_Should_AddToProducts_When_ArgumentsAreValid() {
        //Arrange
        productRepository.createProduct("product", "brand", 4, GenderType.UNISEX);
        //Assert
        assertTrue(productRepository.productExist("product"));
    }

    @Test
    public void createCategory_Should_AddToCategories_When_ArgumentsAreValid() {
        //Arrange
        productRepository.createCategory("category");
        //Assert
        assertTrue(productRepository.categoryExist("category"));
    }

    @Test
    public void findCategoryByName_Should_ReturnCategory_When_Exists() {
        //Arrange
        productRepository.createCategory("category");
        //Assert
        assertEquals(productRepository.getCategories().get(0), productRepository.findCategoryByName("category"));
    }

    @Test
    public void findCategoryByName_Should_ThrowException_When_DoesNotExist() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            productRepository.findCategoryByName("category");
        });
    }

    @Test
    public void findProductByName_Should_ReturnProduct_When_Exists() {
        //Arrange
        productRepository.createProduct("product", "brand", 4, GenderType.UNISEX);
        //Assert
        assertEquals(productRepository.getProducts().get(0), productRepository.findProductByName("product"));
    }

    @Test
    public void findProductByName_Should_ThrowException_When_DoesNotExist() {
        //Act and Assert
        assertThrows(InvalidUserInputException.class, () -> {
            productRepository.findProductByName("product");
        });
    }

}
