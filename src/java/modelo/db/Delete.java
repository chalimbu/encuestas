/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sebastian
 */
public class Delete {
    Connection con;
    public Delete(Connection cone){
        con=cone;
    }
    public void eliminarAsistente(String numeroActa,String idProfesor,String tipoAsistente) throws SQLException{
        PreparedStatement pe2= con.prepareStatement("delete from ASISTENTE \n" +
        "WHERE NUMERO_ACTA=? AND ID_PROFESOR=? AND TIPO_ASISTENTE=?;");
        pe2.setString(1, numeroActa);
        pe2.setString(2, idProfesor);
        pe2.setString(3, tipoAsistente);
        int res=pe2.executeUpdate();
                }
    //elimina es decir cierra la sesion de la ip y agente, para el perfil analista
    public void eliminarIniciadoAdmin(String ip,String agente) throws SQLException{
        PreparedStatement pe2= con.prepareStatement("delete from `iniciados-admin` where direccion=? and name=?");
        pe2.setString(1, ip);
        pe2.setString(2, agente);
        int res=pe2.executeUpdate();
                }
    //elimina es decir cierra la sesion de la ip y agente, para el perfil analista
    public void eliminarIniciadoAnalista(String ip,String agente) throws SQLException{
        PreparedStatement pe2= con.prepareStatement("delete from `iniciados-analista` where direccion=? and name=?");
        pe2.setString(1, ip);
        pe2.setString(2, agente);
        int res=pe2.executeUpdate();
        }
    
    public void eliminarAnalista(int idAnalista) throws SQLException{
        PreparedStatement pe2= con.prepareStatement("delete from usuarios where id=?");
        pe2.setInt(1, idAnalista);
        int res=pe2.executeUpdate();
        PreparedStatement pe3= con.prepareStatement("delete from `user-rol` where `id-usuario`=?");
        pe3.setInt(1, idAnalista);
        int res1=pe3.executeUpdate();
    }
}
