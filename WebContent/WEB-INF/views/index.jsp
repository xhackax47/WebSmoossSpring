<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Smooss</title>
		<link rel="stylesheet" href='<spring:url value="resources/css/bootstrap/bootstrap.min.css"/>' />
		<link rel="stylesheet" href='<spring:url value="resources/css/style.css"/>' />
	</head>
	<body>
	
		<!-- Simple nav -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
			id="navbar_index">
			<a class="navbar-brand" href="index.jsp" id="logo_home">Smooss</a>
			<p style="color: white;">${param.message}</p>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarNavAltMarkup">
				<div class="navbar-nav mr-5 link_style">
					<a class="nav-item nav-link" href="<spring:url value="/login"/>">Connexion</a> 
					<a class="nav-item nav-link" href="<spring:url value="/registration"/>">Inscription</a>
				</div>
			</div>
		</nav>

		<!-- MODAL CONNEXION -->
		<div class="modal fade" id="modalConnexion" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Connexion</h5>
					</div>
					
				</div>
			</div>
		</div>
	
		<!-- Container with carousel -->
		<div class="container-fluid" id="carousel_container_index">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100 h-100" src="resources/img/second.jpg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100 h-100" src="resources/img/second.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100 h-100" src="resources/img/second.jpg"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	
		<!-- Footer div -->
	
		<footer id="footer_bottom_index">
			<div class="container-fluid">
				<div class="row justify-content-around">
					<div class="footer_bottom_index_div">
						<h6>Smooss</h6>
						<a href="#">A propos</a> <a href="#">Aide</a> <a href="#">Qui
							sommes nous ?</a>
					</div>
					<div class="footer_bottom_index_div">
						<h6>Feedback</h6>
						<a href="#">Nous contacter</a> <a href="#">Envoyez nous vos
							idées</a> <a href="#">Nous aider ?</a>
					</div>
					<div class="footer_bottom_index_div">
						<h6>Règles</h6>
							confidentialité</a> <a href="#">...</a>
					</div>
				</div>
			</div>
		</footer>
	
		<!-- Import js lib : jquery & bootstrap -->
		<script src='<spring:url value="resources/js/jquery.js"/>'></script>
		<script src='<spring:url value="resources/js/bootstrap/bootstrap.min.js"/>'></script>
	</body>
</html>