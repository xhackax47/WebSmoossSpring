<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="resources/css/gestionProfil.css">
<title>Gestion du profil</title>
</head>
<body>
	<div class="container-fluid">

		<div class="row" id="disconnect_button">
			<%@ include file="disconnect_button.jsp"%>
		</div>

		<div class="row justify-content-center text-center">
			<h4 class="text-center">&#149; Gestion du profil &#149;</h4>
			<%-- <a class="clip-each clip-gradient" href="<spring:url value="/home"/>">
				<div class="clip-caption">
					<i class="fas fa-home"></i>
				</div>
			</a> --%>
		</div>
		<form:form method="POST" modelAttribute="userProfilForm" enctype="multipart/form-data">
		<div class="row justify-content-center">
			
				<div class="col-3 col-sm-4 col-xs-4">
					<div class="form-group">
						<label for="email">Adresse mail :</label>
						<spring:bind path="email">
							<form:input type="email"
							class="form-control form-control-sm spaceInput"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Enter email" path="email" value="${user.email}"/>
							<form:errors path="email"/>
						</spring:bind>
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="email">Mot de passe :</label>
						<spring:bind path="password">
							<form:input type="password"
							class="form-control form-control-sm spaceInput"
							placeholder="Mot de passe" path="password"
							value="${userProfilForm.password}"/>
							<form:errors path="password"/>
						</spring:bind>
						
						<label for="email">Confirmation mot de passe :</label>
						<spring:bind path="passwordConf">
							<form:input type="password" class="form-control form-control-sm spaceInput"
							placeholder="Confirmation mot de passe" path="passwordConf"
							value="${userProfilForm.password}" />
							<form:errors path="passwordConf"/>
						</spring:bind>
					</div>

					<button type="submit" class="btn btn-warning btnFullCol"
						style="color: #fff; background-color: #FFC107;">Save</button>
				</div>

				<div class="col-3 col-sm-4 col-xs-4">
						<div class="spaceInput">
						<spring:bind path="fileData">
							<c:choose>
								<c:when test="${user.picture == NULL}" >
									<img class="default-img-profile" src="resources/img/defaultIcon.png"
										alt="Card image cap">
								</c:when>
								<c:otherwise>
									<img class="default-img-profile" src="data:image/png;base64,${user.picture}"
										alt="Card image cap">
								</c:otherwise>
							</c:choose>
							
							
								<form:input type="file" path="fileData"/><br>
								<form:errors path="fileData"/>	
							</spring:bind>
						</div>
				</div>
				
				<div class="col-3 col-sm-4 col-xs-4">
					<label for="email">Prénom :</label>
					<spring:bind path="firstName">
						<form:input class="form-control form-control-sm spaceInput" type="text"
						placeholder="Nom" path="firstName" value="${user.firstName}" />
						<form:errors />
					</spring:bind>
					<label for="email">Nom :</label>
					<spring:bind path="lastName">
						<form:input class="form-control form-control-sm spaceInput" type="text"
						placeholder="Prénon" path="lastName" value="${user.lastName}" />
						<form:errors path="lastName"/>
					</spring:bind>
					<label for="email">Pseudo :</label>
					<spring:bind path="nickName">
						<form:input class="form-control form-control-sm spaceInput" type="text"
						placeholder="Pseudo" path="nickName" value="${user.nickName}" />
						<form:errors path="nickName" />
					</spring:bind>
				</div>
			
		</div>
		</form:form>
	</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script src="resources/js/fontawesome-all.min.js"></script>
</body>
</html>