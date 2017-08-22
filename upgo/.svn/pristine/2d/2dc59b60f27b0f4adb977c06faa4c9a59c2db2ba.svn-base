<%@page import="com.upgo.dto.twoBoardComment"%>
<%@page import="com.upgo.dto.BoardAttach"%>
<%@page import="com.upgo.dto.Member"%>
<%@page import="com.upgo.dto.twoBoard"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>

	<meta charset="utf-8" />
	<title>글쓰기</title>
	<link rel="Stylesheet" href="/upgo/styles/default.css" />
	<link rel="Stylesheet" href="/upgo/styles/input2.css" />
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$('a#delete').on('click',function(event){
				var boardNo = $(this).attr('data-boardno')
				 var ok = confirm(boardNo + '번 글을 삭제할까요?');
				 if (ok) {
					location.href = "twodelete.action?boardno=" + boardNo;
				 }
				event.preventDefault(); //<a>의 기본 동작 중단
			});
		});
	
	</script>
		<script type="text/javascript">
	$(function() {
		
		function toggleCommentStatus(commentNo, edit) {		
			$('#commentview' + commentNo).css('display', edit ? 'none' : 'block');
			$('#commentedit' + commentNo).css('display', edit ? 'block' : 'none');
		}
		
		$('a#writecomment').on('click', function(event) {
			$('#commentform').submit();
			event.preventDefault();
		});
		
		$('a[id=edit]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno'); //사용자 정의 설정 - 
			toggleCommentStatus(commentNo, true);
			event.preventDefault();
		});
		
		$('a[id=deletecomment]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			var boardNo = $(this).attr('data-boardno');
			var pageNo = $(this).attr('data-pageno');
			var yes = confirm(commentNo + "번 답글을 삭제할까요?");
			if (yes) {
				location.href =
					'twodeletecomment.action?commentno=' + commentNo + 
							'&boardno=' + boardNo + '&pageno=' + pageNo;
			}
			event.preventDefault();
		});
		$('a[id=modify]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			$('#commenteditform' + commentNo).submit();
			event.preventDefault();
		});

		$('a[id=cancel]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
			toggleCommentStatus(commentNo, false);
			event.preventDefault();
		});
	});
	
	</script>
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 내용</div>
		        <% twoBoard board = (twoBoard)request.getAttribute("board");%>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td><%= board.getTitle() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td><%= board.getWriter() %></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td><%= board.getRegDate() %></td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td><%= board.getReadCount() %></td>
		            </tr>
		           
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">		                    
		                    <%= board.getContent().replace("\r\n","<br>")%>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        <% Member member = (Member)session.getAttribute("loginuser"); %>
		        <% if (member.getMemberId().equals(board.getWriter())){ %>
		        	[&nbsp;<a id="delete" href='#' data-boardno="<%= board.getBoardNo()%>">삭제</a>&nbsp;]
		        	[&nbsp;<a href='twoupdate.action?boardno=<%=board.getBoardNo()%>&pageno=<%= request.getAttribute("pageno")%>'>수정</a>&nbsp;]
		        	<%} %>
		        	[&nbsp;<a href='tworeply.action?boardno=<%=board.getBoardNo()%>'>댓글쓰기</a>&nbsp;]
		        	[&nbsp;<a href='twolist.action?pageno=<%= request.getAttribute("pageno")%>'>목록보기</a>&nbsp;]
		        </div>
		    </div>
		</div>
		
				
		<!-- comment 쓰기 영역 -->
		<br /><br />
		
		<% if (session.getAttribute("loginuser") != null) { %>
		<form id="commentform" 
			action="twowritecomment.action" method="post">
			<input type="hidden" name="boardno" value="<%= board.getBoardNo() %>" />
			<input type="hidden" name="pageno" value='<%= request.getAttribute("pageno") %>' />
			<table style="width:600px;border:solid 1px;margin:0 auto">
	            <tr>
	                <td style="width:550px">	                	
	                    <textarea name="content" 
	                    	style="width:550px" rows="3"></textarea>	                    
	                </td>
	                <td style="width:50px;vertical-align:middle">
	                	<a id="writecomment" href="#" style="text-decoration:none">
	                		댓글<br />등록
	                	</a>
	                </td>
	            </tr>                    
	        </table>
        </form>
        <% } %>
        
        <hr align="center" style="width:600px;" />
		
		 <% if (board.getComments().size() == 0) { %>
			<h3 id="nodata" style="text-align:center">
			 작성된 댓글이 없습니다.
			</h3>
		<% } else { %>
		    <table style="width:600px;border:solid 1px;margin:0 auto">
			<% for (twoBoardComment bcomment : board.getComments()) { %>
			<tr>
				<td style="text-align:left;margin:5px;border-bottom: solid 1px">
	        		<div id='commentview<%= bcomment.getCommentNo() %>'>
	                    <%= bcomment.getWriter() %> &nbsp;&nbsp;
	                    [ <%= bcomment.getRegDate() %> ]
	                    <br /><br />
	                    <span>
							<%= bcomment.getContent().replace("\r\n", "<br>") %>
	                    </span>
	                    <br /><br />
	                    <div style='display: <%= member.getMemberId().equals(bcomment.getWriter()) ? "block" : "none" %>'>
	                    	<a id="edit" data-commentno='<%= bcomment.getCommentNo() %>' href="#">편집</a>
	                    	&nbsp;
	                    	<a id="deletecomment" href="#" data-commentno='<%= bcomment.getCommentNo() %>'
													data-boardno='<%= board.getBoardNo() %>'
													data-pageno='<%= request.getAttribute("pageno") %>'>삭제</a>
	                    </div>
	                </div>
	                
	                <div id='commentedit<%= bcomment.getCommentNo() %>' style="display: none">
						<%= bcomment.getWriter() %>&nbsp;&nbsp; 
						[<%= bcomment.getRegDate() %>] 
						<br /><br />
						<form id="commenteditform<%= bcomment.getCommentNo() %>" action="twoupdatecomment.action" method="post">
						<input type="hidden" name="boardno" value="<%= board.getBoardNo() %>" />
						<input type="hidden" name="pageno" value='<%= request.getAttribute("pageno") %>' />
						<input type="hidden" name="commentno" value="<%= bcomment.getCommentNo() %>" />
						<textarea name="content" style="width: 600px" rows="3" maxlength="200"><%= bcomment.getContent() %></textarea>
						</form>
						<br />
						<div>
							<a id="modify" data-commentno='<%= bcomment.getCommentNo() %>' href="#">수정</a> 
							&nbsp; 
							<a id="cancel" data-commentno='<%= bcomment.getCommentNo() %>' href="#">취소</a>
						</div>
					</div>
		
					</td>
	        	</tr>
			<% } %>
	        </table>
		<% } %>
		<!-- comment 표시 영역 -->
        
        
        <br /><br /><br /><br /><br /><br />
	
	</div>
	</div>

</body>
</html>