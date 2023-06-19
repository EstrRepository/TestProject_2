<%@ page import="by.itclass.constants.AppConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Private room</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-utilities.css">
	<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<jsp:include page="add/menu.jsp"/>

	<div class="container" style="height: 1000px;">
		<div class="row">
			<div class="col-md-12 m_corr">
				<h2>Добро пожаловать ${user.login}</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="main_news">
					<div class="row">
						<div class="col-3">
							<img src="${'image/'.concat(user.image.name)}" class="img-fluid">
							<form method="post" action="<c:url value="<%= AppConstant.UPLOAD_IMAGE_USER_CONT %>"/>" enctype="multipart/form-data" >
								<input type="file" name="<%= AppConstant.FILE_NAME_LABEL %>" class="form-control">
								<input type="submit" class="btn btn-success" value="Загрузить">
							</form>
						</div>
						<div class="col-9">
							<h3>Личные данные:</h3><hr>
							<p>Текущая почта: ${user.email}</p>
							<form method="post" action="<c:url value="<%= AppConstant.URL_REFACTOR_USER_CONT %>"/> ">
								<input type="text" name="<%= AppConstant.LOGIN_LABEL%>" class="form-control" placeholder="Имя"><br>
								<input type="email" name="<%= AppConstant.EMAIL_LABEL %>" class="form-control" placeholder="Почта"><br>
								<input type="password" name="<%= AppConstant.PASSWORD_LABEL%>" class="form-control" placeholder="Новый пароль"><br>
								<input type="password" class="form-control" placeholder="Подтвердить новый пароль"><br>
								<input type="hidden" value="${user.id}" name="<%= AppConstant.ID_LABEL%>">
								<input type="submit" class="btn btn-success" value="Поменять">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="add/footer.jsp"/>


	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>