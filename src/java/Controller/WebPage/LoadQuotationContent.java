/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.WebPage;

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
            
            QuotationDAO dao = new QuotationDAO();
            List<HouseComponent> listHouseComponent = dao.getHouseComponent(selectedHouseType);
            
            QuotationDAO quotationDao = new QuotationDAO();
            DTO.Quotation quotation = quotationDao.getQuotaitonByServiveTypeStyle(selectedService, selectedHouseType, selectedStyle);
            Double length = Double.parseDouble(request.getParameter("1"));
            Double width = Double.parseDouble(request.getParameter("2"));
            Double frontYard = Double.parseDouble(request.getParameter("3"));
            Double backYard = Double.parseDouble(request.getParameter("4"));
            int roofId = Integer.parseInt(request.getParameter("roof"));
            int foundationId = Integer.parseInt(request.getParameter("foundation"));
            
            QuotationDAO floorDao = new QuotationDAO();
            boolean checkFloor = floorDao.checkFloor(selectedHouseType);
            
            QuotationDAO foundationDao = new QuotationDAO();
            RoofNFoundation2 foundation = foundationDao.getRoofNFoundationByID(foundationId);
            
            QuotationDAO roofDao = new QuotationDAO();
            RoofNFoundation2 roof = roofDao.getRoofNFoundationByID(roofId);
            
            double price = 0;
            double S = length * width;
            if (S >= 200){
                price = quotation.getPrice1();
            } else {
                price = quotation.getPrice2();
            }
            double s = width * (length-frontYard-backYard);
            double sFrontYard = (width * frontYard) * 0.5;
            double sBackYard = (width * backYard) * 0.5;
            double sFoundation = foundation.getAreaPercent()/100 * S; //
            double sRoof = roof.getAreaPercent()/100 * s;
                    
            if (selectedService == 2) {
                int packagePrice = Integer.parseInt(request.getParameter("packagePrice"));
                out.println("<h1>Xây trọn gói</h1>");
                if (checkFloor) {
                    
                } else {
                    
                }
            } else {
                out.println("<h1>Xây thô</h1>");
                if (checkFloor) {
                    
                } else { //xây thô k lầu
                    double totalArea = s + sFrontYard + sBackYard + sFoundation + sRoof;
                    double totalPrice = totalArea * price;
                    for (int i = 0; i < listHouseComponent.size(); i++) {
                        out.println("<h1>"+listHouseComponent.get(i).getComponent()+": "+request.getParameter((i+1)+"")+"</h1>");
                    }

//                    out.println("<h1>Kết quả tính diện tích và chi phí xây nhà:</h1>");
//                    out.println("<h2>Bạn cần " + quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName() + " với diện tích là " + width + "m x " + length + "m:</h2>");
//                    out.println("<h2>Diện tích tầng trệt: " + s + "m2 x 100% = " + s + "m2</h2>");
//                    out.println("<h2>Diện tích sân trước: " +width * frontYard+ "m2 x 50% = " + sFrontYard + "m2</h2>");
//                    out.println("<h2>Diện tích sân sau: " +width * backYard+ "m2 x 50% = " + sFrontYard + "m2</h2>");
//                    out.println("<h2>" + foundation.getRoofNFoundationName() + ": " + S + "m2 x " +foundation.getAreaPercent()+ "% = "+sFoundation+"m2</h2>");
//                    out.println("<h2>" + roof.getRoofNFoundationName() + ": " + s + "m2 x "+roof.getAreaPercent()+"% = "+sRoof+"m2</h2>");
//                    out.println("<h2>Đơn giá "+quotation.getService().getName() + " " + quotation.getHouseType().getName() + " " + quotation.getStyle().getName()+": " +price+ " VNĐ</h2>");
//                    out.println("<h1>Tổng diện tích xây dựng: "+totalArea+"m2</h1>");
//                    out.println("<h1>Tổng chi phí xây dựng: "+totalPrice+"VNĐ</h1>");
                }
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
