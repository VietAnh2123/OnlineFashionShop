package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changeinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/head.jsp", out, false);
      out.write("\n");
      out.write("        <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/preloader.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Breadcrumb Section Begin -->\n");
      out.write("            <section class=\"breadcrumb-option\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"breadcrumb__text\">\n");
      out.write("                                <h4>Đăng Ký Tài Khoản</h4>\n");
      out.write("                                <div class=\"breadcrumb__links\">\n");
      out.write("                                    <span>Đăng Ký</span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!-- Breadcrumb Section End -->\n");
      out.write("\n");
      out.write("            <section class=\"checkout spad\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"checkout__form\">\n");
      out.write("                        <form action=\"register\" method=\"POST\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-8 col-md-6\">\n");
      out.write("<!--                                    <h4>Tài Khoản</h4>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-lg-6\">\n");
      out.write("                                            <div class=\"checkout__input\">\n");
      out.write("                                                <p>Tên Đăng Nhập<span>*</span></p>\n");
      out.write("                                                <input type=\"text\" name=\"username\" required=\"\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"checkout__input\">\n");
      out.write("                                                <p>Mật Khẩu<span>*</span></p>\n");
      out.write("                                                <input type=\"password\" name=\"password\" id=\"password\" required=\"\">\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"checkout__input\">\n");
      out.write("                                                <p>Nhập lại Mật Khẩu<span>*</span></p>\n");
      out.write("                                                <input type=\"password\" name=\"confirmPassword\" id=\"confirmPassword\" onkeyup=\"kiemTraMatKhau()\" required=\"\">\n");
      out.write("                                                <p><span id=\"msg\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></p>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>-->\n");
      out.write("                                    <h4>Thông tin Khách Hàng</h4>\n");
      out.write("                                    <div class=\"checkout__input\">\n");
      out.write("                                        <p>Họ Và Tên<span>*</span></p>\n");
      out.write("                                        <input type=\"text\" name=\"fullName\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"checkout__input\">\n");
      out.write("                                        <p>Địa Chỉ<span>*</span></p>\n");
      out.write("                                        <input type=\"text\" name=\"address\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        <div class=\"col-lg-6\">\n");
      out.write("                                            <div class=\"checkout__input\">\n");
      out.write("                                                <p>Số điện thoại<span>*</span></p>\n");
      out.write("                                                <input type=\"text\" name=\"phoneNumber\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-lg-6\">\n");
      out.write("                                            <div class=\"checkout__input\">\n");
      out.write("                                                <p>Email<span>*</span></p>\n");
      out.write("                                                <input type=\"email\" name=\"email\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-lg-6\">\n");
      out.write("                                            <div class=\"checkout__input\">\n");
      out.write("                                                <p>Gender<span>*</span></p>\n");
      out.write("                                                <select name=\"gender\" required=\"\">\n");
      out.write("                                                    <option>---</option>\n");
      out.write("                                                    <option value=\"Nữ\">Nữ</option>\n");
      out.write("                                                    <option value=\"Nam\">Nam</option>\n");
      out.write("                                                </select>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-md-6 mt-3\">\n");
      out.write("                                    <div class=\"\">\n");
      out.write("                                        <button type=\"submit\" class=\"site-btn\">Tạo Tài Khoản</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!-- Checkout Section End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/footer.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/jsplugins.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("<!--    <script>\n");
      out.write("        function kiemTraMatKhau() {\n");
      out.write("            password = document.getElementById(\"password\").value;\n");
      out.write("            confirmPassword = document.getElementById(\"confirmPassword\").value;\n");
      out.write("\n");
      out.write("            if (password != confirmPassword) {\n");
      out.write("                document.getElementById(\"msg\").innerHTML = \"Mật khẩu không khớp!\";\n");
      out.write("                return false;\n");
      out.write("            } else {\n");
      out.write("                document.getElementById(\"msg\").innerHTML = \"\";\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>-->\n");
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
