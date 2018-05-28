<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
<link rel="stylesheet"
	href='<spring:url value="resources/css/bootstrap/bootstrap.min.css"/>' />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css"/>
	<link rel="stylesheet" href="resources/css/registrationLogin.css"/>
</head>
<body>
	<div class="container formRegistrationSignIn">
		<form:form method="POST" modelAttribute="loginForm">
			<h1 class="text-center">Connexion</h1>
			<div class="form-group">
				<spring:bind path="email">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-user"></i>
							</div>
						</div>
						<form:input type="email" class="form-control input_modal"
							path="email" placeholder="Adresse mail"/>
					</div>
					<form:errors cssClass="errors" path="email"/>
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:bind path="password">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-lock"></i>
							</div>
						</div>
						<form:input type="password" class="form-control input_modal"
							path="password" placeholder="Mot de passe"/>
					</div>
					<form:errors cssClass="errors" path="password"/>
					<span class="errors">${globalError}</span>
				</spring:bind>
			</div>
			<button type="submit" class="btn btn-primary button-submit">Connexion !</button>
		</form:form>
	</div>

</body>
</html>