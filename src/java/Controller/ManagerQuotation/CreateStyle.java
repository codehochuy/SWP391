/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerQuotation;

import DAO.HouseTypeDAO;
import DAO.QuotationDAO;
import DAO.StyleDAO;
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
@WebServlet(name = "CreateStyle", urlPatterns = {"/CreateStyle"})
public class CreateStyle extends HttpServlet {

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
            out.println("<title>Servlet CreateStyle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateStyle at " + request.getContextPath() + "</h1>");
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
        try {
            request.setCharacterEncoding("UTF-8");
            String styleversion = request.getParameter("styleversion");
            StyleDAO aO = new StyleDAO();
            String name = request.getParameter("style");
            String regex = "^[0-9a-zA-Z\\p{L}\\p{P}][0-9a-zA-Z\\p{L}\\p{P}\\s]*[0-9a-zA-Z\\p{L}\\p{P}]$";
            if (!name.matches(regex)) {
                QuotationDAO dAO9 = new QuotationDAO();
                List<Quotation> list = dAO9.getAll();

                StyleDAO styleDAO9 = new StyleDAO();
                List<Style> styles = styleDAO9.getAll();

                HouseTypeDAO houseTypeDAO9 = new HouseTypeDAO();
                List<HouseType> houseTypes = houseTypeDAO9.getAll();

                request.setAttribute("styles", styles);
                request.setAttribute("houseTypes", houseTypes);
                request.setAttribute("list", list);

                request.setAttribute("messefalse", "Sai tên!!");
                if (styleversion.equalsIgnoreCase("1")) {
                    request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerStyle.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerStyle.jsp").forward(request, response);
                }
            } else {

                boolean result = aO.addStyle(name);
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
                    if (styleversion.equalsIgnoreCase("1")) {
                        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerStyle.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerStyle.jsp").forward(request, response);
                    }

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

                    request.setAttribute("messefalse", "Đã thêm thất bại");
                    if (styleversion.equalsIgnoreCase("1")) {
                        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerStyle.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerStyle.jsp").forward(request, response);
                    }
                }
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
