
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Model.*;
import java.util.Date;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s=request.getSession();
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equals("UserName"))
                s.setAttribute("UserName", c.getValue());
            else if(c.getName().equals("LastSeen"))
                s.setAttribute("LastSeen", c.getValue());
        }
        if(s.getAttribute("UserName")==null)
            s.setAttribute("UserName", "");
        if(s.getAttribute("LastSeen")==null)
            s.setAttribute("LastSeen", null);
            
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =request.getSession();
        Model.Maneger maneger = Model.Maneger.getInstance();
        User u;
        u = maneger.checkUsr(request.getParameter("usr"), request.getParameter("pass"));
        if(u == null){
            request.setAttribute("msg", "error");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else{
        session.setAttribute("user", u);
        response.sendRedirect("Main");
        }

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
