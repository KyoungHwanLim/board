<%@page import="java.util.List"%>
<%@page import="board.model.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>


	$(function(){
		
	
		
		
		$('#select').on("change", function(){
			tBoard=$('#select option:selected').val();
			$('#tBoard').val(tBoard);
			$("#tBoardFrm").submit();
		})
		
		$('#addBoard').on('click',function(){
			alert($('#select option:selected').val());
			$("#tBoard_add").val($('#select option:selected').val());
			$('#addBoardFrm').submit();
		})
		
		$('.trr').on('click', function(){
			$("#board_seq").val($(this).attr("board_seq"));
			$("#tBoard_tr").val($('#select option:selected').val());
			$("#detailFrm").submit();
		})
		
		
	})

</script>


<style>
	table{
		border:1px solid black;
	}
	table tr{
		border:1px solid black;
	}
	
	
</style>



</head>
<body>
	<form action="${pageContext.request.contextPath }/boardList" id="tBoardFrm" method="post">
		<input type="hidden" name="tBoard" id="tBoard"> 
		<select id="select">
		

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
	</form>
	
	<form action="${pageContext.request.contextPath }/boardDetail" id="detailFrm" method="post">
		<input type="hidden" name="board_seq" id="board_seq">
		<input type="hidden" name="tBoard" id="tBoard_tr"> 
		<table>
			
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자 아이디</th>
				<th>작성일시</th>
			</tr>
				
				
				
				<c:forEach var="vo" items="${boardList}" >
					<c:choose>
					    <c:when test="${vo.board_del_yn eq 'n'}">
							<tr class="trr" board_seq="${vo.board_seq}">
								<td>${vo.rn }</td>
								<td><c:if test="${vo.board_group_seq!=null}"></c:if><c:forEach var="i" begin="0" end="${vo.board_group_seq}">&nbsp;&nbsp;</c:forEach>${vo.board_title }</td>
								<td>${vo.board_mem_id }</td>
								<td>${vo.board_reg_dt }</td>
							</tr>
					    </c:when>
					    <c:otherwise>
							<tr><td>삭제된 게시글입니다</td></tr>
					    </c:otherwise>
					</c:choose>
				
				</c:forEach>
				
				
				
				
				
		</table>
	</form>
		${pageNav }
		
	<form action="${pageContext.request.contextPath }/boardAdd" id="addBoardFrm">
		<input type="hidden" name="tBoard" id="tBoard_add"> 
		<input type="button" id="addBoard" value="게시글 등록">
	</form>
	
	
	
</body>
</html>