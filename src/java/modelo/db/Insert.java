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
    
    public boolean insertarRespuestaAbierta(int idEncuestado,int idPregunta,String abierta) throws SQLException{
        PreparedStatement pe;
        pe = con.prepareStatement("INSERT INTO respuestas(`id-encuestado`,`id-pregunta`,abierta) VALUES (?,?,?)");
        pe.setInt(1, idEncuestado);
        pe.setInt(2,idPregunta);
        pe.setString(3,abierta);
        int res=pe.executeUpdate();
    return res>0;
    }
    public boolean insertarRespuestaCerrada(int idEncuestado,int idPregunta,int cerrada) throws SQLException{
        PreparedStatement pe;
        pe = con.prepareStatement("INSERT INTO respuestas(`id-encuestado`,`id-pregunta`,`valor-respondido`) VALUES (?,?,?)");
        pe.setInt(1, idEncuestado);
        pe.setInt(2,idPregunta);
        pe.setInt(3, cerrada);
        int res=pe.executeUpdate();
    return res>0;
    }
    //ingresar en la base de datos el inicio de sesion de una analista con ip y agente del navegador
    public boolean registrarIngresoAnalista(String ip,String agente) throws SQLException{
        PreparedStatement pe;
        pe = con.prepareStatement("INSERT INTO `iniciados-analista`(direccion,name) VALUES (?,?)");
        pe.setString(1, ip);
        pe.setString(2, agente);
        int res=pe.executeUpdate();
        return res>0;
    }
    //ingresa en la base de datos el inicio de sesion de un admnistrador almancenando su ip y el agente del navegador
    public boolean registrarIngresoAdministrador(String ip,String agente) throws SQLException{
    //INSERT INTO `iniciados-admin`(direccion,name) VALUES ("192.4384.232.24","agentex");
    PreparedStatement pe;
        pe = con.prepareStatement("INSERT INTO `iniciados-admin`(direccion,name) VALUES (?,?)");
        pe.setString(1, ip);
        pe.setString(2, agente);
        int res=pe.executeUpdate();
        return res>0;
    }
    
    }
