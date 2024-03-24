package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.release();
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
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/head.jsp", out, false);
      out.write("\n");
      out.write("        <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/header.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/preloader.jsp", out, false);
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/jsplugins.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "component/footer.jsp", out, false);
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.customer==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (true) {
          _jspx_page_context.forward("login.jsp");
          return true;
        }
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.customer!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <!-- Breadcrumb Section Begin -->\n");
        out.write("            <section class=\"breadcrumb-option\">\n");
        out.write("                <div class=\"container\">\n");
        out.write("                    <div class=\"row\">\n");
        out.write("                        <div class=\"col-lg-12\">\n");
        out.write("                            <div class=\"breadcrumb__text\">\n");
        out.write("                                <h4>Thanh Toán</h4>\n");
        out.write("                                <div class=\"breadcrumb__links\">\n");
        out.write("                                    <a href=\"./index.html\">Trang Chủ</a>\n");
        out.write("                                    <a href=\"./shop.html\">Cửa Hàng</a>\n");
        out.write("                                    <span>Thanh Thoán</span>\n");
        out.write("                                </div>\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("            </section>\n");
        out.write("            <!-- Breadcrumb Section End -->\n");
        out.write("\n");
        out.write("            <!-- Shopping Cart Section Begin -->\n");
        out.write("            <section class=\"shopping-cart spad\">\n");
        out.write("                <div class=\"container\">\n");
        out.write("                    <div class=\"row\">\n");
        out.write("                        <div class=\"col-lg-8\">\n");
        out.write("                            <div class=\"shopping__cart__table\">\n");
        out.write("                                <form action=\"customer\" method=\"POST\">\n");
        out.write("                                    <div class=\"row\">\n");
        out.write("                                        <div class=\"col-lg-8 col-md-6\">\n");
        out.write("                                            <h4>Thông tin Khách Hàng</h4>\n");
        out.write("                                            <div class=\"checkout__input\">\n");
        out.write("                                                <p>Họ Và Tên<span>*</span></p>\n");
        out.write("                                                <input type=\"text\" name=\"fullName\" required=\"\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                            </div>\n");
        out.write("                                            <div class=\"checkout__input\">\n");
        out.write("                                                <p>Địa Chỉ<span>*</span></p>\n");
        out.write("                                                <input type=\"text\" name=\"address\" required=\"\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                            </div>\n");
        out.write("                                            <div class=\"row\">\n");
        out.write("                                                <div class=\"col-lg-6\">\n");
        out.write("                                                    <div class=\"checkout__input\">\n");
        out.write("                                                        <p>Số điện thoại<span>*</span></p>\n");
        out.write("                                                        <input type=\"text\" name=\"phoneNumber\" required=\"\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                                    </div>\n");
        out.write("                                                </div>\n");
        out.write("                                                <div class=\"col-lg-6\">\n");
        out.write("                                                    <div class=\"checkout__input\">\n");
        out.write("                                                        <p>Email<span>*</span></p>\n");
        out.write("                                                        <input type=\"email\" name=\"email\" required=\"\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                                    </div>\n");
        out.write("                                                </div>\n");
        out.write("                                                <div class=\"col-lg-6\">\n");
        out.write("                                                    <div class=\"checkout__input\">\n");
        out.write("                                                        <p>Giới Tính<span>*</span></p>\n");
        out.write("                                                        <select name=\"gender\" required=\"\">\n");
        out.write("                                                            <option value=\"Nam\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.gender.equals(\"Nam\")?'selected':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(">Nam</option>\n");
        out.write("                                                            <option value=\"Nữ\" ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.gender.equals(\"Nữ\")?'selected':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(">Nữ</option>\n");
        out.write("                                                        </select>\n");
        out.write("                                                    </div>\n");
        out.write("                                                </div>\n");
        out.write("                                            </div>\n");
        out.write("                                            <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                                        </div>\n");
        out.write("                                        <div class=\"col-lg-6 col-md-6 mt-3\">\n");
        out.write("                                            <div class=\"\">\n");
        out.write("                                                <input type=\"hidden\" name=\"action\" value=\"change-info\">\n");
        out.write("                                                <input type=\"hidden\" name=\"cId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                                                <button type=\"submit\" class=\"site-btn\">Cập Nhật</button>\n");
        out.write("                                            </div>\n");
        out.write("                                        </div>\n");
        out.write("\n");
        out.write("                                    </div>\n");
        out.write("                                </form>\n");
        out.write("                            </div>\n");
        out.write("                            <div class=\"row\">\n");
        out.write("                                <div class=\"col-lg-6 col-md-6 col-sm-6\">\n");
        out.write("                                    <div class=\"continue__btn\">\n");
        out.write("                                        <a href=\"get-products\">Tiếp tục mua sắm</a>\n");
        out.write("                                    </div>\n");
        out.write("                                </div>\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                        <div class=\"col-lg-4\">\n");
        out.write("                            <div class=\"cart__total\">\n");
        out.write("                                <h6>Đơn Hàng của bạn</h6>\n");
        out.write("                                <ul>\n");
        out.write("                                    <!--                                    <li>Gi <span>$ 169.50</span></li>-->\n");
        out.write("                                    <li>Số Tiền \n");
        out.write("                                        <span>\n");
        out.write("                                            ");
        if (_jspx_meth_fmt_formatNumber_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                        </span>\n");
        out.write("                                    </li>\n");
        out.write("                                    <li>Phí vận chuyển \n");
        out.write("                                        <span>\n");
        out.write("                                            ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart == null || sessionScope.size == 0 ? '0':'30,000'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                                        </span>\n");
        out.write("                                    </li>\n");
        out.write("                                    <hr>\n");
        out.write("                                    <li>Tổng Tiền \n");
        out.write("                                        <span>\n");
        out.write("                                            ");
        if (_jspx_meth_fmt_formatNumber_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write(" VND\n");
        out.write("                                        </span>\n");
        out.write("                                    </li>\n");
        out.write("                                </ul>\n");
        out.write("                                <form action=\"check-out\" method=\"POST\">\n");
        out.write("                                    <input type=\"submit\" value=\"Thanh Toán\" class=\"primary-btn btn-block\">\n");
        out.write("                                </form>\n");
        out.write("                                <!--                                <a href=\"#\" class=\"primary-btn\">Thanh Toán</a>-->\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("            </section>\n");
        out.write("            <!-- Shopping Cart Section End -->\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_fmt_formatNumber_0.setType("number");
    _jspx_th_fmt_formatNumber_0.setMaxFractionDigits(3);
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart.getTotalMoney()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_fmt_formatNumber_1.setType("number");
    _jspx_th_fmt_formatNumber_1.setMaxFractionDigits(3);
    _jspx_th_fmt_formatNumber_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart == null || sessionScope.size == 0?'0':sessionScope.cart.getTotalMoney()+30000}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_1 = _jspx_th_fmt_formatNumber_1.doStartTag();
    if (_jspx_th_fmt_formatNumber_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.reuse(_jspx_th_fmt_formatNumber_1);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_maxFractionDigits_nobody.reuse(_jspx_th_fmt_formatNumber_1);
    return false;
  }
}
