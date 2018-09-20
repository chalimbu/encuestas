/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import modelo.db.Delete;
import modelo.db.Insert;
import modelo.db.Select;

/**
 *
 * @author sebastian
 */
//la justificacion de esta clase es permitir controlar el acceso a los modulos de la aplicacion
//usandola para registrar el ingreso de administradores,analistas
//verificar si se ha iniciado sesion y se tiene permiso por tanto para acceder al recurso
//para deslogearse de aplicacione
public class controlDeAcceso {
    Connection con;
    
    public controlDeAcceso(Connection cone){
    con=cone;
    }
    //permite el logeo de analista y admnistrador
    public void registrarAnalista(HttpServletRequest request) throws SQLException{
       Insert ins=new Insert(con);
       ins.registrarIngresoAnalista(request.getRemoteAddr(), request.getHeader("USER-AGENT"));
    }
    
    public void registrarAdministrador(HttpServletRequest request) throws SQLException{
       Insert ins=new Insert(con);
       ins.registrarIngresoAdministrador(request.getRemoteAddr(), request.getHeader("USER-AGENT"));
    }
    
    public void salidaAnalista(HttpServletRequest request) throws SQLException{
        Delete del=new Delete(con);
        del.eliminarIniciadoAnalista(request.getRemoteAddr(), request.getHeader("USER-AGENT"));
    }
    
    public void salidaAdministrador(HttpServletRequest request) throws SQLException{
        Delete del=new Delete(con);
        del.eliminarIniciadoAdmin(request.getRemoteAddr(), request.getHeader("USER-AGENT"));
    }
    
    public boolean tieneAccesoDeAnalista(HttpServletRequest request) throws SQLException{
        Select sel=new Select(con);
        return sel.accesoAnalista(request.getRemoteAddr(), request.getHeader("USER-AGENT"));
    }
    
    public boolean tieneAccesoDeAdministrador(HttpServletRequest request) throws SQLException{
        Select sel=new Select(con);
        return sel.accesoAdministrador(request.getRemoteAddr(), request.getHeader("USER-AGENT"));
    }
    
    
}
