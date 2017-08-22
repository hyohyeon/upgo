<%@page import="com.upgo.dto.twoBoard"%>
<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<title>글쓰기</title>
<link rel="Stylesheet" href="/upgo/styles/default.css" />
<link rel="Stylesheet" href="/upgo/styles/input2.css" />
<style type="tect/css">
	a { text-decoration:none}
	</style>
<script src="https://code.jquery.com/jquery-3.2.1.js">
	
</script>
<script type="text/javascript">
	$(function() {//jquery's main function
		$('a#update').on('click', function(event) {
			$('form#updateform').submit();
			event.preventDefault();// <a>의 기본 기능 수행 막는 명령
		});
	});
</script>
</head>
<body>

	<div id="pageContainer">

		

		<div style="padding-top: 25px; text-align: center">
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">게시판 글 쓰기</div>
					<form id="updateform" action="twoupdate.action" method="post">
						<%
						twoBoard board = (twoBoard) request.getAttribute("board");
						%>
						<table>
							<tr>
							<th>글번호</th>
								<td>
								<%= board.getBoardNo() %>
								<input type="hidden" name="boardno" 
								value ="<%= board.getBoardNo() %>">
								</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>
								<input type="text" name="title" style="width: 280px" 
								value ="<%= board.getBoardNo() %>"/>
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
									<%
										Member member = (Member) session.getAttribute("loginuser");
									%>
									<%=member.getMemberId()%> 
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>
								<textarea name="content" cols="76" rows="15"><%=board.getContent()%></textarea>
								</td>
							</tr>
						</table>
						<div class="buttons">
						
							<!-- <form의 submit 수행 -->
							<a id="update" href="#">글수정</a> &nbsp;&nbsp; <a
								href="/upgo/twoboard/twolist.action">목록보기</a>  &nbsp;&nbsp;
								<a href='/upgo/twoboard/twodetail.action?boardno=<%= board.getBoardNo()%>&pageno=<%= request.getAttribute("pageno")%>'>취소</a>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

</body>
</html>