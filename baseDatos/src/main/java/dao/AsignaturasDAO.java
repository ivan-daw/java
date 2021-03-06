/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Asignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author oscar
 */
public class AsignaturasDAO {
    
    
    public Asignatura getUserById(int id) {
        Asignatura user = null;
        DBConnection db = new DBConnection();

        Connection con = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/db4free");
            con = ds.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Asignatura> h
                    = new BeanHandler<>(Asignatura.class);
            user = qr.query(con, "select * FROM ASIGNATURAS where ID = ?", h, id);
        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return user;
    }
//
//       public Asignatura getUser(Asignatura userOriginal) {
//        Asignatura user = null;
//        DBConnection db = new DBConnection();
//        Connection con = null;
//        try {
//            con = db.getConnection();
//            QueryRunner qr = new QueryRunner();
//            ResultSetHandler<Asignatura> h
//                    = new BeanHandler<>(Asignatura.class);
//            user = qr.query(con, "select * FROM LOGIN where USER = ?", h, userOriginal.getNombre());
//        } catch (Exception ex) {
//            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            db.cerrarConexion(con);
//        }
//        return user;
//    }
//    
    public List<Asignatura> getAllAsignaturas() {
        List<Asignatura> lista = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Asignatura>> h
                    = new BeanListHandler<Asignatura>(Asignatura.class);
            lista = qr.query(con, "SELECT * FROM ASIGNATURAS", h);

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return lista;
    }
    
    public Asignatura delUser(Asignatura u) {
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "DELETE FROM ASIGNATURAS WHERE ID=?",
                    u.getId());

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.cerrarConexion(con);
        }
        return u;
    }
    
      public Asignatura updateUser(Asignatura u) {
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "UPDATE ASIGNATURAS SET NOMBRE=?, CURSO=?, CICLO=? WHERE ID=?",
                    u.getNombre(), u.getCurso(), u.getCiclo(), u.getId());
            

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            db.cerrarConexion(con);
        }
        return u;
    }

            public Asignatura insertAsignatura(Asignatura u) {
        DBConnection db = new DBConnection();
        Connection con = null;
        try {
            con = db.getConnection();
            QueryRunner qr = new QueryRunner();

            int filas = qr.update(con,
                    "INSERT INTO ASIGNATURAS (NOMBRE,CURSO,CICLO) VALUES(?,?,?)",
                    u.getNombre(), u.getCurso(), u.getCiclo());
            

        } catch (Exception ex) {
            Logger.getLogger(AsignaturasDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            db.cerrarConexion(con);
        }
        return u;
    }
      
    
}
