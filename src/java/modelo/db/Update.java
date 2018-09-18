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
public class Update {
    Connection con;
    
    public Update(Connection con){
    this.con=con;
    }
    
    public void actualizarActa(String id,String fecha,String lugar,String ordenDia,String desarrollo) throws SQLException{
     fecha=fecha.replaceAll("\\s", "");
     lugar=lugar.replaceAll("\\s", "");
     PreparedStatement pe= con.prepareStatement("UPDATE ACTA SET FECHA=?,LUGAR=? , "
             + "ORDEN_DEL_DIA=?, DESARROLLO=? WHERE ACTAID=?");
        /*System.out.println("UPDATE ACTA SET FECHA='"+fecha+"',LUGAR='"+lugar+"' , "
             + "ORDEN_DEL_DIA='"+ordenDia+"' , DESARROLLO='"+desarrollo+"' WHERE ACATAID="+id+";");*/
        //PreparedStatement pe= con.prepareStatement("UPDATE ACTA SET FECHA=?, LUGAR=?, ORDEN_DEL_DIA=?, DESARROLO=? WHERE ACATAID=?");
            pe.setString(1,fecha);
            pe.setString(2, lugar);
            pe.setString(3, ordenDia);
            pe.setString(4, desarrollo);
            pe.setString(5,id);
            System.out.println(""+pe);
            int res = pe.executeUpdate();
            if (res > 0) {
                System.out.println("usuario actualizado correctamente");
             // se realizo la actualizacion
            }
    }
}
