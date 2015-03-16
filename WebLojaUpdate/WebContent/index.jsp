<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.infnet.model.*"%>
<%@ page import="java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.String.*"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/jquery.min.js">
	
</script>
<script src="js/jquery.widget.min.js">
	
</script>
<script src="js/jquery.mousewheel.js">
	
</script>
<script src="js/load-metro.js">
	
</script>


<style>
.conteudo {
	margin-top: 10px;
	float: left;
	margin-left: 150px;
}
.select {
	width: 100% !important;
}

.sucesso {
	padding: 3px;
	border-radius: 5px;
	box-shadow: 1px 2px 8px rgb(142, 142, 142);
	color: green;
	width: 205px;
	background-color: rgba(0, 128, 0, 0.05);
}

.erro {
	color: red;
	padding: 3px;
	box-shadow: 0px 1px 8px #888888;
	border-radius: 8px;
	background-color: rgba(150, 150, 150, 0.19);
	left: 12%;
	position: absolute;
	margin-top: -8px;
	top: 107%;
}

#veiculo {
	height: 300px;
	background-color: #999;
	width: 300px;
	float: left;
	margin-left: 49px;
}

.cont {
	margin-left: 5px !important
}

.largura {
	width: 387px !important;
	color: #333;
}

body {
	font-size: 14px !important;
}

.metro .input-control.select select {
	width: 120px !important;
	color: #333;
}

input {color #333; !important;
	
}
</style>


<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/metro-bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="css/metro-bootstrap-responsive.css" />
<script src="js/"></script>



<title>Adicionar Carro</title>
<script>

$(document).ready(function() {

	if ($("#message").text().lenght < 2)
		$("#message").css("display", "none");

	$("#veiculo").css("display", "block");

	$('.notificar').on('click', function() {
		Notificacao("Thiago", "Deu certo", 2000);
	});

});

function NotificacaoErro(caption, content, timeout) {
	var not = $.Notify({
		caption : caption,
		content : content,
		style : {
			background : 'red',
			color : 'white'
		},
		timeout : timeout
	// 10 seconds
	});
}

function Notificacao(caption, content, timeout) {
	var not = $.Notify({
		caption : caption,
		content : content,
		style : {
			background : 'green',
			color : 'white'
		},
		timeout : timeout
	// 10 seconds
	});
}

</script>

</head>
<body class="metro">


	<nav class="navigation-bar">
		<nav class="navigation-bar-content">
			<div class="element">
				<a class="dropdown-toggle" href="/WebLoja">Home </a>
			</div>

			<span class="element-divider"></span> <a class="element brand"
				href="ListaBuscaServlet?acao=listaCarros"><span
				class="icon-spin">Carros</span></a> 
				
				<a class="element brand"
				href="LojaServlet?acao=MOSTRALOJAS"><span
				class="icon-printer">Lojas</span></a> <span class="element-divider"></span>

			<div class="element input-element">
				<form Action="CarroServlet?acao=PesquisaVeiculo" Method="Post">
					<div class="input-control text largura">
						<input type="text" name="chassi"
							placeholder="Digite o Chassi do veiculo">
						<div id="btn-search">
							<button class="btn-search"></button>
						</div>
					</div>
				</form>
			</div>
			<span class="element-divider place-right"></span> <a
				class="element place-right" href="#"><span class="icon-locked-2"></span></a>
			<span class="element-divider place-right"></span>

		</nav>
	</nav>
	
		<div class="conteudo cont" style="width: 263px !important">
			

			<c:if test="${msgSucesso != null}">
				<script>
					$(function(){
						Notificacao("Carro",'${msgSucesso}',2000);
					});
				</script>
			</c:if>

			<c:if test="${msg != null}">
				<script>
					$(function(){
						NotificacaoErro("Erro",'${msg}',2000);
					});
				</script>
			</c:if>


			<%-- <c:if test="${tiposCarro == null}"> --%>
			<!-- null -->
			<%-- </c:if> --%>

			<h3>Cadastro de Veiculos</h3>

			<form name="Carro" action="CarroServlet?acao=AddCarro" Method="Post">

				<div class="input-control text select">

			<c:forEach items="${atributosCarro}" var="item">
			
			<label>item.getDescricao()</label>
			
			</c:forEach>
					
					
					<input type="submit" value="Enviar" />
			</form>
		</div>
</div>
		<div class="conteudo" style="width: 263px">
			<h3>Cadastro de Motocicletas</h3>
			<form name="Carro" action="CarroServlet?acao=AddMoto" Method="Post">
				<div class="input-control text select">
					<label>Chassi <input type="text" name="chassi" />
					</label> <label>Cor <input type="text" name="cor" />
					</label> <label>Modelo <input type="text" name="modelo" />
					</label> <label>Montadora <input type="text" name="montadora" /></label> <label>Preco
						<input type="text" name="preco" />
					</label> <label>Tipo</label>
					<div class="input-control select">
						<select name="tipo">
							<c:forEach items="${tiposMoto}" var="item">
								<option>${item}</option>
							</c:forEach>
						</select>
					</div>
					<label>Capacidade Tanque <input type="text"
						name="capacidadetanque" /></label> <label>Cilindrada <input
						type="text" name="cilindrada" />
					</label>
					<div class="input-control select">
						<select name="idLoja">
							<c:forEach items="${lojas}" var="item">
								<option value="${item.getId()}">${item.getNome()}</option>
							</c:forEach>
						</select>
					</div>
					<input type="submit" value="Cadastrar Moto" />
				</div>
			</form>

		</div>
		<c:choose>
			<c:when test="${carro != null}">

				<div id="veiculo">

					Carro Encontrado:

					<p>Chassi: ${carro.getChassi() }</p>
					<p>Cor: ${carro.getCor() }</p>
					<%-- 		<p>${carro.getId() }</p>  --%>
					<p>Modelo: ${carro.getModelo() }</p>
					<p>Montadora: ${carro.getMontadora() }</p>
					<p>Preco: ${carro.getPreco() }</p>
					<p>Tipo: ${carro.getTipo() }</p>
					<p>Cambio: ${carro.getEspecificacaoCarro().getCambio() }</p>
<%-- 					<p>Motorização: ${carro.getMotorizacao() }</p> --%>
					<p>Loja: ${carro.getLoja().getNome() }</p>

				</div>

			</c:when>
		</c:choose>
	
	<c:choose>
	
	<c:when test="${moto != null}">

		<div id="veiculo">

			Moto Encontrada:

			<p>Chassi: ${moto.getChassi() }</p>
			<p>Cor: ${moto.getCor() }</p>
			<%-- 		<p>${moto.getId() }</p>  --%>
			<p>Modelo: ${moto.getModelo() }</p>
			<p>Montadora: ${moto.getMontadora() }</p>
			<p>Preco: ${moto.getPreco() }</p>
			<p>Tipo: ${moto.getTipo() }</p>
			<p>Capacidade Tanque: ${moto.getCapacidadeTanque() }</p>
			<p>Cilindrada: ${moto.getCilindrada() }</p>


</div>
	</c:when>
	</c:choose>


</body>
</html>