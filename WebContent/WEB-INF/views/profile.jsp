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
<title>Gestion du profil</title>
</head>
<body>
	<div class="container-fluid">

		<div class="row" id="disconnect_button">
			<!-- Include for the html of the disconnect_button -->
			<%@ include file="disconnect_button.jsp"%>
		</div>

		<div class="row justify-content-center">
			<h4>&#149; Gestion du profil &#149;</h4>
			<a class="clip-each clip-gradient" href="<spring:url value="/home"/>">
				<div class="clip-caption">
					<i class="fas fa-home"></i>
				</div>
			</a>
		</div>


		<div class="container">
			<form action="profile" method="POST" enctype="multipart/form-data">
				<div class="row">
					<div class="col-sm-4">
						<div class="form-group">
							<input type="email"
								class="form-control form-control-sm spaceInput"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Enter email" name="email" value="${user.email}">
							<small id="emailHelp" class="form-text text-muted">We'll
								never share your email with anyone else.</small>
						</div>

						<div class="form-group">

							<input type="password"
								class="form-control form-control-sm spaceInput"
								placeholder="Mot de passe" name="password"
								value="${userProfilForm.password}"> <input
								type="password" class="form-control form-control-sm spaceInput"
								placeholder="Confirmation mot de passe" name="passwordConf"
								value="${userProfilForm.password}">

						</div>

						<button type="submit" class="btn btn-warning btnFullCol"
							style="color: #fff; background-color: #FFC107;"
							action="/ProfileController">Save</button>

					</div>

					<div class="col-sm-4">

						<div class="row">

							<div class="col-sm-3"></div>

							<div class="col-sm-6">

								<div class="card spaceInput">

									<img class="card-img-top img-thumbnail"
										src="data:image/png;base64,${user.picture}"
										alt="Card image cap">

									<!-- @Cynthia -->

									<input type="file" name="file" accept="image/*"><br>
									<input type="submit" value="Upload File"><br>

									<!-- @Cynthia -->

									<button type="button"
										style="color: #fff; background-color: #FFC107;"
										class="btn btn-dark btnFullCol">Changer picture</button>

								</div>

							</div>

							<div class="col-sm-3"></div>

						</div>

					</div>

					<div class="col-sm-4">

						<input class="form-control form-control-sm spaceInput" type="text"
							placeholder="Nom" name="firstName" value="${user.firstName}">

						<input class="form-control form-control-sm spaceInput" type="text"
							placeholder="Prénon" name="lastName" value="${user.lastName}">

						<input class="form-control form-control-sm spaceInput" type="text"
							placeholder="Pseudo" name="nickName" value="${user.nickName}">

					</div>

				</div>

			</form>
		</div>

		<!-- Volet coulissant >> -->

		<div id="volet_clos">

			<div id="volet">

				<p>

					<a id="disconnect" href="">Disconnect</a>

				</p>

				<a href="#volet" class="ouvrir" aria-hidden="true"> <i
					class="fas fa-power-off"></i>

				</a> <a href="#volet_clos" class="fermer" aria-hidden="true"> <i
					class="fas fa-power-off"></i>

				</a>

			</div>

		</div>

		<!-- << Volet coulissant -->

		<svg class="clip-svg"> <defs> <clipPath id="hexagon-clip"
				clipPathUnits="objectBoundingBox"> <polygon
				points="0.25 0.05, 0.75 0.05, 1 0.5, 0.75 0.95, 0.25 0.95, 0 0.5" />

        </clipPath> </defs> </svg>

		<svg class="clip-svg"> <defs> <clipPath
				id="triangle-clip" clipPathUnits="objectBoundingBox"> <polygon
				points="1 0.03, 0.17 1, 1 1" /> </clipPath> </defs> </svg>

	</div>

	<!-- /wrap -->

	</div>

</body>
</html>