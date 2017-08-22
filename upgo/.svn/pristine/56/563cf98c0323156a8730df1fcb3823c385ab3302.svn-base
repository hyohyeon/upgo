<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<header class="w3-container w3-center w3-padding-32">  <a href='tblist.action' style="text-decoration: none;" ><h1><b>여행후기를 남겨주세요</b></h1>
  	<p>Welcome to the page of <span class="w3-tag">hyony's</span></p></a></header>
<meta charset="utf-8">
<title>후기작성페이지</title>
	<link rel="Stylesheet" href="/upgo/styles/default.css" />
	<link rel="Stylesheet" href="/upgo/styles/input2.css" />
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="/upgo/navereditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type='text/javascript'>
	$(function() {
		//전역변수선언
		var editor_object = [];

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

		//전송버튼 클릭이벤트
		$("#save").click(function() {
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
	<form action="/upgo/board2/tbwrite.action" method="post" id="frm">
		<table>
			<tr>
				<td>작성자</td>
				<td style="width: 650px">
					<%
						Member member = (Member) session.getAttribute("loginuser");
					%> <%=member.getMemberId()%>
					<!-- input type="hidden" : 서버로 전송하지만 브라우저에 표시되지 않는 요소 --> <input
					type="hidden" name="writer" value="<%=member.getMemberId()%>">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title"
					style="width: 650px" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="content" name="content"
						rows="10" cols="100" style="width: 650px; height: 412px;"></textarea></td>
			<tr>
				

			</tr>
		</table>
		<br><br>
		<input type="button" style="WIDTH: 40pt; HEIGHT: 20pt"
		id="save" value="저장" /> <input 
					type="button" style="WIDTH: 40pt; HEIGHT: 20pt" value="취소" />
	</form></div></div></div></div>

</body>
</html>