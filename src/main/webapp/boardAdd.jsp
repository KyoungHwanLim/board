<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
		$(function(){
			$('#check').on('click',function(){
				$('form').submit();
			})
			
		})
		
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/boardInsert" method="post" enctype="multipart/form-data">
		<br>
		<input type="hidden" name="tBoard" value="${tBoard}">
		<input type="hidden" name="board_group_seq" value="${param.board_group_seq }">
		<input type="hidden" name="pboard_seq" value="${param.pboard_seq }">

		<select>
			<c:forEach items="${bpList }" var="list">
				<c:choose>
				    <c:when test="${list.bp_seq eq tBoard}">
						<option value="${list.bp_seq }" selected="selected">${list.bp_title }</option>
				    </c:when>
				    <c:otherwise>
						<option value="${list.bp_seq }">${list.bp_title }</option>
				    </c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br>
		<br>
		<input type="text" placeholder="제목을 입력하세요" name="board_title"> <br>
		<textarea name="board_content" rows="10" cols="30" placeholder="내용을 입력하세요"></textarea><br>
		<input type="file" name="file_path" class="file"><br>
		
		<input type="button" value="확인" id="check">&nbsp;&nbsp;
		<input type="button" value="취소" id="cancel">
	</form>
</body>
</html>