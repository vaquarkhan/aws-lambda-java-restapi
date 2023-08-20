package org.awslambda.restapi.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private Integer id;
    private String title;
    private Float price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
}
