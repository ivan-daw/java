/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nota;
import servicios.NotasServicios;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "Notas", urlPatterns = {"/notas"})
public class Notas extends HttpServlet {

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

        
      
         NotasServicios ns= new NotasServicios();
     
        String op = request.getParameter("op");
             if (op==null) op="listar";
        switch (op) {
            case "listar":
               
                request.setAttribute("notas", ns.getAllNotas());
                request.getRequestDispatcher("pintarListaNotas.jsp").forward(request, response);
                break;
            case "insertar":
                Nota a = new Nota();
                a.setID_ALUMNO(Integer.parseInt(request.getParameter("idalumno")));
             
                 a.setID_ASIGNATURA(Integer.parseInt(request.getParameter("idasignatura")));
                a.setNOTA(Integer.parseInt(request.getParameter("nota")));
                a = ns.addNota(a);
                List<Nota> notas = new ArrayList();
                notas.add(a);
                request.setAttribute("notas",notas);
                request.getRequestDispatcher("pintarListaNotas.jsp").forward(request, response);
                break;     
                
            case "update":
                   Nota e = new Nota();

                e.setID_ALUMNO(Integer.parseInt(request.getParameter("idalumno")));
             
                 e.setID_ASIGNATURA(Integer.parseInt(request.getParameter("idasignatura")));
                e.setNOTA(Integer.parseInt(request.getParameter("nota")));
              e = ns.updNota(e);
               
                List<Nota> notasupd = new ArrayList();
                notasupd.add(e);
                 
                     request.setAttribute("notas", notasupd);
              
                request.getRequestDispatcher("pintarListaNotas.jsp").forward(request, response);
                break;     
                
                  case "eliminar":
                  Nota u = new Nota();
                   u.setID_ALUMNO(Integer.parseInt(request.getParameter("idalumno")));
             
                 u.setID_ASIGNATURA(Integer.parseInt(request.getParameter("idasignatura")));
              
              u = ns.delNota(u);
               
                List<Nota> notasdel = new ArrayList();
                notasdel.add(u);
                 
                     request.setAttribute("notas", notasdel);
              
                request.getRequestDispatcher("pintarListaNotas.jsp").forward(request, response);
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
