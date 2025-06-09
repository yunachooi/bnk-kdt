package com.example.jpaEx03.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx03.Entity.Team;

public interface TeamRepository extends JpaRepository<Team, String>{

}
