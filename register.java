/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Connection.connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gururaj M Hudgi
 */
public class save extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet save</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet save at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
    
            
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
//        processRequest(request, response);

            PrintWriter out = null;
            try {
                
                out = response.getWriter();
                String name = request.getParameter("name");
                String age = request.getParameter("age");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String gender = request.getParameter("gender");
                String department = request.getParameter("department");
                Connection con = connection.getConnection();
                
                if(con.isValid(20))
                    
                {
                    String sql ="insert into details values (?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, age);
                    pst.setString(3, email);
                    pst.setString(4, pass);
                    pst.setString(5, gender);
                    pst.setString(6, department);
                    
                    int rs = pst.executeUpdate();
                    
                    if(rs>0)
                    {
                        out.print("<script>alert('data is saved successfully')</script>");
                        getServletContext().getRequestDispatcher("/insert.jsp").include(request, response);
                    }
                    else
                    {
                        out.print("<script>alert('Sorry!!! Data is not saved successfully')</script>");
                        getServletContext().getRequestDispatcher("/insert.jsp").include(request, response);
                    }
                }
                else
                    out.print("fail");
                
                out.close();
            
        } catch (Exception e) {
                 out.print(e);
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
