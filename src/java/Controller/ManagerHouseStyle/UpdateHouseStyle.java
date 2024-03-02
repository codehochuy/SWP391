/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerHouseStyle;

import DAO.HouseComponentDAO;
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
@WebServlet(name = "UpdateHouseStyle", urlPatterns = {"/UpdateHouseStyle"})
public class UpdateHouseStyle extends HttpServlet {

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
            out.println("<title>Servlet UpdateHouseStyle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateHouseStyle at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int housetypeid = Integer.parseInt(id);
        String[] componentIds = request.getParameterValues("componentId");
        if (componentIds != null) {
            HouseComponentDAO aO2 = new HouseComponentDAO();
            aO2.deleteHouseComponent(housetypeid);
            for (String component : componentIds) {
                HouseComponentDAO houseComponentDAO = new HouseComponentDAO();
                int componentID = Integer.parseInt(component);
                houseComponentDAO.createHouseComponent(housetypeid, componentID);
            }
            HouseTypeDAO dao = new HouseTypeDAO();
            boolean result = dao.updateHouseStyleName(id, name);
            if (result) {
                HouseTypeDAO aO = new HouseTypeDAO();
                List<HouseType> houseTypes = aO.getAll();
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("messtrue", "Cập nhật kiểu nhà công");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerHouseStyle.jsp").forward(request, response);
            } else {
                HouseTypeDAO aO = new HouseTypeDAO();
                List<HouseType> houseTypes = aO.getAll();
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("messefalse", "Cập nhật kiểu nhà thất bại");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerHouseStyle.jsp").forward(request, response);
            }

        } else {
            HouseTypeDAO aO = new HouseTypeDAO();
            List<HouseType> houseTypes = aO.getAll();
            request.setAttribute("houseTypes", houseTypes);
            request.setAttribute("messefalse", "Cập nhật kiểu nhà thất bại. Vui lòng chọn ít nhất 1 thành phần");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerHouseStyle.jsp").forward(request, response);

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
