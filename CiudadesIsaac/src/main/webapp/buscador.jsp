<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<form id="fsbusqueda" method="" action="">
		<input type="search" name="busqueda" id="busqueda">
		
		<button id="btn_busqueda" type="submit">
			<i id="fa fa-search" class="fa fa-search">Buscar</i>
		</button>
	</form>
	<div id="sugerencias"></div>





</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/busqueda.js"></script>
</html>