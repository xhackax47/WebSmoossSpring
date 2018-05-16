$(document).ready(function(){
	var lengthErrorMessage = $('#error_message').text();
	
	if (lengthErrorMessage.length > 1) {
		$('#modalEventInfo').modal('show')
	}
});