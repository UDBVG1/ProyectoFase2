<%-- 
    Document   : Form_IngresoMaterial
    Created on : 06-17-2022, 10:13:55 PM
    Author     : Eveling Santos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    
        <title>Tabla de Materiales</title>
    </head>
    <body>
        <%@page import="Entidad.*"%>
        <%@page import="Modelos.*"%>
        <%@page import="java.util.*"%>
        <h1>Ingreso Realizado</h1>
        <%  
            MaterialCRUDD nuevo=new MaterialCRUDD();
            List<List<String>> lista=nuevo.listarMateriales();
        %>
        <div class="container-sm">
         <table class="table">
  <thead>
    <tr>
      <th scope="col">Codigo</th>
      <th scope="col">Nombre</th>
      <th scope="col">Cantidad Total</th>
      <th scope="col">Cantidad Disponible</th>
    </tr>
  </thead>
         <% for(int i=0;i<lista.size();i++){
            %>
  <tbody>
    <tr>
      <th scope="row"><%=lista.get(i).get(0)%></th>
      <td><%=lista.get(i).get(1)%></td>
      <td><%=lista.get(i).get(2)%></td>
      <td><%=lista.get(i).get(3)%></td>
    </tr>
    <%}%>
  </tbody>
</table>
        
        </div>
    </body>
</html>
