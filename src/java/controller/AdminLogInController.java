/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AdminDTO;

/**
 *
 * @author AD
 */
public class AdminLogInController extends HttpServlet {

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String isRemember = request.getParameter("remember");
            
            Cookie adminUser = new Cookie("adminUser", username);
            Cookie adminPass = new Cookie("adminPass", password);
            Cookie adminIsRemember = new Cookie("adminIsRemember", isRemember);
            
            if(isRemember!= null){
                adminUser.setMaxAge(60*60);
                adminPass.setMaxAge(60*60);
                adminIsRemember.setMaxAge(60*60);
            }else{
                adminUser.setMaxAge(0);
                adminPass.setMaxAge(0);
                adminIsRemember.setMaxAge(0);
            }
               
            response.addCookie(adminUser);
            response.addCookie(adminPass);
            response.addCookie(adminIsRemember);
            
            String msg = "";
            AdminDAO aDAO = new AdminDAO();

            AdminDTO admin = aDAO.getAdmin(username, password);

            if (admin == null) {
                msg += "Tên đăng nhập hoặc Mật khẩu không đúng!";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                request.getRequestDispatcher("admindashboard.jsp").forward(request, response);
            }
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
