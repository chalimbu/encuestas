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
import java.sql.*; 
/**
 *
 * @author sebastian
 */
 public class Conexion {
     
 public String table,user,pass;   
    
   public Conexion(){
        this.table="encuestas3";
        this.user="encuestas2";
        this.pass="encuestas2123";
    }
    
    public Connection conectar() throws ClassNotFoundException{
     Connection con=null;
     try {
         Class.forName("com.mysql.jdbc.Driver");  
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+table,user,pass);
         
         if(con.isClosed()){
             JOptionPane.showMessageDialog(null, "se perdio la conexion con la base de datos contacte con soporte ");
         }
         return con;
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "se perdio la conexion con la base de datos contacte con soporte ");
     }
     return con;
    }
    
}
