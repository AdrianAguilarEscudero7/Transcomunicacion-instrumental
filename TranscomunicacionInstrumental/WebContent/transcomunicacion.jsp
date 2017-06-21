<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html lang="es-ES">
<head>
<meta charset="UTF-8">
<title>Transcomunicación Instrumental</title>
<link type="text/css" rel="stylesheet" href="css/styles.css"/>
<link href='https://fonts.googleapis.com/css?family=Creepster' rel='stylesheet'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/scripts.js"></script>
</head>
<body>
  <div id="general-container">
		<div id="pergamino-container">
		  <img id="pergamino" src="pergamino.jpg" alt="pergamino">
		</div>
		<div id="pergamino-sheet">
	    <%
		    try {
		    	String ruta1 = "";
		    	String ruta2 = "";
		    	String rutaPortadora = (String)session.getAttribute("ruta1"); 
		    	String rutaDiccionario = (String)session.getAttribute("ruta2");
		    	if (rutaPortadora != null && rutaDiccionario != null) {
		    		ruta1 = rutaPortadora;
		    		ruta2 = rutaDiccionario+"spanish.lst";
		    	}
		    	
		      BufferedReader br = new BufferedReader(new FileReader(ruta1));
		      BufferedReader br2 = new BufferedReader(new FileReader(ruta2));
		      ArrayList<String> al = new ArrayList<String>();
		      ArrayList<Integer> distMedia = new ArrayList<Integer>();
		      ArrayList<String> palabrasEncontradas = new ArrayList<String>();
		      
		      String linea = "";
		      String linea2 = "";
		      String palabra;
		      int i;
		      int contador = 0;
		      boolean salir;
		      
		      while (linea2 != null) {
		        linea2 = br2.readLine();
		        al.add(linea2);
		      }
		      br2.close();
		      
		      while (linea != null) {
		        linea = br.readLine();
		        i = 0;
		        out.print("<p class='preformateado'>");
		        if (linea != null) {
		          while (i < linea.length()) {
		            salir = false;
		            palabra = "";
		            while (linea.charAt(i) != ' ' && !salir) {
		              palabra += linea.charAt(i);
		              if (i < linea.length()-1) {
		                i++;
		              } else {
		                salir = true;
		              }
		            }
		            i++;
		            contador++;
		            salir = false;
		            for (int j=0; j < al.size() && !salir; j++) {
		              if (palabra.equals(al.get(j))) {
		              	out.print("<span class='palabra-encontrada'>"+palabra+"</span>"+" ");
		                palabrasEncontradas.add(palabra);
		                distMedia.add(contador);
		                contador = 0;
		                salir = true;
		              }
		            }
		            if (!salir) {
		              out.print(palabra+" ");
		            }
		          }
		        }
		        out.print("</p>");
		      }
		      int sumaDigitos = 0;
		      int media = 0;
		      for (int distancia : distMedia) {
		        sumaDigitos += distancia;
		      }
		      if (distMedia.size() != 0) {
		        media = sumaDigitos / distMedia.size();
		      }
		      br.close();
		      
		      out.print("<div id='estadisticas'>");
		      out.print("<span class='estadisticas'>Palabras encontradas: </span><span class='estadisticas-result'>"+palabrasEncontradas.size()+"</span>");
		      out.print("<br>");
		      out.print("<span class='estadisticas'>Distancia media entre palabras: </span><span class='estadisticas-result'>"+ media+"</span>");
		      out.print("<br>");
		      out.print("</div>");
		    } catch (IOException e) {
		      out.print("<p class='p-exception'>No se pudo leer el diccionario, o generar el archivo</p>");
		    }
	    %>
	  </div>
  </div>
</body>
</html>