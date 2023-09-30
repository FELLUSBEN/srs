
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
        HttpSession s =request.getSession();
        User u;
        //add psw == psw2 check!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if(request.getParameter("type") == "castomer"){
            Castomer c =new Castomer(request.getParameter("uname"), request.getParameter("psw"), request.getParameter("email"));
            Model.Maneger.Add(c);
            u = c;
        } 
        else{
            Restaurant r =new Restaurant(request.getParameter("uname"), request.getParameter("psw"), request.getParameter("name"),request.getParameter("address"), request.getParameter("employees"), Integer.parseInt(request.getParameter("seats")), Integer.parseInt(request.getParameter("fseats")), Integer.parseInt(request.getParameter("pr")), Integer.parseInt(request.getParameter("fpr")), request.getParameter("Ftype"));
            Model.Maneger.Add(r);
            u = r;
        }
        
        s.setAttribute("usr", u);
        response.sendRedirect("Main");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
