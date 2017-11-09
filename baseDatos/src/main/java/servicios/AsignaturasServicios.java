/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import java.util.List;
import model.Asignatura;

/**
 *
 * @author ivan
 */
public class AsignaturasServicios {
    
    
    
    public List<Asignatura> getAllAsignaturas()
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.getAllAsignaturas();
    }
    
    public Asignatura getAsignaturaById(int id){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.getUserById(id);
        
    }
    public Asignatura addAsignatura(Asignatura alumnoNuevo)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.insertAsignatura(alumnoNuevo);
    }
    
    public Asignatura delAsignatura(Asignatura asignaturaDel){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.delUser(asignaturaDel);
    }
       public Asignatura updAsignatura(Asignatura asignaturaUpd){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.updateUser(asignaturaUpd);
    }
}


