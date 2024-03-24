package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminstatistic_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/head.jsp", out, false);
      out.write("\n");
      out.write("        <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/adminheader.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"container pt-4\">\n");
      out.write("                <!--Section: Statistics with subtitles-->\n");
      out.write("                <section>\n");
      out.write("                    <div class=\"row\" id=\"total\">\n");
      out.write("                        <div class=\"col-xl-6 col-md-12 mb-4\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div style=\"padding: 10px 15px\">\n");
      out.write("                                    <div class=\"d-flex justify-content-between p-md-1\">\n");
      out.write("                                        <div class=\"d-flex flex-row\">\n");
      out.write("                                            <div class=\"align-self-center\">\n");
      out.write("                                                <i style=\"color: #1B813A; font-size: 50px\" class=\"fa-solid fa-boxes-stacked\"></i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div style=\"text-align: end\">\n");
      out.write("                                            <h4 style=\"color: #1B813A\">Total Products</h4>\n");
      out.write("                                            <p class=\"mb-0\"></p>\n");
      out.write("                                            <h2 class=\"h1 mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.countProduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-6 col-md-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div style=\"padding: 10px 15px\">\n");
      out.write("                                <div class=\"d-flex justify-content-between p-md-1\">\n");
      out.write("                                    <div class=\"d-flex flex-row\">\n");
      out.write("                                        <div class=\"align-self-center\">\n");
      out.write("                                            <i style=\"color: #06439F; font-size: 50px\" class=\"fa-solid fa-truck-fast\"></i>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div style=\"text-align: end\"> \n");
      out.write("                                        <h4 style=\"color: #06439F;\">Number of products sold</h4>\n");
      out.write("                                        <p class=\"mb-0\"></p>\n");
      out.write("                                        <h2 class=\"h1 mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.sumquantitySold}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2> \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xl-6 col-md-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div style=\"padding: 10px 15px\">\n");
      out.write("                                <div class=\"d-flex justify-content-between p-md-1\">\n");
      out.write("                                    <div class=\"d-flex flex-row\">\n");
      out.write("                                        <div class=\"align-self-center\">\n");
      out.write("                                            <i style=\"color: #E94644; font-size: 50px\"  class=\"fa-solid fa-money-bill\"></i>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div style=\"text-align: end\">\n");
      out.write("                                        <h4 style=\"color: #E94644;\">Total Sales</h4>\n");
      out.write("                                        <p class=\"mb-0\"></p>\n");
      out.write("                                        <h2 class=\"h1 mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.totalmoneyAll}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("$</h2>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-6 col-md-12 mb-4\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div style=\"padding: 10px 15px\">\n");
      out.write("                                <div class=\"d-flex justify-content-between p-md-1\">\n");
      out.write("                                    <div class=\"d-flex flex-row\">\n");
      out.write("                                        <div class=\"align-self-center\">\n");
      out.write("                                            <i style=\"color: #06439F; font-size: 50px\" class=\"fa-solid fa-users\"></i>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div style=\"text-align: end\">\n");
      out.write("                                        <h4 style=\"color: #06439F;\">Total Users</h4>\n");
      out.write("                                        <p class=\"mb-0\"></p>\n");
      out.write("                                        <h2 class=\"h1 mb-0\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.countUser}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!--Section: Statistics with subtitles-->\n");
      out.write("        </div>\n");
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
