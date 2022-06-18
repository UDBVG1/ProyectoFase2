package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Form_005fagregarMaterial1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n");
      out.write("<title>Agregar Material</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <div class=\"container\">\n");
      out.write("         <h1 align=\"center\"> Ingresar Nuevo Material </h1>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\"><div class=\"col-12\"> \n");
      out.write("        \n");
      out.write("    </div></div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"col-md-6\">\n");
      out.write("        <form class=\"row g-3\" method=\"post\" action=\"Controlador\">\n");
      out.write("            <div><select class=\"form-select\" aria-label=\"Tipo de Material\" name=\"tipo\" required>\n");
      out.write("            <option selected disabled value=\"\">Escoger Tipo de Material</option>\n");
      out.write("            <option value=\"Libro\">Libro</option>\n");
      out.write("            <option value=\"Revista\">Revista</option>\n");
      out.write("            <option value=\"Obra\">Obra</option>\n");
      out.write("            <option value=\"CD\">CD</option>\n");
      out.write("            <option value=\"DVD\">DVD</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"col-12\"><label for=\"titulo\" class=\"form-label\">Titulo</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"titulo\" placeholder=\"Titulo del material\" required></div>\n");
      out.write("        <div class=\"col-md-6\"> <label for=\"ubicacion\" class=\"form-label\">Ubicación</label>\n");
      out.write("        <input type=\"text\" class=\"form-control\" name=\"ubicacion\" placeholder=\"Ubicación dentro de la Biblioteca\" required></div> \n");
      out.write("        <input type=\"hidden\" name=\"operacion\" value=\"1\">\n");
      out.write("        <input type=\"hidden\" name=\"r1\" value=\"1\">\n");
      out.write("        <div class=\"col-12\"><button type=\"submit\" class=\"btn btn-primary\" value=\"Siguiente\">Siguiente</button></div></form></div></div>\n");
      out.write("        <div class=\"container\"><div class=\"col-12\"></div>\n");
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
