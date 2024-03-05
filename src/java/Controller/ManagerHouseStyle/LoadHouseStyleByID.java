/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerHouseStyle;

import DAO.ComponentDAO;
import DAO.HouseComponentDAO;
import DAO.HouseTypeDAO;
import DTO.Component;
import DTO.ComponentCategory;
import DTO.HouseComponent2;
import DTO.HouseType;
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
@WebServlet(name = "LoadHouseStyleByID", urlPatterns = {"/LoadHouseStyleByID"})
public class LoadHouseStyleByID extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("id");
            int houseid = Integer.parseInt(id);
            HouseTypeDAO dAO = new HouseTypeDAO();
//            List<Style> styles = dAO.getAll();
            HouseType s = dAO.getHouseStyleById(houseid);
            HouseComponentDAO aO = new HouseComponentDAO();
            List<HouseComponent2> list = aO.getHousecomponentbyhousetypeid(houseid);
            ComponentDAO aO1 = new ComponentDAO();
            List<Component> components = aO1.getAll();
            out.println("<form action=\"UpdateHouseStyle\" method=\"POST\" id=\"updatesp\">\n"
                    + "    <div class=\"row\">\n"
                    + "        <div class=\"form-group col-md-6\">\n"
                    + "            <label class=\"control-label\">Mã phong cách </label>\n"
                    + "            <input readonly=\"true\" class=\"form-control\" type=\"text\" name=\"id\" value=\"" + s.getId() + "\" >\n"
                    + "        </div>\n"
                    + "        <div class=\"form-group col-md-6\">\n"
                    + "            <label class=\"control-label\">Tên</label>\n"
                    + "            <input class=\"form-control\" type=\"text\" required name=\"name\" value=\"" + s.getName() + "\" >\n"
                    + "        </div>\n"
                    + "        <div class=\"form-group col-md-6\">\n"
                    + "            <label class=\"control-label\">Danh sách thành phần(Cứng)</label>\n"
                    + "            <ul>");
            for (HouseComponent2 i : list) {
                if (i.getComponent().getId() <= 2) {
                    out.println("<li>" + i.getComponent().getName() + "</li>");
                }
            }
            out.println("</ul>\n"
                    + "        </div>\n"
                    + "        <div class=\"form-group col-md-6\">\n"
                    + "            <label class=\"control-label\">Danh sách thành phần(mềm)</label>\n"
                    + "            <ul>");
            for (Component j : components) {
                if (j.getId() >= 3) { // Chỉ hiển thị những Component có id >= 3
                    boolean isHouseComponent = false;
                    for (HouseComponent2 i : list) {
                        if (i.getComponent().getId() == j.getId()) {
                            isHouseComponent = true;
                            break;
                        }
                    }
                    if (isHouseComponent) {
                        out.println("<input type=\"checkbox\" name=\"componentId\" value=\"" + j.getId() + "\" checked>" + j.getName() + "<br>");
                    } else {
                        out.println("<input type=\"checkbox\" name=\"componentId\" value=\"" + j.getId() + "\">" + j.getName() + "<br>");
                    }
                }
            }
            out.println("</ul>\n"
                    + "        </div>\n"
                    + "    </div>\n"
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadHouseStyleByID.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoadHouseStyleByID.class.getName()).log(Level.SEVERE, null, ex);
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
