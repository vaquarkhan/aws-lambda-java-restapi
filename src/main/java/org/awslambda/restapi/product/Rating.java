package org.awslambda.restapi.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rating {
    private Float rate;
    private Integer count;
}
