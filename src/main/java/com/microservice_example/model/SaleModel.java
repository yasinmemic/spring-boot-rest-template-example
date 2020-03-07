package com.microservice_example.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "My SaleModel", description = "SaleModel Description Area ")
public class SaleModel {

    @ApiModelProperty(value = "The id area of the SaleModel.")
    private Long id;
    @ApiModelProperty(value = "The saleCode area of the SaleModel.")
    private String saleCode;

}
