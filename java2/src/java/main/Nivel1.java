package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Constantes;

/**
 * @author Ivan *
 */
@WebServlet(name = "Nivel1", urlPatterns = {"/Nivel1"})
public class Nivel1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-s pecific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String paginaDestino = Constantes.PAGINA_INDEX;
        Integer nivel = 0000;
        String password = request.getParameter("password");

        //Si existe una sesion anterior la invalida
        if (request.getSession().getAttribute(Constantes.NIVEL) != null) {
            
            request.getSession().invalidate();
            
        }

        if (password == null) {

            paginaDestino = Constantes.PAGINA_ERROR;
            request.getRequestDispatcher(paginaDestino).forward(request, response);

        } else {

            if (password.equals(Constantes.PWD1)) {
                
                nivel = 1000;
                request.getSession().setAttribute(Constantes.NIVEL, nivel);
                request.setAttribute(Constantes.MSG_INFO, "Pasado Nivel 1");
                request.getRequestDispatcher(paginaDestino).forward(request, response);

            } else {

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
