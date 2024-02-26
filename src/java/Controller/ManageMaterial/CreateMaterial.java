/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManageMaterial;

import DAO.MaterialDAO;
import DTO.MaterialCategory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author DELL
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "CreateMaterial", urlPatterns = {"/CreateMaterial"})
public class CreateMaterial extends HttpServlet {

    private static final String DEFAULT_FILENAME = "default.file";

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
        MaterialDAO dao = new MaterialDAO();
        List<MaterialCategory> list = dao.getMaterialCategory();
        request.setAttribute("list", list);
        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/CreateMaterial.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");

        MaterialDAO dao = new MaterialDAO();
        boolean result = dao.createMaterial(name, price, category);

        if (result) {
            request.setAttribute("messtrue", "Thêm vật liệu thành công!");
            MaterialDAO dao1 = new MaterialDAO();
            int materialID = dao1.getMaterialID();
            int length = getServletContext().getRealPath("/").length();
            String uploadPath = new StringBuilder(getServletContext().getRealPath("/")).delete(length - 10, length - 4).toString() + File.separator + "img";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                List<String> fileNames = new ArrayList<>();
                for (Part part : request.getParts()) {
                    String fileName = getFileName(part);
                    if (!fileName.equals(DEFAULT_FILENAME)) {
                        fileNames.add(fileName);
                        part.write(uploadPath + File.separator + fileName);
                    }
                    MaterialDAO dao2 = new MaterialDAO();
                    dao2.addImage(materialID, fileName);
                }
            } catch (FileNotFoundException fne) {
                request.setAttribute("message", "There was an error: " + fne.getMessage());
            }

        } else {
            request.setAttribute("messfalse", "Thêm dự vật liệu thất bại!");
        }
        doGet(request, response);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return DEFAULT_FILENAME;
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