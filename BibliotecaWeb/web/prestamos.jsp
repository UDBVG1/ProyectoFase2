<%-- 
    Document   : prestamos
    Created on : 06-11-2022, 07:30:42 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRESTAMOS</h1>
        
        <%!  
        PrestamosCRUD mostrar = new PrestamosCRUD();
        ArrayList<Material> materiales = mostrar.materiales();        
         %>
    <%
        for(Material m : materiales){
    %>  
        <p>Codigo: <%=m.getCodigo()%></p>
        <a href="ControladorP?operacion=material"><p>Titulo: <%=m.getTitulo()%></p></a>
        <p>Autor: <%=m.getAutor()%></p>
        <p>Cantidades disponibles: <%=m.getCantDisp()%></p><br><br>
        <%}%>  
    </body>
</html>
