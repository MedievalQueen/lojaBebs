<%-- 
    Document   : pesquisacli
    Created on : May 13, 2015, 3:42:42 PM
    Author     : Ina
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/valida.js"></script>

<div class="center_content">
		</br></br><form action="servletCliente?action=pesquisa" method="POST" onsubmit="">	
				<h4>CPF: <input type="text" name="cpf" size="12">     Palavra chave: <input type="text" name="palavra" size="15"> <input type="submit" value="Pesquisar"></h4>
                                </form>
					<br /><br />
                                        <form action="servletCliente?action=acoes" method="POST" onsubmit="return validaclisel(this);">
                                        <table>
                                            <tr>		<th>  </th>
                                                <th> CPF</th> <th> </th> 
                                                <th> Nome</th> <th> </th> 
                                                <th> Email </th> 
                                                <th> Login </th> 
                                            </tr>
                                            <c:forEach var="l" items="${listacli}">
                                                <tr>		<td> <input type="radio"  name="t" onclick="" value="${l.idCliente}"> </td>
                                                    <td>  ${l.cpf}</td>  <td>  </td> 
                                                    <td> ${l.nome}<input type="hidden"  name="nome" value="${l.nome}"></td>  <td>  </td> 
                                                    <td> ${l.email}<input type="hidden"  name="mail" value="${l.email}"></td> 
                                                     <td> ${l.login}<input type="hidden"  name="login" value="${l.login}"></td> 
                                                </tr>
                                            </c:forEach>
                                        </table>
					<br />
					<input type="submit" value="Listar Ações do Cliente">
                                        </form>
                                        
					<input type="submit" value="Listar Compras">
					<br><br/>

                                        <table border='1' >
                                            <tr>
                                                <th>
                                                    Datas Login
                                                </th>
                                                <th>
                                                    Datas Logout
                                                </th>       
                                            </tr>
                                        <c:forEach var="l" items="${listadatalog}">

                                            <tr> <!--forEach   //DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//Date date = new Date();
//out.println(df.format(date));-->
                                                <td>
                                                    ${l.datalogin}
                                                </td>
                                                <td>
                                                    ${l.datalogout}
                                                </td>
                                            </tr>
                                            </c:forEach>
                                        </table><br/>
                                        <table border='1'>
                                            <tr>
                                                <th>
                                                    Data Produtos Visualizados
                                                </th>
                                            </tr>
                                            <c:forEach var="l" items="${listadatalogv}">
                                            <tr> <!--forEach -->
                                                <td>
                                                    2
                                                </td>
                                            </tr>
                                            </c:forEach>
                                        </table>




</div>				