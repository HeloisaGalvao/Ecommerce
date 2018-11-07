<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link href="style.css" rel="stylesheet" media="all" />
<link type="text/css" rel="stylesheet" href="css/cadastro.css">
<link rel="icon" href="./icons/add.ico" type="image/x-icon">
</head>
<body>
	<form action="novoCadastro" method="post" class="dados">
		<!-- DADOS PESSOAIS-->
		<fieldset>
			<legend>Dados Pessoais</legend>
			<table>
				<tr>
					<td><label for="nomeCliente">Nome Sobrenome: </label></td>
					<td align="left"><input type="text" name="nomeCliente" required name=nome 
					placeholder="Fulano de tal" pattern="[a-z\s]+$"></td>
				</tr>
				<tr>
					<td><label>CPF:</label></td>
					<td align="left"><input type="text" name="cpf"  required name=cpf 
					class="form-control cpf-mask" placeholder="Ex.: 000.000.000-00" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}"></td>
				</tr>
			</table>
			<!-- DADOS DE LOGIN -->
			<fieldset>
				<legend>Dados de login</legend>
				<table>
					<tr>
						<td><label for="email">E-mail: </label></td>
						<td align="left"><input type="text" name="email" required placeholder="exemplo@email.com" 
						 pattern="^\w*(\.\w*)?@\w*\.[a-z]+(\.[a-z]+)?$"></td>
					</tr>
					<tr>
						<td><label for="login">Login: </label></td>
						<td align="left"><input type="text" name="login" required></td>
					</tr>
					<tr>
						<td><label for="pass">Senha: </label></td>
						<td align="left"><input type="password" name="senha" required 
							pattern=".{6,10}" placeholder="Minimo de 6 digitos">
						</td>
					</tr>
					<tr>
						<td><label for="passconfirm">Confirme a senha: </label></td>
						<td align="left"><input type="password" name="senhaconfir" required
							pattern=".{6,10}" placeholder="Minimo de 6 digitos">
						</td>
					</tr>
				</table>
			</fieldset>
			<br /> <input type="submit" value="Cadastrar"> <input type="reset" value="Limpar">
		</fieldset>
	</form>
</body>
</html>