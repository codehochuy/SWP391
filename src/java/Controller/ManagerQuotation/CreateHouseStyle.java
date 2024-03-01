/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerQuotation;

import DAO.ComponentDAO;
import DAO.HouseComponentDAO;
import DAO.HouseTypeDAO;
import DAO.QuotationDAO;
import DAO.StyleDAO;
import DTO.Component;
import DTO.HouseType;
import DTO.Quotation;
import DTO.Style;
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
@WebServlet(name = "CreateHouseStyle", urlPatterns = {"/CreateHouseStyle"})
public class CreateHouseStyle extends HttpServlet {

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
            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            List<HouseType> houseTypes = houseTypeDAO.getAll();
            request.setAttribute("houseTypes", houseTypes);
            ComponentDAO aO = new ComponentDAO();
            List<Component> component = aO.getAll();
            request.setAttribute("component", component);
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/CreateHouseStyle.jsp").forward(request, response);
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
        try {
            request.setCharacterEncoding("UTF-8");
            String houseType = request.getParameter("housetype");
            String[] components = request.getParameterValues("components");
            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            boolean result = houseTypeDAO.addHouseStyle(houseType);

            if (result) {
                HouseTypeDAO houseTypeDAO1 = new HouseTypeDAO();
                int newHouseTypeID = houseTypeDAO1.getLatestHouseTypeID();
                HouseComponentDAO aO = new HouseComponentDAO();
                aO.createHouseComponent(newHouseTypeID, 1);
                HouseComponentDAO aO1 = new HouseComponentDAO();
                aO1.createHouseComponent(newHouseTypeID, 2);
                for (String component : components) {
                    HouseComponentDAO houseComponentDAO = new HouseComponentDAO();
                    int componentID = Integer.parseInt(component);
                    houseComponentDAO.createHouseComponent(newHouseTypeID, componentID);
                }
                request.setAttribute("messtrue", "Đã thêm thành công");
            } else {
                request.setAttribute("messefalse", "Đã thêm thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateHouseStyle.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Đã xảy ra lỗi khi thêm");
        }

        // Gửi dữ liệu lấy từ database tới trang JSP
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
