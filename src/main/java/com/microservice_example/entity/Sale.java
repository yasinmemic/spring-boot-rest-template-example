package com.microservice_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;
    @Column
    private String saleCode;
    @Column
    private Long productId;

}
