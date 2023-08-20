package org.awslambda.restapi;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.awslambda.restapi.product.ProductService;

import java.util.HashMap;

public class Main implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, final Context context) {
        ProductService productService = new ProductService();
        LambdaLogger logger = context.getLogger();

        // Response
        APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent();
        String responseBody = null;
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("api-path", apiGatewayProxyRequestEvent.getPath());

        try {
            // Get all products
            if (apiGatewayProxyRequestEvent.getPath().equals("/products") && apiGatewayProxyRequestEvent.getPathParameters() == null) {
                responseBody = productService.getAllProducts();
            }

            // Get product by id
            if (apiGatewayProxyRequestEvent.getPath().startsWith("/products/") && apiGatewayProxyRequestEvent.getPathParameters() != null) {
                Integer productId = Integer.valueOf(apiGatewayProxyRequestEvent.getPathParameters().get("id"));
                responseBody = productService.getProductById(productId);
            }

            // Get products categories
            if (apiGatewayProxyRequestEvent.getPath().equals("/products/categories") && apiGatewayProxyRequestEvent.getPathParameters() == null) {
                responseBody = productService.getProductCategories();
            }

            // return response
            return apiGatewayProxyResponseEvent
                    .withHeaders(headers)
                    .withBody(responseBody);

        } catch (Exception e) {
            logger.log("ERROR: " + e);
            return apiGatewayProxyResponseEvent.withStatusCode(500)
                    .withBody("Something went wrong!");
        }
    }
}


