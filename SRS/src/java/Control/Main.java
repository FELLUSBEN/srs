/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import Model.*;
import java.util.Date;
import java.util.Calendar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model.Maneger maneger = Model.Maneger.getInstance();
        
        if(Calendar.DAY_OF_YEAR != Announcement.getDayOfYear()){
            maneger.DeleteDate(new Date().getTime());
            Announcement.setDayOfYear(Calendar.DAY_OF_YEAR);
        }
        if(request.getSession().getAttribute("user") instanceof Restaurant){
              if(Calendar.DAY_OF_YEAR != Restaurant.getDayOfYear()){
                    Restaurant r=(Restaurant)request.getSession().getAttribute("user");
                    r.setFreeSeats(r.getSeats());
                    r.setFreePR(r.getPr());
                    maneger.Update(r, r);
                    Restaurant.setDayOfYear(Calendar.DAY_OF_YEAR);
                }  
        }
        
        request.setAttribute("announcements", maneger.getAnnouncements((User)request.getSession().getAttribute("user")));
        request.getRequestDispatcher("Main.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // TODO: remove announcement from table
        if (request.getParameter("act") != null){
            String params[] = request.getParameter("act").split(',');
            if (params[1] == "pr"){
                
            }else{
                
            }
        }
           
        
        
        request.getRequestDispatcher("Action").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
