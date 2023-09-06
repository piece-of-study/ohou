<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
 <%@ page import="org.springframework.security.core.Authentication" %>
 <%
     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     Object principal = auth.getPrincipal();

     String name = "";
     if(principal != null) {
         name = auth.getName();
     }
 %>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
    <meta charset="UTF-8">
    <title>index</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/test.js"/>"></script>
    <link href="<c:url value="/resources/css/test.css"/>" rel="stylesheet"/>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <a href="/user/login">로그인</a><br>
    <a href="/join">회원가입</a><br>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <h5><%=name %>님, 반갑습니다.</h5>
    <a href="/logout">로그아웃</a><br>
</sec:authorize>
    ${test}
    <p>red</p>
</body>
</html>