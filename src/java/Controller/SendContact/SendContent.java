/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Contact;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "SendContent", urlPatterns = {"/SendContent"})
public class SendContent extends HttpServlet {

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
            out.println("<title>Servlet SendContent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendContent at " + request.getContextPath() + "</h1>");
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
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");
            String emailContent = "Chào " + name + ",\n\n";
            emailContent += "Xin chân thành cảm ơn Anh/Chị đã liên hệ với chúng tôi tại Công ty Xây dựng. Chúng tôi rất vui được hỗ trợ Anh/Chị trong các dự án xây dựng của mình.\n\n";
            emailContent += "Thông tin chi tiết về dự án của Anh/Chị:\n";
            emailContent += "1. Loại công trình: " + subject + "\n";
            emailContent += "2. Quy mô dự án: " + message + "\n";
// Thêm các thông tin khác tùy ý

            emailContent += "\nKhi chúng tôi đã nhận được thông tin này, chúng tôi sẽ tiến hành xem xét và phản hồi lại Anh/Chị với các thông tin chi tiết về phương án thiết kế, dự toán chi phí và thời gian thực hiện.\n\n";
            emailContent += "Nếu Anh/Chị có bất kỳ câu hỏi hoặc yêu cầu nào khác, xin vui lòng liên hệ với chúng tôi qua số điện thoại hoặc email dưới đây:\n";
// Thêm thông tin liên hệ

            emailContent += "\nChúng tôi rất mong được hợp tác cùng Anh/Chị và xây dựng thành công dự án của mình.\n\n";
            emailContent += "Trân trọng,\n[Tên của bạn]\n[Công ty Xây dựng]";
            response.sendRedirect("Contact");
            Mail.sendMail(email, emailContent); // Change recipient email address
            response.getWriter().println("Email sent successfully!");
        } catch (MessagingException e) {
            response.getWriter().println("Error sending email: " + e.getMessage());
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
