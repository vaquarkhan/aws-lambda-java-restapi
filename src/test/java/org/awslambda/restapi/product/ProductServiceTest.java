package org.awslambda.restapi.product;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTest {
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void getAllProducts() throws IOException, InterruptedException {
        String allProducts = productService.getAllProducts();
        assertTrue(allProducts.startsWith("[") && allProducts.endsWith("]"));
    }

    @Test
    void getProductById() throws IOException, InterruptedException {
        Integer productId = 1;
        String productById = productService.getProductById(productId);

        // convert to object
        Gson gson = new Gson();
        Product product = gson.fromJson(productById, Product.class);

        Integer actual = productId;
        Integer expected = product.getId();

        assertEquals(expected, actual);
    }

    @Test
    void getProductCategories() throws IOException, InterruptedException {
        String productCategories = productService.getProductCategories();
        assertTrue(productCategories.startsWith("[") && productCategories.endsWith("]"));
    }
}