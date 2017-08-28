<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tarefas</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Lista de Tarefas</h2>
		<table class="table">
			<thead>
				<tr>
				    <th>ID</th>
					<th>Descrição</th>
					<th>Finalizado</th>
					<th>Data de Finalização</th>
					<th class="text-center" colspan="2">Ação</th>
				</tr>
			</thead>
			<c:forEach items="${tarefas}" var="tarefa">
				<tbody>
					<tr>
						<td>${tarefa.id}</td>
						<td>${tarefa.descricao}</td>
						<c:if test="${tarefa.finalizado eq true}">
							<td>Finalizado</td>
						</c:if>
						<c:if test="${tarefa.finalizado eq false}">
							<td><a href="finalizaTarefa?id=${tarefa.id}">Finalizar
									agora!</a></td>
						</c:if>
						<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
								pattern="dd/MM/yyyy" /></td>
						<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
						<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<button class="btn btn-lg btn-primary btn-block" onClick="location.href='novaTarefa'">Adicionar nova tarefa</button>
	</div>
	<script src="resources/jquery/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>