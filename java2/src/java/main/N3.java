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

       String Nivel3="no";
       
   //Nivel3 = (String)request.getSession().getAttribute("Nivel2");
   String pwd = request.getParameter("pwd");
   
    
       if (request.getSession().getAttribute("Nivel1").equals("ok")&& request.getSession().getAttribute("Nivel2").equals("ok"))
       {

           request.setAttribute(Constantes.MSG_INFO,"<h1>Servlet Nivel3 </h1> Introduce la password");

       } else {
                   request.setAttribute("mensajeError", "Tienes que seguir el orden de los niveles");
                   request.getRequestDispatcher(paginaDestino).forward(request, response);
       }
       
       if (pwd.equals("12ab")){
               Nivel3="ok";
      request.getSession().setAttribute("Nivel3", Nivel3);
       request.setAttribute(Constantes.MSG_INFO, "Nivel 3 pasado");
                        request.getRequestDispatcher(paginaDestino).forward(request, response);
           }else{
               paginaDestino = Constantes.PAGINA_ERROR;
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
