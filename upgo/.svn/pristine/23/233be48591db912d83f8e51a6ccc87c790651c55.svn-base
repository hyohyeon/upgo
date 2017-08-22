<%@page import="com.upgo.dto.TBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!doctype html>


<html lang="en">
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<title>효현이는 연습중인데</title>
	<header class="w3-container w3-center w3-padding-32">  <a href='tblist.action' style="text-decoration: none;" ><h1><b>여행후기를 남겨주세요</b></h1>
  	<p>Welcome to the page of <span class="w3-tag">hyony's</span></p></a></header>
<!-- 	Bootstrap Core CSS -->
<link href="/upgo/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/upgo/font-awesome/css/font-awesome.min.css"
rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<!-- 헤드여행후기를 남겨주세요 -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="upgo/WebContent/js/featherlight.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() { //jQuery's main function
		$('#write').on('click', function(event) {
			location.href = 'tbwrite.action';
		});
	});
</script>

<body>
	
	<!-- tboards에서 속성 가져오기 -->
	<% List<TBoard> TBoards = (List<TBoard>) request.getAttribute("tboards");%>
	<!-- 검색내역이 없으면 대체이미지출력 -->
	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<br><input id="write" type="button" value="새로운 글 작성하러 가기!"
				style="width: 300px; height: 25px" /><br> <br> <br />
	<% if(TBoards.isEmpty()){ %>
		<div align="center">
		<a href="tblist.action"><img src=/upgo/img/emptyimage.jpg width="350px" height="350px" border="0px"></a>
		</div>
	<!-- 검색내역이 있으면 -->	
		<% }else{ %>
			<table align="center">
				<tr> <!-- 테이블에 하나하나씩 집어넣자! -->
					<% for (TBoard TBoard : TBoards) { %>
				<td> <!-- 작성되었다가 삭제된 글이라면 대체이미지 출력 -->
					<% if (TBoard.isDeleted()) { //삭제된 글인 경우%>
						<img src="/upgo/img/deletedimage.jpg" width="350px" height="350px" border="0px">
					<% } else { //이외 정상적인 삭제되지 않은 글 %>
					<!-- pageno+boardno로 불러오기, content의 첫 사진으로 메인이미지장식 -->
					<a href="tbdetail.action?boardno=<%=TBoard.getBoardNo()%>&pageno=<%=request.getAttribute("pageno")%>"
						style='text-decoration: none'> <img src="<%=TBoard.getContent()%>"
							width="350px" height="350px" border="0px" style="opacity: 1"
							onmouseover="this.style.opacity='0.5'"
							onmouseout="this.style.opacity='1'" /> </a>				
							<% } %><br><br><br>
						<p style='text-align: center'>
							제목 : <%=TBoard.getTitle()%></p>
						<p style='text-align: center'>
							글쓴이 : <%=TBoard.getWriter()%></p>
						<p style='text-align: center'>
							작성일 : <%=TBoard.getRegDate()%></p></td>
					<% } %>
					</tr>
				</table><br><br>
				<%=request.getAttribute("pager").toString()%><br><br>
				<a href="tblist.action">최신목록</a>
				<% } %>
			<br><br>
		</div>
		</div>
		<br> <br>
		<!-- 검색 기능 -->
		<div align=center>
		<span>생생한 여행후기 검색해보세요!</span>
        <form action="tblist.action">
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="searchflag" value="텍스트를 입력하세요" onclick='this.value="";this.onclick="";'/>&nbsp;
            <input type="submit" value="검색"/></div>
        </form>    
		
		
		<!-- 검색 기능 end -->
		<jsp:include page="/WEB-INF/views/include/function.jsp" />
</body>
</html>