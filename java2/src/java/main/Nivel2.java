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
        String paginaDestino = Constantes.PAGINA_INDEX;

      
        String nums = request.getParameter("nums");
          if (request.getSession().getAttribute(Constantes.COMPROBADOR)== null)
       {
             request.getSession().setAttribute(Constantes.COMPROBADOR, (Integer) 1);
           // contador = (Integer)request.getSession().getAttribute("contador");
       }
      
        Integer option = (Integer) request.getSession().getAttribute(Constantes.COMPROBADOR);
        
        if (request.getSession().getAttribute(Constantes.NIVEL).equals(1000)) {

            switch (option) {
                case 1:
                    request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el primer numero");
                    request.getSession().setAttribute(Constantes.COMPROBADOR, (Integer) 2);
                    request.getRequestDispatcher(paginaDestino).forward(request, response);
                    break;
                case 2:
                    if (nums.equals("11")) {
                        request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el segundo numero");
                        request.getSession().setAttribute(Constantes.COMPROBADOR, (Integer) 3);
                        request.getRequestDispatcher(paginaDestino).forward(request, response);

                    } else {
                        paginaDestino = Constantes.PAGINA_ERROR;
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    }

                    break;

                case 3:
                       if (nums.equals("22")) {
                    request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce eltercer numero");
                    request.getSession().setAttribute(Constantes.COMPROBADOR, (Integer) 4);
                    request.getRequestDispatcher(paginaDestino).forward(request, response);
                      } else {
                        paginaDestino = Constantes.PAGINA_ERROR;
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
                    }
                    break;
                case 4:

                    if (nums.equals("33")) {
                        request.getSession().setAttribute(Constantes.NIVEL, (Integer) 1110);
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

            }
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
