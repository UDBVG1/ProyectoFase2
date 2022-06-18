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
     <div class="container">
         <h1 align="center"> Buscar Material </h1>
    </div>
    <div class="container"><div class="col-12"> 
        
    </div></div>
    <div class="container">
        <div class="col-md-6">
        <form class="row g-3" method="post" action="Prueba">

        <div class="col-12"><label for="codigo" class="form-label">Codigo</label>
        <input type="text" class="form-control" name="codigo" placeholder="Ingresar Codigo" ></div>
        <div class="col-12"><label for="titulo" class="form-label">Titulo</label>
        <input type="text" class="form-control"  name="titulo" placeholder="Ingrese Titulo" ></div>
        <div class="col-12"><label for="autor" class="form-label">Autor</label>
        <input type="text" class="form-control"  name="autor" placeholder="Ingresar Autor" ></div>
        <input type="hidden" name="operacion" value="3">
        <input type="hidden" name="r1" value="1">
        <div class="col-12"><button type="submit" class="btn btn-primary" value="Buscar">Buscar</button></div></form></div></div>
        <div class="container"><div class="col-12"></div>
    </body>
</html>
