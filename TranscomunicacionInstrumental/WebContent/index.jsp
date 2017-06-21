<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-ES">
<head>
<meta charset="UTF-8">
<meta name="author" content="Adrián Aguilar">
<title>Transcomunicación Instrumental</title>
<link type="text/css" rel="stylesheet" href="css/styles.css"/>
<link href='https://fonts.googleapis.com/css?family=Creepster' rel='stylesheet'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/scripts.js"></script>
</head>
<body>
	<div id="fondo">
	  <div id="volver-button">
	    <button id='volver'>VOLVER</button>
	  </div>
	  <div id="pergamino-index">
	  </div>
		<div id="video">
			<video autoplay loop>
			  <source src="HorrorVideo.mp4" type="video/mp4">
			</video>
		</div>
		<div id="form">
		  <fieldset>
		  <legend>Transcomunicación Instrumental</legend>
		  <p class="p-inline">Seleccione el número de líneas que contendrá la portadora</p>
		  <select id="lineas-select" name="nLineas" required>
		    <option selected disabled>-- Nº Líneas --</option>
			  <%
			    for (int i=1; i<= 150; i++) {
			    	out.println("<option>"+i+"</option>");
			    }
			  %>
		  </select>
		  <p>Seleccione la frecuencia de espacios, saltos de línea y signos de puntuación</p>
		  <select id="frecuencia-select" name="frecuencia">
			  <optgroup label="Espacios -- Saltos -- Signos -- Caracteres">
				  <option value="0">10% 10% 10% 70%</option>
				  <option value="1">20% 20% 20% 40%</option>
				  <option value="2">25% 25% 25% 25%</option>
			    <option value="3" selected>Estándar (recomendado)</option>
			  </optgroup>
		  </select>
		  <div class="footer-form">
			  <input id="letras-input" type="radio" name="opcion" value="letras" required>
			  <label for="letras-input">Sólo letras</label><br>
			  <input id="letrasNumeros-input" type="radio" name="opcion" value="letrasNumeros">
			  <label for="letrasNumeros-input">Letras y números</label>
		  </div>
		  <div class="button-form">
		    <button id="generaPortadora">GENERAR PORTADORA</button>
		  </div>
		  <input id="ruta1" type="text" name="ruta1" placeholder="Ruta de la portadora; C:\Users\Pepe\Desktop\  (la barra '\' o '/' del final es importante)" required>
		  <input id="ruta2" type="text" name="ruta2" placeholder="Ruta del diccionario; C:\Users\Pepe\Desktop\  (la barra '\' o '/' del final es importante)" required>
		  <p>Los espíritus no conocen a la perfección la lengua española, por lo tanto, al
		    comunicarse con nosotros, las palabras que utilicen no llevarán tildes.</p>
		  <div id="resultado">
		  </div>
		  </fieldset>
		 </div>
	 </div>
</body>
</html>
