package com.example.jpaEx03.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	private String name;
	private String emblemAnimal;
}
