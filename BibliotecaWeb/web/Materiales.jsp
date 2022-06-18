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
        <link rel="stylesheet" type="text/css" href="prestamo.css">
        
        <title>JSP Page</title>
    </head>
    <body>        
    <form action="Materiales.jsp">
      <div class="form-row">
        <div class="col-4">
          <input type="text" class="form-control" placeholder="Titulo" name="searchTitulo" id="search">
        </div>
        <div class="col">
              <select id="ListaTipo" class="form-control" name="tipo">
                <option selected>Todo</option>
                <option >Libro</option>
                <option>Revista</option>
                <option>CD</option>
                <option>DVD</option>
              </select>
        </div>
        <div class="col">
          <button type="submit" class="btn btn-primary" href="Materiales.jsp" id="boton">Buscar</button>
        </div>
      </div>
    </form>    
        <h1>PRESTAMOS</h1>
        <div id='list'>
        <%!    
        PrestamosCRUD mostrar = new PrestamosCRUD();
        ArrayList<Material> materiales = mostrar.materiales();        
         %>
    <%
        for(Material m : materiales){
    %>  
        <p>Codigo: <%=m.getCodigo()%></p>
        <a href="ControladorP?operacion=material&codigo=<%=m.getCodigo()%>">
            <p class="titulo">Titulo: <%=m.getTitulo()%></p></a>
        <p>Autor: <%=m.getAutor()%></p>
        <p>Cantidades disponibles: <%=m.getCantDisp()%></p><br><br>
        <%}%> 
        </div>
 <script>
const input = document.querySelector('#search');    
const boton = document.querySelector('#boton');  

//funcion
cons filtrar = () =>{
    console.log(input.value);
};

boton.addEventListener('click',filtrar);
</script>  
    </body> 
</html>
