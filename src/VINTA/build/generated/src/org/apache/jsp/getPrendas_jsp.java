package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.tienda.Prenda;
import Modelo.tienda.db.DBPrenda;
import java.util.ArrayList;

public final class getPrendas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<title>Productos</title>\n");
      out.write("<link rel=\"stylesheet\"  href=\"css/login.css\"> \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write(" <br/>\n");
      out.write("\n");
      out.write("<form action=\"MostrarTodasPrendas\" method=\"post\">\n");
      out.write("\n");
      out.write("        <form action=\"/VINTA/MostrarTodasPrendas\" method=\"post\">\n");
      out.write("            \n");
      out.write("            <select name=\"opciones\">\n");
      out.write("                <option values =\"1\">Todas</option>\n");
      out.write("                <option values =\"2\">Ninguna</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"Seleccionar\"/>\n");
      out.write("            \n");
      out.write("     ");
 
                ArrayList<Prenda> lista = (ArrayList<Prenda>) request.getAttribute("lista");
            
      out.write("\n");
      out.write("            <select name=\"Coleccion\" >\n");
      out.write("                ");
 for(Prenda p: lista){ 
                
      out.write("\n");
      out.write("                <option values =");
      out.print( p.getIdString() );
      out.write('>');
      out.write(' ');
      out.print( p.getFotos().get(0) );
      out.write(" </option>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("    \n");
      out.write("</body>\n");
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
