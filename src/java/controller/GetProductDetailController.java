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
import model.ProductsDTO;
import model.SizeDTO;

/**
 *
 * @author AD
 */
public class GetProductDetailController extends HttpServlet {

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
            out.println("<title>Servlet GetProductDetailController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetProductDetailController at " + request.getParameter("pId")+ "</h1>");
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
        //processRequest(request, response);
        int pId = Integer.parseInt(request.getParameter("pId"));
        String sizeId = request.getParameter("sizeId")==null?"":request.getParameter("sizeId");
//        int cId = Integer.parseInt(request.getParameter("cId"));
//        String action = request.getParameter("action")==null?"":request.getParameter("action");
        
        ProductDAO pDAO = new ProductDAO();
        ProductsDTO p = pDAO.getProductByID(pId);
        
        List<SizeDTO> sizeList = pDAO.listSizeByProductID(pId);
//        List<ProductsDTO> relatedList = pDAO.relatedList(cId, pId);
        
        if(sizeId!=""){
            int sId = Integer.parseInt(sizeId);
            request.setAttribute("sizeId", sId);
            request.setAttribute("stock", "Có " + pDAO.findStockBySizeId(sizeId) + " sản phẩm");
        }
//        request.setAttribute("relatedList", relatedList);
        request.setAttribute("product", p);
        request.setAttribute("sizeList", sizeList);
        request.getRequestDispatcher("productdetail.jsp").forward(request, response);
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
        doGet(request, response);
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
