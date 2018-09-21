/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.MensajeError;
import modelo.beans.encuesta;
import modelo.db.Conexion;
import modelo.db.Select;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
            controlDeAcceso cta = new controlDeAcceso(cone);
            if (cta.tieneAccesoDeAnalista(request)) {
                if (request.getParameter("pregunta") == null) {//verifico que se envio el parametro
                    MensajeError mens = new MensajeError("debe proporcionar el numero de la pregunta con la variable pregunta");
                    String json = new Gson().toJson(mens);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    cone.close();
                    return;
                } else {
                    if (ValidacionesFormato.isNumeric(request.getParameter("pregunta"))) {
                        DefaultCategoryDataset data = new DefaultCategoryDataset();
                        Select sel = new Select(cone);
                        ResultSet rs = sel.listaRespuestasConValor(Integer.parseInt(request.getParameter("pregunta")));
                        while (rs.next()) {
                            data.setValue(rs.getInt("contadorRespuestas"), "" + rs.getInt("vr"), "" + rs.getInt("vr"));
                            
                        }
                        JFreeChart cha = ChartFactory.createBarChart("Pregunta " + request.getParameter("pregunta"), "Id", "Repeticiones", data, PlotOrientation.VERTICAL, true, true, true);
                            int alto = 600, ancho = 750;
                            response.setContentType("image/PNG");
                            OutputStream out = response.getOutputStream();
                            ChartUtilities.writeChartAsPNG(out, cha, ancho, alto);

                            out.close();
                            cone.close();
                            return;
                    } else {
                        MensajeError mens = new MensajeError("debe proporcionar el numero de la pregunta con la variable pregunta como un numero");
                        String json = new Gson().toJson(mens);
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(json);
                        cone.close();
                        return;
                    }

                }
                /*response.setContentType("image/PNG");
                outputStream out=response.getOutputStream();*/

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GenerarGraficoBarras.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError mens = new MensajeError("Error Base de datos");
            String json = new Gson().toJson(mens);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(GenerarGraficoBarras.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError mens = new MensajeError("Error de base de datos");
            String json = new Gson().toJson(mens);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

            return;
        }

    }

}
