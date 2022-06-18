<%-- 
    Document   : AgregarMaterial
    Created on : 06-10-2022, 10:36:03 PM
    Author     : Eveling Santos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Agregar Material</title>
    </head>
    <body>
                <%@page import="java.util.*"%>
     <div class="container">
         <h1 align="center"> Material Encontrado </h1>
      
    </div>
    <div class="container"><div class="col-12"> 
        
    </div></div>
    <div class="container">
        <div class="col-md-6">
            <% List<List<String>> lista=(ArrayList)request.getAttribute("Material");           
            %>
        <div class="container">
           <ul class="list-group">
            <% for(int i=0;i<lista.size();i++){
            %>
              <li class="list-group-item">Codigo: <%=lista.get(i).get(0)%></li>
                <li class="list-group-item">Titulo: <%=lista.get(i).get(1)%></li>
                <li class="list-group-item">Catalogacion: <%=lista.get(i).get(2)%></li>
                <li class="list-group-item">Cantidad Total: <%=lista.get(i).get(3)%></li>
                <li class="list-group-item">Cantidad Disponible: <%=lista.get(i).get(4)%></li>
            <%
        }%></ul>
</div>
        

    </body>
</html>
