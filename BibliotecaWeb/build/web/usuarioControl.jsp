<%-- 
    Document   : usuarioControl
    Created on : 17-jun-2022, 23:24:15
    Author     : amgoo
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Utilidades.ParametrosGlobales"%>
<%@page import="Entidad.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.UsuariosCRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    UsuariosCRUD dao;
    Usuario user = null;
    if (request.getParameter("txtNombre") != null) {
        user = new Usuario();
        user.setNombre(request.getParameter("txtNombre"));
        if (request.getParameter("chkVigencia") != null && request.getParameter("chkVigencia") == "Administrador") {
            user.setNivel(1);
        } else if (request.getParameter("chkVigencia") != null && request.getParameter("chkVigencia") == "Encargado"){
            user.setNivel(2);
        }
        dao = new UsuariosCRUD();
        try {
            int row = dao.insertarUsuario(user);
            JOptionPane.showMessageDialog(null, row+" Usuario Ingresado", "Completado", JOptionPane.INFORMATION_MESSAGE);
            response.sendRedirect("Categorias.jsp");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar", "Incompleto", JOptionPane.WARNING_MESSAGE);
            if (e != null && e.getMessage() != null) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Incompleto", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Valores nulo", "Incompleto", JOptionPane.WARNING_MESSAGE);
            }
        } finally {
            dao = null;
        }
    }
%>
<!DOCTYPE html>
<html lang="es-lan">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
</head>


<body>
    <div id="login">
        <h3 class="text-center text-info pt-5">Control de Usuario</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-auto">
                    <div id="login-box" class="col-md-auto">
                        <form id="login-form" action="Controlador?operacion=crear" method="post">
                            <!--<h3 class="text-center text-info">Usuarios</h3>-->
                            <div class="form-row">
                                <div class="col">
                                    <label for="nombre" class="text-info">Nombre:</label><br>
                                    <input type="text" name="nombre" id="nombre" class="form-control" >
                                </div>
                                <div class="col">
                                    <label for="apellido" class="text-info">Apellido:</label><br>
                                    <input type="text" name="apellido" id="apelido" class="form-control" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="username" class="text-info">Usuario:</label><br>
                                <input type="text" name="username" id="username" class="form-control" required>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label for="password" class="text-info">Contraseña:</label><br>
                                    <input type="text" name="password" id="password" class="form-control" required>
                                </div>
                                <div class="col">
                                    <label for="passwordC" class="text-info">Confirmar Contraseña:</label><br>
                                    <input type="text" name="passwordC" id="passwordC" class="form-control">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-sm-6">
                                    <label for="nivel" class="text-info">Nivel</label>
                                    <select name="nivel" id="nivel" class="form-control" required>
                                      <option selected>Elegir...</option>
                                      <option value="1">Administrador</option>
                                      <option value="2">Encargado</option>
                                      <option value="3">Usuario</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="identifcacion" class="text-info">Identificacion</label>
                                    <select name="identifcacion" id="identifcacion" class="form-control">
                                        <option value="" selected>Elegir...</option>
                                      <option value="maestro">Maestro</option>
                                      <option value="alumno">Alumno</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="btn1" type="submit" class="btn btn-info btn-md" value="Completar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <h1>Listado de Usuarios</h1>
                <div class="table-responsive">                                 
                    <table class="table table-hover table-striped table-bordered">
                        <thead class="btn-info">
                            <tr>
                                <th class="text-center">N°</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Nivel</th>
                                <th class="text-center">Acciones</th>              
                            </tr>
                        </thead>  
                        <%
                            UsuariosCRUD daocate = new UsuariosCRUD();
                            List<Usuario> usuario = null;
                            int i = 1;

                            try {
                                usuario = daocate.usuariosLista(ParametrosGlobales.getGlobalAccesNivel());
                                for (Usuario usu : usuario) {
                                %>
                                    <tr>
                                    <td><%=i%></td>
                                    <td> <%=usu.getNombre()%></td>
                                    <td><%=usu.getNivel()%></td>
                                    <td class=text-center><a class="btn btn-warning btn-sm" href="editarcategoria.jsp?cod="
                                            <%=usu.getIdUs()%>> Editar</a></td>
                                    </tr>
                                    <%
                                    i++;
                                
                                }

                            } catch (Exception e) {
                                out.print("<tr><td colspan=\"3\">"
                                        + e.getMessage() + "No se pudo listar las categorias</td></tr>");
                            } finally {
                                dao = null;
                                if (usuario != null) {
                                    usuario.clear();
                                }
                                usuario = null;
                            }
                        %>                                                          
                        <!-- <a class="icon-pencil2" data-toggle="tooltip" data-placement="right" title="Editar" href="Controlador"></a>
                        </td>-->
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
