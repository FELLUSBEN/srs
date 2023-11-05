
package Control;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("Register.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        Model.Maneger maneger = Model.Maneger.getInstance();

        User u;
        //add psw == psw2 check!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if(!request.getParameter("psw").equals(request.getParameter("psw2"))){
            request.setAttribute("msg", "Passwords don't match");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }
        if(request.getParameter("type").equals("customer")){
            Castomer c = (Castomer)UserFactory.getUser("customer");
            c.setP(request.getParameter("uname"), request.getParameter("psw"), request.getParameter("email"));
            maneger.Add(c);
            u = c;
        } 
        else{
            Restaurant r = (Restaurant)UserFactory.getUser("restaurant");
            r.setP(request.getParameter("uname"), request.getParameter("psw"), request.getParameter("name"),request.getParameter("address"), request.getParameter("employees"), Integer.parseInt(request.getParameter("seats")), Integer.parseInt(request.getParameter("seats")), Integer.parseInt(request.getParameter("pr")), Integer.parseInt(request.getParameter("pr")), request.getParameter("Ftype"));
            maneger.Add(r);
            u = r;
        }
        
        s.setAttribute("user", u);
        response.sendRedirect("Main");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
