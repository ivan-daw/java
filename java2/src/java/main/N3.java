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
@WebServlet(name = "N3", urlPatterns = {"/N3"})
public class N3 extends HttpServlet {

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
        String paginaDestino = Constantes.PAGINA_INDEX;
        String pwd = request.getParameter("pwd");

        if (request.getSession().getAttribute("signature") == null) {
            paginaDestino = Constantes.PAGINA_ERROR;
            request.setAttribute("mensajeError", "Tienes que empezar en el nivel1");
            request.getRequestDispatcher(paginaDestino).forward(request, response);
        } else {

            if (request.getSession().getAttribute("password").equals("abc")
                    && request.getSession().getAttribute("num1").equals("33")&& request.getSession().getAttribute("num2").equals("22")
                    && request.getSession().getAttribute("num3").equals("11")) {
                if (request.getSession().getAttribute("pwd") == null) {
                    response.getWriter().println("<h1>Nivel3: Introduce pwd</h1>");
                    request.getSession().setAttribute("pwd", pwd);
                } else {
                    if (request.getSession().getAttribute("pwd").equals("12ab")) {
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    } else {

                        paginaDestino = Constantes.PAGINA_ERROR;
                        request.setAttribute("mensajeError", "PWD INCORRECTA");
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    }

                }
            } else {
                paginaDestino = Constantes.PAGINA_ERROR;
                request.setAttribute("mensajeError", "NUMEROS INCORRECTOS");
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
