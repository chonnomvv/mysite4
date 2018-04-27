<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>mysite</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="/board/find" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
						<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.no}</td>
							<td><a href="/board/view?no=${list.no}">${list.title}
							</a></td>
							<td>${list.name}</td>
							<td>${list.hit}</td>
							<td>${list.reg_date}
							</td>
							<c:choose>
								<c:when test="${empty sessionScope.authUser}"></c:when>
								<c:otherwise>
									<div class="bottom">
										<td><a href="/board/delete?user_no=${list.user_no}&no=${list.no}" class="del">삭제</a></td>
									</div>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li class="selected">3</li>
						<li><a href="">4</a></li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<div class="bottom">
					<c:choose>
						<c:when test="${empty sessionScope.authUser}">
						</c:when>
						<c:otherwise>
							<div class="bottom">
								<a href="/board/writeform?auth=${authUser.no}" id="new-book">글쓰기 ${authUser.no}</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>				
			</div>
</body>
</html>