/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartDTO;
import model.CustomerDTO;
import utils.Email;

/**
 *
 * @author AD
 */
public class CheckOutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String note = request.getParameter("note") == null ? "" : request.getParameter("note");
        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        CustomerDTO customer = (CustomerDTO) session.getAttribute("customer");
        OrderDAO oDAO = new OrderDAO();
        ProductDAO pDAO = new ProductDAO();
        Email handleEmail = new Email();

        String msg = "";

        int before = oDAO.getNumberOrders();

        oDAO.addOrder(customer, cart, note);
        LocalDateTime curDateTime = LocalDateTime.now();

        int after = oDAO.getNumberOrders();

        if (before < after) {
            msg += "Đặt hàng thành công";
            session.removeAttribute("cart");
            session.removeAttribute("size");
            handleEmail.sendEmail(handleEmail.subjectOrder(customer.getFullname()), handleEmail.messageOrder(curDateTime, cart.getTotalMoney() + 30000, customer.getAddress()), customer.getEmail());
        } else {
            msg += "Đặt hàng thất bại";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
