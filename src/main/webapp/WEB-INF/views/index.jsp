<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script src="${path}/resources/js/test.js"/>
    <!--<link href="${path}/resources/css/test.css" rel="stylesheet"/>-->
</head>
<body>
${test}
<p>red</p>
</body>
</html>