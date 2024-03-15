/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.AdminQuotation;

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
 * @author ACER
 */
@WebServlet(name = "saveadminquotation", urlPatterns = {"/saveadminquotation"})
public class saveadminquotation extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("USER");
            int userId = user.getId();
            int selectedHouseType = Integer.parseInt(request.getParameter("houseType"));
            int selectedService = Integer.parseInt(request.getParameter("service"));
            int selectedStyle = Integer.parseInt(request.getParameter("style"));
            int packagePrice = (request.getParameter("packagePrice") != null && !request.getParameter("packagePrice").isEmpty()) ? Integer.parseInt(request.getParameter("packagePrice")) : 0;
            int foundationId = (request.getParameter("foundation") != null && !request.getParameter("foundation").isEmpty()) ? Integer.parseInt(request.getParameter("foundation")) : 0;
            int roofId = (request.getParameter("roof") != null && !request.getParameter("roof").isEmpty()) ? Integer.parseInt(request.getParameter("roof")) : 0;
            double price = (request.getParameter("price") != null && !request.getParameter("price").isEmpty()) ? Double.parseDouble(request.getParameter("price")) : 0.0;
            String note = (request.getParameter("note") != null && !request.getParameter("note").isEmpty()) ? request.getParameter("note") : "";
             
            QuotationDAO dao = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao.getHouseComponent(selectedHouseType);
            double totalPrice = (request.getParameter("totalPrice") != null && !request.getParameter("totalPrice").isEmpty()) ? Double.parseDouble(request.getParameter("totalPrice")) : 0.0;

            QuotationDAO quotationDao = new QuotationDAO();
            DTO.Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);
            int quotationId = quotation.getId();

            QuotationDAO dao2 = new QuotationDAO();
            int cusQuoId = dao2.getCusQuoId();
            QuotationDAO dao3 = new QuotationDAO();
            boolean createCusQuoVersion = dao3.createCusQuoVersion(price,totalPrice, foundationId, roofId, cusQuoId, note);
            boolean createCustomerHouseComponent = false;
            if (createCusQuoVersion) {
                for (int i = 0; i < listHouseComponent.size(); i++) {
                HouseComponent houseComponent = listHouseComponent.get(i);
                QuotationDAO dao4 = new QuotationDAO();
                int versionId = dao4.getVersionId();
                double value = (request.getParameter(houseComponent.getComponentId()+"") != null && !request.getParameter(houseComponent.getComponentId()+"").isEmpty()) ? Double.parseDouble(request.getParameter(houseComponent.getComponentId()+"")) : 0.0;
                int componentID = houseComponent.getComponentId();
                QuotationDAO dao5 = new QuotationDAO();
                if (!(value == 0)){
                    createCustomerHouseComponent = dao5.createCustomerHouseComponent(value, versionId, componentID);
                }
            }
            }
            

            if (createCustomerHouseComponent && createCusQuoVersion) {
                out.println("<h1 style=\"color: red;\">Gửi báo giá cho khách hàng thành công</h1>");
            } else {
                out.println("<h1 style=\"color: red;\">Gửi báo giá cho khách hàng thất bại!</h1>");
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
