<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.infnet.loja.model.*"%>
<%@ page import="java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.String.*"%>
<%@ page import="br.edu.infnet.loja.enuns.*"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <script src="//code.jquery.com/jquery-1.11.2.min.js"></script> -->
<!-- <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script> -->
<script src="js/jquery.min.js">
	
</script>
<script src="js/jquery.widget.min.js">
	
</script>
<script src="js/jquery.mousewheel.js">
	
</script>
<script src="js/load-metro.js">
	
</script>

<script>
	$(document).ready(function() {
		if ($("#message").text().lenght < 2)
			$("#message").css("display", "none");

		$("#veiculo").css("display", "block");

		$('.notificar').on('click', function() {
			Notificacao("Thiago", "Deu certo", 2000);
		});

	});

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

	function TrocarLoja(chassi) {
		var idLoja = document.getElementById("selectLoja").value;
		// 		var veiculoId = document.getElementById("idVeiculo").value;
		$.get('CarroServlet', {
			chassi : chassi,
			idLoja : idLoja,
			acao : "TrocaLoja"
		}, function(responseText) {
			$('.sucesso').text(responseText);
			//alert(responseText);
			Notificacao("Carro", responseText, 2000);
		});

	}

	function TrocarLojaMoto(chassi) {
		var idLoja = document.getElementById("selectLojaMoto").value;
		// 		var veiculoId = document.getElementById("idVeiculo").value;

		$.get('CarroServlet', {
			chassi : chassi,
			idLoja : idLoja,
			acao : "TrocaLojaMoto"
		}, function(responseText) {
			//$('.sucesso').text(responseText);
			Notificacao("Moto", responseText, 2000);

		});

	}

	// $("#btn-search").click(function() {
	// 	alert();
	// 	$("#veiculo").css("display","block");
	// 	});
</script>
<%-- <% --%>

<!--   	List<String> tiposCarro = (List<String>) getServletContext().getAttribute("tiposCarro"); -->



<%--  %>  --%>


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
	left: 19%;
	position: absolute;
	margin-top: -8px;
	top: 20%;
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



<title>Buscar Carros</title>

