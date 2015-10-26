<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style>
.container{
padding-right:15px;
padding-left:15px;
margin-right:auto;
margin-left:auto;
}
</style>

</head>
<body>
<h2>Login</h2>
<hr>
</br>
</br>
</br>

	<form action="UsuarioServlet/login" method="post">
	
	<div class="container col-md-6">
	
	<div class="col-md-12">
	<input type="text" placeholder="Usuario" name="usuario" class="form-control">
	</div>
	<div class="col-md-12">
	<input type="password" placeholder="Senha" name="senha" class="form-control">
	</div>
	</br>
	
	<input type="submit" value="Ok" class="btn btn-success pull-right col-md-3">
	
	<input type="hidden" name="url" value="login" >
	</div>
	
</form>
	
	${msg}

</body>
</html>