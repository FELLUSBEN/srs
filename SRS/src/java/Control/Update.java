
package Control;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("Update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model.Maneger maneger = Model.Maneger.getInstance();
        
        Restaurant r1 = (Restaurant)request.getSession().getAttribute("user");
        Restaurant r2 = (Restaurant)UserFactory.getUser("restaurant");
        r2.setP(r1.getUsr(),r1.getPass(),request.getParameter("name"),request.getParameter("address"),request.getParameter("employees"),Integer.parseInt(request.getParameter("seats")),r1.getFreeSeats()+Integer.parseInt(request.getParameter("seats"))-r1.getSeats(),Integer.parseInt(request.getParameter("pr")),r1.getFreePR()+Integer.parseInt(request.getParameter("pr"))-r1.getPr(),request.getParameter("Ftype"));

        maneger.Update(r1, r2);
        response.sendRedirect("Main");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
