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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateBlog", urlPatterns = {"/CreateBlog"})
public class CreateBlog extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String generateRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        // Tạo ngẫu nhiên một chuỗi có độ dài 20 ký tự từ characters
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

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
        HttpSession session = request.getSession();

// Lấy giá trị của thuộc tính "USER" từ session
        User user = (User) session.getAttribute("USER");
        if (user != null) {
            int userId = user.getId(); // Giả sử userId là thuộc tính trong đối tượng User
            request.setAttribute("USERID", userId);
        }

        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/createBlog.jsp").forward(request, response);
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

        // Blog
        String blogID = request.getParameter("blogID");
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String userID = request.getParameter("userID");

        //BlogDetail:
        String[] blogDetailIDParents = request.getParameterValues("blog_detail_id_parent[]");
        String[] titleDetails = request.getParameterValues("title_detail[]");
        String[] contentDetails = request.getParameterValues("content_detail[]");

        // Blog Image
        String[] blogImageIDChilds = request.getParameterValues("blog_image_id_child[]");
        String[] base64Images = request.getParameterValues("base64_image[]");
        String[] imageCaptions = request.getParameterValues("image_caption[]");
        String[] blogDetailIDChilds = request.getParameterValues("blog_detail_id_child[]");

        int length = getServletContext().getRealPath("/").length();
        String basePath = new StringBuilder(getServletContext().getRealPath("/")).delete(length - 10, length - 4).toString();
        String imagePath = basePath + File.separator + "img";
// Kiểm tra nếu đường dẫn không kết thúc bằng dấu gạch chéo ngược, thêm vào
        if (!imagePath.endsWith(File.separator)) {
            imagePath += File.separator;
        }

        for (int i = 0; i < blogImageIDChilds.length; i++) {

        }

        BlogDAO blogDAO = new BlogDAO();

        List<String> imageNames = new ArrayList<>();

        String[] replacedBase64Images = null;
        if (base64Images != null) {
            replacedBase64Images = new String[base64Images.length];
            for (int i = 0; i < base64Images.length; i++) {
                replacedBase64Images[i] = base64Images[i].replace(" ", "+");
                String imageName = generateRandomName() + ".jpg";
                imageNames.add(imageName);
                blogDAO.createFiles(replacedBase64Images[i], imagePath, imageName);
            }
        }

        List<Integer> blogDetailIDChildsInteger = new ArrayList<>();
        for (String id : blogDetailIDChilds) {
            try {
                int intValue = Integer.parseInt(id.trim()); // Chuyển đổi chuỗi thành số nguyên
                blogDetailIDChildsInteger.add(intValue); // Thêm số nguyên vào danh sách
            } catch (NumberFormatException e) {
                // Xử lý nếu có lỗi khi chuyển đổi
                e.printStackTrace();
                // Hoặc bỏ qua và tiếp tục với các giá trị khác nếu cần thiết
            }
        }

        BlogDAO dao = new BlogDAO();
        BlogDAO dao2 = new BlogDAO();
        BlogDAO dao3 = new BlogDAO();
        BlogDAO dao4 = new BlogDAO();
        String createdBlogID = dao.createBlog(title, date, userID);

        List<String> createdBlogDetailIDs = new ArrayList<>();

        if (createdBlogID != null) {

            for (int i = 0; i < blogDetailIDParents.length; i++) {
                String createdBlogDetailID = dao2.createBlogDetail(titleDetails[i], contentDetails[i], createdBlogID);
                createdBlogDetailIDs.add(createdBlogDetailID);
            }
        }

        List<String> createdBlogImageIDs = new ArrayList<>();

        if (createdBlogDetailIDs != null) {
            for (int i = 0; i < blogImageIDChilds.length; i++) {

                int x = blogDetailIDChildsInteger.get(i);

                // Kiểm tra nếu x thỏa mãn điều kiện và không vượt quá số lượng phần tử trong createdBlogDetailIDs
                if (x >= 1 && x <= createdBlogDetailIDs.size()) {
                    String createdBlogImageID = dao3.createBlogImage(imageNames.get(i), imageCaptions[i], createdBlogDetailIDs.get(x - 1));
                    createdBlogImageIDs.add(createdBlogImageID);
                }

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
