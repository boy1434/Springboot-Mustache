package com.cos.viewapp.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//RestController ( 데이터를 리턴한다 )
// Controller ( 파일을 리턴한다 )

@Controller
public class FrontController { // - 컴포넌트
     
	// http://localhost:8080/home
    //	파싱 - 구문 분석 (문장분석)
	// 1. 디스패쳐 서블릿 /home 파싱
	// 2. IoC 컨테이너에 @RestController, @Controller 로 생성된 객체만 찾는다.
	// 3. 메서드를 호출한다.
	
	@GetMapping("/home")
	public String home(Model model) {  // request == model
		// ViewResolver 클래스
		// src/main/resources/templates (prefix - 앞에 붙는다)
		// .mustache (suffix - 뒤에 붙는다)
		
		String name = "김상진";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();	
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목3"));
		
		
		
		model.addAttribute("boards", boards);
		
		return "home"; // RequestDispatcher 가 자동 작동
		
	}
}
