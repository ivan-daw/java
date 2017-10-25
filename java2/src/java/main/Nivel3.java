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
@WebServlet(name = "Nivel3", urlPatterns = {"/Nivel3"})
public class Nivel3 extends HttpServlet {

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

        //Filtro comprueba que se ha pasado el nivel 1 y 2 ademas de que no se ha accedido directamente a este Nivel sin pasar por los demas
        if ((request.getSession().getAttribute(Constantes.NIVEL) == null)
                || !request.getSession().getAttribute(Constantes.NIVEL).equals(1110)) {

            paginaDestino = Constantes.PAGINA_ERROR;
            request.getRequestDispatcher(paginaDestino).forward(request, response);

        } else {

            if (pwd == null) {

                paginaDestino = Constantes.PAGINA_ERROR;
                request.getRequestDispatcher(paginaDestino).forward(request, response);

            } else {

                if (pwd.equals(Constantes.PWD3)) {

                    request.getSession().setAttribute(Constantes.NIVEL, (Integer) 1111);
                    request.setAttribute(Constantes.MSG_INFO, "Nivel 3 pasado");
                    request.getRequestDispatcher(paginaDestino).forward(request, response);

                } else {

                    paginaDestino = Constantes.PAGINA_ERROR;
                    request.getRequestDispatcher(paginaDestino).forward(request, response);

                }

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
