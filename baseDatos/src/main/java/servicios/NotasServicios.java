/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.NotasDAO;
import java.util.List;
import model.Nota;

/**
 *
 * @author Ivan
 */
public class NotasServicios {
    
     
    
    public List<Nota> getAllNotas()
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.getAllNotas();
    }
    
    public Nota getNotaById(Nota obj){
        NotasDAO dao = new NotasDAO();
        
        return dao.getUserById(obj);
        
    }
    public Nota addNota(Nota alumnoNuevo)
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.insertNota(alumnoNuevo);
    }
    
    public Nota delNota(Nota notaDel){
        NotasDAO dao = new NotasDAO();
        
        return dao.delUser(notaDel);
    }
       public Nota updNota(Nota notaUpd){
        NotasDAO dao = new NotasDAO();
        
        return dao.updateUser(notaUpd);
    }
    
}
