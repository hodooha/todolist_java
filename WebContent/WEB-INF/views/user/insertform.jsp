<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="../common/menubar.jsp" />
	</div>

	<div class="container">
		<h1>회원가입</h1>
		<form action="${pageContext.request.contextPath}/user/insert" method="post">
			<div class="mt-5 col-auto">
				<label class="form-label">아이디</label> <input type="text"
					class="form-control" name="id" placeholder="아이디">
			</div>

			<div class="mt-3 col-auto">
				<label for="inputPassword5" class="form-label">비밀번호</label> <input
					type="password" name="pw" class="form-control" placeholder="비밀번호">
			</div>
			<div class="mt-3 col-auto">
				<label class="form-label">이름</label> <input type="text"
					class="form-control" name="name" placeholder="이름">
			</div>
			<div class="mt-3 col-auto">
				<label class="form-label">전화번호</label> <input type="text"
					class="form-control" name="phone" placeholder="전화번호">
			</div>
			<div class="mt-3 col-auto">
				<button class="btn btn-primary" type="submit">가입하기</button>
			</div>
		</form>
	</div>


</body>
</html>