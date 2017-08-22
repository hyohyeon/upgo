<%@page import="com.upgo.dto.Board"%>
<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>

<script type="text/javascript"
	src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/upgo/navereditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type='text/javascript'>
	$(function() {
		//전역변수선언
		var editor_object = [];

		//$('#content').val('<p>hello</><h1>hello2</h1>');

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "content",
			sSkinURI : "/upgo/navereditor2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		//수정완료버튼 이벤트
		$("#update").click(function() {
			//id가 smarteditor인 textarea에 에디터에서 대입
			editor_object.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증

			//폼 submit
			$("#frm").submit();
		})

	})
</script>
</head>
<body>
	<form action="update.action" method="post" id="frm">
		<table width="100%">
			<%
				Board board = (Board) request.getAttribute("board");
			%>
			<tr>
				<th>글 번 호</th>
				<td><%=board.getBoardNo()%> <input type="hidden"
					name="boardno" value="<%=board.getBoardNo()%>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" style="width: 280px"
					value="<%=board.getTitle()%>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=board.getWriter()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" cols="76" rows="15"><%=board.getContent()%></textarea>
				</td>
			</tr>
		</table>
		<div class="buttons">
			<!-- <form>의 submit 수행 -->
			<a id="update" href="#">글수정</a> &nbsp;&nbsp; 
			<a href='/upgo/board/detail.action?boardno=<%=board.getBoardNo()%>&pageno=<%=request.getAttribute("pageno")%>'>취소</a>
		</div>
	</form>

</body>
</html>