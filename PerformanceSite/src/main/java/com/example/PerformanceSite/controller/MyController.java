package com.example.PerformanceSite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.PerformanceSite.dao.ICommentDAO;
import com.example.PerformanceSite.dao.IMemberDAO;
import com.example.PerformanceSite.dao.INoticeDAO;
import com.example.PerformanceSite.dao.IPerformanceDAO;
import com.example.PerformanceSite.dao.IQnaDAO;
import com.example.PerformanceSite.dto.CommentDTO;
import com.example.PerformanceSite.dto.MemberDTO;
import com.example.PerformanceSite.dto.NoticeDTO;
import com.example.PerformanceSite.dto.PerformanceDTO;
import com.example.PerformanceSite.dto.QnaDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private IMemberDAO memberDao;

	@Autowired
	private IPerformanceDAO performDao;

	@Autowired
	private INoticeDAO noticeDao;

	@Autowired
	private ICommentDAO commentDao;

	@Autowired
	private IQnaDAO qnaDao;

	public MyController(IMemberDAO mdao, IPerformanceDAO pdao, INoticeDAO idao, ICommentDAO cdao, IQnaDAO qdao) {
		memberDao = mdao;
		performDao = pdao;
		noticeDao = idao;
		commentDao = cdao;
		qnaDao = qdao;
	}

	@GetMapping("/")
	public String root(Model model) {
		System.out.println("root...");

		List<PerformanceDTO> list = performDao.listState("상영중");
		model.addAttribute("list", list);

		return "index";
	}

	// 회원가입 페이지 열기
	@GetMapping("/regist")
	public String registPage() {
		return "regist";
	}

	// 회원가입
	@PostMapping("/regist")
	public String regist(MemberDTO member, Model model) {
		System.out.println("regist...");

		List<PerformanceDTO> list = performDao.listState("상영중");
		model.addAttribute("list", list);

		memberDao.insertMember(member);

		return "index";
	}

	// 로그인 페이지 열기
	@GetMapping("/login")
	public String loginPage() {

		return "login";
	}

	// 로그인
	@PostMapping("/login")
	public String login(MemberDTO member, HttpServletRequest request, Model model) {
		System.out.println("login...");

		List<PerformanceDTO> list = performDao.listState("상영중");
		model.addAttribute("list", list);

		HttpSession session = request.getSession();

		MemberDTO result = memberDao.getMember(member.getId());

		if (result.getId().equals(member.getId()) && result.getPw().equals(member.getPw())) {
			session.setAttribute("member", result);

			return "index";
		}

		return "index";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		System.out.println("logout...");

		List<PerformanceDTO> list = performDao.listState("상영중");
		model.addAttribute("list", list);

		session.removeAttribute("member");

		return "index";
	}

	// 아이디 중복 검사
	@PostMapping("/idCheck")
	public @ResponseBody String idCheck(@RequestParam("id") String id) {
		System.out.println("idCheck..." + id);

		String result = memberDao.getMemberId(id);

		if (result != null) {
			return "중복된 아이디입니다...";
		} else {
			return "사용가능한 아이디입니다...";
		}
	}

	// 공연 정보 등록 페이지 열기
	@GetMapping("/registInfo")
	public String registInfoPage() {

		return "registInfo";
	}

	// 공연 정보 등록
	@PostMapping("/registInfo")
	public String registInfo(PerformanceDTO perform, Model model) {
		System.out.println("registInfo...");

		List<PerformanceDTO> list = performDao.listAll();
		model.addAttribute("list", list);

		performDao.insertInfo(perform);

		return "index";
	}

	// 공연 정보 상태
	@GetMapping("/state")
	public @ResponseBody List<PerformanceDTO> state(@RequestParam("p_state") String p_state) {
		System.out.println(p_state);

		return performDao.listState(p_state);
	}

	// 공연 정보 상세
	@GetMapping("/detail")
	public @ResponseBody PerformanceDTO detail(@RequestParam("p_code") String p_code) {
		System.out.println(p_code);

		PerformanceDTO perform = performDao.detail(p_code);

		return perform;
	}
	
	//공연정보 삭제
	@GetMapping("/rmPerformance/{p_code}")
	public String rmPerformance(@PathVariable("p_code") String p_code, Model model) {
		System.out.println(p_code);
		
		performDao.remove(p_code);
		
		List<PerformanceDTO> list = performDao.listState("상영중");
		model.addAttribute("list", list);
		
		return "index";
	}

	// 공지사항 페이지 열기
	@GetMapping("/notice")
	public String noticePage(Model model) {
		List<NoticeDTO> list = noticeDao.listAll();
		model.addAttribute("list", list);

		return "notice";
	}

	// 공지사항 페이지 정보
	@PostMapping("/notice")
	public String notice(NoticeDTO notice, Model model) {
		System.out.println("notice");

		noticeDao.insert(notice);

		List<NoticeDTO> list = noticeDao.listAll();
		model.addAttribute("list", list);

		return "notice";
	}

	// 공지사항 페이지 상세
	@GetMapping("/noticeDetail")
	public @ResponseBody NoticeDTO noticeDetail(@RequestParam("n_no") String n_no) {
		System.out.println(n_no);

		NoticeDTO notice = noticeDao.detail(n_no);

		return notice;
	}

	// 공지사항 등록 페이지
	@GetMapping("/noticeInfo")
	public String noticeInfoPage() {

		return "noticeInfo";
	}
	
	//공지사항 삭제
	@GetMapping("/rmNotice/{n_no}")
	public String rmNotice(@PathVariable("n_no") String n_no, Model model) {
		System.out.println(n_no);
		
		noticeDao.remove(n_no);
		
		List<NoticeDTO> list = noticeDao.listAll();
		model.addAttribute("list", list);
		
		return "notice";
	}

	//한줄감상평 등록
	@PostMapping("/comment/{c_writer}")
	public String comment(@PathVariable("c_writer") String c_writer, @RequestParam("c_comment") String c_comment,
			@RequestParam("p_code") String p_code, Model model) {

		System.out.println(c_writer + "..." + c_comment + "..." + p_code);

		commentDao.insert(c_writer, c_comment, p_code);

		return "redirect:/";
	}

	// 한줄감상평 조회
	@GetMapping("/comments")
	public @ResponseBody List<CommentDTO> getComments(@RequestParam("p_code") String p_code) {

		return commentDao.pCodeList(p_code);
	}
	
	//한줄감상평 삭제
	@GetMapping("/rmComment/{c_no}")
	public String rmComment(@PathVariable("c_no") String c_no) {
		System.out.println(c_no);
				
		commentDao.remove(c_no);
			
		return "redirect:/";
	}
	

	// 이벤트 페이지 열기
	@GetMapping("/event")
	public String eventPage() {
		return "event";
	}

	// qna 페이지 열기
	@GetMapping("/qna")
	public String qnaPage(Model model) {
		List<QnaDTO> list = qnaDao.listAll();
		model.addAttribute("list", list);

		return "qna";
	}

	// qna 정보 조회
	@PostMapping("/qna")
	public String qna(QnaDTO qna, Model model) {
		System.out.println("qna");

		qnaDao.insert(qna);

		List<QnaDTO> list = qnaDao.listAll();
		model.addAttribute("list", list);

		return "qna";
	}

	// qna 등록 페이지
	@GetMapping("/qnaInfo")
	public String qnaInfo() {

		return "qnaInfo";
	}

	// qna 페이지 상세
	@GetMapping("/qnaDetail")
	public @ResponseBody QnaDTO qnaDetail(@RequestParam("q_no") String q_no) {
		System.out.println(q_no);

		QnaDTO qna = qnaDao.detail(q_no);

		return qna;
	}
	
	//qna 삭제
	@GetMapping("/rmQna/{q_no}")
	public String rmQna(@PathVariable("q_no") String q_no, Model model) {
		System.out.println(q_no);
			
		qnaDao.remove(q_no);
			
		List<QnaDTO> list = qnaDao.listAll();
		model.addAttribute("list", list);
		
		return "qna";
	}
}
