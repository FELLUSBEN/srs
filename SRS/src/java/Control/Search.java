
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
        request.getRequestDispatcher("Search.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //get all restaurants with the parameters sent by the client - name and type
        String name = request.getParameter("res_name");
        String type = request.getParameter("type");
        ArrayList<Restaurant> res_list = new ArrayList<Restaurant>();
        
        request.setAttribute("res_list", res_list);
        request.getRequestDispatcher("Search.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
