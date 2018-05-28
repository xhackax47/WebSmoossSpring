<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Evenements</title>
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/event.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.9/css/all.css"
	integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
	crossorigin="anonymous">
</head>
<body>
	<form method="POST" action="EventController">
		<div class="container-fluid img-title-description-event-block">
			<img src="data:image/png;base64,${event.picture}" id="imgParty"
				alt="Image de votre évènement">
			<div class="title-description-event">
				<jsp:useBean id="event" class="com.aplose.smooss.model.Event"
					scope="request" />
				<h2>${event.name}</h2>
				<p>${event.description}</p>
			</div>
		</div>
		<div class="container">
			<div class="row justify-content-center mt-4">
				<!-- <div class="col-sm-3">
	                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2889.1541762818792!2d3.9077731149273682!3d43.60333136367297!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12b6a57c3fa4f34d%3A0xec9311353c764d24!2sMill%C3%A9naire!5e0!3m2!1sfr!2sfr!4v1522785402462"
	                        width="200" height="200" frameborder="0" style="border:0; border-radius:8px;" allowfullscreen></iframe>
	                </div> -->
				<div class="event-info">
					<div class="">Adresse : ${event.localisation}</div>
					<div class="start-date-time-event">Début : ${event.start}</div>
					<div class="end-date-time-event">Fin : ${event.end}</div>
					<hr>
				</div>
			</div>
			<!-- <div class="row justify-content-center mt-4">
					<input type="submit" class="btn btn-info" name="submitButton" id="submitButton" value="Créer mon Smooss">
	            </div> -->
	</form>
	<div class="row justify-content-around mt-5 color_text"
		id="module_block">
		<c:forEach var="module" items="${modules}">
			<div class="hexagon_module">
				<a href="#"> <i class="${module.iJspClass} fa-5x center_icon_test"></i></a>
			</div>
		</c:forEach>
	</div>

	<!-- 	<div class="hexagon_module">
			<a href="#"> <i class="fas fa-music fa-5x center_icon_test"></i>
			</a>
		</div>
		<div class="hexagon_module">
			<a href="#"> <i class="fas fa-dollar-sign fa-5x center_icon_test"></i>
			</a>
		</div>
		<div class="hexagon_module">
			<a href="#"> <i
				class="fas fa-camera-retro fa-5x center_icon_test"></i>
			</a>
		</div>
		<div class="hexagon_module">
			<a href="#"> <i class="fas fa-comments fa-5x center_icon_test"></i>
			</a>
		</div>
		<div class="hexagon_module">
			<a href="#"> <i class="fas fa-gamepad fa-5x center_icon_test"></i>
			</a>
		</div>
		<div class="hexagon_module">
			<a href="#"> <i class="fas fa-car fa-5x center_icon_test"></i>
			</a>
		</div>
		<div class="hexagon_module">
			<a href="#"> <i
				class="fas fa-people-carry fa-5x center_icon_test"></i>
			</a>
		</div> -->

	<div class="row justify-content-center mt-5">

		<form action="/DeleteEvent" method="post">
			<input type="hidden" name="idEvent" value="${event.id}"/>
			<input type="submit" name="inputDelete" id="button_redirect_home" value="Supprimer l'Event"/>
		</form>

	</div>
	<div class="row justify-content-center mt-5">
		<a href="EventController" id="button_redirect_home"> Retour à
			l'accueil </a>
	</div>
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
	<script src="resources/js/event.js"></script>

</body>
</html>

