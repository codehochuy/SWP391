/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuotationHistory;

import DAO.QuotationDAO;
import DTO.AdminQuoVersion;
import DTO.HouseComponent;
import DTO.RoofNFoundation2;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
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
@WebServlet(name = "LoadReponseQuotationContentVersionDetail4View", urlPatterns = {"/LoadReponseQuotationContentVersionDetail4View"})
public class LoadReponseQuotationContentVersionDetail4View extends HttpServlet {

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
            int roofId = (request.getParameter("roof") != null && !request.getParameter("roof").isEmpty()) ? Integer.parseInt(request.getParameter("roof")) : 0;
            int foundationId = (request.getParameter("foundation") != null && !request.getParameter("foundation").isEmpty()) ? Integer.parseInt(request.getParameter("foundation")) : 0;
            int packagePrice = (request.getParameter("packagePrice") != null && !request.getParameter("packagePrice").isEmpty()) ? Integer.parseInt(request.getParameter("packagePrice")) : 0;
            String note = (request.getParameter("note") != null && !request.getParameter("note").isEmpty()) ? request.getParameter("note") : "";
            int versionId = (request.getParameter("versionId") != null && !request.getParameter("versionId").isEmpty()) ? Integer.parseInt(request.getParameter("versionId")) : 0;
            int adminQuoVersionId = (request.getParameter("adminQuoVersionId") != null && !request.getParameter("adminQuoVersionId").isEmpty()) ? Integer.parseInt(request.getParameter("adminQuoVersionId")) : 0;

            int cusQuoId = (request.getParameter("cusQuoId") != null && !request.getParameter("cusQuoId").isEmpty()) ? Integer.parseInt(request.getParameter("cusQuoId")) : 0;
            QuotationDAO dao = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao.getHouseComponent(selectedHouseType);
            QuotationDAO dao1 = new QuotationDAO();
            AdminQuoVersion adminQuoVersion = dao1.getAdminQuoVersionById(adminQuoVersionId);
            LocalDateTime quotationDate = adminQuoVersion.getDate();
            LocalDateTime now = LocalDateTime.now();
            QuotationDAO quotationDao = new QuotationDAO();
            DTO.Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);

            Double length = (request.getParameter("1") != null && !request.getParameter("1").isEmpty()) ? Double.parseDouble(request.getParameter("1")) : 0;
            Double width = (request.getParameter("2") != null && !request.getParameter("2").isEmpty()) ? Double.parseDouble(request.getParameter("2")) : 0;
            double frontYard = (request.getParameter("3") != null && !request.getParameter("3").isEmpty()) ? Double.parseDouble(request.getParameter("3")) : 0;
            double backYard = (request.getParameter("4") != null && !request.getParameter("4").isEmpty()) ? Double.parseDouble(request.getParameter("4")) : 0;
            double floor = (request.getParameter("5") != null && !request.getParameter("5").isEmpty()) ? Double.parseDouble(request.getParameter("5")) : 0;
            double balcony = (request.getParameter("6") != null && !request.getParameter("6").isEmpty()) ? Double.parseDouble(request.getParameter("6")) : 0;

            double price = adminQuoVersion.getPrice();
            double S = length * width;
            double s = (length - frontYard - backYard) * width;
            double totalArea = 0;
