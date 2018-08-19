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
import model.ShoppingCart;

/**
 *
 * @author INT303
 */
public class ShowCartServlet extends HttpServlet {

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
        /**
         * try {
         *
         */
        //เวลามีปั�?หาที่�?�?้ไม่ได้ ลบโฟเดอร์build
        HttpSession session = request.getSession(false);

//        Action  คือ xml เช่น fore ในหน้า jsp  (EL,JSTL)
        if (session != null) {
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            System.out.println("Session isnot Null 55555555555555555555555555555555+");
            if (cart != null) {
                System.out.println("Cart isnot Null 55555555555555555555555555555555+");
                getServletContext().getRequestDispatcher("/ShowCart.jsp").forward(request, response);
                return;
            }
// getServletContext() เป็น�?ารดึงข้อมูลมาจา�? appication scopt
        }
//        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Session TimeOut .. Try again N5 Omsin Bun Error !!!  EiEi"); //เป็น�?าร�?�?้error �?บบง่าย ถ้าอยา�?ให้มันไปดึงหน้า html อื่นมาให้ไป�?�?้ที่web.xml

        /**
         * } catch (Exception e) {
         *
         *
         * // getServletContext().g }
         *
         */
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//
//            try {
//
//                HttpSession session = request.getSession(false);
//                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");//key word ใน�?ารเรีย�?ในjsp
//
//                
//                
//                if (cart == null) {
//                      out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet ShowCart</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Servlet ShowCart at " + request.getContextPath() + "</h1>");
//                out.println("<h1>Error !!! นายยังไม่ได้ซื้อโว้ยยยยยย </h1>");
//                out.println("</body>");
//                out.println("</html>");
//
//                }else{
//            
//                    response.sendRedirect("ViewGoods.jsp");
////                        request.setAttribute("products", cart);
////                       getServletContext().getRequestDispatcher("/ViewGoods.jsp").forward(request, response);
//
//                
//                }
//
//            } catch (Exception e) {
//
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet ShowCart</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Servlet ShowCart at " + request.getContextPath() + "</h1>");
//                out.println("<h1>Error !!! " + e + "</h1>");
//                out.println("</body>");
//                out.println("</html>");
//
//            }
//    }
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
