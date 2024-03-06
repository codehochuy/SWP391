/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerQuotation;

import DAO.HouseTypeDAO;
import DAO.QuotationDAO;
import DAO.ServiceDAO;
import DAO.StyleDAO;
import DTO.HouseType;
import DTO.Quotation;
import DTO.Service;
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
@WebServlet(name = "LoadQuotationByID", urlPatterns = {"/LoadQuotationByID"})
public class LoadQuotationByID extends HttpServlet {

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
            String id = request.getParameter("id");
            QuotationDAO aO = new QuotationDAO();
            Quotation quo = aO.getQuotationID(id);

            StyleDAO dAO = new StyleDAO();
            List<Style> styles = dAO.getAll();

            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            List<HouseType> houseTypes = houseTypeDAO.getAll();

            ServiceDAO serviceDAO = new ServiceDAO();
            List<Service> services = serviceDAO.getAll();

            out.println("<form action=\"UpdateQuotation\" method=\"POST\" id=\"updatesp\">\n"
                    + "                            <div class=\"row\">\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Mã bảng giá </label>\n"
                    + "                                    <input readonly=\"true\" class=\"form-control\" type=\"text\" name=\"quotationid\" value=\"" + quo.getId() + "\" >\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Dịch vụ</label>\n"
                    + "                                    <input readonly=\"true\" class=\"form-control\" type=\"text\" required name=\"service\" value=\"" + quo.getService().getName() + "\" >\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Kiểu nhà</label>\n"
                    + "                                    <input readonly=\"true\" class=\"form-control\" type=\"text\"required name=\"housetype\" value=\"" + quo.getHouseType().getName() + "\" min=\"0\">\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Phong cách</label>\n"
                    + "                                    <input readonly=\"true\" class=\"form-control\" type=\"text\"required name=\"style\" value=\"" + quo.getStyle().getName() + "\" min=\"0\">\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Giá giao động</label>\n"
                    + "                                    <input class=\"form-control\" type=\"number\" required name=\"price1\" value=\"" + quo.getPrice1() + "\" min=\"1000000\" max=\"100000000\">\n"
                    + "                                </div>\n"
                    + "                                <div class=\"form-group col-md-6\">\n"
                    + "                                    <label class=\"control-label\">Giá giao động</label>\n"
                    + "                                    <input class=\"form-control\" type=\"number\" required name=\"price2\" value=\"" + quo.getPrice2() + "\" min=\"1000000\" max=\"100000000\">\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                            <BR>\n"
                    + "                            <button class=\"btn btn-save\" type=\"submit\">Lưu lại</button>\n"
                    + "                            <a class=\"btn btn-cancel\" data-dismiss=\"modal\" href=\"#\">Hủy bỏ</a>\n"
                    + "                            <BR>\n"
                    + "                        </form>");

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
