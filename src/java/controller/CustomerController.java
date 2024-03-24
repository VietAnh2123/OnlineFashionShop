/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CustomerDTO;


/**
 *
 * @author AD
 */
public class CustomerController extends HttpServlet {

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
            out.println("<title>Servlet CustomerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if (action.equals("log-out")) {
            logOut(request, response);
        } else if (action.equals("change-info")) {
            request.getRequestDispatcher("changeinfo.jsp").forward(request, response);
        } else if (action.equals("change-password")) {
            request.getRequestDispatcher("changepassword.jsp").forward(request, response);
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
        String action = request.getParameter("action");
        if (action.equals("log-in")) {
            logIn(request, response);
        } else if (action.equals("register")) {
            register(request, response);
        } else if (action.equals("change-info")) {
            changeInfo(request, response);
        } else if (action.equals("change-password")) {
            changePassword(request, response);
        }
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isRemember = request.getParameter("remember");

        Cookie cUser = new Cookie("cUser", username);
        Cookie cPass = new Cookie("cPass", password);
        Cookie cIsRemember = new Cookie("cIsRemember", isRemember);

        if (isRemember != null) {
            cUser.setMaxAge(60 * 60);
            cPass.setMaxAge(60 * 60);
            cIsRemember.setMaxAge(60 * 60);
        } else {
            cUser.setMaxAge(0);
            cPass.setMaxAge(0);
            cIsRemember.setMaxAge(0);
        }

        response.addCookie(cUser);
        response.addCookie(cPass);
        response.addCookie(cIsRemember);

        String msg = "";
        String url = "/";

        if (username == null || username.trim().length() == 0) {
            msg += "Vui lòng điền tên đăng nhập! ";
        } else if (password == null || password.trim().length() == 0) {
            msg += "Vui lòng điền mật khẩu! ";
        }

        if (msg.length() > 0) {
            url = "/login.jsp";
        }

        CustomerDAO cDAO = new CustomerDAO();
        CustomerDTO c = cDAO.checkUser(username, password);

        if (c != null) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", c);
            url = "/index";
        } else {
            msg += "Tài khoản hoặc Mật khẩu không đúng! ";
            url = "/login.jsp";
        }

        request.setAttribute("error", msg);
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
//        String encodePassword = Encode.toSHA1(password);
        
        String msg = "";
        String url = "/";

        CustomerDAO cDAO = new CustomerDAO();

        if (!confirmPassword.equals(password)) {
            msg += "Mật khẩu không khớp! ";
        }

        if (cDAO.checkUsername(username)) {
            msg += "Tên đăng nhập đã tồn tại! ";
        }
        if(cDAO.checkUserEmail(email)){
            msg += "Email đã tồn tại! ";
        }
        request.setAttribute("error", msg);
        if (msg.length() > 0) {
            url = "/register.jsp";
        } else {
            CustomerDTO c = new CustomerDTO(0,
                    username,
                    password,
                    fullName,
                    email,
                    phoneNumber,
                    address,
                    gender
            );

//            cDAO.insertCustomer(c);
            cDAO.insertCustomer(username, password, fullName, email, phoneNumber, address, gender);
            url = "/success.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);

    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
//            response.sendRedirect("index");
        }
        request.getRequestDispatcher("index").forward(request, response);
    }

    private void changeInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int cId = Integer.parseInt(request.getParameter("cId"));
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        String msg = "";

        CustomerDAO cDAO = new CustomerDAO();
        CustomerDTO c = cDAO.findByID(cId);
        if (c != null) {
            CustomerDTO newCustomer = new CustomerDTO(c.getId(), c.getUsername(), c.getPassword(), fullName, email, phoneNumber, address, gender);
            cDAO.updateCustomer(newCustomer);
            msg += "Thay đổi thông tin thành công";
            HttpSession session = request.getSession();
            session.setAttribute("customer", newCustomer);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("changeinfo.jsp").forward(request, response);
        }
    }
    
    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        String errorMsg = "";
        String url = "/";
        
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("customer");
        CustomerDTO customer = null;
        if(obj!=null){
            customer = (CustomerDTO) obj;
        }
        if(customer==null){
            errorMsg += "Bạn chưa đăng nhập vào hệ thống!";
            url = "/changepassword.jsp";
        }else{
            if(!oldPassword.equals(customer.getPassword())){
                errorMsg += "Mật khẩu cũ không đúng!";
                url = "/changepassword.jsp";
            }else if(oldPassword.equals(newPassword)){
                errorMsg += "Mật khẩu mới không được trùng với mật khẩu cũ!";
                url = "/changepassword.jsp";
            }else{
                if(!newPassword.equals(confirmNewPassword)){
                    errorMsg += "Mật khẩu mới không khớp!";
                    url = "/changepassword.jsp";
                }else{
                    customer.setPassword(newPassword);
                    CustomerDAO khDAO = new CustomerDAO();
                    if(!khDAO.changePassword(customer)){
                        errorMsg += "Thay đổi mật khẩu thành công";
                        url = "/changepassword.jsp";
                    }else{
                        errorMsg += "Thay đổi mật khẩu thất bại!";
                        url = "/changepassword.jsp";
                    }
                }
            }
        }
        request.setAttribute("error", errorMsg);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
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
