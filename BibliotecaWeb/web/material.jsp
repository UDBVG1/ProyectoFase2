<%-- 
    Document   : material
    Created on : 06-16-2022, 05:14:21 PM
    Author     : admin
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.*"%>
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
        <%
            String Codigo = request.getParameter("codigo");
            String tipo = Codigo.substring(0,3);
            int resp =0;
            PrestamosCRUD mostrar1 = new PrestamosCRUD();
            ArrayList material=null;
            
            String columna1 = "",columna2 = "",columna3 = "",columna4 = "",columna5="";
            
            switch(tipo){
                case "LIB":
                material = mostrar1.materialIndividual(mostrar1.SQL_libro, Codigo);
                columna1 = "Autor: ";
                columna2 = "Numero de Paginas: ";
                columna3 = "ISBN: ";
                columna4 = "Publicacion: ";
                columna5 = "Cantidad Disponible: ";
                break;
                case "REV":
                material = mostrar1.materialIndividual(mostrar1.SQL_revista, Codigo);    
                columna1 = "Editorial: ";
                columna2 = "Periodicidad: ";
                columna3 = "Publicacion: ";
                columna4 = "Cantidad Disponible: ";                
                break;
                case "CDA":
                material = mostrar1.materialIndividual(mostrar1.SQL_cd, Codigo);    
                columna1 = "Genero: ";
                columna2 = "Duracion: ";
                columna3 = "Canciones: ";
                columna4 = "Director: ";
                columna5 = "Cantidad Disponible";
                break;
                case "DVD":
                material = mostrar1.materialIndividual(mostrar1.SQL_dvd, Codigo);    
                columna1 = "Genero: ";
                columna2 = "Duracion: ";
                columna4 = "Cantidad Disponible: ";
                break;                
            }
        %>
        <div>
            <form >
                <p>Codigo: <%= material.get(0)%></p> 
                <p>Titulo: <%= material.get(1)%></p>
                <p><%= columna1+ material.get(2)%></p>
                <p><%= columna2+ material.get(3)%></p>
                <p><%= columna3+ material.get(4)%></p>
                <p><%= columna4+ material.get(5)%></p>
                <%if(columna5!=""){%>
                <p><%= columna5+ material.get(6)%></p>
                <%}%>
                <a class="btn btn-outline-success" id="reservar" href="ControladorP?operacion=reservaHecha&codigo1=<%= material.get(0)%>" method="post">Reservar</a>

                <!--agrega boton para agregar reserva o prestamo 
                tambien desplega los prestamos ya hecho para hacer la devolucion
                agrega que cada que se haga un prestamo se descuente de disponible pero en mysql
                -->
            </form>
        </div>
    </body>
</html>
