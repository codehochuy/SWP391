/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerHouseStyle;

import DAO.HouseTypeDAO;
import DTO.HouseType;
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
 * @author ACER
 */
@WebServlet(name = "DeleteHouseStyle", urlPatterns = {"/DeleteHouseStyle"})
public class DeleteHouseStyle extends HttpServlet {

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
            String id = request.getParameter("id");
            int house = Integer.parseInt(id);
            HouseTypeDAO dao = new HouseTypeDAO();
            boolean result = dao.deleteHouseStyle(house);
            if (result) {
                HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
                List<HouseType> houseTypes = houseTypeDAO.getAll();
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("messtrue", "Xóa kiểu nhà công");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerHouseStyle.jsp").forward(request, response);

            } else {
                HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
                 List<HouseType> houseTypes = houseTypeDAO.getAll();
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("messefalse", "Xóa kiểu nhà thất bại");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerHouseStyle.jsp").forward(request, response);
            }
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
