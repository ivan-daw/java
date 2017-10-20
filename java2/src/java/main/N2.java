/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
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
@WebServlet(name = "N2", urlPatterns = {"/N2"})
public class N2 extends HttpServlet {

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

        String Nivel2 = "no";
        // Nivel2 = (String)request.getSession().getAttribute("Nivel2");
        String nums = request.getParameter("nums");
        Integer option = (Integer) request.getSession().getAttribute("contador");

        if (request.getSession().getAttribute("Nivel1").equals("ok")) {
            response.getWriter().println(option);

            switch (option) {
                case 10:
                    request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el primer numero");
                    request.getSession().setAttribute("contador", (Integer) 11);
                    request.getRequestDispatcher(paginaDestino).forward(request, response);
                    break;
                case 11:
                    if (nums.equals("11")) {
                        request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el segundo numero");
                        request.getSession().setAttribute("contador", (Integer) 12);
                        request.getRequestDispatcher(paginaDestino).forward(request, response);

                    } else {
                        paginaDestino = Constantes.PAGINA_ERROR;
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    }

                    break;

                case 12:
                       if (nums.equals("22")) {
                    request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce eltercer numero");
                    request.getSession().setAttribute("contador", (Integer) 13);
                    request.getRequestDispatcher(paginaDestino).forward(request, response);
                      } else {
                        paginaDestino = Constantes.PAGINA_ERROR;
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    }
                    break;
                case 13:

                    if (nums.equals("33")) {
                        Nivel2 = "ok";
                        request.getSession().setAttribute("Nivel2", Nivel2);
                        request.setAttribute(Constantes.MSG_INFO, "Nivel 2 pasado");
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    } else {
                        paginaDestino = Constantes.PAGINA_ERROR;
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    }
                    ;
                    break;

                default:
                    paginaDestino = Constantes.PAGINA_ERROR;
                    request.getRequestDispatcher(paginaDestino).forward(request, response);
                    break;

            }/*
            if (request.getSession().getAttribute("contador").equals(10)){
                          request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el primer numero");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
           request.getSession().setAttribute("contador", "11");
           
            }
             if (request.getSession().getAttribute("contador").equals("11")){
                                   request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el segundo numero");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
           request.getSession().setAttribute("contador", "12");
             }
              if (request.getSession().getAttribute("contador").equals(12)){

                                    request.setAttribute(Constantes.MSG_INFO,"<h1>Servlet Nivel2 </h1> Introduce el tercer numero");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
           request.getSession().setAttribute("contador", "13");
              }
              else {
               paginaDestino = Constantes.PAGINA_ERROR;
               request.getRequestDispatcher(paginaDestino).forward(request, response);
              }*/
        } else {
            request.setAttribute("mensajeError", "Tienes que empezar en el nivel1");
            request.getRequestDispatcher(paginaDestino).forward(request, response);
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
