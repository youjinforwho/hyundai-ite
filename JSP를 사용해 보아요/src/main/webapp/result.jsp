<%@ page import="member.vo.MemberVO" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML 주석이에요 -->
<%-- JSP 주석이에요 --%>
	<%-- 
		기억해야 하는 JSP의 구성요소는
		1. Expression => <%= %>
		이 Expression안에는 문자열로 변환이 가능한 값!
		이 Expression이 있는 위치에 값을 그냥 냅다 출력
		
		2. Scriptlet => <%일반 자바 코드가 나와요%>
	 --%>
	 <%
	 	MemberVO vo = (MemberVO)session.getAttribute("MyDATA");
	 	//MemberVO vo = (MemberVO)request.getAttribute("ResultVO");
	 	//JSP는 Servlet으로 실행되며, 편하게 사용하기 위해 기본적으로 session이라는 키워드로 클라이언트 session을 제공함
	 %>

	<h1>성공적으로 회원가입이 되었어요!</h1>
	<h2>가입된 회원의 이름: <%=vo.getUserName() %></h2>
	<h2>가입된 회원의 나이: <%=vo.getUserAge() %></h2> <!-- 자동적으로 문자열로 변환시킴 -->
	<%
		int myAge = 30;
	%>
	<h2>가입된 회원의 나이: <%=myAge %></h2>
</body>
</html>