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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "loadbyID", urlPatterns = {"/loadbyID"})
public class loadbyID extends HttpServlet {

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
            String id = request.getParameter("id");
          BlogDAO dao = new BlogDAO();
            BlogCategoryDTO dto = dao.getBlogCategoryID(id);

      
   out.println("<form action=\"UpdateQuotation\" method=\"POST\" id=\"updateblogcate\">\n"
                    + "    <div class=\"row\">\n"
                    + "        <div class=\"form-group col-md-6\">\n"
                    + "            <label class=\"control-label\">ID </label>\n"
                    + "            <input readonly=\"true\" class=\"form-control\" type=\"text\" name=\"categoryid\" value=\"" + dto.getBlogCategoryID() + "\" >\n"
                    + "        </div>\n"
                    + "        <div class=\"form-group col-md-6\">\n"
                    + "            <label class=\"control-label\">Tên danh mục bài viết</label>\n"
               + "            <input class=\"form-control\" type=\"text\" name=\"blogcategoryname\" value=\"" + dto.getBlogCategoryName() + "\" placeholder=\"Không chấp nhận kí tự đặc biệt\" required>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "    <BR>\n"
                    + "    <button class=\"btn btn-save\" type=\"submit\">Lưu lại</button>\n"
                    + "    <a class=\"btn btn-cancel\" data-dismiss=\"modal\" href=\"#\">Hủy bỏ</a>\n"
                    + "    <BR>\n"
                    + "</form>");

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
