 
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
import modelo.beans.Analista;
import modelo.beans.MensajeError;
import modelo.db.Conexion;
import modelo.db.Select;
/**
 *
 * @author erik
 */
public class VerAnalista extends HttpServlet {
     
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        System.out.println("hola");
         try {
            Conexion con = new Conexion();
            Connection cone;
            cone = con.conectar();
            System.out.println("hola");
            controlDeAcceso cta=new controlDeAcceso(cone);
            if(cta.tieneAccesoDeAdministrador(request)){ //valido que sea un administrador
                ArrayList<Analista> lista = new ArrayList<>();
                Select sel= new Select(cone);
                ResultSet rs;
                rs=sel.verAnalistas();
                while(rs.next()){
                lista.add(new Analista(rs.getInt("id"),rs.getString("usuario"), rs.getString("contrasena")));
                 
                
                }
                String json=new Gson().toJson(lista);
                response.getWriter().write(json);
                cone.close();
                return;
            
            
            }else{
                System.out.println("holahola");
                MensajeError error=new MensajeError("acceso denegado");
                String json=new Gson().toJson(error);
                response.getWriter().write(json);
                cone.close();
                return;
            
            
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            MensajeError error=new MensajeError("error en la conexion de la base de datos");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(VerAnalista.class.getName()).log(Level.SEVERE, null, ex);
            
            MensajeError error=new MensajeError("error en la conexion de la base de datos");
            String json=new Gson().toJson(error);
            response.getWriter().write(json);
            return;
        }
        
    }
 
}
