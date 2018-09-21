/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian
 */
public class Select {

    Connection con = null;

    public Select(Connection con) {
        this.con = con;
    }

    public ResultSet select(String from, String where, String equal) {
        ResultSet rs = null;
        Statement st;

        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from " + from + " where " + where + "=" + equal + ";");
        } catch (SQLException ex) {
            //System.out.println("no fue posible aceder a la tabla "+ from);
        }
        return rs;
    }

    public ResultSet selectTabla(String from) {
        ResultSet rs = null;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from " + from + ";");
        } catch (SQLException ex) {
            //System.out.println("no fue posible aceder a la tabla "+ from);
        }
        return rs;
    }

    public Boolean selectLogin(String from, String where1, String equal1, String where2, String equal2) {
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM " + from
                    + " WHERE " + where1 + "='" + equal1 + "' AND "
                    + where2 + "='" + equal2 + "';");
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            //System.out.println("no fue posible aceder a la tabla "+ from);
            return false;
        }
        return false;
    }

    public ResultSet selectGeneral(String select) {
        ResultSet rs = null;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery(select);
        } catch (SQLException ex) {
            //System.out.println("no fue posible aceder a la tabla "+ from);
        }
        return rs;
    }

    // obtiene el id del ultimo encuestado actual para con este generar los siguientes
    public int obtenerSiguienteEncuestado() throws SQLException {
        Statement stmt = null;
        String query = "select `id-encuestado` from respuestas order by `id-encuestado` desc;";

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next() == true) {
            int siguiente = rs.getInt("id-encuestado");
            return siguiente;
        } else {
            return 0;
        }

    }
    
    public boolean respuestaExiste(int idEncuestado,int idPregunta) throws SQLException{
        //select * from respuestas where `id-encuestado`=1 and `id-pregunta`=1;
        Statement stmt = null;
        String query = "select * from respuestas where `id-encuestado`="+idEncuestado+" and `id-pregunta`="+idPregunta;

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }
    
    //permite interactuar con la bae de datos para dados un numero de pregunta y un numero de 
    //respuesta nos devuelva el conteo
    public int conteoDeRespuestas(int idPregunta,int valorRespondido) throws SQLException{
        Statement stmt = null;
        String query = "select count(`id-encuestado`) from respuestas where `id-pregunta`="+idPregunta+" and `valor-respondido`="+valorRespondido;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        return rs.getInt("count(`id-encuestado`)");
    }
    //devuelve el numero del usuario, si este no existe devuelve 0
    public int numeroUsuario(String usuario,String contrasena) throws SQLException{
        //select * from respuestas where `id-encuestado`=1 and `id-pregunta`=1;
        Statement stmt = null;
        String query = "select * from usuarios where usuario=\""+usuario+"\" and contrasena=\""+contrasena+"\"";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()){
        return rs.getInt("id");
        }else{
        return 0;
        }
    }
    
    public int tipoUsuario(int idUsuario) throws SQLException{
        Statement stmt = null;
        String query = "select * from `user-rol` where `id-usuario`="+idUsuario;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()){
        return rs.getInt("id-rol");
        }else{
        return 0;
        }
    }
    
    //verifica si una ip,agente esta en la base de datos de accesados
    public boolean accesoAdministrador(String ip,String agente) throws SQLException{
        Statement stmt = null;
        String query = "select * from `iniciados-admin` where direccion='"+ip+"' and name='"+agente+"'";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }
    
    public boolean accesoAnalista(String ip,String agente) throws SQLException{
        Statement stmt = null;
        String query = "select * from `iniciados-analista` where direccion='"+ip+"' and name='"+agente+"'";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }
    
    public ResultSet listaRespuestasConValor(int idPregunta) throws SQLException{
        Statement stmt = null;
        String query = "select distinct `valor-respondido` as vr,"
                + "(select count(`id-encuestado`) from respuestas "
                + "where `valor-respondido`=vr and `id-pregunta`="+idPregunta+") as contadorRespuestas "
                + "from respuestas where `id-pregunta`="+idPregunta+" order by vr asc";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
    
        
    public ResultSet verAnalistas() throws SQLException{
        ResultSet rs = null;
        Statement st;
        
            st = con.createStatement();
            rs = st.executeQuery("select * from `usuarios` inner join `user-rol` on usuarios.id= `user-rol`.`id-usuario` having `id-rol`=2");
        
        return rs;
        
    }
    
    public ResultSet respuestasAbiertas(int idPregunta) throws SQLException{
        Statement stmt = null;
        String query = "select abierta from `respuestas` where `id-pregunta`="+idPregunta;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
}
