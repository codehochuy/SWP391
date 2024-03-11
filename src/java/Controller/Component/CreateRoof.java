/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Component;

import DAO.ComponentDAO;
import DAO.RoofNFoundationDAO;
import DTO.Component;
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
@WebServlet(name = "CreateRoof", urlPatterns = {"/CreateRoof"})
public class CreateRoof extends HttpServlet {

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
            out.println("<title>Servlet CreateRoof</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateRoof at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("name");
        String area = request.getParameter("area");
         int areaValue = Integer.parseInt(area);
        String regex = "^[0-9a-zA-Z\\p{L}\\p{P}][0-9a-zA-Z\\p{L}\\p{P}\\s]*[0-9a-zA-Z\\p{L}\\p{P}]$";
       if (!name.matches(regex) || areaValue < 1 || areaValue > 100) {
            RoofNFoundationDAO dao = new RoofNFoundationDAO();
            List<RoofNFoundation> foundations = dao.getAll();
            request.setAttribute("foundations", foundations);
            request.setAttribute("messefalse", "Kiểm tra tên hoặc % diện tích");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerRoof.jsp").forward(request, response);
        } else {
            try {
                RoofNFoundationDAO aO = new RoofNFoundationDAO();
                boolean result = aO.addRoof(name, area);
                if (result) {

                    RoofNFoundationDAO dao = new RoofNFoundationDAO();
                    List<RoofNFoundation> foundations = dao.getAll();
                    request.setAttribute("foundations", foundations);
                    request.setAttribute("messtrue", "Đã thêm thành công");
                    request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerRoof.jsp").forward(request, response);

                } else {
                    RoofNFoundationDAO dao = new RoofNFoundationDAO();
                    List<RoofNFoundation> foundations = dao.getAll();
                    request.setAttribute("foundations", foundations);
                    request.setAttribute("messefalse", "Đã thêm thất bại");
                    request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerRoof.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CreateComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
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
