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
import DTO.BlogDetailDTO;
import DTO.BlogImageDTO;
import Utils.DBContext;
import java.io.IOException;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy ID của blog từ tham số trong URL
            String blogIDString = request.getParameter("blogid");
            int blogID = Integer.parseInt(blogIDString);

            // Tạo BlogDAO và lấy chi tiết blog từ cơ sở dữ liệu
            BlogDAO blogDAO = new BlogDAO(new DBContext());
            BlogDTO blog = blogDAO.getBlogByID(blogID);

            // Tạo đối tượng JSON chứa dữ liệu blog
            JSONObject blogJSON = new JSONObject();
            blogJSON.put("blogID", blog.getBlogID());
            blogJSON.put("title", blog.getTitle());
            blogJSON.put("date", blog.getDate().toString());
            blogJSON.put("usersID", blog.getUsersID());

            // Tạo mảng JSON chứa các chi tiết blog
            JSONArray blogDetailsArray = new JSONArray();
            for (BlogDetailDTO blogDetail : blog.getBlogDetails()) {
                JSONObject blogDetailJSON = new JSONObject();
                blogDetailJSON.put("blogDetailID", blogDetail.getBlogDetailID());
                blogDetailJSON.put("title", blogDetail.getTitle());
                blogDetailJSON.put("content", blogDetail.getContent());
                blogDetailJSON.put("blogID", blogDetail.getBlogID());

                // Tạo mảng JSON chứa các hình ảnh của chi tiết blog
                JSONArray blogImagesArray = new JSONArray();
                for (BlogImageDTO blogImage : blogDetail.getBlogImages()) {
                    JSONObject blogImageJSON = new JSONObject();
                    blogImageJSON.put("blogImageID", blogImage.getBlogImageID());
                    blogImageJSON.put("url", blogImage.getUrl());
                    blogImageJSON.put("caption", blogImage.getCaption());
                    blogImageJSON.put("blogDetailID", blogImage.getBlogDetailID());
                    blogImagesArray.put(blogImageJSON);
                }

                blogDetailJSON.put("blogImages", blogImagesArray);
                blogDetailsArray.put(blogDetailJSON);
            }

            blogJSON.put("blogDetails", blogDetailsArray);

            // Gửi dữ liệu JSON đến trang JSP
            request.setAttribute("json", blogJSON.toString());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ViewBlogDetail.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
            // Hoặc xử lý ngoại lệ một cách khác tùy thuộc vào yêu cầu của bạn
        }
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Lấy ID của blog từ tham số trong URL
//   
//        String blogIDString = request.getParameter("blogid");
//        int blogID = Integer.parseInt(blogIDString);
//
//        // Tạo BlogDAO và lấy chi tiết blog từ cơ sở dữ liệu
//        BlogDAO blogDAO = new BlogDAO(new DBContext());
//        BlogDTO blog = blogDAO.getBlogByID(blogID);
//
//        // data blog sẽ hiển thị dưới dạng javascript
//        request.setAttribute("blog", blog);
//
//          RequestDispatcher dispatcher = request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ViewBlogDetailTemp.jsp");
//        dispatcher.forward(request, response);
//    }
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
