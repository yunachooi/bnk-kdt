package com.example.ShoppingBasket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_shop_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Id
    private String username;

    private String password;
}
