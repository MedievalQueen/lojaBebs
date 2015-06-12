<%-- 
    Document   : categorias
    Created on : Jun 11, 2015, 2:07:29 PM
    Author     : Ina
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="center_content">
    <form action="servletListaProd" method="POST" onsubmit="return validacadastroentrada(this);" >  
        <input type="hidden" name="cat" value="codCat">
        <h2>Ordernar por: 

            <SELECT NAME = "ordem">
                <OPTION value="nome ASC;">ordem alfabética ascendente
                <OPTION value="nome DESC; ">ordem alfabética descendente
                <OPTION value="valor DESC;">preço descendente
                <OPTION value="valor ASC;">preço ascendente
            </SELECT></h2>
        <input type="submit" value="Ok">
    </form>
    </br></br>	
    <!-- Start of Main Content Area -->
    <div id="main_content">

        <div class="h_divider">&nbsp;</div>


        <!-- Start Left Sub Item -->
        <div class="sub_left">


            <c:forEach var="p" items="${produtos}">
                <div class="sub_items_header">
                    <h1><c:out value="${p.nome}"/></h1>
                    <h2><c:out value="${p.descricao}"/></h2>
                </div>                          
                <div class="sub_items_image"> <img src="<c:url value="${p.imagem}"/>" width="167" height="164" alt="Sub Item Name" /> </div>
                <div class="sub_items_text">
                    <p><c:out value="${p.descricao}"/></p>
                    <p> <strong> Quantidade em estoque <br />
                            <c:out value="${p.quantidade}"/> </strong> </p>
                </div>
                <div class="sub_items_cartinfo">
                    <div class="price">
                        <h2><c:out value="${p.valor}"/>R$</h2>
                    </div>
                    <div class="addtocart"> <a href="#"><span>Add to Cart</span></a> </div>
                    <div class="clearthis">&nbsp;</div>
                </div>
                <div class="h_divider">&nbsp;</div>

                </br></c:forEach>


        </div>


    </div>
</div>