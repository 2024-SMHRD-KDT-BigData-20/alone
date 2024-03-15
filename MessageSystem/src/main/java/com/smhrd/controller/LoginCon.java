package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;


public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("[LoginCon]");
		
		// 0. post방식으로 넘어온 데이터 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터 수집(email,pw,tel,address)
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		// 3. MemberVO에 email,pw 묶어서 담기
		MemberVO login = new MemberVO(email, pw);
		
		// 4. MemberMapper.xml sql문 작성
		
		// 5-1. MemberDAO에 로그인기능 메소드 구현
		// 5-2. MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		// 5-3. select메소드 호출-> 결과물을 MemberVO로 담아주기
		MemberVO loginMember = dao.selectMember(login);
		
		// 6. 명령 후 처리
		// 로그인 성공 -> 세션에 회원정보 저장 -> main.jsp
		// 로그인 실패 -> main.jsp
		if(loginMember != null) {
			// 성공
			// 세션에 정보 저장
			// Servlet에서는 세션 객체 생성 먼저!
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
		}else {
			// 실패
			System.out.println("로그인 실패ㅜㅜ");
		}
		
		
		response.sendRedirect("main.jsp");
		
		
	}

}
