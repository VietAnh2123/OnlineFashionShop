package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <style>\n");
      out.write("        .require{\n");
      out.write("            color: red;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/head.jsp", out, false);
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/navigation.jsp", out, false);
      out.write("\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <form action=\"register\" method=\"POST\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"register\">\n");
      out.write("                    <h1 class=\"text-center mt-5\">THÔNG TIN ĐĂNG KÝ</h1>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <h3>TÀI KHOẢN</h3> \n");
      out.write("                            <label class=\"form-label\" for=\"username\">Tên đăng nhập</label><span class=\"require\">*</span>\n");
      out.write("                            <input class=\"form form-control\" type=\"text\" name=\"username\" id=\"username\" required > \n");
      out.write("\n");
      out.write("                            <label class=\"form-label\" for=\"password\">Mật khẩu</label><span class=\"require\">*</span>\n");
      out.write("                            <input class=\"form form-control\" type=\"password\" name=\"password\" id=\"password\" required onkeyup=\"kiemTraMatKhau()\">\n");
      out.write("\n");
      out.write("                            <label class=\"form-label\" for=\"confirmPassword\">Nhập lại mật khẩu</label><span class=\"require\">*</span>\n");
      out.write("                            <input class=\"form form-control\" type=\"password\" name=\"confirmPassword\" id=\"confirmPassword\" onchange=\"kiemTraMatKhau()\">\n");
      out.write("                            <span class=\"require\" id=\"msg\"></span>\n");
      out.write("\n");
      out.write("                            <h3 class=\"mt-3\">THÔNG TIN KHÁCH HÀNG</h3>\n");
      out.write("\n");
      out.write("                            <label class=\"form-label\" for=\"fullName\">Họ và Tên</label>\n");
      out.write("                            <input class=\"form form-control\" type=\"text\" name=\"fullName\" id=\"hoVaTen\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                        <label class=\"form-label\" for=\"gender\">Giới tính</label>\n");
      out.write("                        <select class=\"form form-control\" name=\"gender\" id=\"gioiTinh\">\n");
      out.write("                            <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.gender}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></option>\n");
      out.write("                            <option value=\"Nam\">Nam</option>\n");
      out.write("                            <option value=\"Nữ\">Nữ</option>\n");
      out.write("                        </select>\n");
      out.write("\n");
      out.write("                        <label class=\"form-label\" for=\"dob\">Ngày Sinh</label>\n");
      out.write("                        <input class=\"form form-control\" type=\"date\" name=\"dob\" id=\"dob\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.dob}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("\n");
      out.write("                        <h3>ĐỊA CHỈ</h3>\n");
      out.write("\n");
      out.write("                        <label class=\"form-label\" class=\"\" for=\"address\">Địa chỉ khách hàng</label>\n");
      out.write("                        <input class=\"form form-control\" type=\"text\" name=\"address\" id=\"address\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                        <label class=\"form-label\" class=\"\" for=\"phoneNumber\">Số điện thoại</label>\n");
      out.write("                        <input class=\"form form-control\" type=\"text\" name=\"phoneNumber\" id=\"phoneNumber\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                        <label class=\"form-label\" class=\"\" for=\"email\">Email</label>\n");
      out.write("                        <input class=\"form form-control\" type=\"email\" name=\"email\" id=\"email\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <div class=\"require\" id=\"baoLoi\">\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <input class=\"btn btn-secondary form-control\" type=\"submit\" name=\"submit-btn\" id=\"submit-btn\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function kiemTraMatKhau() {\n");
      out.write("            matKhau = document.getElementById(\"password\").value;\n");
      out.write("            matKhauNhapLai = document.getElementById(\"confirmPassword\").value;\n");
      out.write("\n");
      out.write("            if (matKhau != matKhauNhapLai) {\n");
      out.write("                document.getElementById(\"msg\").innerHTML = \"Mật khẩu không khớp!\";\n");
      out.write("                return false;\n");
      out.write("            } else {\n");
      out.write("                document.getElementById(\"msg\").innerHTML = \"\";\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function kiemTraDongY() {\n");
      out.write("            dieuKhoan = document.getElementById(\"dieuKhoan\");\n");
      out.write("            if (dieuKhoan.checked == true) {\n");
      out.write("                document.getElementById(\"submit-btn\").style.visibility = \"visible\";\n");
      out.write("            } else {\n");
      out.write("                document.getElementById(\"submit-btn\").style.visibility = \"hidden\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