//            if (selectedService == 2 && packagePrice != 0) {
//                if (packagePrice == 1) {
//                    price = quotation.getPrice1();
//                } else {
//                    price = quotation.getPrice2();
//                }
//            } else {
//                if (S >= 200) {
//                    price = quotation.getPrice1();
//                } else {
//                    price = quotation.getPrice2();
//                }
//            }
            double sFrontYard = 0;
            double sBackYard = 0;
            double sBalcony = 0;
            double sFoundation = 0;
            double sRoof = 0;
            //print out result
            out.println("<h4 style=\"color: white;\">Phản hồi báo giá của TITAN</h4>");
            out.println("<p>Kết quả tính diện tích và chi phí xây nhà</p>");
            out.println("<p>Bạn cần " + quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName() + " với diện tích là " + width + "m x " + length + "m:</p>");
            DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
            String formatteds = decimalFormat2.format(s);
            out.println("<p>Diện tích tầng trệt: " + s + "m2 x 100% = " + formatteds + "m2</p>");
            totalArea += s;
            if (floor != 0) {
                for (int i = 1; i <= floor; i++) {
                    out.println("<p>Lầu " + i + ": " + s + "m2 x 100% = " + formatteds + "m2</p>");
                }
                totalArea += s * floor;
            }

            if (balcony != 0 && floor != 0) {
                sBalcony = (width * balcony) * floor;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedsBalcony = decimalFormat.format(sBalcony);
                out.println("<p>Ban công: " + (width * balcony) + "m2 x " + floor + " lầu = " + formattedsBalcony + "m2</p>");
                totalArea += sBalcony;
            } else if (balcony != 0) {
                sBalcony = (width * balcony);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedsBalcony = decimalFormat.format(sBalcony);
                out.println("<p>Ban công: " + formattedsBalcony + "m2</p>");
                totalArea += sBalcony;
            }

            if (frontYard != 0) {
                sFrontYard = (width * frontYard) * 0.5;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSFrontYard = decimalFormat.format(sFrontYard);
                out.println("<p>Diện tích sân trước: " + width * frontYard + "m2 x 50% = " + formattedSFrontYard + "m2</p>");
                totalArea += sFrontYard;
            }
            if (backYard != 0) {
                sBackYard = (width * backYard) * 0.5;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSBackYard = decimalFormat.format(sBackYard);
                out.println("<p>Diện tích sân sau: " + width * backYard + "m2 x 50% = " + formattedSBackYard + "m2</p>");
                totalArea += sBackYard;
            }
            for (int i = 0; i < listHouseComponent.size(); i++) {
                HouseComponent houseComponent = listHouseComponent.get(i);
                if (houseComponent.getComponentId() > 6) {
                    double areaBuild = Double.parseDouble(request.getParameter(houseComponent.getComponentId() + ""));
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    String formattedSFoundation = decimalFormat.format(areaBuild);
                    out.println("<p>" + houseComponent.getComponent() + ": " + formattedSFoundation + "m2</p>");
                    totalArea += areaBuild;
                }
            }

            if (foundationId != 0) {
                QuotationDAO foundationDao = new QuotationDAO();
                RoofNFoundation2 foundation = foundationDao.getRoofNFoundationByID(foundationId);
                sFoundation = S * (foundation.getAreaPercent() / 100.0);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSFoundation = decimalFormat.format(sFoundation);
                out.println("<p>" + foundation.getRoofNFoundationName() + ": " + S + "m2 x " + foundation.getAreaPercent() + "% = " + formattedSFoundation + "m2</p>");
                totalArea += sFoundation;
                out.println("<input type=\"hidden\" name=\"foundation\" value=\"" + foundationId + "\">");
            }

            if (roofId != 0) {
                QuotationDAO roofDao = new QuotationDAO();
                RoofNFoundation2 roof = roofDao.getRoofNFoundationByID(roofId);
                sRoof = s * (roof.getAreaPercent() / 100.0);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSRoof = decimalFormat.format(sRoof);
                out.println("<p>" + roof.getRoofNFoundationName() + ": " + s + "m2 x " + roof.getAreaPercent() + "% = " + formattedSRoof + "m2</p>");
                totalArea += sRoof;
                out.println("<input type=\"hidden\" name=\"roof\" value=\"" + roofId + "\">");
            }

            DecimalFormat decimalFormat1 = new DecimalFormat("#,###.##");
            String formattedPrice = decimalFormat1.format(price);
            if (selectedService == 2 && packagePrice != 0) {

                if (packagePrice == 1) {
                    out.println("<p>Gói xây dựng Tiết kiệm: " + formattedPrice + " VNĐ/m2</p>");
                    out.println("<input type=\"hidden\" name=\"packagePrice\" value=\"" + packagePrice + "\">");
                } else {
                    out.println("<p>Gói xây dựng VIP: " + formattedPrice + " VNĐ/m2</p>");
                    out.println("<input type=\"hidden\" name=\"packagePrice\" value=\"" + packagePrice + "\">");
                }

            } else {
                out.println("<p>Đơn giá " + quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName() + ": " + formattedPrice + " VNĐ/m2</p>");
            }

            double totalPrice = totalArea * price;
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String formattedTotalPrice = decimalFormat.format(totalPrice);
            DecimalFormat decimalFormat3 = new DecimalFormat("#.##");
            String formattedTotalArea = decimalFormat3.format(totalArea);
            out.println("<p>Tổng diện tích xây dựng: " + formattedTotalArea + "m2</p>");
            out.println("<p style=\"color: red;\">Tổng chi phí xây dựng: " + formattedTotalPrice + "VNĐ</p>");
            if (note != "") {
                out.println("<p class=\"text-note\">Ghi chú: " + note + "</p>");
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
