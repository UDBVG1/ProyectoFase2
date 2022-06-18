<%-- 
    Document   : reservas
    Created on : 06-17-2022, 10:26:30 PM
    Author     : admin
--%>

<%@page import="Entidad.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.PrestamosCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css" integrity="sha384-zIaWifL2YFF1qaDiAo0JFgsmasocJ/rqu7LKYH8CoBEXqGbb9eO+Xi3s6fQhgFWM" crossorigin="anonymous">
                

        <title>JSP Page</title>
    </head>
    <body>
        <h1>RESERVAS</h1>
        <%!    
        PrestamosCRUD mostrar5 = new PrestamosCRUD();
        ArrayList<Reserva> reservas = mostrar5.reservas(); 
        ArrayList labels = mostrar5.labels(mostrar5.SQL_reservas);
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
        <th colspan = "<%=labels.size()%>">reservas</th>
    </tr>  
    <tr>
      <%for(int i= 0; i<labels.size();i++){%>
      <th><%=labels.get(i)%></th>
      <%}%>
      <th>Acciones</th>
    </tr>  
    
  </thead>
  
  <tbody>
    
    <%for(Reserva r : reservas){%>
    <tr class="titulo" style="table-row">
        <td><%=r.getId()%></td> 
        <td><%=r.getCodigo()%></td>
        <td class="titulo"><%=r.getTitulo()%></td>
        <td><%=r.getAutor()%></td>    
        <td><%=r.getEstado()%></td>    
        <td><%=r.getUsuario()%></td>    
        <td>
            <a href="ControladorP?operacion=prestamo&codigo2=<%=r.getCodigo()%>&id=<%=r.getId()%>" method="post">Prestar</a>
            <a href="ControladorP?operacion=devolucion&codigo2=<%=r.getCodigo()%>&id=<%=r.getId()%>" method="post">Devolver</a>
        </td>
    </tr>    
    <%}%>   
    <!--nose porque no se actualiza de un solo si igual lo estoy redireccionando-->
    </tbody>
    </table>   
        <script src="./jsb.js"></script>          
    </body>
</html>
