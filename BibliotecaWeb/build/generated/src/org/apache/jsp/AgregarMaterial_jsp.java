package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AgregarMaterial_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Agregar Material</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <div class=\"container\">\n");
      out.write("         <h1 align=\"center\"> Ingresar Nuevo Material </h1>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\"><div class=\"col-12\"> \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div></div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"col-md-6\">\n");
      out.write("        <form class=\"row g-3\" method=\"post\" action=\"Controlador\">\n");
      out.write("\n");
      out.write("         \n");
      out.write("        <div class=\"col-12\"><label for=\"titulo\" class=\"form-label\">Titulo</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"titulo\" placeholder=\"Titulo del material\"></div>\n");
      out.write("        <div class=\"col-12\"><label for=\"autor\" class=\"form-label\">Autor</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"autor\" placeholder=\"Autor del material\"></div>\n");
      out.write("        <div class=\"col-md-6\"> <label for=\"ubicacion\" class=\"form-label\">Ubicación</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\" name=\"ubicacion\"></div>\n");
      out.write("        <div class=\"col-12\"><button type=\"submit\" class=\"btn btn-primary\" name=\"boton\" value=\"Ingresar\">Ingresar</button></div></form></div></div>\n");
      out.write("        <div class=\"container\"><div class=\"col-12\"></div>\n");
      out.write("        <div class=\"col-md-4\"><label for=\"tipo\" class=\"form-label\">Tipo de Material</label>\n");
      out.write("        <select name=\"tipo\" class=\"form-select\">\n");
      out.write("            <option selected>Escoge...</option>\n");
      out.write("            <option>Libro ");
 int i=1; 
      out.write("</option>\n");
      out.write("            <option>Revista");
 i=2; 
      out.write("</option>\n");
      out.write("            <option>Obra ");
 i=3; 
      out.write("</option>\n");
      out.write("            <option>CD");
 i=4; 
      out.write("</option>\n");
      out.write("            <option>DVD");
 i=5; 
      out.write("</option>\n");
      out.write("        </select>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("            ");
 switch (i){
                case 1:
             
      out.write("\n");
      out.write("        <div class=\"col-12\"><label for=\"editorial\" class=\"form-label\">Editorial</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"editorial\" placeholder=\"Editorial\"></div>\n");
      out.write("        <div class=\"col-12\"><label for=\"ISBN\" class=\"form-label\">ISBN</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"autor\" placeholder=\"ISBN\"></div>\n");
      out.write("        <div class=\"col-md-6\"> <label for=\"publicacion\" class=\"form-label\">Año de publicacion</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\" name=\"publicacion\"></div>\n");
      out.write("        <div class=\"col-md-6\"> <label for=\"paginas\" class=\"form-label\">Cantidad de Paginas</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\" name=\"paginas\"></div>\n");
      out.write("        ");
 break;
        case 2:
        
      out.write("\n");
      out.write("               <div class=\"col-12\"><label for=\"editorial\" class=\"form-label\">Editorial</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"editorial\" placeholder=\"Editorial\"></div>\n");
      out.write("                <div class=\"col-12\"><label for=\"ISBN\" class=\"form-label\">ISBN</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"periodicidad\" placeholder=\"ISBN\"></div>\n");
      out.write("        <div class=\"col-md-6\"> <label for=\"publicacion\" class=\"form-label\">Año de publicacion</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\" name=\"publicacion\"></div>\n");
      out.write("        <div class=\"col-md-6\"> <label for=\"paginas\" class=\"form-label\">Cantidad de Paginas</label>\n");
      out.write("        ");
 break;
        default:
        } 
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
