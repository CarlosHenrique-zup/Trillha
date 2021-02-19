<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/alteraCliente" var="linkServletNovoCliente" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera cliente</title>
</head>

<body>

	<form action="${linkServletNovoCliente}" method="post">

		Nome: <input type="text" name="nome" value="${cliente.nome}" /> <input
			type="hidden" name="id" value="1" /> <input type="submit" />

	</form>

</body>

</html>

