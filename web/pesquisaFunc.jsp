<%-- 
    Document   : pesquisaFunc
    Created on : May 13, 2015, 3:45:20 PM
    Author     : Ina
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
    </br></br>
    <form action="servletFuncionario?action=pesquisa" method="POST" onsubmit="return validacadastroentrada(this);">	
        <h4>CPF: <input type="text" name="cpf" size="12">     Palavra chave: <input type="text" name="palavra" size="15"> <input type="submit" value="Pesquisar"></h4>
    </form>
    <br /><br />
    
    <table>
        <tr>		<th>  </th>
            <th> CPF</th> <th> </th> 
            <th> Nome</th> <th> </th> 
            <th> Email </th> 
        </tr>
        <c:forEach var="l" items="${listafunc}">
        <tr>		<td> <input type="radio"  name="t" onclick="AnEventHasOccurred()" value="${l.cpf}"> </td>
            <td>  ${l.cpf}</td>  <td>  </td> 
            <td> ${l.nome}<input type="hidden"  name="nome" value="${l.nome}"></td>  <td>  </td> 
            <td> ${l.email}<input type="hidden"  name="mail" value="${l.email}"></td> 
            <input type="hidden"  name="tipo" value="${l.tipo}"><input type="hidden"  name="sexo" value="${l.sexo}">
        </tr>
    
        </c:forEach>
    </table>
<script type="text/javascript">
function AnEventHasOccurred() {
var choices;
var nm;
var m;
var t;
var s;
var els = document.getElementsByName('t');
var n = document.getElementsByName('nome');
var mail= document.getElementsByName('mail');
var tipo= document.getElementsByName('tipo');
var sexo= document.getElementsByName('sexo');
for (var i=0;i<els.length;i++){
  if ( els[i].checked ) {
    choices=els[i].value;
    nm=n[i].value;
    m=mail[i].value;
    t=tipo[i].value;
    s=sexo[i].value;
  }
}
document.getElementById("nome").value = nm;
   //document.write(listafunc);
  // for (var i=0;i<lista.length;i++){
  /*if ( choices==lista[i].cpf) {
document.getElementById("nome").value = lista[i].nome;
document.getElementById("email").value = lista[i].email;
        }
}
   */
document.getElementById("cpf").value = choices;
document.getElementById("email").value = m;
document.getElementById("tipo").value = t;
document.getElementById("sexo").value = s;
}
</script>
    
    <br /><br />
    <form action="servletFuncionario?action=cadastra" method="post"  onsubmit="return validacadastro(this);">
        <table border=0 >
            <tr>	<td>    Nome Completo: </td><td><input type="text" id="nome" name="nome" size="40"></td></tr>
            <tr>	<td>	CPF: </td><td><input type="text" id="cpf" name="cpf" size="11"></td></tr>
            <tr>	<td>	Email:</td><td> <input type="text" id="email" name="email" size="40"></td></tr>
            <tr>	<td>    Sexo: </td>
                <td>
                    <SELECT NAME = "sexo"id="sexo">
                        <OPTION >
                        <OPTION value="feminino">feminino
                        <OPTION value="masculino">masculino
                    </SELECT>
                </td>
            </tr>
            <tr>	<td> Tipo: </td>
                <td>
                    <SELECT NAME = "tipo"id="tipo">
                         <OPTION >
                        <OPTION value="2">Administrador
                        <OPTION value="3">Gerente
                    </SELECT>
                </td>
            </tr>
        </table><br/>
        <input type="submit" value="Cadastrar Funcionário">
    
    </form><br />
    <input type="submit" value="Alterar Funcionário">
    <input type="submit" value="Remover">
</div>
