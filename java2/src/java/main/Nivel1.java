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
@WebServlet(name = "Nivel1", urlPatterns = {"/Nivel1"})
public class Nivel1 extends HttpServlet {

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
       String paginaDestino = Constantes.PAGINA_INDEX;
       //1º digito comprobador activado en nivel 1
       //2º 1=nivel 1 pasado
       //3º 1=nivel 2 pasado
       //4º 1=nivel 3 pasado
       
       Integer nivel=0000;

       
        String password = request.getParameter("password");
 
  
    
       if (request.getSession().getAttribute(Constantes.NIVEL)== null)
       {
           request.getSession().setAttribute(Constantes.NIVEL, nivel);
           // contador = (Integer)request.getSession().getAttribute("contador");
       }
       
      if (password==null){
          request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel1 </h1> Introduce contraseña");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
       }
           if (password.equals("abc")){   
               nivel=1000;
      request.getSession().setAttribute(Constantes.NIVEL, nivel);
          request.setAttribute(Constantes.MSG_INFO, "Pasado Nivel 1");
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
