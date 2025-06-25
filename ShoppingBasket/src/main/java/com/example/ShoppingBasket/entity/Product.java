package com.example.ShoppingBasket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_shop_product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "PRODUCTNO")
    private Integer productNo;

    @Column(name = "PRODUCTNAME")
    private String productName;

    @Column(name = "PRODUCTPRICE")
    private Integer productPrice;

    @Column(name = "PRODUCTSTOCK")
    private Integer productStock;
}
