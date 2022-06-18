<%-- 
    Document   : MaterialFiltrado
    Created on : 06-17-2022, 03:31:25 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Filtrado</h1>
        <%  String Codigo = request.getParameter("titulo");
            String tipo = request.getParameter("tipo");%>
    </body>
</html>
<script>
// JavaScript code
function search_animal() {
    let input = document.getElementById('searchbar').value;
    input=input.toLowerCase();
    let x = document.getElementsByClassName('animals');
      
    for (i = 0; i < x.length; i++) { 
        if (!x[i].innerHTML.toLowerCase().includes(input)) {
            x[i].style.display="none";
        }
        else {
            x[i].style.display="list-item";                 
        }
    }
}    
    
</script>