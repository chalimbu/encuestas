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
import modelo.db.Select;

/**
 *
 * @author sebastian
 */
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        
        //valida que se reciben los parametros
        if(request.getParameter("usuario")==null||request.getParameter("contrasena")==null){
             MensajeError error=new MensajeError("son necesarios los parametros usuario y contrasena, para iniciar sesion");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            return;
        }
        //valida el usuario y contraseña
        
        try {
            Conexion con=new Conexion();
            Connection cone=con.conectar();
            Select sele=new Select(cone);
            controlDeAcceso ctra=new controlDeAcceso(cone);
            int numeroUsuario=sele.numeroUsuario(request.getParameter("usuario"), request.getParameter("contrasena"));//encuentra el numero de usuario
            if(numeroUsuario==0){//significa que el usuario no existe
            MensajeError error=new MensajeError("el usuario/contraseña no existen");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            cone.close();
            return;
            }else{//el usuario existe se identifica que rol tiene para responder
                int numeroRol=sele.tipoUsuario(numeroUsuario);
                if(numeroRol==1){
                ctra.registrarAdministrador(request);
                MensajeError error=new MensajeError("admnistrador");
                String json=new Gson().toJson(error);
                response.getWriter().write(json);
                cone.close();
                return;
                }else{
                
                ctra.registrarAnalista(request);
                MensajeError error=new MensajeError("analista");
                String json=new Gson().toJson(error);
                response.getWriter().write(json);
                cone.close();
                return;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError error=new MensajeError("error en la conexion de la base de datos");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError error=new MensajeError("error en la conexion de la base de datos");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            return;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}
