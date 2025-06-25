package com.example.ShoppingBasket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_shop_basket")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Basket {

    @Id
    @Column(name = "BASKETNO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer basketNo;

    @ManyToOne
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCTNO", referencedColumnName = "PRODUCTNO")
    private Product product;

    @Column(name = "PRODUCTCOUNT")
    private Integer productCount;
}
