/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.db.Conexion;

/**
 *
 * @author sebastian
 */
public class GenerarGraficoBarras extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {         
        try {
            Conexion con = new Conexion();
            Connection cone;
            cone = con.conectar();///
            controlDeAcceso cta=new controlDeAcceso(cone);
            if(cta.tieneAccesoDeAnalista(request)){
                /*response.setContentType("image/PNG");
                outputStream out=response.getOutputStream();*/
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenerarGraficoBarras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenerarGraficoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    
}
