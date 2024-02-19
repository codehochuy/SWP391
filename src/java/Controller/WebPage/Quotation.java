/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.WebPage;

import DAO.HouseTypeDAO;
import DAO.QuotationDAO;
import DAO.ServiceDAO;
import DAO.StyleDAO;
import DTO.HouseType;
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
 * @author PC
 */
@WebServlet(name = "Quotation", urlPatterns = {"/Quotation"})
public class Quotation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            ServiceDAO serviceDao = new ServiceDAO();
            List<DTO.Service> listService = serviceDao.getAll();
            HouseTypeDAO houseTypeDao = new HouseTypeDAO();
            List<HouseType> listHouseType = houseTypeDao.getAll();
            StyleDAO styleDao = new StyleDAO();
            List<Style> listStyle = styleDao.getAll();
            QuotationDAO quotationDao = new QuotationDAO();
            List<DTO.Quotation> listQuotation = quotationDao.getAll();
            
            
            request.setAttribute("listService", listService);
            request.setAttribute("listHouseType", listHouseType);
            request.setAttribute("listStyle", listStyle);
            request.setAttribute("listQuotation", listQuotation);
            request.getRequestDispatcher("WebPages/ViewWebPage/quotation.jsp").forward(request, response);
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
