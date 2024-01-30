/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ManagerQuotation;

import DAO.HouseTypeDAO;
import DAO.QuotationDAO;
import DAO.StyleDAO;
import DTO.HouseType;
import DTO.Quotation;
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
@WebServlet(name = "CreateQuotation", urlPatterns = {"/CreateQuotation"})
public class CreateQuotation extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateQuotation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateQuotation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.setCharacterEncoding("UTF-8");
        String service = request.getParameter("service");
        int serviceid = 0;
        if (service.equalsIgnoreCase("Thi công thô")) {
            serviceid = 1;
        } else {
            serviceid = 2;
        }
        int houseTypeid = Integer.parseInt(request.getParameter("houseTypes"));
        int styleid = Integer.parseInt(request.getParameter("styles"));
        double price1 = 0.0;
        double price2 = 0.0;

        String price1Param = request.getParameter("price1");
        String price2Param = request.getParameter("price2");

        try {
            if (price1Param != null && !price1Param.isEmpty()) {
                price1 = Double.parseDouble(price1Param);
            }

            if (price2Param != null && !price2Param.isEmpty()) {
                price2 = Double.parseDouble(price2Param);
            }
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ khi không thể chuyển đổi thành double
            e.printStackTrace(); // Hoặc thực hiện xử lý thông báo lỗi khác
        }

        String timeParameter = request.getParameter("time");
        int time = (timeParameter != null && !timeParameter.isEmpty()) ? Integer.parseInt(timeParameter) : 0;
        QuotationDAO aO = new QuotationDAO();
        boolean result = aO.createQuotation(price1, price2, time, styleid, houseTypeid, serviceid);
        if (result) {
            QuotationDAO dAO = new QuotationDAO();
            List<Quotation> list = dAO.getAll();

            StyleDAO styleDAO = new StyleDAO();
            List<Style> styles = styleDAO.getAll();

            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            List<HouseType> houseTypes = houseTypeDAO.getAll();

            request.setAttribute("styles", styles);
            request.setAttribute("houseTypes", houseTypes);
            request.setAttribute("list", list);
            request.setAttribute("messtrue", "Thêm báo giá mới thành công");
            if(serviceid == 1){
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation.jsp").forward(request, response);       
            }else{
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation2.jsp").forward(request, response);     
            }
            
        } else {
            QuotationDAO dAO = new QuotationDAO();
            List<Quotation> list = dAO.getAll();

            StyleDAO styleDAO = new StyleDAO();
            List<Style> styles = styleDAO.getAll();

            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            List<HouseType> houseTypes = houseTypeDAO.getAll();

            request.setAttribute("styles", styles);
            request.setAttribute("houseTypes", houseTypes);
            request.setAttribute("list", list);
            request.setAttribute("messefalse", "Tồn tại 1 báo giá tương tự");
            request.setAttribute("messefalse1", "Tồn tại 1 báo giá tương tự");
            if(serviceid == 1){
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation.jsp").forward(request, response);       
            }else{
                request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation2.jsp").forward(request, response);     
            }
        }
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
