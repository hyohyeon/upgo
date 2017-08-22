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
	<form action="/upgo/board/write.action" method="post" id="frm">
		<table width="100%">
			<tr>
				<td>고객아이디</td>
				<td>
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
						rows="10" cols="100" style="width: 766px; height: 412px;"></textarea></td>
			<tr>
				<td><input type="button" id="save" value="저장" /> <input
					type="button" value="취소" /></td>

			</tr>
		</table>
	</form>

</body>
</html>