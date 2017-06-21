/**
 * author: Adrián Aguilar
 */

$(document).ready(function() {
	
	$("#generaPortadora").click(function() {
		var datos = {
			lineas : $("#lineas-select").val(),
			frecuencia : $("#frecuencia-select").val(),
			opcion : $("input:radio[name=opcion]:checked").val(),
			ruta1 : $("#ruta1").val(),
			ruta2 : $("#ruta2").val()
		};
		var linea = $("#lineas-select").val();
		if (linea > 22) {
			var altura = 930;
			for (i=22; i < linea; i++) {
				altura = altura + 41.5;
			}
			$("#pergamino-index").css("height", altura+"px");
		}
		
		$.post("Servlet",datos,response);
	});
	
	function response(response) {
		if (response === 'ok') {
			$("#resultado").addClass("resultado-class").text("Portadora generada correctamente.").stop().fadeOut(0.1).fadeIn(500);
			
			$("#pergamino-index").slideDown(1700).load("transcomunicacion.jsp #general-container");
			$("#volver-button").slideDown(1500);
		} else if (response === 'error') {
			$("#resultado").addClass("resultado-class").text("Hubo algún error al generar la portadora." +
					" verifique correctamente la ruta.").stop().fadeOut(0.1).fadeIn(500);
		} else {
			$("#resultado").addClass("resultado-class").text("Seleccione una opción, y seleccione el nº de líneas que desea que contenga la portadora.").stop().fadeOut(0.1).fadeIn(500);
		}
	}
	
	$("#volver").click(function() {
		$("#pergamino-index").slideUp(1700);
		$("#volver-button").slideUp(700);
	});
});