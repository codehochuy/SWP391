/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuotationHistory;

import DAO.QuotationDAO;
import DTO.CustomerHouseComponent;
import DTO.HouseComponent;
import DTO.Quotation;
import DTO.QuotationVersion;
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
@WebServlet(name = "ShowQuotationVersionDetail", urlPatterns = {"/ShowQuotationVersionDetail"})
public class ShowQuotationVersionDetail extends HttpServlet {

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
            int cusQuoId = Integer.parseInt(request.getParameter("cusQuoId"));
            int versionId = Integer.parseInt(request.getParameter("versionId"));
            int quotationId = Integer.parseInt(request.getParameter("quotationId"));
            QuotationDAO dao = new QuotationDAO();
            List<CustomerHouseComponent> listCustomerHouseComponent = dao.getListCustomerHouseComponentByVersionId(versionId);
            QuotationDAO dao1 = new QuotationDAO();
            QuotationVersion cusQuoVersion = dao1.getCusQuoVersionById(versionId);
            QuotationDAO dao2 = new QuotationDAO();
            Quotation quotation1 = dao2.getQuotationID(quotationId + "");

            //load quotation content info
            int selectedHouseType = quotation1.getHouseType().getId();
            int selectedService = quotation1.getService().getId();
            int selectedStyle = quotation1.getStyle().getId();
            int foundation = cusQuoVersion.getFoundationId();
            int roof = cusQuoVersion.getRoofId();
            int packagePrice = 0;
            
            QuotationDAO dao3 = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao3.getHouseComponent(selectedHouseType);

            QuotationDAO quotationDao = new QuotationDAO();
            Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);
            if (selectedService == 2 && quotation.getPrice1() == cusQuoVersion.getPrice()) {
                packagePrice = 1;
            } else if(selectedService == 2 && quotation.getPrice2() == cusQuoVersion.getPrice()){
                packagePrice = 2;
            }
            

            request.setAttribute("listCustomerHouseComponent", listCustomerHouseComponent);
            request.setAttribute("cusQuoVersion", cusQuoVersion);
            request.setAttribute("cusQuoId", cusQuoId);
            request.setAttribute("selectedHouseType", selectedHouseType);
            request.setAttribute("selectedService", selectedService);
            request.setAttribute("selectedStyle", selectedStyle);
            request.setAttribute("foundation", foundation);
            request.setAttribute("roof", roof);
            request.setAttribute("packagePrice", packagePrice);
            request.getRequestDispatcher("WebPages/ViewWebPage/quotationHistoryVersionDetail.jsp").forward(request, response);
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
