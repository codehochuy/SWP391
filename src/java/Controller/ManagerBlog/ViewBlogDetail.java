/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerBlog;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import DAO.BlogDAO;
import DTO.BlogDTO;
import Utils.DBContext;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
    @WebServlet(name = "ViewBlogDetail", urlPatterns = {"/ViewBlogDetail"})
    public class ViewBlogDetail extends HttpServlet {

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
            out.println("<title>Servlet ViewBlogDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewBlogDetail at " + request.getContextPath() + "</h1>");
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
    try {
        // Lấy BlogID từ request
        int blogID = Integer.parseInt(request.getParameter("blogid"));

        // Gọi DAO để lấy thông tin chi tiết của blog
        BlogDAO blogDAO = new BlogDAO();
        BlogDTO blog = blogDAO.getBlogByID(blogID);
         BlogDAO dao = new BlogDAO();
         List<String> categoryList = dao.listCategory();
    request.setAttribute("categoryList", categoryList);

        // Đặt đối tượng BlogDTO vào request attribute
        request.setAttribute("blog", blog);

        // Chuyển hướng request đến trang ViewBlogDetail.jsp để hiển thị thông tin blog
        RequestDispatcher dispatcher = request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ViewBlogDetail.jsp");
        dispatcher.forward(request, response);

    } catch (Exception e) {
        // Xử lý ngoại lệ nếu có
        e.printStackTrace();
        // Trả về lỗi 500 Internal Server Error
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
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
