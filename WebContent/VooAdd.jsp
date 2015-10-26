<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Voo</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

<%
		ArrayList<AeroportoModel> listaAerop = (ArrayList<AeroportoModel>) request
				.getAttribute("listaAerop");
		ArrayList<AeronaveModelView> listaAero = (ArrayList<AeronaveModelView>) request
				.getAttribute("listaAero");
%>

	<form action="VooServlet" method="post">

<div class="col-md-5">
		<select name="origem" class="form-control">
			<%
				for (AeroportoModel origem : listaAerop) {
			%>
			<option value=<%out.println(origem.getIdAeroporto());%>>
				<%
					out.println(origem.getNome());
				%>
			</option>
			<%
				}
			%>
		</select> 
		<select name="destino" class="form-control">
			<%
				for (AeroportoModel destino : listaAerop) {
			%>
			<option value=<%out.println(destino.getIdAeroporto());%>>
				<%
					out.println(destino.getNome());
				%>
			</option>
			<%
				}
			%>
		</select>
		<select name="aeronave" class="form-control">
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
		
		<div class='input-group date' id='datetimepicker1'>
			<input type="text" name="data" class="form-control">
			<span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
		 </div>
		 
		<select name="status" class="form-control">
			<option value="Pendente">Pendente</option>
			<option value="Concluido">Concluído</option>
		</select>  
		<input type="number" name="valor" placeholder="Valor" class="form-control"> 
		
		<input type="submit" value="Cadastrar" class="btn btn-success">
</div>
<input type="hidden" value="add" name="url">

<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
</script>
${msg}
	</form>
</body>
</html>