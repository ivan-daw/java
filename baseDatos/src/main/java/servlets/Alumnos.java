/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumno;
import servicios.AlumnosServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author oscar
 */
@WebServlet(name = "Alumnos", urlPatterns = {"/alumnos"})
public class Alumnos extends HttpServlet {

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

        

       
      
         AlumnosServicios as = new AlumnosServicios();
     
        String op = request.getParameter("op");
             if (op==null) op="listar";
        switch (op) {
            case "listar":
               
                request.setAttribute("alumnos", as.getAllAlumnos());
                request.getRequestDispatcher("pintarListaAlumnos.jsp").forward(request, response);
                break;
            case "insertar":
                Alumno a = new Alumno();
                a.setNombre(request.getParameter("nombre"));
                LocalDate local = LocalDate.of(1910, Month.MARCH, 12);
                a.setFecha_nacimiento(Date.from(local.atStartOfDay().toInstant(ZoneOffset.UTC)));
                a.setMayor_edad( Boolean.valueOf(request.getParameter("mayor"))); //parse a boleean
                a = as.addAlumno(a);
                List<Alumno> alumnos = new ArrayList();
                alumnos.add(a);
                request.setAttribute("alumnos",alumnos);
                request.getRequestDispatcher("pintarListaAlumnos.jsp").forward(request, response);
                break;     
                
            case "update":
                     response.setContentType("text/html"); 
    PrintWriter pw=response.getWriter();    
//             for  (String nombre : request.getParameterMap().keySet()){
//                 String[] values = parameters.get(parameter);
//              System.out.println( parameter + "" + values[0] );
//                 
//             }; 
                Map map = request.getParameterMap();
    for (Object key: map.keySet())
    {
            String keyStr = (String)key;
            
            String[] value = (String[])map.get(keyStr);
            
    pw.println("parametro " + (String)key + "   =   " + Arrays.toString(value) + " <br>") ;
    pw.println();
    }
                break;
                
            case "eliminar":
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
