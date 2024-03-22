/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManageMaterial;

import DAO.HouseTypeDAO;
import DAO.MaterialDAO;
import DAO.ProjectDAO;
import DAO.ProjectImageDAO;
import DAO.ServiceDAO;
import DAO.StyleDAO;
import DTO.HouseType;
import DTO.Material;
import DTO.MaterialCategory;
import DTO.ProjectImage;
import DTO.Service;
import DTO.Style;
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
 * @author DELL
 */
@WebServlet(name = "UpdateMaterial", urlPatterns = {"/UpdateMaterial"})
public class UpdateMaterial extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String unit = request.getParameter("unit");
            String type = request.getParameter("type");
            String category = request.getParameter("category");
            String id = request.getParameter("id");
            
            MaterialDAO dao = new MaterialDAO();
            boolean result = dao.updateMaterial(name, price, unit, type, category, id);
            if (result) {
                request.setAttribute("messtrue", "Cập nhật vật liệu thành công");
            } else {
                request.setAttribute("messefalse", "Cập nhật vật liệu thất bại");
            }
            
            MaterialDAO dao2 = new MaterialDAO();
            Material list = dao2.getByID(id);
            MaterialDAO dao1 = new MaterialDAO();
            List<MaterialCategory> list1 = dao1.getMaterialCategory();
            request.setAttribute("list", list);
            request.setAttribute("list1", list1);
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ShowMaterialDetail.jsp").forward(request, response);
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