package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;

// maven project의 servlet은 url-mapping값이 파일에 XX
// src/main/webapp/WEB-INF/web.xml에서 관리
public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 잘 이동했는지 확인
		System.out.println("[JoinCon]");

		// 0. post방식으로 넘어온 데이터 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터 수집(email,pw,tel,address)
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// 2. 받아온 값 MemberVO객체에 묶어 담아주기
		MemberVO joinMember = new MemberVO(email, pw, tel, address);
		// 받아온값 확인해보기
		System.out.println(joinMember.toString());
		
		// 3. MemberMapper.xml에 sql문 작성
		
		// 4-1. MemberDAO가서 회원가입 메소드 작성
		// 4-2. MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		// 4-3. insertMember 메소드 호출
		int cnt = dao.insertMember(joinMember);
		
		// 5. 명령 후 처리
		// 회원가입 성공(cnt>0) => joinSuccess.jsp
		// 회원가입 실패 => main.jsp
		if(cnt>0) {
			// 성공
			// 회원가입 축하드립니다~ 000님 --> email 정보 보내기
			// request에 담아서 forward방식 이동
			// /MessageSystem/src/main/webapp/joinSuccess.jsp
			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			request.setAttribute("joinEmail", email);
			rd.forward(request, response);
			
		}else {
			// 실패
			System.out.println("회원가입 실패ㅜㅜ");
			response.sendRedirect("main.jsp");
		}
		
		
		
		
		
		
		
	}

}
