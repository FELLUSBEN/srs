
package Control;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Announce", urlPatterns = {"/Announce"})
public class Announce extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("Announce.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model.Maneger maneger = Model.Maneger.getInstance();
        Announcement a = new Announcement(((User)request.getSession().getAttribute("user")).getUsr(),request.getParameter("title"),request.getParameter("desc"));
        maneger.Add(a);
        response.sendRedirect("Main");
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
