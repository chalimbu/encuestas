/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
 public class Conexion {
     
 public String table,user,pass;   
    
   public Conexion(){
        this.table="acta5";
        this.user="root";
        this.pass="";
    }
    
    public Connection conectar(){
     Connection conn=null;
     try {
         String url = "jdbc:mysql://127.0.0.1:3306/"+table+"?user="+user+"&password="+pass;
         Driver d = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection(url);
         
         if(conn.isClosed()){
             JOptionPane.showMessageDialog(null, "se perdio la conexion con la base de datos contacte con soporte ");
         }
         return conn;
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
         JOptionPane.showMessageDialog(null, "se perdio la conexion con la base de datos contacte con soporte");
         Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      }
     return conn;
    }
    
}
