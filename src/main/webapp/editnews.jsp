<%@ page import="by.itclass.constants.AppConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Edit news</title>
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
				<h2>Редактировать новость</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="main_news">
					<form method="post" action="<c:url value="<%= AppConstant.URL_REFACTOR_NEWS_CONT%>"/> " enctype="multipart/form-data">
						<input type="hidden" value="${news.id}" name="<%= AppConstant.ID_LABEL%>">
						<input type="text" value="${news.title}" name="<%= AppConstant.TITLE_LABEL%>" class="form-control" placeholder="Введите заголовок"><br>
						<textarea rows="10" name="<%= AppConstant.TEXT_LABEL%>" class="form-control" placeholder="Введите текст новости">${news.text}</textarea><br>
						<input type="file" name="<%= AppConstant.FILE_NAME_LABEL%>" class="form-control"><br>
						<input type="submit" class="btn btn-warning" value="Редактировать новость">
						<a href="<c:url value="<%= AppConstant.URL_MY_NEWS_CONT%>"/> " class="btn btn-link">Назад</a>
					</form>

				</div>
			</div>
		</div>

	</div>

	<jsp:include page="add/footer.jsp"/>


	<script src="js/bootstrap.js"></script>
	<script src="js/jquery-3.6.0.js"></script>
</body>
</html>