package com.example.jpaEx03.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pno;
	private String name;
	private String position;
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
}
