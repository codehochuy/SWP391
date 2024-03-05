/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.WebPage;

import DAO.BlogDAO;
import DTO.BlogCategoryDTO;
import DTO.BlogDTO;
import Utils.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.google.gson.Gson;
/**
 *
 * @author PC
 */
@WebServlet(name = "Blog", urlPatterns = {"/Blog"})
public class Blog extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
             // Khởi tạo BlogDAO và lấy danh sách blog
        BlogDAO blogDAO = new BlogDAO();
        List<BlogDTO> blogs = blogDAO.getAll();
        
        BlogDAO dao2 = new BlogDAO();
        List<BlogCategoryDTO> blogCategories = dao2.getAllBlogCategories();
   

        // Đặt danh sách blog vào thuộc tính của request để hiển thị trên trang JSP
        request.setAttribute("blogs", blogs);
         request.setAttribute("blogCategories", blogCategories);
        // Chuyển hướng đến trang JSP để hiển thị danh sách blog
        request.getRequestDispatcher("WebPages/ViewWebPage/blog.jsp").forward(request, response);

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
      String category = request.getParameter("category");
   BlogDAO blogDAO = new BlogDAO();
        List<BlogDTO> blogs = blogDAO.getAllbyCategory(category);


        
         BlogDAO dao2 = new BlogDAO();
        List<BlogCategoryDTO> blogCategories = dao2.getAllBlogCategories();
     
        request.setAttribute("blogs", blogs);
         request.setAttribute("blogCategories", blogCategories);

        request.getRequestDispatcher("WebPages/ViewWebPage/blog.jsp").forward(request, response);
      
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
