/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Component;

import DAO.ComponentCategoryDAO;
import DAO.ComponentDAO;
import DAO.RoofNFoundationDAO;
import DTO.Component;
import DTO.ComponentCategory;
import DTO.RoofNFoundation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoadRoofByID", urlPatterns = {"/LoadRoofByID"})
public class LoadRoofByID extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            int styleId = Integer.parseInt(id);
            RoofNFoundationDAO dAO = new RoofNFoundationDAO();
//            List<Style> styles = dAO.getAll();
            RoofNFoundation s = dAO.getComponentCateById(styleId);

            ComponentCategoryDAO cdo = new ComponentCategoryDAO();
            List<ComponentCategory> categories = cdo.getAll();
            out.println("<form action=\"UpdateComponentCate\" method=\"POST\" id=\"updatesp\">\n"
                    + "                            <div class=\"row\">\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Mã phong cách </label>\n"
                    + "                                    <input readonly=\"true\" class=\"form-control\" type=\"text\" name=\"id\" value=\"" + s.getId() + "\" >\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Tên</label>\n"
                    + "                                    <input class=\"form-control\" type=\"text\" required name=\"name\" value=\"" + s.getCategoryname() + "\" >\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Tên</label>\n"
                    + "                                    <input class=\"form-control\" type=\"text\" required name=\"areapercent\" value=\"" + s.getAreaPercent()+ "\" >\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label for=\"exampleSelect1\" class=\"control-label\">Phân loại</label>\n"
                    + "                                    <select class=\"form-control\" name=\"category\">\n");
            for (ComponentCategory i : categories) {
                if (i.getId() == s.getCategory().getId()) {
                    out.println("<option selected value=\"" + i.getId() + "\">" + i.getName() + "</option>");
                } else {
                    out.println("<option value=\"" + i.getId() + "\">" + i.getName() + "</option>");
                }
            }
            out.println("                                    </select>\n");
            out.println("                                </div>\n"
                    + "                            </div>\n"
                    + "                            <BR>\n"
                    + "                            <BR>\n"
                    + "                            <BR>\n"
                    + "                            <button class=\"btn btn-save\" type=\"submit\">Lưu lại</button>\n"
                    + "                            <a class=\"btn btn-cancel\" data-dismiss=\"modal\" href=\"#\">Hủy bỏ</a>\n"
                    + "                            <BR>\n"
                    + "                        </form>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadRoofByID.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadRoofByID.class.getName()).log(Level.SEVERE, null, ex);
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
