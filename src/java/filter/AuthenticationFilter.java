package filter;

import DTO.User;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        //this.context.log("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("USER");
        }

        if (user == null && !uri.endsWith("Login.jsp") && !uri.endsWith("LoginServlet") && !uri.endsWith(".css") && !uri.endsWith(".png") && !uri.endsWith(".jpg") 
                && !uri.endsWith("index")
                && !uri.endsWith("About")
                && !uri.endsWith("Service")
                && !uri.endsWith("Team")
                && !uri.endsWith("ListProject")
                && !uri.endsWith("Blog")
                && !uri.endsWith("FullContructionPrice")
                && !uri.endsWith("RawContructionPrice")
                && !uri.endsWith("Contact")
                && !uri.endsWith("Quotation")
                && !uri.endsWith("LoadFormFill")
                && !uri.endsWith("LoadQuotationContent")
                
            ) {
            this.context.log("Unauthorized access request");
            res.sendRedirect("Login.jsp");
        } else {
            chain.doFilter(request, response);
        }
        
    }

    @Override
    public void destroy() {
        //close any resources here
    }
}
