<%@page import="com.smhrd.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	// main값 ->controller->main/update,joinsuccess
	// 바로 select.jsp에서는 DB정보를 불러옴
	// 마치 selectCon인것처럼
	// 1. sql문 작성
	// 2. DAO 메소드 구현, 호출
	MemberDAO dao = new MemberDAO();
	List<MemberVO> memberlist = dao.selectAll();

	
	// Dynamic project : project탭-clean : 지금 저장되어있는 상황을 적용
	// maven project : 프로젝트 우클릭-maven-update project

%>
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>	
								<td>삭제</td>						
							</tr>
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
						<%for(MemberVO m:memberlist){ %>
							<tr>
								<td><%=m.getEmail() %></td>
								<td><%=m.getTel() %></td>
								<td><%=m.getAddress() %></td>
								<!-- DeleteCon으로 이동할때 쿼리스트링으로 email같이 보내기 
								요청?name=value&name=value
								-->
								<td><a href="DeleteCon?email=<%=m.getEmail()%>">회원삭제</a></td>
							</tr>
						<%} %>
						</table>
					</nav>		
					<a href="main.jsp" class="button next scrolly">되돌아가기</a>
					
					<div>
					
					<input type="text" name="search">
					
					<button type="button" onclick="searchName()">검색</button>
					<hr>
					</div><!-- /검색기능 -->
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			
			<script>
				// jquery 먼저 실행된 다음에 js 코드 사용할것!!
				// ajax는 jquery 문법에서 가져옴
				function searchName(){
					$.ajax({
						url : "SearchCon",
						type : "get",
						// 보내는 데이터
						// js 객체 {key:value, key:value}
						// key값이 Controller에서 name으로 인식
						data : {"s" : $("input[name=search]").val()},
						// 받아오는 데이터 타입
						dataType : "json",
						success : function(res){
							console.log(res);  
							for(let i=0;i<res.length;i++){
								console.log(res[i].email);
								// 태그내용을 담을 변수
								let data = "";
								data += res[i].email;
								data += res[i].tel;
								data += res[i].address+"<br>";
								// 결과값을 태그로 출력
								// hr태그 다음에 결과를 추가 .append(태그내용)
								$('hr').append(data);
							}
							
							
							
							
							
							// 뒤에 추가 .after(태그내용)
							// 앞에 추가 .before(태그내용)
							// 덮어쓰기 .html(태그내용)
							
							
						},
						error :function(){
							alert("통신 실패ㅜㅜ");
						}
						
					}); //ajax 끝
				}// searchName 함수 끝
				
				
				
				
				
				
				
				
			
			
			
			</script>
			
			
			
			
	</body>
</html>

