/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QuotationHistory;

import DAO.QuotationDAO;
import DTO.HouseComponent;
import DTO.RoofNFoundation2;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
@WebServlet(name = "LoadQuotationContent", urlPatterns = {"/LoadQuotationContent"})
public class LoadQuotationContent extends HttpServlet {

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

            QuotationDAO dao = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao.getHouseComponent(selectedHouseType);

            QuotationDAO quotationDao = new QuotationDAO();
            DTO.Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);

            Double length = (request.getParameter("1") != null && !request.getParameter("1").isEmpty()) ? Double.parseDouble(request.getParameter("1")) : 0;
            Double width = (request.getParameter("2") != null && !request.getParameter("2").isEmpty()) ? Double.parseDouble(request.getParameter("2")) : 0;
            double frontYard = (request.getParameter("3") != null && !request.getParameter("3").isEmpty()) ? Double.parseDouble(request.getParameter("3")) : 0;
            double backYard = (request.getParameter("4") != null && !request.getParameter("4").isEmpty()) ? Double.parseDouble(request.getParameter("4")) : 0;
            double floor = (request.getParameter("5") != null && !request.getParameter("5").isEmpty()) ? Double.parseDouble(request.getParameter("5")) : 0;
            double balcony = (request.getParameter("6") != null && !request.getParameter("6").isEmpty()) ? Double.parseDouble(request.getParameter("6")) : 0;
            String note = (request.getParameter("note") != null && !request.getParameter("note").isEmpty()) ? request.getParameter("note") : "";

            double price = 0;
            double S = length * width;
            double s = (length - frontYard - backYard) * width;
            double totalArea = 0;
            if (selectedService == 2 && packagePrice != 0) {
                if (packagePrice == 1) {
                    price = quotation.getPrice1();
                } else {
                    price = quotation.getPrice2();
                }
            } else {
                if (S >= 200) {
                    price = quotation.getPrice1();
                } else {
                    price = quotation.getPrice2();
                }
            }
            double sFrontYard = 0;
            double sBackYard = 0;
            double sBalcony = 0;
            double sFoundation = 0;
            double sRoof = 0;
            //print out result
            out.println("<h1>Kết quả tính diện tích và chi phí xây nhà</h1>");
            out.println("<h2>Bạn cần " + quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName() + " với diện tích là " + width + "m x " + length + "m:</h2>");
            DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
            String formatteds = decimalFormat2.format(s);
            out.println("<h2>Diện tích tầng trệt: " + s + "m2 x 100% = " + formatteds + "m2</h2>");
            totalArea += s;
            if (floor != 0) {
                for (int i = 1; i <= floor; i++) {
                    out.println("<h2>Lầu " + i + ": " + s + "m2 x 100% = " + formatteds + "m2</h2>");
                }
                totalArea += s * floor;
            }

            if (balcony != 0 && floor != 0) {
                sBalcony = (width * balcony) * floor;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedsBalcony = decimalFormat.format(sBalcony);
                out.println("<h2>Ban công: " + (width * balcony) + "m2 x " + floor + " lầu = " + formattedsBalcony + "m2</h2>");
                totalArea += sBalcony;
            } else if (balcony != 0) {
                sBalcony = (width * balcony);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedsBalcony = decimalFormat.format(sBalcony);
                out.println("<h2>Ban công: " + formattedsBalcony + "m2</h2>");
                totalArea += sBalcony;
            }

            if (frontYard != 0) {
                sFrontYard = (width * frontYard) * 0.5;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSFrontYard = decimalFormat.format(sFrontYard);
                out.println("<h2>Diện tích sân trước: " + width * frontYard + "m2 x 50% = " + formattedSFrontYard + "m2</h2>");
                totalArea += sFrontYard;
            }
            if (backYard != 0) {
                sBackYard = (width * backYard) * 0.5;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSBackYard = decimalFormat.format(sBackYard);
                out.println("<h2>Diện tích sân sau: " + width * backYard + "m2 x 50% = " + formattedSBackYard + "m2</h2>");
                totalArea += sBackYard;
            }

            for (int i = 0; i < listHouseComponent.size(); i++) {
                HouseComponent houseComponent = listHouseComponent.get(i);
                if (houseComponent.getComponentId() > 6) {
                    double areaBuild = Double.parseDouble(request.getParameter(houseComponent.getComponentId() + ""));
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    String formattedSFoundation = decimalFormat.format(areaBuild);
                    out.println("<h2>" + houseComponent.getComponent() + ": " + formattedSFoundation + "m2</h2>");
                    totalArea += areaBuild;
                }
            }

            if (foundationId != 0) {
                QuotationDAO foundationDao = new QuotationDAO();
                RoofNFoundation2 foundation = foundationDao.getRoofNFoundationByID(foundationId);
                sFoundation = S * (foundation.getAreaPercent() / 100.0);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSFoundation = decimalFormat.format(sFoundation);
                out.println("<h2>" + foundation.getRoofNFoundationName() + ": " + S + "m2 x " + foundation.getAreaPercent() + "% = " + formattedSFoundation + "m2</h2>");
                totalArea += sFoundation;
                out.println("<input type=\"hidden\" name=\"foundation\" value=\"" + foundationId + "\">");
            }

            if (roofId != 0) {
                QuotationDAO roofDao = new QuotationDAO();
                RoofNFoundation2 roof = roofDao.getRoofNFoundationByID(roofId);
                sRoof = s * (roof.getAreaPercent() / 100.0);
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedSRoof = decimalFormat.format(sRoof);
                out.println("<h2>" + roof.getRoofNFoundationName() + ": " + s + "m2 x " + roof.getAreaPercent() + "% = " + formattedSRoof + "m2</h2>");
                totalArea += sRoof;
                out.println("<input type=\"hidden\" name=\"roof\" value=\"" + roofId + "\">");
            }

            DecimalFormat decimalFormat1 = new DecimalFormat("#,###.##");
            String formattedPrice = decimalFormat1.format(price);
            if (selectedService == 2 && packagePrice != 0) {

                if (packagePrice == 1) {
                    out.println("<h2>Gói xây dựng Tiết kiệm: " + formattedPrice + " VNĐ/m2</h2>");
                    out.println("<input type=\"hidden\" name=\"packagePrice\" value=\"" + packagePrice + "\">");
                } else {
                    out.println("<h2>Gói xây dựng VIP: " + formattedPrice + " VNĐ/m2</h2>");
                    out.println("<input type=\"hidden\" name=\"packagePrice\" value=\"" + packagePrice + "\">");
                }

            } else {
                out.println("<h2>Đơn giá " + quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName() + ": " + formattedPrice + " VNĐ/m2</h2>");
            }

            double totalPrice = totalArea * price;
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String formattedTotalPrice = decimalFormat.format(totalPrice);
            DecimalFormat decimalFormat3 = new DecimalFormat("#.##");
            String formattedTotalArea = decimalFormat3.format(totalArea);
            out.println("<h1>Tổng diện tích xây dựng: " + formattedTotalArea + "m2</h1>");
            out.println("<h1 style=\"color: red;\">Tổng chi phí xây dựng: " + formattedTotalPrice + "VNĐ</h1>");
            if (note != "") {
                out.println("<h4 class=\"text-note\">Ghi chú: " + note + "</h4>");
            }

            out.println("<input type=\"hidden\" name=\"houseType\" value=\"" + selectedHouseType + "\">");
            out.println("<input type=\"hidden\" name=\"service\" value=\"" + selectedService + "\">");
            out.println("<input type=\"hidden\" name=\"style\" value=\"" + selectedStyle + "\">");
            out.println("<input type=\"hidden\" name=\"price\" value=\"" + price + "\">");
            out.println("<input type=\"hidden\" name=\"totalPrice\" value=\"" + totalPrice + "\">");
            out.println("<input type=\"hidden\" name=\"cusQuoName\" value=\"" + quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName() + "\">");
            out.println("<input type=\"hidden\" name=\"note\" value=\"" + note + "\">");
            for (int i = 0; i < listHouseComponent.size(); i++) {
                out.println("<input type=\"hidden\" name=\"" + listHouseComponent.get(i).getComponentId() + "\" value=\"" + request.getParameter(listHouseComponent.get(i).getComponentId() + "") + "\">");
            }

            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("USER");

            if (user == null) {
                out.println("<div class=\"contact-form\">\n"
                        + "    <button class=\"btn\" style=\"border: 1px solid #FFD700;\" type=\"\"  name=\"\" value=\"\"><a href=\"Login.jsp\">Đăng nhập để lưu báo giá</a></button>\n"
                        + "</div>");
            } else {
                out.println("<div class=\"contact-form\">\n"
                        + "    <button class=\"btn\" style=\"border: 1px solid #FFD700;\" type=\"submit\"  name=\"action\" value=\"saveQuotationContent\">Lưu báo giá</button>\n"
                        + "</div>");
                out.println("<div class=\"contact-form\">\n"
                        + "    <button class=\"btn\" style=\"border: 1px solid #FFD700;\" type=\"submit\"  name=\"action\" value=\"saveAndSendRequestQuotation\">Lưu và Gửi yêu cầu báo giá</button>\n"
                        + "</div>");
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
