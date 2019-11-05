/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce426;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author gkoffas
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public Register() {}
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("uname");
        String passWrd = request.getParameter("password");
        String eMail = request.getParameter("email");
        
        try {
	    String connUrl = "jdbc:mysql://localhost:3306/webapp";
	    String dbUser = "root";
	    String dbPassword = "vento_aureo";

	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection(connUrl, dbUser, dbPassword);
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, email FROM userinfo;");
            
            while (rs.next()) {
                if (rs.getString("username").equals(userName) || rs.getString("email").equals(eMail)) {
                    response.sendRedirect("./error_login.jsp");
                    return;
                }
            }
            
            String query = "INSERT INTO userinfo(username, password, email) VALUES('" + userName + "', '" + passWrd + "', '" + eMail + "');";
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            
            stmt.close();
            response.sendRedirect("./success.jsp");
            
        } catch (ClassNotFoundException | SQLException e) {
            response.getWriter().append(e.getMessage());
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Register Servlet";
    }// </editor-fold>

}
