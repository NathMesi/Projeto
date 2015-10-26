<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>

	
</script>

</head>
<body>
<h2>Buscar Passagem</h2>

<hr/>


<form method="get" action="PassagemServlet">

<div class="col-md-4">
<input type="text" name="numero" placeholder="Número do bilhete" class="form-control col-md-12">
</div>

<input type="submit" class="btn btn-success">

</div>

<input type="hidden" value="buscarPassagem" name="url"> 
</form>

	${msg}

</body>
</html>