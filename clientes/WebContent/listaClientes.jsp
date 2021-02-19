<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="java.util.List, br.com.zup.estrelas.cliente.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlet Cliente</title>
</head>

<body>

	<c:if test="${not empty cliente} }">
		Cliente ${cliente} cadastrado com sucesso!
	</c:if>

	<br/>
	Lista de Clientes:
	<br/>
	
	<ul>
		<c:forEach items="${cliente}" var="cliente">
		<li>
		${cliente.nome}
		<a href="/cliente/mostraCliente?id=${cliente.id}">edita</a>
		<a href="/cliente/removeCliente?id=${cliente.id}">remove</a>
		</li>
		</c:forEach>
	</ul>


</body>
</html>
