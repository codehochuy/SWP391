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
import DAO.BlogDAO;
import DTO.BlogDTO;
import Utils.DBContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DeleteBlog extends HttpServlet {

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
            out.println("<title>Servlet DeleteBlog</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteBlog at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID của blog cần xóa từ request
        int blogID = Integer.parseInt(request.getParameter("id"));

        // Tạo BlogDAO và xóa blog từ cơ sở dữ liệu
        BlogDAO blogDAO = new BlogDAO(new DBContext());

        boolean result = blogDAO.deleteBlog(blogID);
        if (result) {
            BlogDAO blogDAO2 = new BlogDAO();
            List<BlogDTO> blogs = blogDAO2.getAll();
            request.setAttribute("blogs", blogs);
            request.setAttribute("messtrue", "Xóa dự án thành công");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerBlog.jsp").forward(request, response);

        } else {
            BlogDAO blogDAO2 = new BlogDAO();
            List<BlogDTO> blogs = blogDAO2.getAll();
            request.setAttribute("blogs", blogs);
            request.setAttribute("messefalse", "Xóa dự án thất bại");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerBlog.jsp").forward(request, response);
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
