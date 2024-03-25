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
@WebServlet(name = "UpdateQuotation", urlPatterns = {"/UpdateQuotation"})
public class UpdateQuotation extends HttpServlet {

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
            out.println("<title>Servlet UpdateQuotation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateQuotation at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("quotationid");
        String housetype = request.getParameter("housetype");
        String style = request.getParameter("style");
        String service = request.getParameter("service");
        String price1 = request.getParameter("price1");int intPrice1 = Integer.parseInt(price1);
        String price2 = request.getParameter("price2");int intPrice2 = Integer.parseInt(price2);
        if (intPrice2 <= intPrice1) {
             QuotationDAO dAO = new QuotationDAO();
            List<Quotation> list = dAO.getAll();

            StyleDAO styleDAO = new StyleDAO();
            List<Style> styles = styleDAO.getAll();

            HouseTypeDAO houseTypeDAO = new HouseTypeDAO();
            List<HouseType> houseTypes = houseTypeDAO.getAll();

            request.setAttribute("styles", styles);
            request.setAttribute("houseTypes", houseTypes);
            request.setAttribute("list", list);
            request.setAttribute("messefalse", "Sai giá tiền !!");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation.jsp").forward(request, response);
        }else{
            
      

        
        QuotationDAO dao = new QuotationDAO();
        boolean result = dao.updateQuotation(id, price1, price2, "0");
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
            request.setAttribute("messtrue", "Cập nhật bảng giá thành công");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation.jsp").forward(request, response);

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
            request.setAttribute("messefalse", "Cập nhật bảng giá thất bại");
            request.getRequestDispatcher("WebPages/ViewManager/Page/AdminManager/ManagerQuotation.jsp").forward(request, response);

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
