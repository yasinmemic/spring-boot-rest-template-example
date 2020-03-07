package com.microservice_example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "My Product Model", description = "Product Description Area ")
public class ProductModel {

    @ApiModelProperty(value = "The id area of the Product Model.")
    private Long id;
    @ApiModelProperty(value = "The name area of the Product Model.")
    private String name;
    @ApiModelProperty(value = "The price area of the Product Model.")
    private BigDecimal price;
}