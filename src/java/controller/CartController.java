/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartDTO;
import model.Item;
import model.ProductsDTO;

/**
 *
 * @author AD
 */
public class CartController extends HttpServlet {

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
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Product ID " + "</h1>");

            out.println("<h1>Quantity " + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();

        Object o = session.getAttribute("cart");
        CartDTO cart = new CartDTO();
        if (o != null) {
            cart = (CartDTO) o;
        }
        String sizeId_raw = request.getParameter("sizeId") == null ? "" : request.getParameter("sizeId");
        String pId = request.getParameter("pId");
//        String quantity_raw = request.getParameter("quantity");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (sizeId_raw == "") {
            request.setAttribute("msg", "Vui lòng chọn size");
            request.getRequestDispatcher("product-detail").forward(request, response);
        }
        if (quantity <= 0) {
            request.setAttribute("msg", "Số lượng không hợp lệ");
            request.getRequestDispatcher("product-detail").forward(request, response);
        }

        //response.getWriter().print("Size: " + sizeId + "\n Product ID: " + pId + "\n Quantity: " + quantity);
        int sizeId = Integer.parseInt(sizeId_raw);
        ProductDAO pDAO = new ProductDAO();
        ProductsDTO p = pDAO.getProductBySizeID(sizeId);

        Item item = new Item(p,sizeId ,quantity);
        cart.addItem(item);

        session.setAttribute("cart", cart);
        response.sendRedirect("shoppingcart.jsp");

        List<Item> list = cart.getItems();

        session.setAttribute("size", list.size());
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
