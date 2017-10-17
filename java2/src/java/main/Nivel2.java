/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constantes;

/**
 *
 * @author user
 */
@WebServlet(name = "Nivel2", urlPatterns = {"/Nivel2"})
public class Nivel2 extends HttpServlet {

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
        String paginaDestino = "Nivel3";
        //String numeros = request.getParameter("numeros");
        String num1 = request.getParameter("num1");
         String num2 = request.getParameter("num2");
          String num3 = request.getParameter("num3");
if  (request.getSession().getAttribute("signature") == null){
     paginaDestino = Constantes.PAGINA_ERROR;
            request.setAttribute("mensajeError", "Tienes que empezar en el nivel1");
            request.getRequestDispatcher(paginaDestino).forward(request, response);
} else {

        if( request.getSession().getAttribute("password").equals("abc"))  {
            //if (request.getSession().getAttribute("numeros") == null) {
            if (request.getSession().getAttribute("num1") == null) {
                response.getWriter().println("<h1>Nivel2: Introduce el primer numero</h1>");
               //    request.getSession().setAttribute("numeros", numeros);
                request.getSession().setAttribute("num1", num1);
                            if (request.getSession().getAttribute("num1") != null && request.getSession().getAttribute("num2") == null) {
                response.getWriter().println("<h1>Nivel2: Introduce el segundo numero</h1>");
                 request.getSession().setAttribute("num2", num2);
                 
                  if (request.getSession().getAttribute("num2") != null && request.getSession().getAttribute("num3") == null) {
                response.getWriter().println("<h1>Nivel2: Introduce el tercer numero</h1>");
                 request.getSession().setAttribute("num3", num3);}}

            } else {

                request.getRequestDispatcher(paginaDestino).forward(request, response);
            }
        } else {
            paginaDestino = Constantes.PAGINA_ERROR;
            request.setAttribute("mensajeError", "PASSWORD INCORRECTA");
            request.getRequestDispatcher(paginaDestino).forward(request, response);

        }
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
