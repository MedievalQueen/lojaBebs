<%-- 
    Document   : pesquisaFunc
    Created on : May 13, 2015, 3:45:20 PM
    Author     : Ina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
		</br></br>
				<h4>CPF: <input type="text" name="cpf" size="12">     Palavra chave: <input type="text" name="palavra" size="15"> <input type="submit" value="Pesquisar"></h4>
					<br /><br />
					<table>
					<tr>		<th>  </th>
							<th> CPF</th> 
							<th> Nome</th> 
							<th> Email </th> 
					</tr>
					<tr>		<td> <input type="checkbox" name="t" value=""> </td>
							<td>  0607682950</td> 
							<td> Arminius</td> 
							<td> armthewarrior@hotmail.com</td> 			
					</tr>
					</table>
					<br /><br />
					<form action="#" method="post"  onsubmit="return validacadastro(this);">
					<table border=0 >
					<tr>	<td>    Nome Completo: </td><td><input type="text" name="nome" size="40"></td></tr>
					<tr>	<td>	CPF: </td><td><input type="text" name="cpf" size="11"></td></tr>
					<tr>	<td>	Endereço: </td><td><input type="text" name="endereco" size="40"></td></tr>
					<tr>	<td>	Email:</td><td> <input type="text" name="email" size="40"></td></tr>
					<tr>	<td>    Sexo: </td>
						<td>
								<SELECT NAME = "sexo">
								<OPTION value="f">feminino
								<OPTION value="m">masculino
								</SELECT>
						</td>
					</tr>
					<tr>	<td> Tipo: </td>
						<td>
								<SELECT NAME = "Tipo">
								<OPTION value="2">Administrador
								<OPTION value="3">Gerente
								</SELECT>
						</td>
					</tr>
					</table>
				</form><br />
					<input type="submit" value="Cadastrar/Alterar Funcionário">
					<input type="submit" value="Remover">
</div>
