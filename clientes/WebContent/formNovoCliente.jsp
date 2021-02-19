<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novoCliente" var="linkServletNovoCliente" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo cliente</title>
</head>

<body>

	<form action="${linkServletNovoCliente}" method="post">

		Nome: <input type="text" name="nome" /> <input type="submit" />

	</form>

</body>

</html>

