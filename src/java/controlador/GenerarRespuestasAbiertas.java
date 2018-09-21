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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.MensajeError;
import modelo.beans.respuesta;
import modelo.db.Conexion;
import modelo.db.Select;

/**
 *
 * @author sebastian
 */
public class GenerarRespuestasAbiertas extends HttpServlet {

   
    //devulve las respuestas abiertas dada a una pregunta, verifica que se inicio como analista
    //verifica que se envio el parametro,que es un numero, y devuelve las no null
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            Conexion con = new Conexion();
            Connection cone;
            cone = con.conectar();
            controlDeAcceso cta=new controlDeAcceso(cone);
            if(cta.tieneAccesoDeAnalista(request)){
            if(request.getParameter("pregunta")==null){
                MensajeError error = new MensajeError("debe pasar el argumento pregunta con el numero de pregunta ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                cone.close();
                return;
            }else{
                if(ValidacionesFormato.isNumeric(request.getParameter("pregunta"))){
                    Select sel=new Select(cone);
                    ResultSet rs=sel.respuestasAbiertas(Integer.parseInt(request.getParameter("pregunta")));
                    ArrayList<String> lista = new ArrayList<>();
                    while(rs.next()){
                        if(rs.getString("abierta")!=null){
                            lista.add(rs.getString("abierta"));
                        }
                    }
                    String json = new Gson().toJson(lista);
                    response.getWriter().write(json);
                    cone.close();
                }else{
                    MensajeError error = new MensajeError("el parametro pregunta debe ser el NUMERO de la pregunta");
                    String json = new Gson().toJson(error);
                    response.getWriter().write(json);
                    cone.close();
                }
            }
            }else{
            MensajeError error = new MensajeError("no ha iniciado sesion como analista, acceso denegado ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                cone.close();
                return;
            }
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenerarRespuestasAbiertas.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError error = new MensajeError("problema ingresando a la base de datos ");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
            } catch (SQLException ex) { 
            Logger.getLogger(GenerarRespuestasAbiertas.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError error = new MensajeError("problema ingresando a la base de datos");
                String json = new Gson().toJson(error);
                response.getWriter().write(json);
                return;
        } 
       }
    }


