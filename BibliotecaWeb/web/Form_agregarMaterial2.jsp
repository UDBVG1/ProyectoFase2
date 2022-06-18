<%-- 
    Document   : Form_agregarMaterial
    Created on : 06-16-2022, 12:42:48 PM
    Author     : Eveling Santos
--%>

<%@page import="Utilidades.ParametrosGlobales"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <title>Agregar ${Material.tipo}</title>
    </head>
    <body>
    <div class="container">
         <h1 align="center"> Ingresar ${Material.tipo} </h1>
      
    </div>
    <div class="container"><div class="col-12"> 
        <ul class="list-group list-group-flush">
            <li class="list-group-item">Titulo : ${Material.titulo}</li>
            <li class="list-group-item">Ubicación: ${Material.catalogacion}</li>
          </ul>

    </div></div>
    <div class="input-group">
        <div><form method="post" action="Controlador" id="formulario">

            <% if ("Libro".equals(ParametrosGlobales.tipo)){     
            %>
                <div class="col-12"><label for="autor" class="form-label">Autor</label>
                <input type="text" class="form-control"  name="autor" placeholder="Autor del material" required></div>
                <div class="col-12" ><label for="editorial" class="form-label">Editorial</label>
                <input type="text" class="form-control"  name="editorial" placeholder="Editorial" required></div>
                <div class="col-12"><label for="ISBN" class="form-label">ISBN</label>
                <input type="text" class="form-control"  id="ISBN" name="ISBN" placeholder="ISBN" required></div>
                <div class="col-md-6"> <label for="publicacion" class="form-label">Año de publicacion</label>
                <input type="text" class="form-control" name="publicacion" placeholder="Año de Publicacion" required></div>
                
                <div class="col-md-6"> <label for="paginas" class="form-label">Cantidad de Paginas</label>
                <input type="text" class="form-control" name="paginas" required></div>
            <%}
            else
            {
            if("Revista".equals(ParametrosGlobales.tipo)){
            %>
                <div class="col-md-6"> <label for="periodicidad" class="form-label">Periodicidad</label>
                <input type="text" class="form-control" name="periodicidad" required></div>
                <div class="col-md-6"> <label for="publicacion" class="form-label">Año de Publicacion</label>
                <input type="text" class="form-control" name="publicacion" required></div>
            <%}
else
if ("Obra".equals(ParametrosGlobales.tipo)){
%>               
                <div class="col-12"><label for="autor" class="form-label">Autor</label>
                <input type="text" class="form-control"  name="autor" placeholder="Autor del material" required></div>
                <div class="col-12"><label for="editorial" class="form-label">Editorial</label>
                <input type="text" class="form-control"  name="editorial" placeholder="Editorial" required></div>
                <div class="col-md-6"> <label for="publicacion" class="form-label">Año de publicacion</label>
                <input type="text" class="form-control" name="publicacion" required></div>
                <div class="col-md-6"> <label for="paginas" class="form-label">Cantidad de Paginas</label>
                <input type="text" class="form-control" name="paginas" required></div>


<%
}
else{
 if("CD".equals(ParametrosGlobales.tipo)){
%>
                <div class="col-12"><label for="autor" class="form-label">Cantante</label>
                <input type="text" class="form-control"  name="autor" placeholder="Cantante" required></div>
                <div class="col-12"><label for="paginas" class="form-label">Cantidad de Canciones</label>
                <input type="text" class="form-control"  name="paginas" placeholder="Cantidad de Canciones" required></div>
                <div class="col-12"><label for="genero" class="form-label">Genero</label>
                <input type="text" class="form-control"  name="genero" placeholder="Genero del CD" required></div>
                <div class="col-12"><label for="duracion" class="form-label">Duracion</label>
                <input type="text" class="form-control"  name="duracion" placeholder="Duracion" required></div>

<%}
  else{
            %>
            
                 <div class="col-12"><label for="autor" class="form-label">Director</label>
                <input type="text" class="form-control"  name="autor" placeholder="director" required></div>
                <div class="col-12"><label for="genero" class="form-label">Genero</label>
                <input type="text" class="form-control"  name="genero" placeholder="Genero del DVD" required></div>
                <div class="col-12"><label for="duracion" class="form-label">Duracion</label>
                <input type="text" class="form-control"  name="duracion" placeholder="Duracion" required></div>
            
            <%
            }
}
}%>

-------------------------------------------------------------------

-------------------------------------------------------------------

<div class="input-group">
    
                <div class="col-12"><label for="cantidad" class="form-label">Cantidad</label>
                <input type="text" class="form-control"  name="cantidad" placeholder="Cantidad a Ingresar" required></div>
                <div class="col-12"><label for="tiempo" class="form-label">Tiempo</label>
                <input type="text" class="form-control"  name="tiempo" placeholder="Duracion" required></div>
</div> 
<input type="hidden" name="titulo" value="${Material.titulo}">
<input type="hidden" name="catalogacion" value="${Material.catalogacion}">
<input type="hidden" name="tipo" value="${Material.tipo}">
<input type="hidden" name="r1" value="2">
<input type="hidden" name="operacion" value="1">
<div class="input-group">
    <P>
    </p><br>
    <div class="col-12"><input type="submit" class="btn btn-primary" name="boton" value="Agregar ${Material.tipo}"></div></div>
            </form></div></div>
    </body>
</html>