</head>
<body class="metro">

	<nav class="navigation-bar">
		<nav class="navigation-bar-content">
			<div class="element">
				<a class="dropdown-toggle" href="index.jsp">Home </a>
			</div>

			<span class="element-divider"></span> <a class="element brand"
				href="ListaBuscaServlet?acao=listaCarros"><span
				class="icon-spin">Carros</span></a> <a class="element brand"
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
	<div class="conteudo cont">


		<%-- <c:if test="${tiposCarro == null}"> --%>
		<!-- null -->
		<%-- </c:if> --%>

		<h3>Busca de Veiculos</h3>

		<form name="Carro" action="ListaBuscaServlet?acao=pesquisaVeiculos"
			Method="Post">
			<div class="input-control select text">
				<label>Chassi</label> <input type="text" placeholder="Chassi"
					name="chassi" /> </label> <label>Cor <input type="text" name="cor" />
				</label> <label>Modelo <input type="text" name="modelo" />
				</label> <label>Montadora <input type="text" name="montadora" /></label> <label>Preco
					<input type="text" name="preco" />
				</label> <label>Tipo</label>

				<div class="input-control select">
					<select name="tipo">
						<c:forEach items="${appendTipos}" var="item">
							<option>${item}</option>
						</c:forEach>
					</select>
				</div>

				<label>Cambio</label> <input type="text" name="cambio" /> <label>Motorização</label>

				<input type="text" name="motorizacao" /> <label>Loja </label>
				<div class="input-control select text">
					<select name="idLoja">
						<option value="0">Selecione</option>
						<c:forEach items="${lojas}" var="item">
							<option value="${item.getId()}">${item.getNome()}</option>
						</c:forEach>
					</select>
				</div>
				</label> <label>Capacidade Tanque <input type="text"
					name="capacidadeTanque" /></label> <label>Cilindrada <input
					type="text" name="cilindrada" />
				</label> <input type="submit" value="Enviar" />
		</form>
	</div>

	</div>


	<div class="conteudo"
		style="width: 74%; float: left; margin-left: 68px;">

		<c:if test="${msgSucesso != null}">
			<div class="sucesso">${msgSucesso}</div>
		</c:if>

		<c:if test="${erro != null}">
			<div class="erro">${erro}</div>
		</c:if>

		<c:choose>

			<c:when test="${carros != null && carros.size() > 0}">

				<h3 style="clear: both;">Carros:</h3>

				<table border="1" width="80%" style="clear: both;">

					<tr>
						<th>Chassi</th>
						<th>Cor</th>
						<th>Modelo</th>
						<th>Montadora</th>
						<th>Preco</th>
						<th>Tipo</th>
						<th>Cambio</th>
						<th>Motorização</th>
						<th>Loja</th>
					</tr>

					<c:forEach items="${carros}" var="carro">
						<tr>
							<td>${carro.getChassi()}</td>
							<td>${carro.getCor() }</td>
							<td>${carro.getModelo() }</td>
							<td>${carro.getMontadora() }</td>
							<c:choose>
								<c:when test="${carro.getPreco() < 1}">
									<td>Não informado.</td>
								</c:when>
								<c:otherwise>
									<td>${carro.getPreco()}</td>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${!empty carro.getTipo()}">
									<td>${carro.getTipo()}</td>
								</c:when>
								<c:otherwise>
									<td>Não Informado.</td>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${!empty carro.getCambio()}">
									<td>${carro.getTipo()}</td>
								</c:when>
								<c:otherwise>
									<td>Não Informado.</td>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${carro.getMotorizacao() < 1}">
									<td>Não informado.</td>
								</c:when>
								<c:otherwise>
									<td>${carro.getMotorizacao() }</td>
								</c:otherwise>
							</c:choose>
							<td>

								<div class="input-control select">
									<select id="selectLoja"
										onchange="TrocarLoja('${carro.getChassi()}')">
										<c:forEach items="${lojas}" var="loja">
											<c:choose>
												<c:when test="${loja.getId() == carro.getLoja().getId()}">
													<option selected value="${loja.getId()}">${loja.getNome()}</option>
													<%-- 												<input type="hidden" id="idVeiculo" value="${carro.getId()}" /> --%>
												</c:when>
												<c:otherwise>
													<option value="${loja.getId()}">${loja.getNome()}</option>
													<%-- 												<input type="hidden" id="idVeiculo" value="${carro.getId()}" /> --%>
												</c:otherwise>
											</c:choose>

										</c:forEach>
									</select>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>

			</c:when>
		</c:choose>


		<c:choose>

			<c:when test="${motos != null && motos.size() > 0}">

				<h3>Motos:</h3>

				<table border="1" width="80%" style="clear: both;">

					<tr>
						<th>Chassi</th>
						<th>Cor</th>
						<th>Modelo</th>
						<th>Montadora</th>
						<th>Preco</th>
						<th>Tipo</th>
						<th>Cilindrada</th>
						<th>Capacidade Tanque</th>
						<th>Loja</th>
					</tr>

					<c:forEach items="${motos}" var="moto">
						<tr>
							<td>${moto.getChassi()}</td>
							<td>${moto.getCor() }</td>
							<td>${moto.getModelo() }</td>
							<td>${moto.getMontadora() }</td>
							<c:choose>
								<c:when test="${moto.getPreco() < 1}">
									<td>Não informado.</td>
								</c:when>
								<c:otherwise>
									<td>${moto.getPreco()}</td>
								</c:otherwise>
							</c:choose>
							<td>${moto.getTipo() }</td>
							<td>${moto.getCilindrada() }</td>
							<c:choose>
								<c:when test="${moto.getCapacidadeTanque() < 1}">
									<td>Não informado.</td>
								</c:when>
								<c:otherwise>
									<td>${moto.getCapacidadeTanque() }</td>
								</c:otherwise>
							</c:choose>
							<td>
								<div class="input-control select">
									<select id="selectLojaMoto"
										onchange="TrocarLojaMoto('${moto.getChassi()}')">
										<c:forEach items="${lojas}" var="loja">
											<c:choose>
												<c:when test="${loja.getId() == moto.getLoja().getId()}">
													<option selected value="${loja.getId()}">${loja.getNome()}</option>
													<%-- 												<input type="hidden" id="idVeiculo" value="${carro.getId()}" /> --%>
												</c:when>
												<c:otherwise>
													<option value="${loja.getId()}">${loja.getNome()}</option>
													<%-- 												<input type="hidden" id="idVeiculo" value="${carro.getId()}" /> --%>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>

			</c:when>
		</c:choose>
	</div>








</body>
</html>