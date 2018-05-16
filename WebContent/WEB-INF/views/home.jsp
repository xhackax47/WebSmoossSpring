<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>SMOOSS</title>
<link rel="stylesheet" href="resources/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/main_style.css">
<link rel="stylesheet" href="resources/css/home_user.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
</head>

<body>
	<div class="container-fluid">
		<div class="row" id="disconnect_button">
			<!-- Include for the html of the disconnect_button -->
			<%@ include file="disconnect_button.jsp"%>
		</div>

		<div class="row justify-content-center" id="title">
			<h1>&#149; SMOOSS &#149;</h1>
			<h6>Bienvenue sur Smooss</h6>
		</div>

		<div class="row justify-content-center" id="middle_blocks">
			<div class="clip-block">
				<a data-toggle="modal" data-target="#modalEventInfo">
					<div class="clip-each clip-solid">
						<div class="clip-caption">
							<i class="fal fa-4x fa-calendar-alt"></i>
						</div>
						<div class="social-share-block">
							<span class="social-each"></span> <span> <i
								class="fas fa-plus"></i>
							</span>
						</div>
					</div>
				</a>
			</div>
			<div class="clip-block">
				<a href="<spring:url value="/profile"/>" class="clip-each clip-gradient">
					<div class="clip-caption">
						<i class="fas fa-3x fa-user"></i>
					</div>
				</a>
			</div>
			<div class="clip-block">
				<a href="mesInvitations.php">
					<div class="clip-each clip-solid">
						<div class="clip-caption">
							<i class="fas fa-5x fa-envelope" style="color: #fff;"></i>
						</div>
						<div class="social-share-block">
							<span class="social-each"> <strong>4</strong>
							</span> <span> <i class="fas fa-envelope"></i>
							</span>
						</div>
					</div>
				</a>
			</div>
		</div>
		<div class="row justify-content-center" id="div_event_list">
			<table>
				<caption class="text-center">Ma liste d'évènements</caption>
				<tbody id="body_event_list">
					<c:forEach var="event" items="${events}">
						<tr class="block_event_list">
							<td class="title_td" id="title"><a
								href="EventController?idEvent=${event.id}">${event.name}</a></td>
							<td class="description_td" id="description">${event.description}</td>
							<td class="date_td" id="date">${event.start}</td>
							<td id="map"><a target="_blank"
								href="https://www.google.com/maps/place/${event.localisation}">Voir
									sur Maps</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<svg class="clip-svg">
                <defs>
                    <clipPath id="hexagon-clip"
				clipPathUnits="objectBoundingBox">
                        <polygon
				points="0.25 0.05, 0.75 0.05, 1 0.5, 0.75 0.95, 0.25 0.95, 0 0.5" />
                    </clipPath>
                </defs>
            </svg>

		<svg class="clip-svg">
                <defs>
                    <clipPath id="triangle-clip"
				clipPathUnits="objectBoundingBox">
                        <polygon points="1 0.03, 0.17 1, 1 1" />
                    </clipPath>
                </defs>
            </svg>
	</div>

	<div class="modal fade" id="modalInformationEvent" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header" id="div_modal_title">
					<h5 class="modal-title" id="modal_title_event"></h5>
				</div>
				<div class="modal-body" id="block_body_event">
					<div id="modal_map_event"></div>
					<div class="block_description_date_event">
						<div id="modal_description_event"></div>
						<div id="modal_date_event"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalEventInfo" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header justify-content-center">
					<h5 class="modal-title" id="exampleModalLabel"
						style="color: black;">Nouvel évènement</h5>
				</div>
				<form:form method="POST" modelAttribute="eventForm">
					<div class="modal-body">
<%-- 						<div class="form-group">
							<label for="pictureEvent" style="color: black;">Choisir
								une image :</label>
							<spring:bind path="pictureEvent">
								<form:input type="file" class="form-control input_modal"
									path="pictureEvent" accept="image/*"></form:input>
								<form:errors path="pictureEvent"></form:errors>
							</spring:bind>
						</div> --%>
						<div class="form-group">
							<label for="name">Nom :</label>
							<spring:bind path="name">
								<form:input type="text" class="form-control input_modal"
									path="name" placeholder="Nom"/>
								<form:errors path="name"/>
							</spring:bind>
						</div>
						<div class="form-group">
							<label for="description">Description :</label>
							<spring:bind path="description">
								<form:textarea maxlength="280" style="resize: none;"
								class="input-event form-control" rows="4" cols="50" path="description" placeholder="Description"/>
								<form:errors path="description"></form:errors>
							</spring:bind>
						</div>
						<div class="form-group">
							<label for="localisation"> Adresse :</label>
							<spring:bind path="localisation">
								<form:input type="text"
								class="form-control" path="localisation" id="adresse"
								placeholder="Adresse"/>
								<form:errors path="localisation"/>
							</spring:bind>
						</div>
						<div class="form-inline">
							<label for="startDateEvent">Jour / heure début :</label>
							<spring:bind path="startDateEvent">
								<form:input type="date" class="form-control mb-2 mr-sm-2 mb-sm-0"
								path="startDateEvent" id="startDateEvent"/>
								<form:errors path="startDateEvent"/>
							</spring:bind>
							<spring:bind path="startTimeEvent">
								<form:input type="time" class="form-control mb-2 mr-sm-2 mb-sm-0"
								path="startTimeEvent" id="startDateEvent"/>
								<form:errors path="startDateEvent"/>
							</spring:bind>
						</div>
						<div class="form-inline">
							<label for="endDateEvent">Jour / heure fin : </label>
							<spring:bind path="endDateEvent">
								<form:input type="date" class="form-control mb-2 mr-sm-2 mb-sm-0"
								path="endDateEvent" id="startDateEvent"/>
								<form:errors path="endDateEvent"/>
							</spring:bind>
							<spring:bind path="endTimeEvent">
								<form:input type="time" class="form-control mb-2 mr-sm-2 mb-sm-0"
								path="endTimeEvent" id="startDateEvent"/>
								<form:errors path="endTimeEvent"/>
							</spring:bind>
						</div>
						<!-- <h5 style="color: black">Selectionner vos modules pour votre
							évènement:</h5>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="PlaylistModule" name="PlaylistModule" value="checked">
							<label class="form-check-label" for="PlaylistModule">PlayList</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="TriCountModule" name="TriCountModule" value="checked">
							<label class="form-check-label" for="TriCountModule">Gestion
								des dépenses</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="PicturesModule" name="PicturesModule" value="checked">
							<label class="form-check-label" for="PicturesModule">Photos</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="ChatModule"
								name="ChatModule" value="checked"> <label
								class="form-check-label" for="ChatModule">Chat</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="MiniGameModule" name="MiniGameModule" value="checked">
							<label class="form-check-label" for="MiniGameModule">Mini-jeux</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="CarpoolingModule" name="CarpoolingModule" value="checked">
							<label class="form-check-label" for="CarpoolingModule">Covoiturage</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="BringModule"
								name="BringModule" value="checked"> <label
								class="form-check-label" for="BringModule">Liste de
								courses</label>
						</div>-->
					</div> 
					<div class="modal-footer justify-content-center"
						style="flex-direction: column;">
						<button type="submit" name="inputSubmit"
							class="btn btn-success button_submit_modal"
							id="button_submit_connexion_modal">Créer un évènement</button>
						<p>
							<span style="color: red;" id="error_message">${param.message}</span>
						</p>
					</div>
				</form:form>
			</div>
		</div>
	</div>


	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="resources/js/fontawesome-all.min.js"></script>
	<script src="resources/js/home.js"></script>
</body>
</html>