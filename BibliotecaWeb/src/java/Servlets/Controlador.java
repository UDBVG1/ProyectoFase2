/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidad.Audiovisual;
import Entidad.Escrito;
import Entidad.Material;
import Utilidades.ParametrosGlobales;
import Modelos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eveling Santos
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    
    public MaterialCRUDD NuevoMaterialCRUDD=new MaterialCRUDD();
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
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
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
         String  tipo, titulo, ubicacion;
         int i;
         int valor;
         PrintWriter out = response.getWriter();
         out.println("<html>");
         out.println("<head></head>");         
         out.println("<body>");
         
         tipo=titulo=ubicacion="";
         valor=Integer.parseInt(request.getParameter("operacion"));
         i=Integer.parseInt(request.getParameter("r1"));
         tipo=request.getParameter("tipo");
         out.println(tipo);
         switch (valor){
             case 1:            
                                if (i==1){
                                Material NuevoMaterial=new Material();
                                
                                NuevoMaterial.titulo=request.getParameter("titulo");
                                NuevoMaterial.catalogacion=request.getParameter("ubicacion");
                                NuevoMaterial.tipo=request.getParameter("tipo");
                                ParametrosGlobales.tipo=NuevoMaterial.getTipo();
                                ParametrosGlobales.tipoA=1;

                                request.setAttribute("Material", NuevoMaterial);
                                request.getRequestDispatcher("Form_agregarMaterial2.jsp").forward(request, response);                                                   
                            }
                            else{
                                    
                                    Escrito NuevoEscrito=new Escrito();
                                    Audiovisual NuevoAudio=new Audiovisual();
                                    MaterialCRUDD Nmaterial=new MaterialCRUDD();
                                    tipo=Nmaterial.PreparacionTipo(request.getParameter("tipo"));
                                    out.println(tipo);
                                    String codigo="";
                                    
                                    if ("LIB".equals(tipo) || "OBR".equals(tipo) || "REV".equals(tipo)){
                                    NuevoEscrito.setTitulo(request.getParameter("titulo"));
                                    NuevoEscrito.setCatalogacion(request.getParameter("catalogacion"));                                   
                                    NuevoEscrito.tipo=tipo;
                                    if (request.getParameter("cantidad")!=null){
                                    NuevoEscrito.setCantTotal(Integer.parseInt(request.getParameter("cantidad")));
                                    NuevoEscrito.CantDisp=NuevoEscrito.getCantTotal();
                                    }
                                    else{
                                        NuevoEscrito.CantTotal=0;
                                    }
                                    
                                    if (request.getParameter("tiempo")!=null){
                                     NuevoEscrito.setTiempo(Integer.parseInt(request.getParameter("tiempo")));   
                                    }
                                    else{
                                        NuevoEscrito.tiempo=0;
                                    }
                                    
                                    
                                    }
                                    else
                                    {
                                    NuevoAudio.setTitulo(request.getParameter("titulo"));
                                    NuevoAudio.setCatalogacion(request.getParameter("catalogacion"));                                   
                                    NuevoAudio.tipo=tipo;
                                    if (request.getParameter("cantidad")!=null){
                                    NuevoAudio.setCantTotal(Integer.parseInt(request.getParameter("cantidad")));
                                    NuevoAudio.CantDisp=NuevoEscrito.getCantTotal();
                                    }
                                    else{
                                        NuevoAudio.CantTotal=0;
                                    }
                                    
                                    if (request.getParameter("tiempo")!=null){
                                     NuevoAudio.setTiempo(Integer.parseInt(request.getParameter("tiempo")));   
                                    }
                                    else{
                                        NuevoAudio.tiempo=0;
                                    }
                                    }
                                    switch(tipo){
                                            case "LIB":
                                                 if (request.getParameter("autor")!=null){
                                                    NuevoEscrito.setAutor(request.getParameter("autor"));}
                                                if (request.getParameter("editorial")!=null){
                                                NuevoEscrito.setEditorial(request.getParameter("editorial"));}
                                                if (request.getParameter("ISBN")!=null){
                                                NuevoEscrito.setISBN(Integer.parseInt(request.getParameter("ISBN")));}
                                                else
                                                {
                                                    NuevoEscrito.ISBN=0;
                                                }
                                                if (request.getParameter("paginas")!=null){
                                                NuevoEscrito.setNumPaginas(Integer.parseInt(request.getParameter("paginas")));}
                                                else{
                                                    NuevoEscrito.numPaginas=0;
                                                }
                                                codigo=Nmaterial.InsertarEscrito(NuevoEscrito);
                                                break;
                                            case "REV":
                                                    if (request.getParameter("periodicidad")!=null){
                                                   NuevoEscrito.setPeriodicidad(request.getParameter("periodicidad"));
                                                   }
                                                   if (request.getParameter("publicacion")!=null){
                                                   NuevoEscrito.setFechaPubli(Integer.parseInt(request.getParameter("publicacion")));
                                                   }
                                                   else{
                                                   NuevoEscrito.fechaPubli=0;
                                                   }
                                                   codigo=Nmaterial.InsertarEscrito(NuevoEscrito);
                                                   break;
                                            case "OBR":
                                    
                                                if (request.getParameter("autor")!=null){
                                                    NuevoEscrito.setAutor(request.getParameter("autor"));}
                                                if (request.getParameter("editorial")!=null){
                                                NuevoEscrito.setEditorial(request.getParameter("editorial"));}
                                                if (request.getParameter("paginas")!=null){
                                                NuevoEscrito.setNumPaginas(Integer.parseInt(request.getParameter("paginas")));}
                                                else{
                                                    NuevoEscrito.numPaginas=0;
                                                }
                                                codigo=Nmaterial.InsertarEscrito(NuevoEscrito);
                                                break;
                                            case "CDA":
                                                if (request.getParameter("autor")!=null){
                                                    NuevoAudio.setAutor(request.getParameter("autor"));}
                                                if (request.getParameter("genero")!=null){
                                                    NuevoAudio.setGenero(request.getParameter("genero"));
                                                }
                                                if (request.getParameter("paginas")!=null){
                                                    NuevoAudio.setNumCanciones(Integer.parseInt(request.getParameter("paginas")));
                                                }
                                                else{
                                                    NuevoAudio.numCanciones=0;
                                                }
                                                if (request.getParameter("duracion")!=null){
                                                    NuevoAudio.setGenero(request.getParameter("duracion"));
                                                }
                                              codigo=Nmaterial.InsertarAudio(NuevoAudio);
                                              break;
                                            case "DVD":
                                                if (request.getParameter("autor")!=null){
                                                    NuevoAudio.setAutor(request.getParameter("autor"));}
                                                if (request.getParameter("genero")!=null){
                                                    NuevoAudio.setGenero(request.getParameter("genero"));
                                                }
                                                if (request.getParameter("duracion")!=null){
                                                    NuevoAudio.setGenero(request.getParameter("duracion"));
                                                }
                                              codigo=Nmaterial.InsertarAudio(NuevoAudio);
                                                break;
                                            default:
                                    }
                                }
                            break;
             case 2:
                 
                 break;
             default:
         }


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
    /*
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
  
    
    

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

}
