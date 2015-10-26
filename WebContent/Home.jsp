<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<h2>Home</h2>

<hr/>

	<a href="/Projeto/AeronaveServlet?url=list" class="btn btn-default">Aeronaves</a>
	<a href="/Projeto/VooServlet?url=list" class="btn btn-default">Voos</a>
	<a href="/Projeto/PassagemServlet?url=exibeAdd" class="btn btn-default">Passagem</a>
	<a href="/Projeto/PassagemBuscar.jsp" class="btn btn-default">Checkin</a>
	<a href="/Projeto/VoosJson?url=list" class="btn btn-default">json</a>

	<input type="hidden" name="url" value="home">
</body>
</html>