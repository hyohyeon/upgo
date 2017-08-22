<%@ page import="com.upgo.dto.TBoardComment"%>
<%@ page import="com.upgo.dto.Member"%>
<%@ page import="com.upgo.dto.TBoard"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
	<meta charset="utf-8" />
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<title>여행정리함</title>
	<header class="w3-container w3-center w3-padding-32">  <a href='tblist.action' style="text-decoration: none;" ><h1><b>여행후기를 남겨주세요</b></h1>
  	<p>Welcome to the page of <span class="w3-tag">hyony's</span></p></a></header>
	<!-- table 관련 css -->
	<link rel="Stylesheet" href="/upgo/styles/inputtb.css" />
	<link rel="Stylesheet" href="/upgo/styles/default.css" />
	<!-- 	Bootstrap Core CSS -->
	<link href="/upgo/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="/upgo/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
	<link href="/upgo/navereditor/css/smart_editor2_out.css" rel="stylesheet">
	<!-- 헤드여행후기를 남겨주세요 -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type="text/javascript" charset="utf-8">
	$(function() {
		$('a#delete').on('click', function(event) {
			var boardNo = $(this).attr('data-boardno');
			var ok = confirm(boardNo + '번 글을 삭제할까요?');
			if (ok) {
				location.href = "tbdelete.action?boardno=" + boardNo;
			}
			event.preventDefault();//<a>의 기본 동작 중단
		});
	});	
	</script>
	<script type="text/javascript">
	$(function() {
		function toggleCommentStatus(commentNo, edit) { 
			$('#commentview' + commentNo).css('display', edit ? 'none' : 'block');
			$('#commentedit' + commentNo).css('display', edit ? 'block' : 'none');
		}
		
		//댓글 등록 이벤트 처리
		$('#tbwritecomment').on('click', function(event) {
			var content = $('textarea#comment_content').val();
			if (content.length == 0) {
				alert('댓글 내용을 입력하세요');
				$('#comment_content').focus();
			} else {			
				$('#commentform').submit();
			}
			event.preventDefault();
		});
		
		//$('#edit')
		$('a[id=edit]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno');
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
					'deletecomment.action?commentno=' + commentNo + 
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
    <center /><hr align="center" style="width:580px; border: dotted 1.5px #1f6cba;">
	<div id="pageContainer">
		<div style="padding-top:25px; text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">♡TRAVEL BOARD♡</div><br>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>${ requestScope.tboard.title }</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${ tboard.writer }</td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td>${ tboard.regDate }</td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td>${ tboard.readCount }</td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td class="se2_outputarea"  style="height:200px;vertical-align:top">
		                   <c:set var="newLine" value="" />
		                   ${ fn:replace(tboard.content, newLine, "<br>") }
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
	        
		        <c:if test="${ tboard.writer eq loginuser.memberId }">
		        	[&nbsp;<a id="delete" href='#' data-boardno="${ tboard.boardNo }">삭제</a>&nbsp;]
		        	[&nbsp;<a href='tbupdate.action?boardno=${ tboard.boardNo }&pageno=${ pageno }'>수정</a>&nbsp;]
		        </c:if>
		        	[&nbsp;<a href='tblist.action?pageno=pageno=${ pageno }'>목록보기</a>&nbsp;]
		        </div>
		    </div>
		</div>
		<br><br>
		<center /><hr align="center" style="width:580px; border: dotted 1.5px #1f6cba;">
		<!-- comment 쓰기 영역 -->
		<br /><br />
		
		<c:if test="${ loginuser ne null }">
		<form id="commentform" 
			action="tbwritecomment.action" method="post">
			<input type="hidden" name="boardno" value="${ tboard.boardNo }" />
			<input type="hidden" name="pageno" value='${ pageno }' />
			<table style="width:590px;border:solid 1.5px; color:gray;margin:0 auto">
	            <tr>
	                <td style="width:550px">	                	
	                    <textarea id="comment_content" name="content" 
	                    	style="width:550px; vertical-align:middle;" rows="3"></textarea>	                    
	                </td>
	                <td style="width:40px;vertical-align:middle;">
	                	<a id="tbwritecomment" href="#" style="font-size:10pt;bold;color:gray;">
	                		댓글<br />등록
	                	</a>
	                </td>
	            </tr>                    
	        </table>
        </form>
        <center /><hr align="center" style="width:580px;">
        </c:if>
		<c:choose>
		<c:when test="${ empty tboard.comments }">
			<span id="nodata" style="text-align:center; font-size: 12pt; bold; ">
		 	<b>아직 작성된 댓글이 없어요T.T &nbsp; 댓글을 남겨주세요♡</b>
			</span>
		</c:when>
		<c:otherwise>
		    <table style="width:590px;border:solid 1.2px;margin:0 auto">			
			<c:forEach var="bcomment" items="${ tboard.comments }">	<!-- tboard에 있는 comments를 bcomment에 저장	 -->
			<tr>
				<td style="text-align:left;margin:5px;border-bottom: solid 1px">
	        		<div id='commentview${ bcomment.commentNo }'>
	                    ${ bcomment.writer } &nbsp;&nbsp;
	                    [ ${ bcomment.regDate } ]
	                    <br /><br />
	                    <span>
							${ fn:replace(bcomment.content, newLine, "<br>") }
	                    </span>
	                    <br /><br />
	                    <div style='display: ${ loginuser.memberId eq bcomment.writer ? "block" : "none" }'>
	                    	<a id="edit" style="font-size:10pt;" data-commentno='${ bcomment.commentNo }' href="#">편집</a>
	                    	&nbsp;
	                    	<a id="deletecomment" style="font-size:10pt;" href="#" data-commentno='${ bcomment.commentNo }'
														   data-boardno='${ tboard.boardNo }'
													       data-pageno='${ pageno }'>삭제</a>
	                    </div>
	                </div>
	                <div id='commentedit${ bcomment.commentNo }' style="display: none">
						${ bcomment.writer }&nbsp;&nbsp; 
						[${ bcomment.regDate }] 
						<br /><br />
						<form id="commenteditform${ bcomment.commentNo }" 
							action="tbupdatecomment.action" method="post">
						<input type="hidden" name="boardno" value="${ tboard.boardNo }" />
						<input type="hidden" name="pageno" value='${ pageno }' />
						<input type="hidden" name="commentno" value="${ bcomment.commentNo }" />
						<textarea name="content" style="width: 580px" rows="3" maxlength="200">${ bcomment.content }</textarea>
						</form>
						<br />
						<div>
							<a id="modify" data-commentno='${ bcomment.commentNo }' href="#">수정</a> 
							&nbsp; 
							<a id="cancel" data-commentno='${ bcomment.commentNo }' href="#">취소</a>
						</div>
					</div>
		
					</td>
	        	</tr>
	        	</c:forEach>						
	        </table>
		</c:otherwise>
		</c:choose>
		<!-- comment 표시 영역 -->
       <br /><br /><br /><br /><br /><br />
	</div>
	</div>
<jsp:include page="/WEB-INF/views/include/function.jsp" />
</body>
</html>