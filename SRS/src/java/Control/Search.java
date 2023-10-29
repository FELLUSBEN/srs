
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Model.*;
import java.util.Date;
import java.util.ArrayList;


@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Display.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model.Maneger maneger = Model.Maneger.getInstance();
        
        if (request.getParameter("act") == null){
            String[] sparams={request.getParameter("name"), request.getParameter("type")};
            request.getSession().setAttribute("search", sparams[0]+","+sparams[1]);
            ArrayList<Restaurant> rs= maneger.Search(sparams[0], sparams[1]);
            request.setAttribute("content", (rs == null)? "X":rs); 
            request.getRequestDispatcher("Display.jsp").forward(request, response);
        }else{
            String[] params=request.getParameter("act").split(",");
            String[] sparams=((String)request.getSession().getAttribute("search")).split(",");
            if(sparams.length == 0){
                String[] s = {"" , ""};
                sparams = s;
            }
            if(params[0].equals("SEATS")){
                Restaurant r = maneger.find(params[1]);
                int seats= Integer.parseInt(request.getParameter("count"));
                if(r.getFreeSeats()- seats < 0){
                    request.setAttribute("err", "there is not enough space in the restaurant");
                    ArrayList<Restaurant> rs= maneger.Search(sparams[0], sparams[1]);
                    request.setAttribute("content", (rs == null)? "X":rs); 
                    request.getRequestDispatcher("Display.jsp").forward(request, response);

                }
                else{
                    Restaurant r2 = new Restaurant(r.getUsr(),r.getPass(),r.getName(),r.getAddress(),r.getEmployees(),r.getSeats(),r.getFreeSeats() - seats,r.getPr(),r.getFreePR(),r.getType());

                    maneger.Update(r, r2);
                    
                    Announcement a = new Announcement(((User)request.getSession().getAttribute("user")).getUsr(),"seats",request.getParameter("count"),params[1]);
                    maneger.Add(a);
                    
                    response.sendRedirect("Main");
                }
            }else if(params[0].equals("PR")){
                Restaurant r = maneger.find(params[1]);
                int pr= Integer.parseInt(request.getParameter("count"));
                if(r.getFreePR()- pr < 0){
                    request.setAttribute("err", "there is not enough space in the restaurant");
                    ArrayList<Restaurant> rs= maneger.Search(sparams[0], sparams[1]);
                    request.setAttribute("content", (rs == null)? "X":rs); 
                    request.getRequestDispatcher("Display.jsp").forward(request, response);

                }
                else{
                    Restaurant r2 = new Restaurant(r.getUsr(),r.getPass(),r.getName(),r.getAddress(),r.getEmployees(),r.getSeats(),r.getFreeSeats(),r.getPr(),r.getFreePR() - pr,r.getType());

                    maneger.Update(r, r2);
                    
                    Announcement a = new Announcement(((User)request.getSession().getAttribute("user")).getUsr(),"pr",request.getParameter("count"),params[1]);
                    maneger.Add(a);
                    
                    response.sendRedirect("Main");
                }
            }
        }
        
//        HttpSession session = request.getSession();
//        //get all restaurants with the parameters sent by the client - name and type
//        String name = request.getParameter("res_name");
//        String type = request.getParameter("type");
//        ArrayList<Restaurant> res_list = new ArrayList<Restaurant>();
//        //use manager!!!
//        request.setAttribute("res_list", res_list);
//        request.getRequestDispatcher("Search.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
