package com.microservice_example.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "My EntityForReturn Model", description = "EntityForReturn Description Area ")
public class EntityForReturn {
    @ApiModelProperty(value = "The product area of the EntityForReturn Model.")
    private ProductModel product;
    @ApiModelProperty(value = "The sale area of the EntityForReturn Model.")
    private SaleModel sale;
    @ApiModelProperty(value = "The shipping area of the EntityForReturn Model.")
    private ShippingModel shipping;

}
