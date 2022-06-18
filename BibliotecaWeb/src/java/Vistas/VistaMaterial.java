/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eveling Santos
 */
@WebServlet(name = "VistaMaterial", urlPatterns = {"/VistaMaterial"})
public class VistaMaterial extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("</head>");
            out.println("<body>");
              
            out.println("<h1> Materiales </h1>");
            
            out.println("<container>");
            out.println("<div class='col-sm'>");
            out.println("<div class=\"dropdown\"><button class=\"btn btn-secondary dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton2\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">");
            out.println("Materiales </button>");
            out.println("<ul class=\"dropdown-menu dropdown-menu-dark\" aria-labelledby=\"dropdownMenuButton2\">");
            out.println("<li><a class=\"dropdown-item active\" href=\"#\">Agregar Material</a></li>");
            out.println("<li><a class=\"dropdown-item\" href=\"#\">Mostrar Material</a></li>");
            out.println("<li><a class=\"dropdown-item\" href=\"#\">Borrar Material here</a></li>");
            out.println("<li><hr class=\"dropdown-divider\"></li>");
            out.println("<li><a class=\"dropdown-item\" href=\"#\">Regresar</a></li>");
            out.println("</ul></div>");
            out.println("</div>");
            out.println("</container>");
            /*
            out.println("<div class='container mt-5'> <div class=´row'>");
            out.println("<div class='col-sm'>");
            out.println( "<container><form method=\"#\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"Usuario\">Nombre</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"nombre\" name=\"nombre\" placeholder=\"Nombre\"></div>");
            out.println("<div class=\"form-group\">");            
            out.println("<label for=\"Password\">Direccion</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"direccion\" name=\"direccion\" placeholder=\"Direccion\"></div>");
            out.println("<button type=\"submit\" class=\"btn btn-primary\">Guardar <i class=\"fa fa-floppy-o\" aria-hidden=\"true\"></i></button></form></container></div></div></div>");
            
            +/
            /*Creación de tabla*/
            /*
            out.println("<div><p><table class=\"table\">");
            out.println("  <thead><tr><th scope=\"col\">#</th><th scope=\"col\">First</th><th scope=\"col\">Last</th><th scope=\"col\">Handle</th></tr></thead><tbody>");
             int j=100;
             int z=200;
             int b=300;
            for (int i=0; i<5 ; i++){
                out.println("<tr><th scope=\"row\">"+i+"</th><td>"+ j +"</td><td>"+ z +"</td><td>"+b+"</td></tr>");
                j++;
                z++;
                b++;
            }
            
            out.println("</tbody></table></div>");*/
            
            out.println("</body>");
            out.println("</html>");
            
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
    
    

}
