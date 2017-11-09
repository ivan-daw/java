/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

ID_ALUMNO int(11) PK 
ID_ASIGNATURA int(11) PK 
NOTA
 */
package model;

/**
 *
 * @author Ivan
 */
public class Nota {
    private int ID_ALUMNO;
    private int ID_ASIGNATURA;
    private int NOTA;

    public int getID_ALUMNO() {
        return ID_ALUMNO;
    }

    public void setID_ALUMNO(int ID_ALUMNO) {
        this.ID_ALUMNO = ID_ALUMNO;
    }

    public int getID_ASIGNATURA() {
        return ID_ASIGNATURA;
    }

    public void setID_ASIGNATURA(int ID_ASIGNATURA) {
        this.ID_ASIGNATURA = ID_ASIGNATURA;
    }

    public int getNOTA() {
        return NOTA;
    }

    public void setNOTA(int NOTA) {
        this.NOTA = NOTA;
    }

    
    
}
