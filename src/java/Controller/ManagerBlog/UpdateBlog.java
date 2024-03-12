/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerBlog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.BlogDAO;
import DTO.BlogDTO;
import DTO.User;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateBlog", urlPatterns = {"/UpdateBlog"})
public class UpdateBlog extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Lấy thông tin từ request
        int blogId = Integer.parseInt(request.getParameter("blogId"));
        String title = request.getParameter("title");
        String tags = request.getParameter("tags");
        String content = request.getParameter("content");
        String category = request.getParameter("category");
        String dateModified = request.getParameter("dateModified");

        BlogDAO dao = new BlogDAO();
        List<BlogDTO> existingBlogs = dao.getAll();
        boolean titleExists = existingBlogs.stream()
                .anyMatch(blog -> blog.getTitle().equalsIgnoreCase(title) && blog.getBlogID() != blogId);

        if (titleExists) {
            // Title already exists, send a response indicating duplication
            response.getWriter().write("DUPLICATE_TITLE");
        } else {
            BlogDAO dao1 = new BlogDAO();
            String blogcategoryID = dao1.returnblogcategoryID(category);
            // Gọi DAO để cập nhật bài viết
            BlogDAO dao2 = new BlogDAO();
            dao2.updateBlog(blogId, title, tags, content, blogcategoryID, dateModified);
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
