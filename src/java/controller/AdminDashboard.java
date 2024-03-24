/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrdersDTO;

/**
 *
 * @author AD
 */
public class AdminDashboard extends HttpServlet {

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
            out.println("<title>Servlet AdminDashboard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminDashboard at " + request.getContextPath() + "</h1>");
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
        ProductDAO pDAO = new ProductDAO();
        OrderDAO oDAO = new OrderDAO();
        CustomerDAO cDAO = new CustomerDAO();
        
        int countProduct = pDAO.countProduct();
        int countOrder = oDAO.countOrders();
        int countCustomer = cDAO.countCustomers();
        double countTotalMoney = oDAO.countTotalMoney();
        List<OrdersDTO> deliveredOrders = oDAO.deliveredOrders();
        List<OrdersDTO> deliveringOrders = oDAO.deliveringOrders();
        List<OrdersDTO> canceledOrders = oDAO.canceledOrders();
        
        request.setAttribute("countDeliveredOrders", deliveredOrders.size());
        request.setAttribute("countDeliveringOrders", deliveringOrders.size());
        request.setAttribute("countCanceledOrders", canceledOrders.size());
        
        request.setAttribute("countProduct", countProduct);
        request.setAttribute("countOrder", countOrder);
        request.setAttribute("countCustomer", countCustomer);
        request.setAttribute("countTotalMoney", countTotalMoney);
        
        request.getRequestDispatcher("adminstatistic.jsp").forward(request, response);
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
        processRequest(request, response);
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
