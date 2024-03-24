/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuotationHistory;

import DAO.QuotationDAO;
import DTO.AdminHouseComponent;
import DTO.CustomerHouseComponent;
import DTO.HouseComponent;
import DTO.Quotation;
import DTO.AdminQuoVersion;
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
@WebServlet(name = "ShowReponseQuotationVersionDetail", urlPatterns = {"/ShowReponseQuotationVersionDetail"})
public class ShowReponseQuotationVersionDetail extends HttpServlet {

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
            int versionId = Integer.parseInt(request.getParameter("versionId"));
            int adminQuoVersionId = Integer.parseInt(request.getParameter("adminQuoVersionId"));
            QuotationDAO dao4 = new QuotationDAO();
            int quotationId = dao4.getQuotationIdByVersionId(versionId);
            
            QuotationDAO dao = new QuotationDAO();
            List<AdminHouseComponent> listAdminHouseComponent = dao.getListAdminHouseComponentByAdminQuoVersionID(adminQuoVersionId);
            QuotationDAO dao1 = new QuotationDAO();
            AdminQuoVersion adminQuoVersion = dao1.getAdminQuoVersionById(adminQuoVersionId);
            QuotationDAO dao2 = new QuotationDAO();
            Quotation quotation1 = dao2.getQuotationID(quotationId + "");

            //load quotation content info
            int selectedHouseType = quotation1.getHouseType().getId();
            int selectedService = quotation1.getService().getId();
            int selectedStyle = quotation1.getStyle().getId();
            int foundation = adminQuoVersion.getFoundationId();
            int roof = adminQuoVersion.getRoofId();
            int packagePrice = 0;
            String note = adminQuoVersion.getNote();
            QuotationDAO dao3 = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao3.getHouseComponent(selectedHouseType);

            QuotationDAO quotationDao = new QuotationDAO();
            Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);
            if (selectedService == 2 && quotation.getPrice1() == adminQuoVersion.getPrice()) {
                packagePrice = 1;
            } else if(selectedService == 2 && quotation.getPrice2() == adminQuoVersion.getPrice()){
                packagePrice = 2;
            }
            
            request.setAttribute("versionId", versionId);
            request.setAttribute("listAdminHouseComponent", listAdminHouseComponent);
            request.setAttribute("listHouseComponent", listHouseComponent);
            request.setAttribute("adminQuoVersionId", adminQuoVersionId);
            request.setAttribute("selectedHouseType", selectedHouseType);
            request.setAttribute("selectedService", selectedService);
            request.setAttribute("selectedStyle", selectedStyle);
            request.setAttribute("foundation", foundation);
            request.setAttribute("roof", roof);
            request.setAttribute("packagePrice", packagePrice);
            request.setAttribute("note", note);
            request.getRequestDispatcher("WebPages/ViewWebPage/reponseQuotationHistoryVersionDetail.jsp").forward(request, response);
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
