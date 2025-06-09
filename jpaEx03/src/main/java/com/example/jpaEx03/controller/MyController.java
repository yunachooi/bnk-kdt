package com.example.jpaEx03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jpaEx03.Entity.Player;
import com.example.jpaEx03.repository.PlayerRepository;

@Controller
public class MyController {
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/players")
	public String getPlayerList(Model model) {
		List<Player> list = playerRepository.findAll();
		model.addAttribute("list", list);
		return "players/list";
	}
}
