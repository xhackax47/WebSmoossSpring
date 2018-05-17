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
	<link rel="stylesheet" href="resources/css/registrationLogin.css"/>
</head>
<body>
	<div class="container formRegistrationSignIn">
		<form:form method="POST" modelAttribute="userForm">
			<h1 class="text-center">Inscription</h1>
			<div class="form-group">
				<spring:bind path="lastName">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-user"></i>
							</div>
						</div>	
						<form:input type="text" class="form-control input_modal"
								path="lastName" placeholder="Nom"/>
					</div>
					<form:errors cssClass="errors" path="lastName"/>
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:bind path="firstName">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-user"></i>
							</div>
						</div>
						<form:input type="text" class="form-control input_modal"
							path="firstName" placeholder="Prénom"/>
					</div>
					<form:errors cssClass="errors" path="firstName"/>
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:bind path="nickName">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-user"></i>
							</div>
						</div>
						<form:input type="text" class="form-control input_modal"
							path="nickName" placeholder="Pseudo"/>
					</div>	
					<form:errors cssClass="errors" path="nickName"/>
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:bind path="email">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-at"></i>
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
				</spring:bind>
			</div>
			<div class="form-group">
				<spring:bind path="passwordConf">	
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fas fa-lock"></i>
							</div>
						</div>
						<form:input type="password" class="form-control input_modal"
							path="passwordConf" placeholder="Confirmation mot de passe"/>
					</div>
					<form:errors cssClass="errors" path="passwordConf"/>
				</spring:bind>				
			</div>
			<div class="form-group" style="text-align: center;">
				<spring:bind path="checkBoxCGU">
					<form:checkbox id="checkBoxCGU" value="on" path="checkBoxCGU" />
					<form:errors path="checkBoxCGU"/>
				</spring:bind>
				<a href="cgu.view" style="padding: 10px;">J'ai lu et j'accepte
					les Conditions Générales d'Utilisation</a>
			</div>
			<button type="submit" class="btn btn-primary button-submit">S'inscrire</button>

		</form:form>
	</div>
	<!-- Import js lib : jquery & bootstrap -->
	<script src='<spring:url value="resources/js/jquery.js"/>'></script>
	<script
		src='<spring:url value="resources/js/bootstrap/bootstrap.min.js"/>'></script>
</body>
</html>