package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;


public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[DeleteCon]");
		
		// 1. 쿼리스트링으로 넘어온 email 가져오기(파라미터 수집)
		// email에 담겨있는 정보가 한글이라면 URLEncoder.encode(인코딩데이터,인코딩방식)식으로 보냄
		// encode한값을 꺼내올때는 URLDecoder.decode(디코딩데이터,디코딩방식)
		String email = request.getParameter("email");
		System.out.println(email);
		
		// 2. MemberMapper.xml에 SQL문 작성--> parameterType="String"
		
		
		// 3-1. DAO 메소드 구현(deleteMember)
		// 3-2. DAO 객체 생성
		MemberDAO dao = new MemberDAO();
		// 3-3. DAO 메소드 호출 --> int 형으로 담아서 확인
		int cnt = dao.deleteMember(email);
		
		if(cnt>0) {
			System.out.println("회원삭제 성공~~");
		}else {
			System.out.println("회원삭제 실패ㅜㅜㅜ");
		}
	
		// 4. 모든일이 끝나면 select.jsp로 이동
		response.sendRedirect("select.jsp");
		
		
		
		
		
		
		
		
	}

}
