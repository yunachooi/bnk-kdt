package com.example.sessionEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sessionEx.dao.IUserDao;
import com.example.sessionEx.dto.UserDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
//http://localhost:8092/user
public class UserController {
	@Autowired
	private IUserDao userDao;

	// http://localhost:8092/user/userlist
	@GetMapping("/userlist")
	public String userlist(Model model) {
		List<UserDTO> list = userDao.getUserList();
		model.addAttribute("list", list);
		return "/user/userlist";
	}

	@GetMapping("/userSearch")
	public String userSearch() {
		return "/user/userSearch";
	}

	@PostMapping("/userSearch")
	public String userSearchPost(Model model, UserDTO user) {
		System.out.println("userSearch..." + user);
		List<UserDTO> list = userDao.getUserListWithParam2(user);

		model.addAttribute("list", list);
		return "/user/userlist";
	}

	@GetMapping("/userReg")
	public String userReg() {
		return "/user/userReg";
	}

	@PostMapping("/create")
	public String insert(@Valid UserDTO user, BindingResult result) {
		if (result.hasErrors()) {
			if (result.getFieldError("id") != null) {
				System.out.println("1: " + result.getFieldError("id").getDefaultMessage());
			}
			if (result.getFieldError("pw") != null) {
				System.out.println("2: " + result.getFieldError("pw").getDefaultMessage());
			}
		}
		return "/user/userReg";
	}
}
