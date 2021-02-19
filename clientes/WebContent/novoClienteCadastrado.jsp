<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<body>
	
		<c:if test="${not empty cliente}">
			Cliente ${cliente} cadastrado com sucesso!
		</c:if>
		
		<c:if test="${empty cliente}">
			Nenhum cliente cadastrado!
		</c:if>
	
	</body>
	
</html>
