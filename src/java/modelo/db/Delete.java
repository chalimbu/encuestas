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
}
