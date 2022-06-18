package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Form_005fBuscarMaterial_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("   <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>    \r\n");
      out.write("        </head>\r\n");
      out.write("    <body>\r\n");
      out.write("     <div class=\"container\">\r\n");
      out.write("         <h1 align=\"center\"> Gestion de Material </h1>\r\n");
      out.write("         ");
String Msj; 
      out.write("\r\n");
      out.write("         \r\n");
      out.write("            ");
Msj=request.getParameter("Mensaje");
            if(request.getParameter("Mensaje")=="Ingreso Exitoso"){
      out.write("\r\n");
      out.write("         <div class=\"alert alert-primary\" role=\"alert\">\r\n");
      out.write("             ");
      out.print(request.getParameter("Mensaje"));
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("         ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"container-sm\">\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("            <button class=\"btn btn-secondary dropdown-toggle\" type=\"button\" id=\"Materiales\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              Gestion de Materiales\r\n");
      out.write("            </button>\r\n");
      out.write("            <ul class=\"dropdown-menu\" aria-labelledby=\"Materiales\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"Form_agregarMaterial1.jsp\">Agregar Material</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"Form_BMaterial.jsp\">Buscar Material</a></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"Form_IngresoMaterial.jsp\">Mostrar Material</a></li>\r\n");
      out.write("              <li><hr class=\"dropdown-divider\"></li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"principal.jsp\">Regresar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("    </div></div>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("    <div class=\"container\"><div class=\"col-12\"> \r\n");
      out.write("        \r\n");
      out.write("    </div></div>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"col-md-6\">\r\n");
      out.write("        <form class=\"row g-3\" method=\"post\" action=\"Prueba\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-12\"><label for=\"codigo\" class=\"form-label\">Buscar por Codigo</label>\r\n");
      out.write("        <input type=\"text\" class=\"form-control\"  name=\"codigo\" placeholder=\"Ingresar Codigo\" required></div>\r\n");
      out.write("        <input type=\"hidden\" name=\"operacion\" value=\"2\">\r\n");
      out.write("        <input type=\"hidden\" name=\"r1\" value=\"1\">\r\n");
      out.write("        <div class=\"col-12\"><button type=\"submit\" class=\"btn btn-primary\" value=\"Buscar\">Buscar</button></div></form></div></div>\r\n");
      out.write("        <div class=\"container\"><div class=\"col-12\"></div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
