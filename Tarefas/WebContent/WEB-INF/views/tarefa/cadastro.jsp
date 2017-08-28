<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefas</title>
<h3>Cadastro de Usuário</h3>
<hr />
<form:errors path="tarefa.descricao"/>
<form action="cadastraUsuario" method="POST">
	Usuário: <input type="usuario" name="usuario">
	<form:errors path="usuario.usuario" />
	<br /> Senha: <input type="password" name="senha">
	<form:errors path="usuario.senha" />
	<br /> <input type="submit" value="Cadastrar-se" /><br />
</form>
</head>
<body>
</body>
</html>