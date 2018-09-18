/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.db;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class Insert {
    Connection con;
    
    public Insert(Connection cone){
    con=cone;
    }
    
    public boolean insertarAsistente(int numeroActa,int numeroAsistente,String idProfesor) throws SQLException{
                PreparedStatement pe;
                pe = con.prepareStatement("INSERT INTO ASISTENTE VALUES (?,?,?)");
                pe.setString(1, ""+numeroActa);
                pe.setString(2, idProfesor);
                pe.setString(3, ""+numeroAsistente);
                int res = pe.executeUpdate();
        return res > 0;
  }
    
    }
