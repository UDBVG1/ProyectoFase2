package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.*;
import Modelos.*;
import java.util.*;

public final class Form_005fIngresoMaterial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>    \r\n");
      out.write("        <title>Tabla de Materiales</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <h1>Ingreso Realizado</h1>\r\n");
      out.write("        ");
  
            MaterialCRUDD nuevo=new MaterialCRUDD();
            List<List<String>> lista=nuevo.listarMateriales();
        
      out.write("\r\n");
      out.write("        <div class=\"container-sm\">\r\n");
      out.write("         <table class=\"table\">\r\n");
      out.write("  <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th scope=\"col\">Codigo</th>\r\n");
      out.write("      <th scope=\"col\">Nombre</th>\r\n");
      out.write("      <th scope=\"col\">Cantidad Total</th>\r\n");
      out.write("      <th scope=\"col\">Cantidad Disponible</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </thead>\r\n");
      out.write("         ");
 for(int i=0;i<lista.size();i++){
            
      out.write("\r\n");
      out.write("  <tbody>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th scope=\"row\">");
      out.print(lista.get(i).get(0));
      out.write("</th>\r\n");
      out.write("      <td>");
      out.print(lista.get(i).get(1));
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(lista.get(i).get(2));
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(lista.get(i).get(3));
      out.write("</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");
}
      out.write("\r\n");
      out.write("  </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("        \r\n");
      out.write("        </div>\r\n");
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
