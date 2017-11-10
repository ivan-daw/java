/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;
import servicios.AsignaturasServicios;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Asignaturas", urlPatterns = {"/asignaturas"})
public class Asignaturas extends HttpServlet {

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

        

       
      
         AsignaturasServicios asig = new AsignaturasServicios();
     
        String op = request.getParameter("op");
             if (op==null) op="listar";
        switch (op) {
            case "listar":
               
                request.setAttribute("asignaturas", asig.getAllAsignaturas());
                request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
                break;
            case "insertar":
                Asignatura a = new Asignatura();
                a.setNombre(request.getParameter("nombre"));
             
                a.setCurso(request.getParameter("curso"));
                a.setCiclo(request.getParameter("ciclo"));
                a = asig.addAsignatura(a);
                List<Asignatura> asignaturas = new ArrayList();
                asignaturas.add(a);
                request.setAttribute("asignaturas",asignaturas);
                request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
                break;     
                
            case "update":
                   Asignatura e = new Asignatura();
                  int mid = Integer.parseInt(request.getParameter("id"));
               e.setId(mid);
               e.setNombre(request.getParameter("nombre"));

             
                e.setCurso(request.getParameter("curso"));
                e.setCiclo(request.getParameter("ciclo"));
              e = asig.updAsignatura(e);
               
                List<Asignatura> asignaturasupd = new ArrayList();
                asignaturasupd.add(e);
                 
                     request.setAttribute("asignaturas", asignaturasupd);
              
                request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
                break;     
                
                  case "eliminar":
                  Asignatura u = new Asignatura();
                  mid = Integer.parseInt(request.getParameter("id"));
               u.setId(mid);
             
              u = asig.delAsignatura(u);
               
                List<Asignatura> asignaturasdel = new ArrayList();
                asignaturasdel.add(u);
                 
                     request.setAttribute("asignaturas", asignaturasdel);
              
                request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
                break;     

                
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
