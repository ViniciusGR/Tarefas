<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefas</title>
</head>
<body>
	<form:errors path="tarefa.descricao" />
	<form action="alteraTarefa" method="POST">
		<input type="hidden" name="id" value="${tarefa.id}" /> Descrição: <br />
		<textarea name="descricao" rows="5" cols="100">${tarefa.descricao}</textarea>
		<br /> Finalizado? <input name="finalizado" type="checkbox"
			value="true" ${tarefa.finalizado?'checked':''} /><br /> Data de
		Finalização: <br /> <input name="dataFinalizacao" type="text"
			value='<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>' /><br />
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>