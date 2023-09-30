
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
        User u;
        u = Model.Maneger.checkUsr(request.getParameter("usr"), request.getParameter("pass"));
        if(u == null){
            request.setAttribute("msg", "error");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else
            u = new User(s.getId());
        s.setAttribute("usr", u);
        Cookie c1 = new Cookie("UserName", u.getUsr());
        Cookie c2 = new Cookie("LastSeen", new Date().toString());
        c1.setPath("Login");
        response.addCookie(c1);
        response.addCookie(c2);
        session.setAttribute("UserName", u.getUsr());
        response.sendRedirect("Main");
        

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
