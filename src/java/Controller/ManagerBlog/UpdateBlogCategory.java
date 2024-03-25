/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerBlog;

import DAO.BlogDAO;
import DTO.BlogCategoryDTO;
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
@WebServlet(name = "UpdateBlogCategory", urlPatterns = {"/UpdateBlogCategory"})
public class UpdateBlogCategory extends HttpServlet {

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
            out.println("<title>Servlet UpdateBlogCategory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBlogCategory at " + request.getContextPath() + "</h1>");
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
        String categoryid = request.getParameter("categoryid");
        String blogcategoryname = request.getParameter("blogcategoryname");
        String regex = "^[0-9a-zA-Z\\p{L}][0-9a-zA-Z\\p{L}\\s]*[0-9a-zA-Z\\p{L}]$";
        if (!blogcategoryname.matches(regex)) {
            request.setAttribute("messefalse", "Đặt tên không đúng");
            BlogDAO dao5 = new BlogDAO();
            List<BlogCategoryDTO> blogCategories = dao5.getAllBlogCategories();
            request.setAttribute("blogCategories", blogCategories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerBlogCategory.jsp");
            dispatcher.forward(request, response);
        } else {
            BlogDAO dao = new BlogDAO();
            List<BlogCategoryDTO> existingCategories = dao.getAllBlogCategories();
            if (existingCategories.stream().anyMatch(category -> category.getBlogCategoryName().equalsIgnoreCase(blogcategoryname))) {
                request.setAttribute("messefalse", "Danh mục đã tồn tại trong cơ sở dữ liệu");
                BlogDAO dao5 = new BlogDAO();
                List<BlogCategoryDTO> blogCategories = dao5.getAllBlogCategories();
                request.setAttribute("blogCategories", blogCategories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerBlogCategory.jsp");
                dispatcher.forward(request, response);
            } else {
                BlogDAO dao1 = new BlogDAO();
                dao1.updateBlogCategory(categoryid, blogcategoryname);
                BlogDAO dao2 = new BlogDAO();
                List<BlogCategoryDTO> blogCategories = dao2.getAllBlogCategories();
                request.setAttribute("blogCategories", blogCategories);
                request.setAttribute("messtrue", "Cập nhật danh mục thành công");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerBlogCategory.jsp");
                dispatcher.forward(request, response);
            }
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
