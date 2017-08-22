<%@page import="com.upgo.dto.TBoard"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 수정 페이지</title>

<link rel="Stylesheet" href="/upgo/styles/default.css" />
<link rel="Stylesheet" href="/upgo/styles/input2.css" />
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/upgo/navereditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type='text/javascript'>
	$(function() {
		//전역변수선언
		var editor_object = [];

		//$('#content').val('<p>hello</><h1>hello2</h1>');

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "content",
			sSkinURI : "/upgo/navereditor/SmartEditor2Skin.html",
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
	<div id="pageContainer">
	<div style="padding-top:15px;text-align:center">
	<div id="inputcontent">
	<div id="inputmain">
	<div class="inputsubtitle">게시판 글 쓰기</div>
	<form action="tbupdate.action" method="post" id="frm">
		<table width="100%">
			<%
				TBoard tboard = (TBoard) request.getAttribute("tboard");
			%>
			<tr>
				<th style="width:100px">글 번 호</th>
				
				<td style="width: 650px"><%=tboard.getBoardNo()%> <input type="hidden"
					name="boardno" value="<%=tboard.getBoardNo()%>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" style="width: 280px"
					value="<%=tboard.getTitle()%>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=tboard.getWriter()%></td>
				
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" rows="10" cols="100" style="width: 100%; height: 412px;"><%=tboard.getContent()%></textarea>
				</td>
			</tr>
		</table>
		<div class="buttons">
			<!-- <form>의 submit 수행 -->
			<a id="update" href="#">글수정</a> &nbsp;&nbsp; <a
				href='/upgo/board2/tbdetail.action?boardno=<%=tboard.getBoardNo()%>&pageno=<%=request.getAttribute("pageno")%>'>취소</a>
		</div>
	</form>

</body>
</html>