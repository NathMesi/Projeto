<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<%
		ArrayList<AeronaveModelView> lista = (ArrayList<AeronaveModelView>) request
				.getAttribute("lista");
%>

<h2>Aeronave</h2>

<hr/>

<a href="/Projeto/AeronaveServlet?url=exibeAdd" class="btn btn-success">Adicionar</a>

</br></br></br>

<div class="col-md-10">
<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>
				ID
			</th>
			<th>
				Tipo
			</th>
			<th>
				Nome
			</th>
			<th>
				Assentos
			</th>
			<th>
				Fileira
			</th>
			<th>
				Coluna
			</th>
			<th>
				Opções
			</th>
		</tr>
		<%
		for(AeronaveModelView amv : lista){
		%>
		<tr>
			<td>
				<% out.println(""+amv.getAero().getIdAeronave()); %>
			</td>
			<td>
				<% out.println(""+amv.getTipo().getNome()); %>
			</td>
			<td>
				<% out.println(""+amv.getAero().getNome()); %>
			</td>
			<td>
				<% out.println(""+amv.getAero().getQtdAssentos()); %>
			</td>
			<td>
				<% out.println(""+amv.getAero().getFileira()); %>
			</td>
			<td>
				<% out.println(""+amv.getAero().getColuna()); %>
			</td>
			<td>
			<a href="/Projeto/AeronaveServlet?url=exibeEdit&id=<%out.println(amv.getAero().getIdAeronave());%>" class="btn btn-warning">Editar</a>
			<a href="/Projeto/AeronaveServlet?url=delete&id=<%out.println(amv.getAero().getIdAeronave());%>" class="btn btn-danger">Excluir</a>
			</td>
		</tr>
		<%}%>	
	</table> 
</div>
	<input type="hidden" name="url" value="list" >
</body>
</html>