<%-- 
    Document   : prestamos
    Created on : 06-11-2022, 07:30:42 PM
    Author     : admin
--%>

<%@page import="Entidad.Prestamo"%>
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
          
        <a href="Materiales.jsp"></a>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRESTAMOS</h1>
        
        <%!  
        PrestamosCRUD mostrar = new PrestamosCRUD();
        ArrayList<Prestamo> prestamo = mostrar.prestamoU(3);   // aqui poner el usuario especifico
        ArrayList labels1 = mostrar.labels(mostrar.SQL_SELECTPRESX);
         %>
    <form action="Materiales.jsp" method="post">
      <div class="form-row">
        <div class="col-7">
          <input class="form-control" id="searchbar" onkeyup="search_columna()" type="text"
        name="search" placeholder="Buscar articulo.." >
        </div>
      </div>
    </form>          
         
<table class="table table-striped">
<thead class="thead-light">
    <tr>
        <th colspan = "<%=labels1.size()%>">prestamos</th>
    </tr>  
    <tr>
      <%for(int j= 0; j<labels1.size();j++){%>
      <th><%=labels1.get(j)%></th>
      <%}%>
    </tr>  
</thead>
  
  <tbody>
    
    <%for(Prestamo p : prestamo){%>
    <tr class="titulo" style="table-row">
        <td><%=p.getCodigo()%></td>
        <td><%=p.getTitulo()%></td>
        <td><%=p.getFechaprestamo()%></td>    
        <td><%=p.getFechaentrega()%></td>    
        <td><%=p.getMora()%></td>    
    </tr>    
    <%}%>   
    <!--nose porque no se actualiza de un solo si igual lo estoy redireccionando-->
    </tbody>
    </table>
    <script src="./jsb.js"></script>
    </body>
</html>
