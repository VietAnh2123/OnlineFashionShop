/* 467                     
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryDTO;
import model.ProductsDTO;

/**
 *
 * @author AD
 */
public class GetProductsController extends HttpServlet {

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
            out.println("<title>Servlet GetProductsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CategoryID at " + request.getParameter("cId") + "</h1>");
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
//        CategoryDAO cDAO = new CategoryDAO();
//        List<CategoryDTO> listCategory = cDAO.listCategory();

//        request.setAttribute("categories", listCategory);
//        request.getRequestDispatcher("shop.jsp").forward(request, response);
        ProductDAO pDAO = new ProductDAO();
        String cId_raw = request.getParameter("cId") == null ? "" : request.getParameter("cId");
        String keyword = request.getParameter("keyword") == null ? "" : request.getParameter("keyword");
        String sortBy = request.getParameter("sortBy") == null ? "" : request.getParameter("sortBy");

        String index_raw = request.getParameter("index") == null ? "1" : request.getParameter("index");
        int index = Integer.valueOf(index_raw);
        int pageSize = 9;
        int numberPage = 0;
        int totalRecord = pDAO.countProducts();
        numberPage = (int) Math.ceil((double) totalRecord / pageSize);

        List<ProductsDTO> pListByCid = pDAO.listProducts(cId_raw, keyword, sortBy, index, pageSize);
        request.setAttribute("productsList", pListByCid);
        request.setAttribute("index", index);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("sortBy", sortBy);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
