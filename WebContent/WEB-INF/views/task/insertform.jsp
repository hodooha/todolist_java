<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js">
	
</script>
<script type="text/javascript">
	$(function() {

		$.ajax({

			url : "${pageContext.request.contextPath}/task/list",
			success : function(data) {
				console.log(data);

			},
			error : function() {
				alert("오류 발생!");
			}

		})

	})
</script>
</head>
<body>
	<div>
		<jsp:include page="../common/menubar.jsp" />
	</div>

	<form id="addTaskForm" action="${pageContext.request.contextPath}/task/insert" method="post" >
		<div class="container mt-5 input-group mb-3">
			<input id="task" name="task" type="text" class="form-control" placeholder="할일을 입력하세요.">
			<button class="btn btn-warning" type="submit" id="addTaskBtn">Button</button>
		</div>
	</form>

	<div id="taskListArea"></div>
</body>
</html>