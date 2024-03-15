package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 세션에 저장되어있는 값 삭제
		// .removeAttribute("세션이름") --> 특정 세션 삭제
		// .invalidate() --> 전체 세션 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("loginMember");
		response.sendRedirect("main.jsp");
		
	}

}
