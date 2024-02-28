/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerQuotation;

import DAO.ComponentDAO;
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
            HouseTypeDAO aO = new HouseTypeDAO();
            String name = request.getParameter("housestyle");
            boolean result = aO.addHouseStyle(name);
            if (result) {
                QuotationDAO dAO = new QuotationDAO();
                List<Quotation> list = dAO.getAll();

                StyleDAO styleDAO = new StyleDAO();
                List<Style> styles = styleDAO.getAll();

                HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
                List<HouseType> houseTypes = houseTypeDAO.getAll();

                request.setAttribute("styles", styles);
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("list", list);

                request.setAttribute("messtrue", "Đã thêm thành công");

                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/CreateHouseStyle.jsp").forward(request, response);

            } else {
                QuotationDAO dAO = new QuotationDAO();
                List<Quotation> list = dAO.getAll();

                StyleDAO styleDAO = new StyleDAO();
                List<Style> styles = styleDAO.getAll();

                HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
                List<HouseType> houseTypes = houseTypeDAO.getAll();

                request.setAttribute("styles", styles);
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("list", list);

                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerHouseStyle.jsp").forward(request, response);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateHouseStyle.class.getName()).log(Level.SEVERE, null, ex);
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
