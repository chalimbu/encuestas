/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.MensajeError;
import modelo.db.Conexion;
import modelo.db.Insert;

/**
 *
 * @author sebastian
 */
public class CrearAnalista extends HttpServlet {

    //permite crear un analista, primero verifica que sea administrador el que ingresa
    //Luego verifica que se envio usuario y contrasena, y luego los ingresa
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conexion con = new Conexion();
            Connection cone;
            cone = con.conectar();
            controlDeAcceso cta = new controlDeAcceso(cone);
            if (cta.tieneAccesoDeAdministrador(request)) {//validos que el usuario este logeado
                if (request.getParameter("usuario") == null || request.getParameter("contrasena") == null) {
                    MensajeError error = new MensajeError("debe proporcionar los parametros usuario y contrasena para crear un usuario");
                    String json = new Gson().toJson(error);
                    response.getWriter().write(json);
                    cone.close();
                    return;
                }else{
                    Insert ins=new Insert(cone);
                    ins.registrarNuevoAnalista(request.getParameter("usuario"), request.getParameter("contrasena"));
                }
            } else {
                MensajeError error = new MensajeError("no ha iniciado sesion como administrador, acceso denegado ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                cone.close();
                return;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearAnalista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearAnalista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
