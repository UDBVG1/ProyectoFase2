/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entidad.Usuario;
import Modelos.UsuariosCRUD;
import Utilidades.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
//import javabeans.MensajeBean;
import javax.servlet.RequestDispatcher;
//import modelo.*;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

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
//                MensajeBean men=(MensajeBean) request.getAttribute("mensaje");
                Conexion oper= new Conexion();

//                if (oper.grabaMensaje(men)){
//                    request.setAttribute("result","ok");
//                }

                RequestDispatcher rd=request.getRequestDispatcher("/inicio.jsp");
                rd.forward(request, response);
            }else if(op.equals("muestra")){
                response.sendRedirect("mostrar.jsp");
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

    private void verificar(HttpServletRequest request, HttpServletResponse response) {
        UsuariosCRUD crud;
        Usuario usuario;
        usuario=this.obtenerDatos(request);
        //response.sendRedirect("principal.jsp");
    }

    private Usuario obtenerDatos(HttpServletRequest request) {
        Usuario u = new Usuario();
        u.setNombre(request.getParameter("username"));
        u.setClave(request.getParameter("password"));
        return u;
    }

}
