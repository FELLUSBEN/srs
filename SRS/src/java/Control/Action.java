/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author razic
 */
@WebServlet(name = "Action", urlPatterns = {"/Action"})
public class Action extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Action</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Action at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("act").equals("A")){
//            Restaurant r = new Restaurant(((User)request.getSession().getAttribute("usr")).getUsr(),request.getParameter("name"),request.getParameter("link"),request.getParameter("desc"),Boolean.parseBoolean(request.getParameter("pub")));
//            if(Model.Maneger.isExists(r)){
//                request.setAttribute("msg", "exist");
//                request.getRequestDispatcher("Massege").forward(request, response);
//            }else{
//                Model.Maneger.Add(r);
//                ((User)request.getSession().getAttribute("usr")).setAdded(s.getName());
//                request.getRequestDispatcher("Main").forward(request, response);
//            } *******add annaons - meneger function needed*********
        }
        
        else if(request.getParameter("act").equals("S")){
            String[] sparams={request.getParameter("name"), request.getParameter("desc")};
            request.getSession().setAttribute("search", sparams[0]+","+sparams[1]);
            ArrayList<Restaurant> rs= Model.Maneger.Serch(((User)request.getSession().getAttribute("usr")).getUsr(), sparams[0], sparams[1]);
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
//            else{
//                Model.Maneger.Delete(new Restaurant(params[1],params[2],"","","",0,0,0,0,""));
//                ArrayList<Restaurant> rs= Model.Maneger.Serch(params[1] ,sparams[0], sparams[1]);
//                request.setAttribute("content", (rs == null)? "X":rs); 
//                request.getRequestDispatcher("Display.jsp").forward(request, response);
//            } ******optional: add delete restaurant
        }
        
        response.sendRedirect("Main");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("act").equals("A")){
            request.getRequestDispatcher("Add.jsp").forward(request, response);
        }else if(request.getParameter("act").equals("E")){
            request.getRequestDispatcher("Exit.jsp").forward(request, response);
        }else if(request.getParameter("act").equals("S")){
            request.getRequestDispatcher("Display.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
