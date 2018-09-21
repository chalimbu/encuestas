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
import modelo.db.Delete;

/**
 *
 * @author sebastian
 */
public class EliminarAnalista extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conexion con = new Conexion();
            Connection cone;
            
            cone = con.conectar();
            controlDeAcceso cta = new controlDeAcceso(cone);
            if (cta.tieneAccesoDeAdministrador(request)) { //validos que el usuario este logeado
                if (request.getParameter("idAnalista") == null) {
                    MensajeError error = new MensajeError("no ha iniciado sesion como administrador, acceso denegado ");
                    String json = new Gson().toJson(error);
                    response.getWriter().write(json);
                    return;
                } else {
                    if (ValidacionesFormato.isNumeric(request.getParameter("idAnalista"))) {
                        Delete del = new Delete(cone);
                        del.eliminarAnalista(Integer.parseInt(request.getParameter("idAnalista")));
                    } else {
                        MensajeError error = new MensajeError("el id del analista debe ser numerico ");
                        String json = new Gson().toJson(error);
                        response.getWriter().write(json);
                    }
                    
                }
            } else {
                MensajeError error = new MensajeError("no ha iniciado sesion como administrador, acceso denegado ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
                
            }
            //validaciones de parametros necesarios recibidos
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminarAnalista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EliminarAnalista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
