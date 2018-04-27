
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="header">
    <h1><a href="/main">MySite</a></h1>

    <c:choose>
    <c:when test="${empty authUser}">
        <li><a href="/user/loginform">로그인</a></li>
        <li><a href="/user/joinform">회원가입</a></li>
    </c:when>
    <c:otherwise>
    <li><a href="/user/modifyform">회원정보수정</a></li>
    <li><a href="/user/logout">로그아웃</a></li>
    <ul> <li><b> ${authUser.name}</b>님 반갑습니다.</li>
        </c:otherwise>
        </c:choose>
    </ul>
</div>
