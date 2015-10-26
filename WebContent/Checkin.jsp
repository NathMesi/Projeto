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

</head>
<body>
<%
PassagemModel passagem = (PassagemModel)request.getAttribute("passagem");
%>

<h2>Check-in</h2>

<hr/>

<form method="post" action="PassagemServlet">

<div class="col-md-8">
<input type="text" name="id" placeholder="Número do bilhete" class="form-control col-md-6" value="<% out.println(passagem.getIdPasagem()); %>">
<input type="text" name="idVoo" placeholder="Número do bilhete" class="form-control col-md-6" value="<% out.println(passagem.getIdVoo()); %>">
<input type="text" name="email" placeholder="Número do bilhete" class="form-control col-md-6" value="<% out.println(passagem.getEmail()); %>">
<input type="text" name="celular" placeholder="Número do bilhete" class="form-control col-md-6" value="<% out.println(passagem.getCelular()); %>">
<input type="text" name="fileira" placeholder="Fileira" class="form-control col-md-6">
<input type="text" name="coluna" placeholder="Coluna" class="form-control col-md-6">
</div>

<br/>
<br/>
<br/>

<div class="col-md-8">
<input type="submit" class="btn btn-success">
</div>

</div>

<input type="hidden" value="checkin" name="url"> 
</form>

	${msg}

</body>
</html>