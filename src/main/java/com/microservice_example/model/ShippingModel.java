package com.microservice_example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "My ShippingModel", description = "ShippingModel Description Area ")

public class ShippingModel {
    @ApiModelProperty(value = "The status area of the SaleModel.")
    private String status;

}
