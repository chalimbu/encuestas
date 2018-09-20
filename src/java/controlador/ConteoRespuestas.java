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
import modelo.beans.Conteo;
import modelo.beans.MensajeError;
import modelo.db.Conexion;
import modelo.db.Select;

/**
 *
 * @author sebastian
 */
public class ConteoRespuestas extends HttpServlet {
//la clase debe permitir al admninistrador obtener el conteo de respuestas dadas 
    //producto del id de pregunta y los numeros posibles de valores de respuesta

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
        try {
            Conexion con = new Conexion();
            Connection cone;
            cone = con.conectar();
            controlDeAcceso cta=new controlDeAcceso(cone);
            if(cta.tieneAccesoDeAnalista(request)){ //validos que el usuario este logeado
            //validaciones de parametros necesarios recibidos
            if (request.getParameter("idPregunta") == null) {
                MensajeError error = new MensajeError("falta el parametro con name idPregunta");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
            }
            if (request.getParameter("idRespuesta") == null) {
                MensajeError error = new MensajeError("falta el parametro con name idRespuesta");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
            }
            //validaciones de formato
            if (!ValidacionesFormato.isNumeric(request.getParameter("idPregunta"))) {
                MensajeError error = new MensajeError("el parametro idPregunta debe ser un numero, el numero que identifica a la pregunta");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
            }
            if (!ValidacionesFormato.isNumeric(request.getParameter("idRespuesta"))) {
                MensajeError error = new MensajeError("el parametro idRespuesta debe ser un numero, el numero del id de la respuesta ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
            }
            //generacion de la respuesta del conteo
            Select sel=new Select(cone);
            Conteo conteo=new Conteo(sel.conteoDeRespuestas(Integer.parseInt(request.getParameter("idPregunta")), Integer.parseInt(request.getParameter("idRespuesta"))));
            String json = new Gson().toJson(conteo);
            response.getWriter().write(json);
            cone.close();
            return;
            }else{
            MensajeError error = new MensajeError("no ha iniciado sesion como analista, acceso denegado ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConteoRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConteoRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
