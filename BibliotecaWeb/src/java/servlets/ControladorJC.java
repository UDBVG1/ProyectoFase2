/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entidad.Usuario;
import Modelos.UsuariosCRUD;
import Utilidades.Conexion;
import Utilidades.ParametrosGlobales;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


/**
 *
 * @author Rafael
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class ControladorJC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        	String op=request.getParameter("operacion");
                int result=0;
            if(op.equals("principal")){
                verificar(request,response);
            }else if(op.equals("grabar")){
                Conexion oper= new Conexion();
                RequestDispatcher rd=request.getRequestDispatcher("/inicio.jsp");
                rd.forward(request, response);
            }else if(op.equals("crear")){
                crear(request,response);
            }else if(op.equals("ver")){
                Conexion oper= new Conexion();
                /*ArrayList mensajes=oper.obtenerMensajes(request.getParameter("nombre"));
                request.setAttribute("mensajes", mensajes);
                RequestDispatcher rd=request.getRequestDispatcher("/ver.jsp");
                rd.forward(request, response);*/
           }
           
        }
    }  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session;
        UsuariosCRUD crud;
        crud = new UsuariosCRUD();
        Usuario datos = crud.usuarioAcceso(request.getParameter("username"),request.getParameter("password"));
        System.out.println(datos.getIdUs());
        ParametrosGlobales.setGlobalAccesId(datos.getIdUs());
        ParametrosGlobales.setGlobalUser(datos.getNombre());
        ParametrosGlobales.setGlobalAccesNivel(datos.getNivel());
        System.out.println(ParametrosGlobales.getGlobalAccesNivel());
        if (datos !=null && datos.getNivel()==1){
            session=request.getSession();
            session.setAttribute("usuario", datos.getUsuario());
            request.setAttribute("msje", "Ingreso Aceptado");
            this.getServletConfig().getServletContext().getRequestDispatcher("/principal.jsp").forward(request, response);
        }else{
            request.setAttribute("msje", "Credenciales Incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        //response.sendRedirect("principal.jsp");
    }

    private Usuario obtenerDatos(HttpServletRequest request) {
        Usuario u = new Usuario();
        u.setUsuario(request.getParameter("username"));
        u.setClave(request.getParameter("password"));
        return u;
    }

    private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuariosCRUD crud = new UsuariosCRUD();
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre")+" "+request.getParameter("apellido"));
        usuario.setUsuario(request.getParameter("username"));
        usuario.setNivel(Integer.parseInt(request.getParameter("nivel")));
        usuario.setIdentificador(request.getParameter("identifcacion"));
        if(request.getParameter("password").equals(request.getParameter("passwordC"))){
            usuario.setClave(request.getParameter("password"));
            int rows = crud.insertarUsuario(usuario);
            this.getServletConfig().getServletContext().getRequestDispatcher("/principal.jsp").forward(request, response);
            JOptionPane.showMessageDialog(null, rows+" Usuario Ingresado", "Completado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Contraseña no coinciden", "Incompletado", JOptionPane.WARNING_MESSAGE);
        }
    }
}
