package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;
import com.smhrd.model.MessageVO;


public class insertMSG extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// main에서 sendName,receiveEmail,msg 가져오기
		// 0. post방식 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 1. 파라미터 수집
		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String msg = request.getParameter("msg");
		
		// 2. MessageVO로 3가지 값 담아서 묶어주기
		MessageVO insertmsg = new MessageVO(sendName, receiveEmail, msg);
		
		// 3. MessageMapper.xml에 SQL문 작성
		
		// 4-1. DAO 메소드 구현
		// 4-2. DAO 객체 생성
		MessageDAO mdao = new MessageDAO();
		// 4-3. DAO 메소드 호출 -> int 형으로 담음
		int cnt = mdao.insertMSG(insertmsg);
		// 4-4. int가 >0이면 syso 출력문 확인
		if(cnt>0) {
			System.out.println("메세지 전송 성공~~");
		}else {
			System.out.println("메세지 전송 실패ㅜㅜ");
		}
		// 5. 명령 후 처리
		// 메세지 전송을 실행하면(성공/실패) main.jsp로 이동
		response.sendRedirect("main.jsp");
		
		
	}

}
