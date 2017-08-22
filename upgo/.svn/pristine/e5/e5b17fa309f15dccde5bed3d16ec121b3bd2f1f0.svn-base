<%@page import="com.upgo.dto.BoardAttach"%>
<%@page import="com.upgo.dto.twoBoardComment"%>
<%@page import="com.upgo.dto.BoardAttach"%>
<%@page import="com.upgo.dto.Member"%>
<%@page import="com.upgo.dto.twoBoard"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<title>글쓰기</title>
<link rel="Stylesheet" href="/upgo/styles/default.css" />
<link rel="Stylesheet" href="/upgo/styles/input2.css" />
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('a#delete').on('click', function(event) {
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
			$('#commentview' + commentNo).css('display',
					edit ? 'none' : 'block');
			$('#commentedit' + commentNo).css('display',
					edit ? 'block' : 'none');
		}
		
		//댓글 등록 이벤트 처리
		$('#writecomment').on('click', function(event) {
			var content = $('textarea#comment_content').val();
			if (content.length == 0) {
				alert('댓글 내용을 입력하세요');
				$('#comment_content').focus();
			} else {
			$('#commentform').submit();
		}
			event.preventDefault();
		});

		$('a[id=edit]').on('click', function(event) {
			var commentNo = $(this).attr('data-commentno'); //사용자 정의 설정 - 
			toggleCommentStatus(commentNo, true);
			event.preventDefault();
		});

		$('a[id=deletecomment]').on(
				'click',
				function(event) {
					var commentNo = $(this).attr('data-commentno');
					var boardNo = $(this).attr('data-boardno');
					var pageNo = $(this).attr('data-pageno');
					var yes = confirm(commentNo + "번 답글을 삭제할까요?");
					if (yes) {
						location.href = 'twodeletecomment.action?commentno='
								+ commentNo + '&boardno=' + boardNo
								+ '&pageno=' + pageNo;
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
<!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>

	<div id="pageContainer">

		<jsp:include page="/WEB-INF/views/include/header.jsp" />

		<div style="padding-top: 25px; text-align: center">
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">게시판 글 내용</div>

					<table>
						<tr>
							<th>제목</th>

							<td>${ requestScope.board.title}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${ requestScope.board.writer}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${ board.regDate}</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>${ board.readCount}</td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td style="height: 200px; vertical-align: top"><c:set
									var="newline" value="" /> ${ fn:replace(board.content,newLine, "<br>") }
							</td>
						</tr>
					</table>
					<div class="buttons">
						<%Member member = (Member) session.getAttribute("loginuser");%>
						<c:if test="${ board.writer eq loginuser.memberId }">
		        
		        	[&nbsp;<a id="delete" href='#' data-boardno="${board.boardNo}">삭제</a>&nbsp;]
		        	[&nbsp;<a href='twoupdate.action?boardno=${ board.boardNo}&pageno=${pageno}'>수정</a>&nbsp;]
		        	
		        </c:if>
						[&nbsp;<a href='tworeply.action?boardno=${board.boardNo}'>답글쓰기</a>&nbsp;]
						[&nbsp;<a href='twolist.action?pageno=${pageno}'>목록보기</a>&nbsp;]
					</div>
				</div>
			</div>


			<!-- comment 쓰기 영역 -->
			<br />
			<br />


			<c:if test="${loginuser ne null}">
				<form id="commentform" action="twowritecomment.action" method="post">
					<input type="hidden" name="boardno" value="${board.boardNo }" /> <input
						type="hidden" name="pageno" value='${pageno}' />
					<table style="width: 600px; border: solid 1px; margin: 0 auto">
						<tr>
							<td style="width: 550px">
							<textarea id = "comment_content" name="content"
									style="width: 550px" rows="3"></textarea></td>
							<td style="width: 50px; vertical-align: middle"><a
								id="writecomment" href="#" style="text-decoration: none"> 댓글<br />등록
							</a></td>
						</tr>
					</table>
				</form>
			</c:if>


			<hr align="center" style="width: 600px;" />

			<c:choose>
				<c:when test="${ empty board.comments }">

					<h3 id="nodata" style="text-align: center">작성된 댓글이 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table style="width: 600px; border: solid 1px; margin: 0 auto">
					<c:forEach var="bcomment" items="${board.comments }">
						<tr>
							<td
								style="text-align: left; margin: 5px; border-bottom: solid 1px">
								<div id='commentview${bcomment.commentNo }'>
									${ bcomment.writer}
									&nbsp;&nbsp; [
									${ bcomment.regDate}
									] <br />
									<br /> <span> ${fn: replace(bcomment.content,replace,"<br>")}
									</span> <br />
									<br />
									<div
										style='display: ${loginuser.memberId eq bcomment.writer ? "block" : "none"}'>
										<a id="edit" data-commentno='${ bcomment.commentNo}'
											href="#">편집</a> &nbsp; <a id="deletecomment" href="#"
											data-commentno='${bcomment.commentNo}'
											data-boardno='${board.boardNo}'
											data-pageno='${"pageno"}'>삭제</a>
									</div>
								</div>

								<div id='commentedit${ bcomment.commentNo}'
									style="display: none">
									${bcomment.writer}&nbsp;&nbsp; 
									[${ bcomment.regDate}]
									<br />
									<br />
									<form id="commenteditform${bcomment.commentNo}"
										action="twoupdatecomment.action" method="post">
										<input type="hidden" name="boardno"
											value="${ board.boardNo}" /> <input type="hidden"
											name="pageno" value='${ "pageno"}' />
										<input type="hidden" name="commentno"
											value="${bcomment.commentNo}" />
										<textarea name="content" style="width: 600px" rows="3"
											maxlength="200">${bcomment.content}</textarea>
									</form>
									<br />
									<div>
										<a id="modify" data-commentno='${bcomment.commentNo}'
											href="#">수정</a> &nbsp; <a id="cancel"
											data-commentno='${ bcomment.commentNo}' href="#">취소</a>
									</div>
								</div>

							</td>
						</tr>
					   </c:forEach>
					</table>

				</c:otherwise>
			</c:choose>
			<!-- comment 표시 영역 -->


			<br />
			<br />
			<br />
			<br />
			<br />
			<br />

		</div>
	</div>
<a id="to-top" href="#top" class="btn btn-dark btn-lg"><i class="fa fa-chevron-up fa-fw fa-1x"></i></a>
		<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    //#to-top button appears after scrolling
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    
    
    </script>
</body>
</html>