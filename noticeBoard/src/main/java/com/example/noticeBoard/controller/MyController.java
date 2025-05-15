package com.example.noticeBoard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.noticeBoard.dao.IBoardDao;
import com.example.noticeBoard.dto.BoardDTO;

@Controller
public class MyController {
	private IBoardDao boardDao;
	
	public MyController(IBoardDao dao) {
		boardDao = dao;
	}
	
	@GetMapping("/{start}/{end}")
	public String root(@PathVariable("start") int start, @PathVariable("end") int end, Model model) {
		System.out.println("root...");
		List<BoardDTO> list = boardDao.selectAll(start, end);
		
		model.addAttribute("list", list);
		
		return "index";
	}
	
	
}
