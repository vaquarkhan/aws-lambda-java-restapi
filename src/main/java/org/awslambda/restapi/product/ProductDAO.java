package org.awslambda.restapi.product;

import java.io.IOException;

public interface ProductDAO {
    public String getAllProducts() throws IOException, InterruptedException;

    public String getProductById(Integer Id) throws IOException, InterruptedException;

    public String getProductCategories() throws IOException, InterruptedException;
}
