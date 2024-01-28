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
import DAO.UserDAO;
import DTO.HouseType;
import DTO.ProjectImage;
import DTO.Service;
import DTO.Style;
import DTO.User;
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
@WebServlet(name = "CreateProject", urlPatterns = {"/CreateProject"})
public class CreateProject extends HttpServlet {

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
            ServiceDAO serviceDAO = new ServiceDAO();
            List<Service> services = serviceDAO.getAll();

            StyleDAO styleDAO = new StyleDAO();
            List<Style> styles = styleDAO.getAll();

            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            List<HouseType> houseTypes = houseTypeDAO.getAll();

            UserDAO aO = new UserDAO();
            List<User> user = aO.getAll();

            request.setAttribute("services", services);
            request.setAttribute("user", user);
            request.setAttribute("styles", styles);
            request.setAttribute("houseTypes", houseTypes);

            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/CreateProject.jsp").forward(request, response);
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
        String projectname = request.getParameter("projectname");
        String date = request.getParameter("date");
//        int time = Integer.parseInt(request.getParameter("time"));
        int service = Integer.parseInt(request.getParameter("service"));
        int houseTypes = Integer.parseInt(request.getParameter("houseTypes"));
        int styles = Integer.parseInt(request.getParameter("styles"));
        String description = request.getParameter("description");
        String timeParameter = request.getParameter("time");
        int time = (timeParameter != null && !timeParameter.isEmpty()) ? Integer.parseInt(timeParameter) : 0;
        int userid = Integer.parseInt(request.getParameter("user"));

        ProjectDAO dao = new ProjectDAO();
        boolean result = dao.createProject(projectname, description, date, time, service, houseTypes, styles, userid);

        if (result) {
            request.setAttribute("messtrue", "Thêm dự án thành công");
            int projectid = dao.getProjectId();
            ProjectImageDAO aO = new ProjectImageDAO();
        } else {
            request.setAttribute("messefalse", "Thêm dự án thất bại");
        }

//        
//        response.sendRedirect(request.getContextPath() + "/CreateProject");
        doGet(request, response);
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
