<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tarefas</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/bootstrap/css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form class="form-signin" action="efetuaLogin" method="POST"> 
			<h2 class="form-signin-heading">Entrar:</h2>
			<label for="usuario" class="sr-only">Usuário</label> <input
				type="text" id="usuario" class="form-control"
				name="usuario" placeholder="Nome de usuário" required autofocus> <label
				for="senha" class="sr-only">Senha</label> <input
				type="password" id="senha" class="form-control"
				name="senha" placeholder="Senha" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
	<script src="resources/jquery/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>