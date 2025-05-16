package com.example.cbtSite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cbtSite.dao.ExamDAO;
import com.example.cbtSite.dao.ExamMemberDAO;
import com.example.cbtSite.dto.CorrectAnswerDTO;
import com.example.cbtSite.dto.ExamMemberDTO;
import com.example.cbtSite.dto.ExamResponseDTO;

@Controller
public class MyController {
	ExamMemberDAO memberDao;
	ExamDAO examDao;
	
	@Autowired
	private MyController(ExamMemberDAO mdao, ExamDAO edao) {
		memberDao = mdao;
		examDao = edao;
	}
	
	@GetMapping("/")
	public String root() {
		System.out.println("root...");
		return "index";
	}
	
	@PostMapping("/exam")
	public String examPost(@RequestParam("e_number")String e_number, @RequestParam("e_name")String e_name, Model model) {
		System.out.println("exam..." + e_number + "..." + e_name);
		ExamMemberDTO exammember = memberDao.selectMember(e_number);
		
		model.addAttribute("e_number", e_number);
		model.addAttribute("e_name", e_name);
		
		if(exammember != null) {
			return "exam";
		} else {
			return "index";
		}
	}
	
	@PostMapping("/submitExam")
    public String submitExam(@RequestParam("e_number")String e_number,
    						@RequestParam("exam1")int exam1,
					    	@RequestParam("exam2")int exam2,
					    	@RequestParam("exam3")int exam3,
					    	@RequestParam("exam4")int exam4,
					    	@RequestParam("exam5")int exam5,
					    	Model model) {
		System.out.println("submitExam..." + e_number + "..." + exam1 + "..." +  exam2 + "..." + exam3 + "..." + exam4 + "..." + exam5);
        
		String subject_number= "S001";
		int score = 0;
	    
	    List<ExamResponseDTO> responses = new ArrayList<>();
        responses.add(new ExamResponseDTO(e_number, 1, exam1));
        responses.add(new ExamResponseDTO(e_number, 2, exam2));
        responses.add(new ExamResponseDTO(e_number, 3, exam3));
        responses.add(new ExamResponseDTO(e_number, 4, exam4));
        responses.add(new ExamResponseDTO(e_number, 5, exam5));
        
        for (ExamResponseDTO response : responses) {
        	examDao.insertResponse(response);
            
            CorrectAnswerDTO correct = examDao.getCorrectAnswer(subject_number, response.getQ_number());

            if (correct != null && correct.getCorrect_answer() == response.getAnswer()) {
                score += 20;
            }
        }
        
        String e_name = memberDao.getId(e_number);
        		
        model.addAttribute("score", score);
        model.addAttribute("e_number", e_number);
        model.addAttribute("e_name", e_name);

        return "result";
    }
	
}
