<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>

    <!--<form action="${pageContext.request.contextPath}/login-process" method="post">-->
    <form action="/login-process" method="post">
        <label for="username">이메일:</label>
        <input type="email" id="username" name="username" required><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>

        <button type="submit">로그인</button>
    </form>
    <a href="/join">회원가입</a><br>
</body>
</html>