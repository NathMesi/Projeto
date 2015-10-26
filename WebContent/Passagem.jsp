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
	var elemento = 0;
	function geraGroup(){
		elemento = elemento + 1;
		var pDefault = "<div class='panel panel-default' id='panel" + elemento + "'>";
		var pHeading = "<div class='panel-heading' role='tab' id='h" + elemento + "'> "+
		"<h4 class='panel-title'> <a role='button' data-toggle='collapse' data-parent='#accordion' "+
		"href='#c" + elemento + "' aria-expanded='true' aria-controls='c" + elemento + "'>";
		var titulo = "Passageiro";
		var fimHeading = "</a> </h4> " +
		"<button class='btn btn-danger pull-right' id='r" + elemento + "' onclick='removePassag(this)'>X</button> " +
		"</div>";
		var pBody = "<div id='c" + elemento + "' class='panel-collapse collapse in' role='tabpanel' aria-labelledby='h" + elemento + "'> "+
	     	"<div class='panel-body'>";
	   	var body = geraUsuario(elemento);
	   	var fimBody = "</div> </div> </div> </div>";
	   	var element = pDefault + pHeading + titulo + fimHeading + pBody + body + fimBody;
		$("#accordion").append(element);	
		
		qtdPassag(elemento);
	}
	
	function geraUsuario(elem){
		var html = "<div class='col-md-12'> " + 
		"<input type='text' name='" + elem +"nome' placeholder='Nome' class='form-control col-md-6'> "+
		"<input type='text' name='" + elem +"sobrenome' placeholder='Sobrenome' class='form-control col-md-6'> " +
		"<select name='" + elem +"tratamento' class='form-control col-md-6'> " +
			"<option value='Sra'>Sra</option> " +
			"<option value='Sr'>Sr</option> " + 
			"<option value='Srta'>Srta</option> " +
		"</select> " +
		"<select name='" + elem +"tipo' class='form-control col-md-6'> " +
			"<option value='Adulto'>Adulto</option> " +
			"<option value='Criança'>Criança</option> " +
			"<option value='Bebê'>Bebê</option> " +
		"</select> " +
		"</div>";
		
		return html;
	}
		
	function removePassag(element){
		var num = ($(element).attr("id")).substring(1);		
		$("#panel"+num).remove();
		qtdPassag();
	}
	
	function alteraPropDebito(valor){
		if(valor == true)
			$(".rDebito").removeAttr("disabled");
		else
			$(".rDebito").attr("disabled", "disabled");
	}
	
	function alteraPropCredito(valor){
		if(valor == true)
			$(".rCredito").removeAttr("disabled");
		else
			$(".rCredito").attr("disabled", "disabled");
	}
	
	
</script>

</head>
<body>
<%
		ArrayList<VooModelView> lista = (ArrayList<VooModelView>) request
				.getAttribute("lista");
%>

<h2>Aeronave</h2>

<hr/>

<div class="col-md-12 row">

<button id="add" class="btn btn-success">Adicionar Passageiro</button>

</br></br>

<form method="post" action="PassagemServlet">


<div class="col-md-7">
<input type="text" name="email" placeholder="Email" class="form-control col-md-6">
</div>
<div class="col-md-7">
<input type="text" name="celular" placeholder="Celular" class="form-control col-md-6">
</div>
<div class="col-md-7"> 

<h2>Check-in</h2>

<hr/>

<select name="voo" class="form-control col-md-6">
	<%
		for(VooModelView vmv : lista) {
	%>
		<option value=<%out.println(vmv.getVoo().getIdVoo()); %>>
		<%
			out.println(vmv.getOrigem().getNome() + " - " + vmv.getDestino().getNome());
		%>
		</option>
	<%
		}
	%>
</select>
</div>
<br/>


<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true"></div>

<br/>
<br/>

</hr>

<div class="col-md-12">
	<div class="col-md-6">
		<label for="rDebito">Débito</label>
		<input type="radio" id="rDebito" name="pagamento" value="debito">
	</div>
	<div class="col-md-6">
		<label for="rDebito">Credito</label>
		<input type="radio" id="rCredito" name="pagamento" value="credito" >
	</div>
</div>
<div id="divDebito" class="col-md-6">
	<input type="text" id="bancoD" name="banco" class="rDebito form-control" placeholder="Banco">
	<input type="text" id="agenciaD" name="agencia" class="rDebito form-control" placeholder="Agência">
	<input type="text" id="ccD" name="cc" class="rDebito form-control" placeholder="Conta Corrente">
	<input type="text" id="titularD" name="titular" class="rDebito form-control" placeholder="Titular">
	<input type="text" id="bancoD" name="banco" class="rDebito form-control" placeholder="Banco">
	<input type="text" id="cpfD" name="cpf" class="rDebito form-control" placeholder="CPF">
	<input type="text" id="telefoneD" name="telefone" class="rDebito form-control" placeholder="Telefone de contato">
</div>
<div id="divCredito" >
	<div class="form-group col-md-6">
		<input type="text" id="cartaoC" name="cartao" class="rCredito form-control col-md-6" placeholder="Número do cartão">
		<input type="text" id="titularC" name="titular" class="rCredito form-control col-md-6" placeholder="Titular">
		<input type="text" id="cpfC" name="cpf" class="rCredito form-control" placeholder="CPF">
		<input type="text" id="numeroC" name="numero" class="rCredito form-control" placeholder="Número">
		<input type="text" id="validadeC" name="validade" class="rCredito form-control" placeholder="Validade">
		<input type="text" id="codigoC" name="codigo" class="rCredito form-control" placeholder="Código de Segurança">
	</div>
</div>

<br/>
<br/>
<br/>


<div class="col-md-12 row">
<input type="submit" class="btn btn-success">
</div>

</div>

<input type="hidden" value="add" name="url"> 

</form>


	${msg}
	
<script>
$(document).ready(function() {
	$("#rDebito").prop("checked", true);
	alteraPropDebito(true);
	alteraPropCredito(false);
});

$( "#a" ).click(function() {

	 $.ajax({
	    method: "post",
	    url: "PassagemServlet",
	    data: {"foo": "_foo", "bar": "_bar", "url":"add"},
	    success : function(retorno){
	        alert(retorno);
	    },
	    error : function(a,b,c){
			alert("b");
	    }
	  }); 		
});
$( "#add" ).click(function() {
	geraGroup();
});

$("#rDebito").change(function () {
	alteraPropDebito(true);
	alteraPropCredito(false);
});

$("#rCredito").change(function () {
	alteraPropDebito(false);
	alteraPropCredito(true);
});
</script>

</body>
</html>