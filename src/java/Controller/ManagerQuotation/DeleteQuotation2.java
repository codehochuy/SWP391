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
@WebServlet(name = "DeleteQuotation2", urlPatterns = {"/DeleteQuotation2"})
public class DeleteQuotation2 extends HttpServlet {

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
            String quotationid = request.getParameter("id");

            QuotationDAO dao = new QuotationDAO();
            boolean result = dao.deleteQuotation(quotationid);
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
                request.setAttribute("messtrue", "Xóa bảng giá thành công");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation2.jsp").forward(request, response);

            } else {
                QuotationDAO dao1 = new QuotationDAO();
                List<Quotation> list = dao1.getAll();
                request.setAttribute("list", list);
                request.setAttribute("messefalse", "Xóa bảng giá thất bại");
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation2.jsp").forward(request, response);
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
