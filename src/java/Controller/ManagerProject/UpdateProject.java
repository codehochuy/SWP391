/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerProject;

import DAO.HouseTypeDAO;
import DAO.ProjectDAO;
import DAO.ProjectImageDAO;
import DAO.ServiceDAO;
import DAO.StyleDAO;
import DTO.HouseType;
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
@WebServlet(name = "UpdateProject", urlPatterns = {"/UpdateProject"})
public class UpdateProject extends HttpServlet {

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
            String projectidParameter = request.getParameter("projectid");
        int projectid = (projectidParameter != null && !projectidParameter.isEmpty()) ? Integer.parseInt(projectidParameter) : 0;
        String projectname = request.getParameter("projectname");
        String date = request.getParameter("date");
        String serviceParameter = request.getParameter("service");
        int service = (serviceParameter != null && !serviceParameter.isEmpty()) ? Integer.parseInt(serviceParameter) : 0;
        String houseTypesParameter = request.getParameter("houseTypes");
        int houseTypes = (houseTypesParameter != null && !houseTypesParameter.isEmpty()) ? Integer.parseInt(houseTypesParameter) : 0;
        String stylesParameter = request.getParameter("styles");
        int styles = (stylesParameter != null && !stylesParameter.isEmpty()) ? Integer.parseInt(stylesParameter) : 0;
        String description = request.getParameter("description");
        String timeParameter = request.getParameter("time");
        int time = (timeParameter != null && !timeParameter.isEmpty()) ? Integer.parseInt(timeParameter) : 0;

        ProjectDAO dao = new ProjectDAO();
        boolean result = dao.updateProject(projectname, description, date, time, service, houseTypes, styles, projectid);
        if (result) {
            request.setAttribute("messtrue", "Cập nhật dự án thành công");
        } else {
            request.setAttribute("messefalse", "Cập nhật dự án thất bại");
        }

        ProjectDAO dao2 = new ProjectDAO();
        DTO.Project project = dao2.getProjectbyID(projectidParameter);

        ServiceDAO serviceDAO = new ServiceDAO();
        List<Service> listService = serviceDAO.getAll();

        StyleDAO styleDAO = new StyleDAO();
        List<Style> listStyle = styleDAO.getAll();

        HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
        List<HouseType> listHouseType = houseTypeDAO.getAll();

        ProjectImageDAO imageDAO = new ProjectImageDAO();
        List<ProjectImage> images = imageDAO.getProjectImagesByProjectID(projectidParameter);

        request.setAttribute("images", images);
        request.setAttribute("services", listService);
        request.setAttribute("styles", listStyle);
        request.setAttribute("houseTypes", listHouseType);
        request.setAttribute("project", project);
        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerProjectDetail.jsp").forward(request, response);
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