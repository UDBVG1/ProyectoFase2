package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String pagembed=null;
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"es-lan\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"/docs/4.1/assets/img/favicons/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    <title>Dashboard Template for Bootstrap</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.1/examples/dashboard/\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"css/dashboard.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("    <nav class=\"navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow\">\r\n");
      out.write("      <a class=\"navbar-brand col-sm-3 col-md-2 mr-0\" href=\"#\">Biblioteca</a>\r\n");
      out.write("      <input class=\"form-control form-control-dark w-100\" type=\"text\" placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("      <ul class=\"navbar-nav px-3\">\r\n");
      out.write("        <li class=\"nav-item text-nowrap\">\r\n");
      out.write("          <a class=\"nav-link\" href=\"login.jsp\">Sign in</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <nav class=\"col-md-2 d-none d-md-block bg-light sidebar\">\r\n");
      out.write("          <div class=\"sidebar-sticky\">\r\n");
      out.write("            <ul class=\"nav flex-column\">\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                  <a class=\"nav-link active\" href=\"home.jsp\" target=\"opcion\">\r\n");
      out.write("                  <span data-feather=\"home\"></span>\r\n");
      out.write("                  Home <span class=\"sr-only\">(current)</span>\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                  <span data-feather=\"file\"></span>\r\n");
      out.write("                  Materiales\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"reservas.jsp\">\r\n");
      out.write("                  <span data-feather=\"shopping-cart\"></span>\r\n");
      out.write("                  Prestamos\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                  <a class=\"nav-link\" href=\"usuarioControl.jsp\" target=\"opcion\">\r\n");
      out.write("                  <span data-feather=\"users\"></span>\r\n");
      out.write("                  Usuarios\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                  <span data-feather=\"bar-chart-2\"></span>\r\n");
      out.write("                  Reports\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                  <span data-feather=\"layers\"></span>\r\n");
      out.write("                  Integrations\r\n");
      out.write("                </a>\r\n");
      out.write("              </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <main role=\"main\" class=\"col-md-9 ml-sm-auto col-lg-10 px-4\">\r\n");
      out.write("          <div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom\">\r\n");
      out.write("            <h1 class=\"h2\">Test</h1>\r\n");
      out.write("            <div class=\"btn-toolbar mb-2 mb-md-0\">\r\n");
      out.write("              <div class=\"btn-group mr-2\">\r\n");
      out.write("                <button class=\"btn btn-sm btn-outline-secondary\">Share</button>\r\n");
      out.write("                <button class=\"btn btn-sm btn-outline-secondary\">Export</button>\r\n");
      out.write("              </div>\r\n");
      out.write("              <button class=\"btn btn-sm btn-outline-secondary dropdown-toggle\">\r\n");
      out.write("                <span data-feather=\"calendar\"></span>\r\n");
      out.write("                This week\r\n");
      out.write("              </button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"embed-responsive embed-responsive-16by9\">\r\n");
      out.write("            <iframe class=\"embed-responsive-item\" name=\"opcion\" src=\"home.jsp\" frameborder=\"0\" allowfullscreen></iframe>\r\n");
      out.write("          </div>  \r\n");
      out.write("           <!-- <iframe class=\"embed-responsive-itemw-100\" name=\"opcion\" src=\"home.jsp\" frameborder=\"0\"></iframe>\r\n");
      out.write("          <!--<canvas class=\"my-4 w-100\" id=\"myChart\" width=\"900\" height=\"380\"></canvas> -->\r\n");
      out.write("          \r\n");
      out.write("        </main>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"js/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script>window.jQuery || document.write('<script src=\"js/jquery-slim.min.js\"><\\/script>')</script>\r\n");
      out.write("    <script src=\"js/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Icons -->\r\n");
      out.write("    <script src=\"js/feather.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("      feather.replace()\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Graphs -->\r\n");
      out.write("    <script src=\"js/Chart.min.js\"></script>\r\n");
      out.write("     <!--<script>\r\n");
      out.write("      var ctx = document.getElementById(\"myChart\");\r\n");
      out.write("      var myChart = new Chart(ctx, {\r\n");
      out.write("        type: 'line',\r\n");
      out.write("        data: {\r\n");
      out.write("          labels: [\"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\"],\r\n");
      out.write("          datasets: [{\r\n");
      out.write("            data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],\r\n");
      out.write("            lineTension: 0,\r\n");
      out.write("            backgroundColor: 'transparent',\r\n");
      out.write("            borderColor: '#007bff',\r\n");
      out.write("            borderWidth: 4,\r\n");
      out.write("            pointBackgroundColor: '#007bff'\r\n");
      out.write("          }]\r\n");
      out.write("        },\r\n");
      out.write("        options: {\r\n");
      out.write("          scales: {\r\n");
      out.write("            yAxes: [{\r\n");
      out.write("              ticks: {\r\n");
      out.write("                beginAtZero: false\r\n");
      out.write("              }\r\n");
      out.write("            }]\r\n");
      out.write("          },\r\n");
      out.write("          legend: {\r\n");
      out.write("            display: false,\r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("      });\r\n");
      out.write("    </script>-->\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
