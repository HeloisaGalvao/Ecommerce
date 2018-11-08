<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="cadastro.css" rel="stylesheet" media="all" />
<link type="text/css" rel="stylesheet" href="css/cadastro.css">
<link rel="shortcut icon" href="./icons/login.ico" type="image/x-icon">
</head>
<body>
	<form action="loginUser" method="get">
		<!-- DADOS LOGIN-->
		<fieldset>
			<legend>Dados Login</legend>
			<table>
				<tr>
					<td><label for="nomeCliente">Login: </label></td>
					<td align="left"><input type="text" name="login" required> </td>
				</tr>
				<tr>
					<td><label>Senha:</label></td>
					<td align="left"><input type="text" name="senha"  required></td>
				</tr>
			</table>
			<br/> <input type="submit" value="Entrar"> 
		</fieldset>
	</form>
</body>
</html>