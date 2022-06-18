package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Reserva;
import java.util.ArrayList;
import Modelos.PrestamosCRUD;

public final class reservas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

    
        PrestamosCRUD mostrar5 = new PrestamosCRUD();
        ArrayList<Reserva> reservas = mostrar5.reservas();        
         
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css\" integrity=\"sha384-zIaWifL2YFF1qaDiAo0JFgsmasocJ/rqu7LKYH8CoBEXqGbb9eO+Xi3s6fQhgFWM\" crossorigin=\"anonymous\">\n");
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>RESERVAS</h1>\n");
      out.write("        <div id='list'>\n");
      out.write("        ");
      out.write("\n");
      out.write("      <table class=\"table table-striped\">\n");
      out.write("  <thead class=\"thead-light\">\n");
      out.write("    <tr>\n");
      out.write("      <th colspan = \"3\">LIBROS</th>\n");
      out.write("      <th>\n");
      out.write("          <i class=\"fa fa-plus-square-o\" aria-hidden=\"true\"></i>\n");
      out.write("      </th>\n");
      out.write("    </tr>  \n");
      out.write("  </thead>\n");
      out.write("  \n");
      out.write("  <tbody>\n");
      out.write("    \n");
      out.write("    ");
for(Reserva r : reservas){
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print(r.getId());
      out.write("</td> \n");
      out.write("        <td>");
      out.print(r.getCodigo());
      out.write("</td>\n");
      out.write("        <td>");
      out.print(r.getCodigo());
      out.write("</td>\n");
      out.write("        <td>");
      out.print(r.getTitulo());
      out.write("</td>\n");
      out.write("        <td>");
      out.print(r.getAutor());
      out.write("</td>    \n");
      out.write("        <td>");
      out.print(r.getEstado());
      out.write("</td>    \n");
      out.write("        <td>");
      out.print(r.getUsuario());
      out.write("</td>    \n");
      out.write("        <td>\n");
      out.write("            <a href=\"ControladorP?operacion=prestamo&codigo2=");
      out.print(r.getCodigo());
      out.write("&id=");
      out.print(r.getId());
      out.write("\">Prestar</a>\n");
      out.write("            <a href=\"ControladorP?operacion=devolucion&codigo2=");
      out.print(r.getCodigo());
      out.write("&id=");
      out.print(r.getId());
      out.write("\">Devolver</a>\n");
      out.write("        </td>\n");
      out.write("    </tr>    \n");
      out.write("    ");
}
      out.write("   \n");
      out.write("    \n");
      out.write("    </tbody>\n");
      out.write("    </table>   \n");
      out.write("          \n");
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
