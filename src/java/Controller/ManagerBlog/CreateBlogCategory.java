/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerBlog;

import DAO.BlogDAO;
import DTO.BlogCategoryDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateBlogCategory", urlPatterns = {"/CreateBlogCategory"})
public class CreateBlogCategory extends HttpServlet {

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
            out.println("<title>Servlet CreateBlogCategory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateBlogCategory at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String newCategoryValue = request.getParameter("newCategoryValue");
        BlogDAO dao = new BlogDAO();
        List<BlogCategoryDTO> existingCategories = dao.getAllBlogCategories();
        boolean categoryExists = false;
        // Check if newCategoryValue already exists in the database
        for (BlogCategoryDTO existingCategory : existingCategories) {
            if (existingCategory.getBlogCategoryName().equalsIgnoreCase(newCategoryValue)) {
                categoryExists = true;
                break;
            }
        }
        if (categoryExists) {
            BlogDAO blogDAO2 = new BlogDAO();
            List<BlogCategoryDTO> blogCategories = blogDAO2.getAllBlogCategories();
            request.setAttribute("blogCategories", blogCategories);
            response.getWriter().write("DUPLICATE");
        } else {
            BlogDAO dao1 = new BlogDAO();
            dao1.createBlogCategory(newCategoryValue);
            BlogDAO blogDAO2 = new BlogDAO();
            List<BlogCategoryDTO> blogCategories = blogDAO2.getAllBlogCategories();
            request.setAttribute("blogCategories", blogCategories);
            response.getWriter().write("SUCCESS");
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
