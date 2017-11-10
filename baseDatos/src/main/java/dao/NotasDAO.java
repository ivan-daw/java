/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Nota;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Ivan
 */
public class NotasDAO {
    
      
    
    public Nota getUserById(Nota u) {
 
        Nota user = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Nota> h
                    = new BeanHandler<>(Nota.class);
             user = qr.query(con, "select * FROM NOTAS where ID_ALUMNO = ? AND ID_ASIGNATURA = ?", h, 
                    u.getId_alumno(), u.getId_asignatura());
            
        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return user;
    }

        
//        Nota user = null;
//        DBConnection db = new DBConnection();
//
//        Connection con = null;
//        try {
//            Context ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("jdbc/db4free");
//            con = ds.getConnection();
//            QueryRunner qr = new QueryRunner();
//            ResultSetHandler<Nota> h
//                    = new BeanHandler<>(Nota.class);
//            user = qr.query(con, "select * FROM NOTAS where ID_ALUMNO = ? AND ID_ASIGNATURA = ?", h, 
//                    u.getId_alumno(), u.getId_asignatura());
//        } catch (Exception ex) {
//            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return user;
    
//
//       public Nota getUser(Nota userOriginal) {
//        Nota user = null;
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            QueryRunner qr = new QueryRunner();
//            ResultSetHandler<Nota> h
//                    = new BeanHandler<>(Nota.class);
//            user = qr.query(con, "select * FROM LOGIN where USER = ?", h, userOriginal.getNombre());
//        } catch (Exception ex) {
//            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return user;
//    }
//    

    public List<Nota> getAllNotas() {
        List<Nota> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Nota>> h
                    = new BeanListHandler<Nota>(Nota.class);
            lista = qr.query(con, "SELECT * FROM NOTAS", h);

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return lista;
    }
    
    public Nota delUser(Nota u) {
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "DELETE FROM NOTAS WHERE ID_ALUMNO = ? AND ID_ASIGNATURA = ?",
                    u.getId_alumno(), u.getId_asignatura());

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return u;
    }
    
      public Nota updateUser(Nota u) {
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "UPDATE NOTAS SET NOTA=? WHERE ID_ALUMNO = ? AND ID_ASIGNATURA = ?",
                    u.getNota(), u.getId_alumno(), u.getId_asignatura());
            

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            db.cerrarConexion(con);
        }
        return u;
    }

            public Nota insertNota(Nota u) {
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "INSERT INTO NOTAS (ID_ALUMNO, ID_ASIGNATURA, NOTA) VALUES(?,?,?)",
                    u.getId_alumno(), u.getId_asignatura(), u.getNota());
            

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            db.cerrarConexion(con);
        }
        return u;
    }
      
    
}
