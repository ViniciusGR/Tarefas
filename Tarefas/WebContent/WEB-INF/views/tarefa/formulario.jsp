<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tarefas</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<h2>Nova tarefa</h2>
	<form:errors path="tarefa.descricao"/>
	<form action="adicionaTarefa" method="POST">
		<label for="descricao">Descrição: </label> <br />
		<textarea name="descricao" id="descricao" class="form-control" rows="5" cols="100"></textarea>
		<br /> <button class="btn btn-lg btn-primary btn-block" onclick="this.disabled=true;this.value='Salvando...';this.form.submit();" type="submit">Adicionar</button>
	</form>
	</div>
	<script src="resources/jquery/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>