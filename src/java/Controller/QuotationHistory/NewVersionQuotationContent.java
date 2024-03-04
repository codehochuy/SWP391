/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuotationHistory;

import DAO.QuotationDAO;
import DTO.HouseComponent;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "NewVersionQuotationContent", urlPatterns = {"/NewVersionQuotationContent"})
public class NewVersionQuotationContent extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("USER");
            int userId = user.getId();
            int selectedHouseType = Integer.parseInt(request.getParameter("houseType"));
            int selectedService = Integer.parseInt(request.getParameter("service"));
            int selectedStyle = Integer.parseInt(request.getParameter("style"));
            int packagePrice = (request.getParameter("packagePrice") != null && !request.getParameter("packagePrice").isEmpty()) ? Integer.parseInt(request.getParameter("packagePrice")) : 0;
            int foundationId = (request.getParameter("foundationId") != null && !request.getParameter("foundationId").isEmpty()) ? Integer.parseInt(request.getParameter("foundationId")) : 0;
            int roofId = (request.getParameter("roofId") != null && !request.getParameter("roofId").isEmpty()) ? Integer.parseInt(request.getParameter("roofId")) : 0;
            double price = (request.getParameter("price") != null && !request.getParameter("price").isEmpty()) ? Double.parseDouble(request.getParameter("price")) : 0.0;

            QuotationDAO dao = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao.getHouseComponent(selectedHouseType);
            double[] xValues = new double[listHouseComponent.size()];

            for (int i = 1; i <= listHouseComponent.size(); i++) {
                String iString = i + "";
                double x = (request.getParameter(iString) != null && !request.getParameter(iString).isEmpty()) ? Double.parseDouble(request.getParameter(iString)) : 0;

                // Lưu trữ giá trị x vào mảng hoặc danh sách tương ứng
                xValues[i - 1] = x;
            }

            QuotationDAO quotationDao = new QuotationDAO();
            DTO.Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);
            int quotationId = quotation.getId();

            QuotationDAO dao2 = new QuotationDAO();
            int cusQuoId = dao2.getCusQuoId();
            QuotationDAO dao3 = new QuotationDAO();
            boolean createCusQuoVersion = dao3.createCusQuoVersion(price, foundationId, roofId, cusQuoId);
            boolean createCustomerHouseComponent = false;
            if (createCusQuoVersion) {
                for (int i = 0; i < listHouseComponent.size(); i++) {
                HouseComponent houseComponent = listHouseComponent.get(i);
                double xValue = xValues[i];
                QuotationDAO dao4 = new QuotationDAO();
                int versionId = dao4.getVersionId();
                int componentID = houseComponent.getComponentId();
                QuotationDAO dao5 = new QuotationDAO();
                createCustomerHouseComponent = dao5.createCustomerHouseComponent(xValue, versionId, componentID);
                if (createCustomerHouseComponent != true) {
                    break;
                }
            }
            }
            

            if (createCustomerHouseComponent && createCusQuoVersion) {
                out.println("<h1 style=\"color: red;\">Lưu báo giá thành công!</h1>");
            } else {
                out.println("<h1 style=\"color: red;\">Lưu báo giá thất bại!</h1>");
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
