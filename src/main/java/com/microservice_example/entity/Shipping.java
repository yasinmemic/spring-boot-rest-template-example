package com.microservice_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping implements Serializable {

    @Id
    private Long saleId;
    @Column
    private Boolean status;
    @Column
    private Date createdAt;
}
