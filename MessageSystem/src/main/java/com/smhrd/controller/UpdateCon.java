package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;


public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		System.out.println("[UpdateCon]");
		
		// 0.post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터 수집
		// name기준으로 pw,tel,address
		// session에 저장된 정보 email
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
		String email = loginMember.getEmail();
		String pw2 = loginMember.getPw();
		
		// pw 확인해서 맞으면~~~DB저장
//		if(pw.equals(pw2)) {
//			// DAO객체, 메소드 호출, 결과가 실행성공->main......
//			
//		}
		
		// 2. MemberVO에 e,p,t,a 정보를 담아서 묶기
		MemberVO update = new MemberVO(email, pw, tel, address);
		
		// 3. MemberMapper.xml에서 sql문 완성
		
		// 4-1. DAO에 메소드 구현
		// 4-2. DAO 객체 생성
		MemberDAO dao = new MemberDAO();
		// 4-3. DAO 메소드 호출
		int cnt = dao.updateMember(update);
		
		// 5. 명령 후 처리
		// 회원정보 수정 성공 -> main.jsp 진짜로 바꼈는지 확인
		// 회원정보 수정 실패...-> update.jsp 다시 수정
		if(cnt>0) {
			// 성공
			// 수정된 정보를 다시 세션에 저장-> loginMember에 덮어쓰기
			session.setAttribute("loginMember", update);
			response.sendRedirect("main.jsp");
			
		}else {
			// 실패
			System.out.println("회원정보 수정 실패ㅜㅜ");
			response.sendRedirect("update.jsp");
		}
		
		
		
		
		
		
	}

}
