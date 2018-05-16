<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<link rel="stylesheet" href="resources/css/disconnect_button.css">
<div id="volet_clos">
    <div id="volet">
        <p>
            <a id="disconnect" href="/logout">Disconnect</a>
            ${user.firstName}
        </p>
        <a href="#volet" class="ouvrir" aria-hidden="true">
            <i class="fas fa-power-off"></i>
        </a>
        <a href="#volet_clos" class="fermer" aria-hidden="true">
            <i class="fas fa-power-off"></i>
        </a>
    </div>
</div>