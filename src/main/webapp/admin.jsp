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
		$('#del').on("click", function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/tBoardDelete');
			$('#tBoard').val($('#selectdel option:selected').val())
			$('#frm').submit();
		})
		
		$('#up').on("click", function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/tBoardUpdate');
			$('#tBoard').val($('#selectup option:selected').val())
			$('#frm').submit();
		})
		$('#add').on("click", function(){
			$('#frm').attr('action','${pageContext.request.contextPath }/tBoardInsert');
			$('#frm').submit();
		})
	})

</script>


</head>
<body>
	<h1>게시판관리페이지</h1>
	<form id="frm">
		<select id="selectdel">
				<c:forEach items="${bpList }" var="list">
			    <c:if test="${list.del_yn eq 'n'}">
					<c:choose>
					    <c:when test="${list.bp_seq eq tBoard}">
							<option value="${list.bp_seq }" selected="selected">${list.bp_title }</option>
					    </c:when>
					    <c:otherwise>
							<option value="${list.bp_seq }">${list.bp_title }</option>
					    </c:otherwise>
					</c:choose>
			    </c:if>
			</c:forEach>
		</select>
		<input type="button" value="선택된 게시판 삭제" id="del"><br>
		<select id="selectup">
				<c:forEach items="${bpList }" var="list">
			    <c:if test="${list.del_yn eq 'y'}">
					<c:choose>
					    <c:when test="${list.bp_seq eq tBoard}">
							<option value="${list.bp_seq }" selected="selected">${list.bp_title }</option>
					    </c:when>
					    <c:otherwise>
							<option value="${list.bp_seq }">${list.bp_title }</option>
					    </c:otherwise>
					</c:choose>
			    </c:if>
			</c:forEach>
		</select>
		<input type="button" value="선택된 게시판 활성화" id="up"><br>
		<input type="hidden" id="tBoard" name="tBoard">
		<br><input type="text" name="name"><input type="button" value="게시판 추가" id="add" >
	</form>
</body>
</html>