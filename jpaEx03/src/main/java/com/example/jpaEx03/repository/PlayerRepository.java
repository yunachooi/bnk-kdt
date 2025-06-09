package com.example.jpaEx03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx03.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
