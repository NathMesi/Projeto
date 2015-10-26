<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Aeronave</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<%
		ArrayList<TipoAeronaveModel> lista = (ArrayList<TipoAeronaveModel>) request
				.getAttribute("listaTipo");
	%>

<h2>Aeronave</h2>

<hr/>

<a class="btn btn-default" href="/Projeto/AeronaveServlet?url=list">Voltar</a>

	<form action="AeronaveServlet" method="post">

<div class="col-md-5 row">
		<select name="tipo" class="form-control row">
			<%
				for (TipoAeronaveModel tipo : lista) {
			%>
			<option value=<%out.println(tipo.getIdTipo());%>>
				<%
					out.println(tipo.getNome());
				%>
			</option>
			<%
				}
			%>
		</select> 
		<input type="text" name="nome" placeholder="Nome" class="form-control row"> 
		<input type="text" name="assentos" placeholder="Quantidade de assentos" class="form-control row"> 
		<input type="text" name="fileira" placeholder="Fileiras" class="form-control row"> 
		<input type="text" name="coluna" placeholder="Colunas" class="form-control row">
		
		</br>
		
		<input type="submit" value="Cadastrar" class="btn btn-success">
</div>
<input type="hidden" value="add" name="url">

${msg}
	</form>
</body>
</html>