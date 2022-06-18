<%-- 
    Document   : Materiales
    Created on : 06-16-2022, 05:03:03 PM
    Author     : admin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Material"%>
<%@page import="Modelos.PrestamosCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css" integrity="sha384-zIaWifL2YFF1qaDiAo0JFgsmasocJ/rqu7LKYH8CoBEXqGbb9eO+Xi3s6fQhgFWM" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./searchbar.css">
        
        <title>JSP Page</title>
    </head>
    <body>        
    <form action="Materiales.jsp">
      <div class="form-row">
        <div>
          <h3>Busqueda:</h3>
        </div>
        <div class="col-7"> 
          <input class="form-control" id="searchbar" onkeyup="search_titulo()" type="text"
        name="search" placeholder="Search titulo..">
        </div><br>
      </div>
    </form>    

        <div id='list'>
        <%!    
        PrestamosCRUD mostrar = new PrestamosCRUD();
        ArrayList<Material> materiales = mostrar.materiales();        
         %>
    <%
        for(Material m : materiales){
    %>  
        <p class="titulo">Codigo: <%=m.getCodigo()%>
        <a href="ControladorP?operacion=material&codigo=<%=m.getCodigo()%>" method="post">
        <br>Titulo: <%=m.getTitulo()%></a>
        <br>Autor: <%=m.getAutor()%>
        <br>Cantidades disponibles: <%=m.getCantDisp()%><br></p>
        <%}%> 
        </div>
<script src="./jsb.js"></script> 
    </body> 
</html>
