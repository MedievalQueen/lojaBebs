<%-- 
    Document   : rel_faturamento
    Created on : May 13, 2015, 3:48:23 PM
    Author     : Ina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
<br />
					<a href="redir_relatorios.jsp"> Relatório de Cliente</a>&nbsp;
					<a href="redir_produtos.jsp"> Relatório de Produtos</a>&nbsp;
					<a href="servletVenda?action=fatur" formmethod="post"> Faturamento da loja</a>&nbsp;
					<a href="redir_cli5.jsp"> Clientes que mais compraram</a>
					<br /><br />
<h3>Faturamento mensal e anual da loja:</h3><br/>
					<table>
					<tr>	
							<th> Mês</th> 
							<th> 2015</th>
							
					</tr>
					<tr>	
							<td> Jan</td> 
							<td> ${listaf[0]} R$</td>
					</tr>
					<tr>	
							<td> Fev</td> 
							<td> ${listaf[1]} R$</td>
					</tr>
<tr>	
							<td> Mar</td> 
							<td> ${listaf[2]} R$</td>
					</tr>
<tr>	
							<td> Abr</td> 
							<td> ${listaf[3]} R$</td>
					</tr>
<tr>	
							<td> Mai</td> 
							<td> ${listaf[4]} R$</td>
					</tr>
<tr>	
							<td> Jun</td> 
							<td> ${listaf[5]} R$</td>
					</tr>
                                        <tr>	
							<td> Jul</td> 
							<td> ${listaf[6]} R$</td>
					</tr>
                                        <tr>	
							<td> Ago</td> 
							<td> ${listaf[7]} R$</td>
					</tr>
                                        <tr>	
							<td> Set</td> 
							<td> ${listaf[8]} R$</td>
					</tr>
                                        <tr>	
							<td> Out</td> 
							<td> ${listaf[9]} R$</td>
					</tr>
                                        <tr>	
							<td> Nov</td> 
							<td> ${listaf[10]} R$</td>
					</tr>
                                        <tr>	
							<td> Dez</td> 
							<td> ${listaf[11]} R$</td>
					</tr>
					<tr>	
							<th> Total/Ano</th> 
							<td> ${listaf[12]} R$</td>
					</tr>
					</table>
					<br />
	</div>				