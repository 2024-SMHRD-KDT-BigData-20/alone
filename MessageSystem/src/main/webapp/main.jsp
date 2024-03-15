<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.MessageVO"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.MessageDAO"%>
<%@page import="com.smhrd.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	// 로그인한 사람의 메세지 가져오기
	// 세션에 로그인한 사람의 email
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");

	// MessageMapper.xml에 sql문 작성
	// DAO에 메소드 구현
	// DAO 객체 생성
	MessageDAO mdao = new MessageDAO();
	// DAO 메소드 호출  -> 로그인한 상태일때만 dao 일시키기
	List<MessageVO> msglist = null;
	if(loginMember != null){
		msglist = mdao.selectMSG(loginMember.getEmail());
		if(msglist == null){
			System.out.print("없냐구ㅠ");
		}else{
			System.out.print("ㅇ;ㅣㅆ다구ㅠ");
			System.out.print(msglist.size());
		}
	}
	
	

%>
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
		<!-- Wrapper -->
		<div id="wrapper">
		<!-- Header -->
		<header id="header" class="alt">
			<a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
			<nav>
				<c:choose>
					<c:when test="${empty loginMember }">
						<a href="#menu">로그인</a>
					</c:when>
					<c:otherwise>
					<%-- 만약에 로그인한 사람의 email이 admin이면 select.jsp 이동 --%>
					<c:if test="${ loginMember.email eq 'admin'}">
						<a href="select.jsp">회원관리</a>
					</c:if>
					<%-- 로그아웃버튼을 누르면 요청이 LogoutCon.java이동
					href="LogoutCon"이라는 url-mapping값 --%>
						<a href="LogoutCon">로그아웃</a>
						<a href="update.jsp">개인정보수정</a>
					</c:otherwise>
				</c:choose>
			
				
				<!-- 로그인 후 Logout.jsp로 이동할 수 있는'로그아웃'링크와 '개인정보수정'링크를 출력하시오. -->
			</nav>
		</header>

		<!-- Menu -->
		<nav id="menu">	
			<ul class="links">
				<li><h5>로그인</h5></li>
				<form action="LoginCon" method="post">
				 	<li><input type="text" name="email" placeholder="Email을 입력하세요"></li>
					<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
					<li><input type="submit" value="LogIn" class="button fit"></li>
					</form>
			</ul>
			<ul class="actions vertical">
				<li><h5>회원가입</h5></li>
				<form action="JoinCon" method="post">
					<li><input type="text" name="email" placeholder="Email을 입력하세요" ></li>
					<li><input type="password" name="pw" placeholder="PW를 입력하세요" ></li>
					<li><input type="text" name="tel" placeholder="전화번호를 입력하세요" ></li>
					<li><input type="text" name="address" placeholder="집주소를 입력하세요" ></li>
					<li><input type="submit" value="JoinUs" class="button fit"></li>
				</form>
			</ul>
		</nav>			
		<!-- Banner -->
			<section id="banner" class="major">
				<div class="inner">
				<header class="major">
					<%-- jstl 정리할때는 jsp 주석으로 정리
						Jsp Standard Tag Library
						주로 jstl+EL표현식 같이 사용
						java의 if-else문과 같은 표현이
						choose - when/otherwise
						== null 표현이 empty
						MemberVO 객체를 Java코드에서 꺼내온다면 loginMember.getEmail()
						EL식으로 꺼내오는 경우 loginMember.email
						EL식때문에 오류가 나면 잘라내기-붙여넣기 진행
					 --%>
					<c:choose>
						<c:when test="${empty loginMember }">
							<h1>로그인 한 세션이메일 출력해주세요</h1>
						</c:when>
				
						<c:otherwise>
							<h1>${loginMember.email}</h1>
						</c:otherwise>
					</c:choose>
					
					<!-- 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오.ex)smart님 환영합니다 -->
				</header>
				<div class="content">
					<p>아래는 지금까지 배운 웹 기술들입니다.<br></p>
					<ul class="actions">
						<li><a href="#one" class="button next scrolly">확인하기</a></li>
					</ul>
				</div>
				</div>
			</section>

		<!-- Main -->
			<div id="main">
			<!-- One -->
			<section id="one" class="tiles">
				<article>
					<span class="image">
						<img src="images/pic01.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="#" class="link">HTML</a></h3>
						<p>홈페이지를 만드는 기초 언어</p>
					</header>
				</article>
				<article>
					<span class="image">
						<img src="images/pic02.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="#" class="link">CSS</a></h3>
						<p>HTML을 디자인해주는 언어</p>
					</header>
				</article>
				<article>
					<span class="image">
						<img src="images/pic03.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="#" class="link">Servlet/JSP</a></h3>
						<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
					</header>
				</article>
				<article>
					<span class="image">
						<img src="images/pic04.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="#" class="link">JavaScript</a></h3>
						<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
					</header>
				</article>
				<article>
					<span class="image">
						<img src="images/pic05.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="#" class="link">MVC</a></h3>
						<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
					</header>
				</article>
				<article>
					<span class="image">
						<img src="images/pic06.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="#" class="link">Web Project</a></h3>
						<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
					</header>
				</article>
			</section>
			<!-- Two -->
			<section id="two">
				<div class="inner">
					<header class="major">
						<h2>나에게 온 메세지 확인하기</h2>
					</header>
					<p></p>
					<ul class="actions">
					<%if(loginMember == null){ %>
						<li>로그인을 하세요.</li>
						
						<%}else{
							if(msglist.size() != 0){
								for(MessageVO msg:msglist){
								
							%>
							<li>보낸사람 : <%=msg.getSendName() %> </li>
							<li>보낸날짜 : <%=msg.getIndate() %></li>
							<li>내    용 : <%=msg.getMsg() %></li><br>
						
						<%
						
								}//for끝
							
							}else{ %>
							<li>받은메세지가 없습니다.</li>
						<%
							}
						} %>
						
						<li><a href="#" class="button next scrolly">전체삭제하기</a></li>
					</ul>
				</div>
			</section>
			</div>

			<!-- Contact -->
			<section id="contact">
				<div class="inner">
				<section>
				<!-- 메세지, 게시글 같이 데이터길이 긴 데이터 : post방식 전송 -->
					<form action="insertMSG" method="post">
						<div class="field half first">
							<label for="name">Name</label>
							<input type="text" name="sendName" id="name" placeholder="보내는 사람 이름" />
						</div>
						<div class="field half">
							<label for="email">Email</label>
							<input type="text" name="receiveEmail" id="email" placeholder="보낼 사람 이메일"/>
						</div>
						<div class="field">
							<label for="message">Message</label>
							<textarea name="msg" id="message" rows="6"></textarea>
						</div>
						<ul class="actions">
							<li><input type="submit" value="Send Message" class="special" /></li>
							<li><input type="reset" value="Clear" /></li>
						</ul>
					</form>
				</section>
				<section class="split">
					<section>
						<div class="contact-method">
							<span class="icon alt fa-envelope"></span>
							<h3>Email</h3>
							<c:choose>
								<c:when test="${empty loginMember }">
									<a href="#">로그인 한 사람의 이메일을 출력</a>
								</c:when>
								<c:otherwise>
									<a href="#">${loginMember.email }</a>
								</c:otherwise>
							</c:choose>
							
							<!-- 로그인 한 사용자의 이메일을 출력하시오 -->
						</div>
					</section>
					<section>
						<div class="contact-method">
							<span class="icon alt fa-phone"></span>
							<h3>Phone</h3>
							<c:choose>
								<c:when test="${empty loginMember }">
									<span>로그인 한 사람의 전화번호를 출력</span>
								</c:when>
								<c:otherwise>
									<span>${loginMember.tel }</span>
								</c:otherwise>
							</c:choose>


				
							<!-- 로그인 한 사용자의 전화번호를 출력하시오 -->
						</div>
					</section>
					<section>
						<div class="contact-method">
							<span class="icon alt fa-home"></span>
							<h3>Address</h3>
							
		                     <c:choose>
		                        <c:when test="${empty loginMember }">
		                           <span>로그인 한 사람의 집주소를 출력</span>
		                        </c:when>
		                        <c:otherwise>
		                           <span>${loginMember.address }</span>
		                        </c:otherwise>
		                     </c:choose>							
							
							
							
							<!-- 로그인 한 사용자의 집주소를 출력하시오 -->
						</div>
					</section>
				</section>					
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<ul class="icons">
						<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
						<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
					</ul>
				</div>
			</footer>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>

