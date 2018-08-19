/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PrimeNumber;

/**
 *
 * @author INT303
 */
public class PrimeNumberServlet extends HttpServlet {

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

//        request.getSession(); จะมีค่าเริ่มต้นเป็น true
//        request.getSession(Boolean); ถ้าเป็นt �?ล้วไม่เคยมีเชตชั่นจะสรัางให้ �?ต่ถ้า f �?ล้วไม่มีเชตชั่นจะreturn null
        HttpSession session = request.getSession(true);

        String n = request.getParameter("number");

        if (n != null) {//เช็คว่า 
            int number = Integer.valueOf(n);
            PrimeNumber pn = (PrimeNumber) session.getAttribute("pn");

            if (pn == null) {
                pn = new PrimeNumber(number);
                session.setAttribute("pn", pn);
            }
            pn.setNumber(number);
        }
        getServletContext().getRequestDispatcher("/PrimeNumberView.jsp").forward(request, response);
//    getServletContext() 

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
        processRequest(request, response);
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
        processRequest(request, response);
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
