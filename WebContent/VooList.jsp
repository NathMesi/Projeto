<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>


<%
		ArrayList<VooModelView> lista = (ArrayList<VooModelView>) request
				.getAttribute("lista");
%>
<h2>Vôos</h2>

<hr/>

<a href="/Projeto/VooServlet?url=exibeAdd" class="btn btn-success">Adicionar</a>

<table class="table table-hover table-responsive table-striped">
		<tr>
			<th>
				ID
			</th>
			<th>
				Origem
			</th>
			<th>
				Destino
			</th>
			<th>
				Aeronave
			</th>
			<th>
				Data
			</th>
			<th>
				Status
			</th>
			<th>
				Valor
			</th>
			<th>
				Opções
			</th>
		</tr>
		<%
		for(VooModelView vmv : lista){
		%>
		<tr>
			<td>
				<% out.println(vmv.getVoo().getIdVoo()); %>
			</td>
			<td>
				<% out.println(vmv.getOrigem().getNome()); %>
			</td>
			<td>
				<% out.println(vmv.getDestino().getNome()); %>
			</td>
			<td>
				<% out.println(vmv.getAmv().getAero().getNome()); %>
			</td>
			<td>
				<% out.println(vmv.getVoo().getData()); %>
			</td>
			<td>
				<% out.println(vmv.getVoo().getStatus()); %>
			</td>
			<td>
				<% out.println(vmv.getVoo().getPreco()); %>
			</td>
			<td>
			<a href="/Projeto/VooServlet?url=exibeEdit&id=<%out.println(vmv.getVoo().getIdVoo());%>" class="btn btn-warning">Editar</a>
			<a href="/Projeto/VooServlet?url=delete&id=<%out.println(vmv.getVoo().getIdVoo());%>" class="btn btn-danger">Excluir</a>
			</td>
		</tr>
		<%}%>	
	</table> 

	<input type="hidden" name="url" value="list" >
</body>
</html>