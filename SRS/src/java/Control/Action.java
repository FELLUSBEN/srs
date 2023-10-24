
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
        if(request.getParameter("act").equals("S")){
            String[] sparams={request.getParameter("name"), request.getParameter("desc")};
            request.getSession().setAttribute("search", sparams[0]+","+sparams[1]);
            ArrayList<Restaurant> rs= Model.Maneger.Search(sparams[0], sparams[1]);
            request.setAttribute("content", (rs == null)? "X":rs); 
            request.getRequestDispatcher("Display.jsp").forward(request, response);
        }else{
            String[] params=request.getParameter("act").split(",");
            String[] sparams=((String)request.getSession().getAttribute("search")).split(",");
            if(sparams.length == 0){
                String[] s = {"" , ""};
                sparams = s;
            }
            if(params[0].equals("U")){
                if(request.getParameter("name") == null)
                    request.getRequestDispatcher("Update.jsp").forward(request, response);
                else{
                    Restaurant r1 = new Restaurant(params[1],params[2],params[3],params[4],params[5],Integer.parseInt(params[6]),Integer.parseInt(params[7]),Integer.parseInt(params[8]),Integer.parseInt(params[9]),params[5]);
                    Restaurant r2 = new Restaurant(params[1],params[2],request.getParameter("name"),request.getParameter("address"),request.getParameter("employees"),Integer.parseInt(request.getParameter("seats")),Integer.parseInt(request.getParameter("Fseats")),Integer.parseInt(request.getParameter("pr")),Integer.parseInt(request.getParameter("Fpr")),request.getParameter("Ftype"));
                    
                    if(Model.Maneger.isExists(r2)){
                        Model.Maneger.Add(r1);
                        request.setAttribute("msg", "exist");
                        request.getRequestDispatcher("Massege").forward(request, response);
                    }else{
                        Model.Maneger.Delete(r1);
                        Model.Maneger.Add(r2);
//                        ArrayList<Restaurant> rs= Model.Maneger.Serch(params[1] ,sparams[0], sparams[1]);
//                        request.setAttribute("content", (rs == null)? "X":rs); 
//                        request.getRequestDispatcher("Display.jsp").forward(request, response);        ******might be helpfull*******
                    }
                }
            }
            else if(params[0].equals("B")){
                Restaurant r = Model.Maneger.find(params[1],params[2]);
                if(r.getFreeSeats()- Integer.parseInt(params[3]) < 0 || r.getFreePR()- Integer.parseInt(params[4]) < 0){
                    request.setAttribute("msg", "no_room");
                    request.getRequestDispatcher("Massege").forward(request, response);
                }
                else{
                    Model.Maneger.Delete(r);
                    r.setFreePR(r.getFreePR()- Integer.parseInt(params[4]));
                    r.setFreeSeats(r.getFreeSeats()- Integer.parseInt(params[3]));
                    Model.Maneger.Add(r);
                }
            }
//            else{
//                Model.Maneger.Delete(new Restaurant(params[1],params[2],"","","",0,0,0,0,""));
//                ArrayList<Restaurant> rs= Model.Maneger.Serch(params[1] ,sparams[0], sparams[1]);
//                request.setAttribute("content", (rs == null)? "X":rs); 
//                request.getRequestDispatcher("Display.jsp").forward(request, response);
//            } ******optional: add delete restaurant
        }
        
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
    } //diside if Announcement.jsp will add announcement for restaurant and display them for castomer, or make to diffrent "Announcement.jsp"


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
