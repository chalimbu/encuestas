/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.MensajeError;
import modelo.db.Conexion;
import modelo.db.Insert;
import modelo.db.Select;
import modelo.db.Update;

/**
 *
 * @author sebastian
 */
public class GuardarEncuestaEmpresario extends HttpServlet {
//servicio que guarda la informacion suministrada en la encuesta a empresarios 
//en la base de datos
    
//actual: valida que se dieron todos los datos y en el formato correcto
   
 
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
         int[] preguntasAbiertas = {1,2};
         int[] preguntasCerradas = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
         boolean enviado=false;
       
         
         // verificar que no este nulo las preguntas abiertas
         int i;
         for(i=0;i<preguntasAbiertas.length;i++){
            if(request.getParameter("a"+preguntasAbiertas[i])==null&&!enviado){ 
            MensajeError error=new MensajeError("falta el elemento con id "+preguntasAbiertas[i]
                    + " que debe ser devuelto mediante el name: a"+preguntasAbiertas[i]+
                      " y es la respuesta a una pregunta abierta");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            enviado=true;
            return;
            }
        }
         
         //verificar que no este nulo las pregutnas cerradas
         for(i=0;i<preguntasCerradas.length;i++){
            if(request.getParameter("c"+preguntasCerradas[i])==null&&!enviado){ 
            MensajeError error=new MensajeError("falta el elemento con id "+preguntasCerradas[i]
                    + "que debe ser devuelto mediante el name: c"+preguntasCerradas[i]
                    +" y que es la respuesta a una pregunta cerrada");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            enviado=true;
            return;
            }
            if(!ValidacionesFormato.isNumeric(request.getParameter("c"+preguntasCerradas[i]))&&!enviado){ 
            MensajeError error=new MensajeError("el elemento c"+preguntasCerradas[i]+" debe ser la opcion "
                    + "numerica seleccionada, mediante el id de la pregunta");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            enviado=true;
            return;
            }
        }
         MensajeError error=new MensajeError("problema al guardar la encuesta en la base de datos");
         String json=new Gson().toJson(error);
        //ingresar valores reogidos de la encuesta en la base de datos
        try {
            int idEncuestado=0;
            Conexion con=new Conexion();
            Connection cone;
            cone = con.conectar();
            Select sel=new Select(cone);
            idEncuestado=sel.obtenerSiguienteEncuestado()+1; //obtiene el id del proximo encuestado
            Insert ins=new Insert(cone);
            Update upd=new Update(cone);
            for(i=0;i<preguntasAbiertas.length;i++){
                int idPregunta=preguntasAbiertas[i];
                String abierta=request.getParameter("a"+preguntasAbiertas[i]);
                if(sel.respuestaExiste(idEncuestado,preguntasAbiertas[i])){//si ya existe actualize
                    upd.actualizarRespuestAbierta(idEncuestado, idPregunta, abierta);
                }else{//sino existe cree la respuesta
                    ins.insertarRespuestaAbierta(idEncuestado,idPregunta,abierta);
                }
            }
            for(i=0;i<preguntasCerradas.length;i++){
                int idPregunta=preguntasCerradas[i];
                int cerrada=Integer.parseInt(request.getParameter("c"+preguntasCerradas[i]));
                if(sel.respuestaExiste(idEncuestado,preguntasCerradas[i])){//si ya existe actualize
                    upd.actualizarRespuestaCerrada(idEncuestado, idPregunta, cerrada);
                }else{//sino existe cree la respuesta
                    ins.insertarRespuestaCerrada(idEncuestado, idPregunta, cerrada);
                }
            
            }
            cone.close();
        } catch (ClassNotFoundException ex) {
            if(!enviado){
            response.getWriter().write(json);
            enviado=true;
            return;
            }
            Logger.getLogger(GuardarEncuestaEgresado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            if(!enviado){
            response.getWriter().write(json);
            enviado=true;
            return;
            }
            Logger.getLogger(GuardarEncuestaEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }




