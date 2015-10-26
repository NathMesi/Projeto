<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Voo</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<%
		ArrayList<AeroportoModel> listaAerop = (ArrayList<AeroportoModel>) request
				.getAttribute("listaAerop");
		ArrayList<AeronaveModelView> listaAero = (ArrayList<AeronaveModelView>) request
				.getAttribute("listaAero");
		VooModelView vmv = (VooModelView) request.getAttribute("vmv");
	%>

<h2>Vôos</h2>

<hr/>

<a class="btn btn-default" href="/Projeto/VooServlet?url=list">Voltar</a>

</br></br>

	<form action="VooServlet" method="post">
	<div class="col-md-5">
		<input name="id" type=text class=form-control value=<%out.println(vmv.getVoo().getIdVoo());%>>
		
			<select name="origem" class="form-control">
				<%
					for (AeroportoModel origem : listaAerop) {
				%>
				<option value=<%out.println(origem.getIdAeroporto()); 
				if(origem.getIdAeroporto()==vmv.getVoo().getIdOrigem()){out.println("selected");} %>>
					<%
						out.println(origem.getNome());
					%>
				</option>
				<%
					}
				%>
			</select> <select name="destino" class="form-control">
				<%
					for (AeroportoModel destino : listaAerop) {
				%>
				<option value=<%out.println(destino.getIdAeroporto()); 
				if(destino.getIdAeroporto()==vmv.getVoo().getIdDestino()){out.println("selected");} %>>
					<%
						out.println(destino.getNome());
					%>
				</option>
				<%
					}
				%>
			</select> <select name="aeronave" class="form-control">
				<%
					for (AeronaveModelView amv : listaAero) {
				%>
				<option value=<%out.println(amv.getAero().getIdAeronave());%>>
					<%
						out.println(amv.getAero().getNome());
					%>
				</option>
				<%
					}
				%>
			</select> 
			<input type="time" name="data" placeholder="Data" class="form-control" value=<%out.println(vmv.getVoo().getData());%>> 
			<select name="status" class="form-control">
				<option value="Pendente" <%if(vmv.getVoo().getStatus().equals("Pendente")){out.println("selected");} %>>Pendente</option>
				<option value="Concluido" <%if(vmv.getVoo().getStatus().equals("Concluido")){out.println("selected");} %>>Concluído</option>
			</select> 
			<input type="number" name="valor" placeholder="Valor" class="form-control" value=<%out.println(vmv.getVoo().getPreco());%>> 
			
			</br>
			
			<input type="submit" value="Cadastrar" class="btn btn-success">
		</div>
		<input type="hidden" value="edit" name="url"> ${msg}
	</form>
</body>
</html>