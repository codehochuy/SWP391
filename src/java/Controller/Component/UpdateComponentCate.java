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
@WebServlet(name = "UpdateComponentCate", urlPatterns = {"/UpdateComponentCate"})
public class UpdateComponentCate extends HttpServlet {

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
            out.println("<title>Servlet UpdateComponentCate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateComponentCate at " + request.getContextPath() + "</h1>");
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
        String category = request.getParameter("category");
        String areapercent = request.getParameter("areapercent");
        String regex = "^[0-9a-zA-Z\\p{L}\\p{P}][0-9a-zA-Z\\p{L}\\p{P}\\s]*[0-9a-zA-Z\\p{L}\\p{P}]$";
        int areapercentValue = Integer.parseInt(areapercent);
        if (!name.matches(regex) || areapercentValue < 1 || areapercentValue > 100) {
            RoofNFoundationDAO dao1 = new RoofNFoundationDAO();
            List<RoofNFoundation> foundations = dao1.getAll();
            request.setAttribute("foundations", foundations);
            request.setAttribute("messefalse", "Sai tên hoặc % diện tích");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerRoof.jsp").forward(request, response);
        } else {

            RoofNFoundationDAO dao = new RoofNFoundationDAO();
            boolean result = dao.updateComponentCateName(id, name, category, areapercent);
            if (result) {
                RoofNFoundationDAO dao1 = new RoofNFoundationDAO();
                List<RoofNFoundation> foundations = dao1.getAll();
                request.setAttribute("foundations", foundations);
                request.setAttribute("messtrue", "Cập nhật thành phần thành công");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerRoof.jsp").forward(request, response);
            } else {
                RoofNFoundationDAO dao1 = new RoofNFoundationDAO();
                List<RoofNFoundation> foundations = dao1.getAll();
                request.setAttribute("foundations", foundations);
                request.setAttribute("messefalse", "Cập nhật thành phần thất bại");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerRoof.jsp").forward(request, response);
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
