/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entidad.*;
import Modelos.PrestamosCRUD;
import Utilidades.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
@WebServlet(name = "ControladorP", urlPatterns = {"/ControladorP"})
public class ControladorP extends HttpServlet {

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
                PrestamosCRUD prestamos = new PrestamosCRUD();
        	String op=request.getParameter("operacion");
//                int result=0;
            if(op.equals("material")){
//              response.sendRedirect("material.jsp"); //solo redireccionar
                RequestDispatcher rd=request.getRequestDispatcher("/material.jsp");
                rd.forward(request, response);//con datos                
            }else if(op.equals("reservaHecha")){
                // 3 alumno 1 admin 2 bibliotecario
                int resp=prestamos.insertarReserva(request.getParameter("codigo1"), 3);
                if(resp==0){
                JOptionPane.showMessageDialog(null, "Reserva Exitosa", "HECHO", JOptionPane.INFORMATION_MESSAGE);                    
                response.sendRedirect("Materiales.jsp"); 
                }
                else if(resp==1){
                JOptionPane.showMessageDialog(null, "Reserva Cancelada", "Cancelado", JOptionPane.INFORMATION_MESSAGE);      
                response.sendRedirect("Materiales.jsp"); 
                }
                else{
                response.sendRedirect("Materiales.jsp");   
                }
                //cambiar al nivel de usuario
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

    private String toString(String Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
