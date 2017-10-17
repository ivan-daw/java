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

       String Nivel2="no";
        String password = request.getParameter("num");
   Nivel2 = (String)request.getSession().getAttribute("Nivel2");
   String nums=null;
   nums=nums+request.getParameter(nums);
   
    
       if (request.getSession().getAttribute("Nivel1").equals("ok"))
       {
            if (request.getSession().getAttribute("contador").equals(10)){
                          request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el primer numero");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
           request.getSession().setAttribute("contador", 11);
           
            }
             if (request.getSession().getAttribute("contador").equals(11)){
                                   request.setAttribute(Constantes.MSG_INFO, "<h1>Servlet Nivel2 </h1> Introduce el segundo numero");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
           request.getSession().setAttribute("contador", 12);
             }
              if (request.getSession().getAttribute("contador").equals(12)){

                                    request.setAttribute(Constantes.MSG_INFO,"<h1>Servlet Nivel2 </h1> Introduce el tercer numero");
           request.getRequestDispatcher(paginaDestino).forward(request, response);
           request.getSession().setAttribute("contador", 13);
              }
              else {
               paginaDestino = Constantes.PAGINA_ERROR;
               request.getRequestDispatcher(paginaDestino).forward(request, response);
              }
       }
       
       if (nums=="112233"){
               Nivel2="ok";
      request.getSession().setAttribute("Nivel2", Nivel2);
           }else{
               paginaDestino = Constantes.PAGINA_ERROR;
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
