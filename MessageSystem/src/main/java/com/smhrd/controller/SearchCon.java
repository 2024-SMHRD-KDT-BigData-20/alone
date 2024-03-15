package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberVO;


public class SearchCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ajax로 부터 데이터 객체 형태로 받아오면
		// name 지정해줘서 파라미터수집
		String email = request.getParameter("s");
		System.out.println(email);
		
		// MemberMapper.xml에서 SQL문 작성
		// DAO 메소드 구현
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> searchlist = dao.searchMember(email);
		
		// JAVA객체를 Json문자열 데이터 변환 후 전송
		
		// Gson : Java객체를 json으로, json데이터를 Java객체로 변환
		// Gson 객체 생성
		Gson gson = new Gson();
		// toJson(데이터)
		String res = gson.toJson(searchlist);
		
		// PrintWriter객체는 결과물을 전달하는 통로됨
		
		// 돌려주기1) 돌려줄 값의 인코딩 필요
		// ajax는 UTF-8로만 인코딩함
		response.setCharacterEncoding("UTF-8");
		
		// 돌려주기2) 전달할 통로 만들기
		PrintWriter out = response.getWriter();
		
		// 예외처리
		if(searchlist != null) {
			// 돌려주기3) PrintWriter객체에 값 전달!!
			out.print(res);
		}else {
			System.out.println("검색 실패ㅜㅜ");
		}
		
		
		
	}

}
