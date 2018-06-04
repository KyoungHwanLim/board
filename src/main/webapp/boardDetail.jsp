<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		
		
		$('#addcomments').on('click',function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/addComment');
			$('#frm').submit();
		})
		$('#modify').on('click',function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/boardModify');
			$('#frm').attr('method','post');
			$('#frm').submit();
		})
		$('#delete').on('click',function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/boardDelete');
			$('#frm').submit();
		})
		$('#addReply').on('click',function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/boardAdd');
			$('#frm').submit();
		})
	})
</script>

<c:choose>
	<c:when test="${vo.board_group_seq==null||vo.board_group_seq==''}">
		<c:set var="board_group_seq" value="1"/>
	</c:when>
	<c:otherwise>
		<c:set var="board_group_seq" value="${vo.board_group_seq+1}"/>
	</c:otherwise>
</c:choose>
			

<body>
		<form id="frm">
			<input type="hidden" name="tBoard" value="${tBoard }">
			<input type="hidden" name="board_group_seq" value="${board_group_seq}">
			<input type="hidden" name="board_seq" value="${vo.board_seq }">
			<input type="hidden" name="pboard_seq" value="${vo.board_seq }">
			제목 : ${vo.board_title }<br>
			<c:forEach var="filename" items="${list}">
				<a href='${pageContext.request.contextPath}/boardFileDown?filename=${filename}'>첨부파일</a>
			</c:forEach><br>
			내용 : ${vo.board_content }<br>
			작성자 : ${vo.board_mem_id }<br>
			작성일시 : ${vo.board_reg_dt }<br>
			<input type="text" name="comments">
			<input type="button" value="댓글작성" id="addcomments">
			
			<c:if test="${vo.board_mem_id eq sessionId}">
				<input type="button" value="수정" id="modify">
				<input type="button" value="삭제" id="delete">
			</c:if>
			<input type="button" value="답글" id="addReply">
		</form><br><br>
			<c:forEach var="comments" items="${commentsList}">
				댓글번호 : ${comments.cmt_seq}
				작성자 : ${comments.cmt_mem_id }
				내용 : ${cmt_content }
				작성일시 : ${cmt_reg_dt }
				<br>
			</c:forEach><br>
</body>
</html>