<%@page import="com.upgo.dto.TBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<title>게시물 목록</title>
<link rel="Stylesheet" href="/upgo/styles/default.css" />
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() { //jQuery's main function
		$('#write').on('click', function(event) {
			location.href = 'tbwrite.action';
		});
	});
</script>
</head>
<body>
	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<input id="write" type="button" value="글쓰기"
				style="width: 300px; height: 25px" /> <br />
			<br />
			<% List<TBoard> TBoards = 
				(List<TBoard>)request.getAttribute("tboards"); %>
			<table border="1" align="center">
				<tr style="background-color: beige; height: 25px">
					<th style="width: 50px">번호</th>
					<th style="width: 300px">제목</th>
					<th style="width: 150px">작성자</th>
					<th style="width: 120px">작성일</th>
					<th style="width: 80px">조회수</th>
					<th style="width: 200px">첨부파일</th>
				</tr>
				<% for (TBoard TBoard : TBoards) { %>
				<tr style="height: 25px">
					<td style='text-align: center'><%= TBoard.getBoardNo()%></td>
					<td style='text-align: left; padding: 5px'>
					<% if (TBoard.isDeleted()) { //삭제된 글인 경우%>
						<span id="deleted-message">[ 삭제된 글 ]</span>
					<% } else { //삭제되지 않은 글 %>
						<a href='tbdetail.action?boardno=<%= TBoard.getBoardNo() %>&pageno=<%= request.getAttribute("pageno") %>' style='text-decoration: none'>
							<%= TBoard.getTitle() %>
						</a>
					<% } %>
					</td>
					<td style='text-align: center'><%= TBoard.getWriter() %></td>
					<td style='text-align: center'><%= TBoard.getRegDate() %></td>
					<td style='text-align: center'><%= TBoard.getReadCount() %></td>
					<td style='image-align: center'></td>
					<% } %>
				</tr>
			</table>
			<br>
			<br>
			<%= request.getAttribute("pager").toString() %>
		</div>
	</div>
</body>
</html>