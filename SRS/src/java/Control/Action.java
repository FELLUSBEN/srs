
package Control;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Action", urlPatterns = {"/Action"})
public class Action extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model.Maneger maneger = Model.Maneger.getInstance();
     
        String[] params=request.getParameter("act").split(",");
        String[] sparams=((String)request.getSession().getAttribute("search")).split(",");
        if(sparams.length == 0){
            String[] s = {"" , ""};
            sparams = s;
        }
        else if(params[0].equals("B")){
            Restaurant r = maneger.find(params[1],params[2]);
            if(r.getFreeSeats()- Integer.parseInt(params[3]) < 0 || r.getFreePR()- Integer.parseInt(params[4]) < 0){
                request.setAttribute("msg", "no_room");
                request.getRequestDispatcher("Massege").forward(request, response);
            }
            else{
                maneger.Delete(r);
                r.setFreePR(r.getFreePR()- Integer.parseInt(params[4]));
                r.setFreeSeats(r.getFreeSeats()- Integer.parseInt(params[3]));
                maneger.Add(r);
            }
        }
//            else{
//                Model.Maneger.Delete(new Restaurant(params[1],params[2],"","","",0,0,0,0,""));
//                ArrayList<Restaurant> rs= Model.Maneger.Serch(params[1] ,sparams[0], sparams[1]);
//                request.setAttribute("content", (rs == null)? "X":rs); 
//                request.getRequestDispatcher("Display.jsp").forward(request, response);
//            } ******optional: add delete restaurant

        response.sendRedirect("Main");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("act").equals("A")){
            request.getRequestDispatcher("Announcement.jsp").forward(request, response);
        }else if(request.getParameter("act").equals("E")){
            request.getRequestDispatcher("Exit.jsp").forward(request, response);
        }else if(request.getParameter("act").equals("U")){
            request.getRequestDispatcher("Update.jsp").forward(request, response);
        }else if(request.getParameter("act").equals("S")){
            request.getRequestDispatcher("Display.jsp").forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
