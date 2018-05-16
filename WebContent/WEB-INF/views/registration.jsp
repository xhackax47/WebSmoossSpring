<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href='<spring:url value="resources/css/bootstrap/bootstrap.min.css"/>' />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
</head>
<body>
	<div class="container">
		<form:form method="POST" modelAttribute="userForm">
			<h1>Inscription</h1>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-user"></i>
						</div>
					</div>
					<spring:bind path="lastName">
						<form:input type="text" class="form-control input_modal"
							path="lastName" placeholder="Nom"></form:input>
						<form:errors path="lastName"></form:errors>
					</spring:bind>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-user"></i>
						</div>
					</div>
					<spring:bind path="firstName">
						<form:input type="text" class="form-control input_modal"
							path="firstName" placeholder="Prénom"></form:input>
						<form:errors path="firstName"></form:errors>
					</spring:bind>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-at"></i>
						</div>
					</div>
					<spring:bind path="email">
						<form:input type="email" class="form-control input_modal"
							path="email" placeholder="Adresse mail"></form:input>
						<form:errors path="email"></form:errors>
					</spring:bind>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-user"></i>
						</div>
					</div>
					<spring:bind path="nickName">
						<form:input type="text" class="form-control input_modal"
							path="nickName" placeholder="Pseudo"></form:input>
						<form:errors path="nickName"></form:errors>
					</spring:bind>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-lock"></i>
						</div>
					</div>
					<spring:bind path="password">
						<form:input type="password" class="form-control input_modal"
							path="password" placeholder="Mot de passe"></form:input>
						<form:errors path="password"></form:errors>
					</spring:bind>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-lock"></i>
						</div>
					</div>
					<spring:bind path="passwordConf">
						<form:input type="password" class="form-control input_modal"
							path="passwordConf" placeholder="Confirmation mot de passe"></form:input>
						<form:errors path="passwordConf"></form:errors>
					</spring:bind>
				</div>
			</div>
			<div class="form-group" style="text-align: center;">
				<spring:bind path="checkBoxCGU">
					<form:checkbox id="checkBoxCGU" value="on" path="checkBoxCGU" />
					<form:errors path="checkBoxCGU"></form:errors>
				</spring:bind>
				<a href="cgu.view" style="padding: 10px;">J'ai lu et j'accepte
					les Conditions Générales d'Utilisation</a>
			</div>
			<button type="submit" class="btn button_submit_modal"
				id="button_submit_inscription_modal">Devenir un Smoosser !</button>

		</form:form>
	</div>
	<!-- Import js lib : jquery & bootstrap -->
	<script src='<spring:url value="resources/js/jquery.js"/>'></script>
	<script
		src='<spring:url value="resources/js/bootstrap/bootstrap.min.js"/>'></script>
</body>
</html>