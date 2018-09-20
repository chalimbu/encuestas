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
public class DesLogeo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //chequea que se envia el perfil de usuario a deslogear 1 administrador, 2 analista
        if (request.getParameter("perfil") == null) {
            MensajeError error = new MensajeError("son necesarios los parametros perfil para deslogear 1 admnistrador,2 analista");
            String json = new Gson().toJson(error);
            response.getWriter().write(json);
            return;
        } else {
            //chequea que el formato de peticion sea correcto request.getParameter("perfil")==null
            if (ValidacionesFormato.isNumeric(request.getParameter("perfil"))) {//es numero y se envio, podemos elimiar el perfil
                try {
                    Conexion con = new Conexion();
                    Connection cone = con.conectar();
                    controlDeAcceso cta=new controlDeAcceso(cone);
                    if(Integer.parseInt(request.getParameter("perfil"))==1){//es administrador
                    cta.salidaAdministrador(request);
                    cone.close();
                    return;
                    }else{
                    cta.salidaAnalista(request);
                    cone.close();
                    return;
                    }
                    
                    } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DesLogeo.class.getName()).log(Level.SEVERE, null, ex);
                    MensajeError error = new MensajeError("problema con la base de datos");
                    String json = new Gson().toJson(error);
                    response.getWriter().write(json);
                    
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(DesLogeo.class.getName()).log(Level.SEVERE, null, ex);
                    MensajeError error = new MensajeError("problema con la base de datos ");
                    String json = new Gson().toJson(error);
                    response.getWriter().write(json);
                    return;
                    
                }
            }else{
                    MensajeError error = new MensajeError("error el perfil debe ser un numero ");
                    String json = new Gson().toJson(error);
                    response.getWriter().write(json);
                    return;
            
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  

}
