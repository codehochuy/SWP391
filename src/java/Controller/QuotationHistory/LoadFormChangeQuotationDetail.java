/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuotationHistory;

import DAO.QuotationDAO;
import DTO.HouseComponent;
import DTO.RoofNFoundation2;
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
@WebServlet(name = "LoadFormChangeQuotationDetail", urlPatterns = {"/LoadFormChangeQuotationDetail"})
public class LoadFormChangeQuotationDetail extends HttpServlet {

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
            int selectedHouseType = Integer.parseInt(request.getParameter("houseType"));
            int selectedService = Integer.parseInt(request.getParameter("service"));
            int selectedStyle = Integer.parseInt(request.getParameter("style"));
            int cusQuoId = Integer.parseInt(request.getParameter("cusQuoId"));
            QuotationDAO dao = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao.getHouseComponent(selectedHouseType);
            QuotationDAO dao1 = new QuotationDAO();
            List<RoofNFoundation2> listFoundation = dao1.getFoundation();
            QuotationDAO dao2 = new QuotationDAO();
            List<RoofNFoundation2> listRoof = dao2.getRoof();
            QuotationDAO quotationDao = new QuotationDAO();
            DTO.Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);

            int roofId = (request.getParameter("roof") != null && !request.getParameter("roof").isEmpty()) ? Integer.parseInt(request.getParameter("roof")) : 0;
            int foundationId = (request.getParameter("foundation") != null && !request.getParameter("foundation").isEmpty()) ? Integer.parseInt(request.getParameter("foundation")) : 0;
            int packagePrice = (request.getParameter("packagePrice") != null && !request.getParameter("packagePrice").isEmpty()) ? Integer.parseInt(request.getParameter("packagePrice")) : 0;
            String note = (request.getParameter("note") != null && !request.getParameter("note").isEmpty()) ? request.getParameter("note") : "";

            if (selectedService == 2) {
                out.println("<div class=\"control-group\">\n"
                        + "    <h5>Chọn gói xây dựng</h5>\n"
                        + "    <select name=\"packagePrice\" id=\"packagePrice\">\n"
                        + "        <option value=\"1\"" + (packagePrice == 1 ? " selected" : "") + ">Gói tiết kiệm</option>\n"
                        + "        <option value=\"2\"" + (packagePrice == 2 ? " selected" : "") + ">Gói VIP</option>\n"
                        + "    </select>\n"
                        + "    <p class=\"help-block text-danger\"></p>\n"
                        + "</div>");
            }
            for (int i = 0; i < listHouseComponent.size(); i++) {
                HouseComponent houseComponent = listHouseComponent.get(i);
                double value = (request.getParameter(houseComponent.getComponentId() + "") != null && !request.getParameter(houseComponent.getComponentId() + "").isEmpty()) ? Double.parseDouble(request.getParameter(houseComponent.getComponentId() + "")) : 0;
                if (houseComponent.getComponentId() <= 6) {
                    if (houseComponent.getComponentId() == 5) {
                        out.println("<div class=\"control-group\">\n"
                                + "                                        <h5>Nhập " + houseComponent.getComponent() + " (số tầng)</h5>\n"
                                + "                                        <input type=\"number\"  class=\"form-control\" name=\"" + houseComponent.getComponentId() + "\" id=\"" + houseComponent.getComponentId() + "\" placeholder=\"Nhập " + houseComponent.getComponent() + " xây dựng\"\n"
                                + "                                                 value=\"" + value + "\"\n"
                                + "                                               required=\"required\"\n"
                                + "                                               data-validation-required-message=\"Vui lòng nhập " + houseComponent.getComponent() + " xây dựng\" />\n"
                                + "                                        <p class=\"help-block text-danger\"></p>\n"
                                + "<span id=\"error_" + houseComponent.getComponentId() + "\" class=\"error\"></span>"
                                + "                                    </div>");
                    } else {
                        out.println("<div class=\"control-group\">\n"
                                + "                                        <h5>Nhập " + houseComponent.getComponent() + " (m)</h5>\n"
                                + "                                        <input type=\"text\" oninput=\"this.value = this.value.replace(/[^\\d.]/g, '').replace(/(\\..*)\\./g, '$1');\" class=\"form-control\" name=\"" + houseComponent.getComponentId() + "\" id=\"" + houseComponent.getComponentId() + "\" placeholder=\"Nhập " + houseComponent.getComponent() + " xây dựng (m)\"\n"
                                + "                                               value=\"" + value + "\"\n"
                                + "                                               required=\"required\"\n"
                                + "                                               data-validation-required-message=\"Vui lòng nhập " + houseComponent.getComponent() + " xây dựng\" />\n"
                                + "                                        <p class=\"help-block text-danger\"></p>\n"
                                + "<span id=\"error_" + houseComponent.getComponentId() + "\" class=\"error\"></span>"
                                + "                                    </div>");
                    }
                } else {
                    out.println("<div class=\"control-group\">\n"
                            + "                                        <h5>Nhập " + houseComponent.getComponent() + " (m2)</h5>\n"
                            + "                                        <input type=\"text\" oninput=\"this.value = this.value.replace(/[^\\d.]/g, '').replace(/(\\..*)\\./g, '$1');\" class=\"form-control\" name=\"" + houseComponent.getComponentId() + "\" id=\"" + houseComponent.getComponentId() + "\" placeholder=\"Nhập " + houseComponent.getComponent() + " xây dựng (m2)\"\n"
                            + "                                                 value=\"" + value + "\"\n"
                            + "                                               required=\"required\"\n"
                            + "                                               data-validation-required-message=\"Vui lòng nhập " + houseComponent.getComponent() + " xây dựng\" />\n"
                            + "                                        <p class=\"help-block text-danger\"></p>\n"
                            + "<span id=\"error_" + houseComponent.getComponentId() + "\" class=\"error\"></span>"
                            + "                                    </div>");
                }
            }

            out.println("<div class=\"control-group\">\n"
                    + "    <h5>Chọn Móng</h5>\n"
                    + "    <select name=\"foundation\" title=\"Chọn loại móng\" id=\"foundation\">\n");

            for (RoofNFoundation2 f : listFoundation) {
                String selected = "";
                if (f.getRoofNFoundationId() == foundationId) {
                    selected = "selected";
                }
                out.println("    <option value=\"" + f.getRoofNFoundationId() + "\"" + selected + ">" + f.getRoofNFoundationName() + "</option>\n");
            }

            out.println("    </select>\n"
                    + "    <p class=\"help-block text-danger\"></p>\n"
                    + "</div>");

            out.println("<div class=\"control-group\">\n"
                    + "    <h5>Chọn Mái</h5>\n"
                    + "    <select name=\"roof\" title=\"Chọn loại mái\" id=\"roof\">\n");

            for (RoofNFoundation2 r : listRoof) {
                String selected = "";
                if (r.getRoofNFoundationId() == roofId) {
                    selected = "selected";
                }
                out.println("    <option value=\"" + r.getRoofNFoundationId() + "\"" + selected + ">" + r.getRoofNFoundationName() + "</option>\n");
            }

            out.println("    </select>\n"
                    + "    <p class=\"help-block text-danger\"></p>\n"
                    + "</div>");
            out.println("<div class=\"control-group note\">\n"
                    + "    <h5>Ghi chú</h5>\n"
                    + "    <textarea class=\"form-control ghi-chu\" id=\"note\" name=\"note\" placeholder=\"Nội dung ghi chú\">" + note + "</textarea>\n"
                    + "</div>");

            out.println("<input type=\"hidden\" id=\"service\" name=\"service\" value=\"" + selectedService + "\"/>");
            out.println("<input type=\"hidden\" id=\"houseType\" name=\"houseType\" value=\"" + selectedHouseType + "\"/>");
            out.println("<input type=\"hidden\" id=\"style\" name=\"style\" value=\"" + selectedStyle + "\"/>");
            out.println("<input type=\"hidden\" id=\"cusQuoId\" name=\"cusQuoId\" value=\"" + cusQuoId + "\"/>");

            out.println("<div>\n"
                    + "                                        <button class=\"btn\" type=\"submit\" style=\"border: 1px solid #FFD700;\" >Nhận Báo Giá</button>\n"
                    + "                                    </div>");

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
