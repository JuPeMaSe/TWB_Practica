package com.mistrutswebapp.action;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.*;  

public class CreaBDAction extends Action {
	 private static Log log = LogFactory.getLog(LoginAction.class);

	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	 { 
		  if (log.isInfoEnabled())
		  { 
		   log.info("In CreaBDAction");
		  }
		  Connection con = null;  
          Statement  st   = null;  
          String     sql  = null;  
          ResultSet  rst1 = null;  
            
//          try {  
//              // Cargamos el controlador JDBC  
//              Class.forName("org.hsqldb.jdbcDriver");  
//          } catch (Exception ex){  
//              log.error("Se ha producido un error al cargar el controlador JDBC"+ ex.getMessage());  
//              return mapping.findForward("error");  
//          }              
//          // Nos conectamos a la base de datos creandola en caso de que no exista   
//          conn = DriverManager.getConnection("jdbc:hsqldb:mem:memoriadb");  
//          // Creamos la tabla sobre la que trabajaremos  +
          try{
              // hago el lookup del pool de conexiones
              Context ctx=new InitialContext();
              DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/ConexionHSQLDS");
                 
              // pido una conexion
              con=ds.getConnection();
        
              // la uso
              //System.out.println(con);
			  log.info("In LoginAction despues de connection");
         // try {  
              st  = con.createStatement();  
              sql = "CREATE TABLE usuarios (user_ID VARCHAR(20), password VARCHAR(12), nombre VARCHAR(100))";  
              st.executeUpdate(sql);
              //Borramos los usuarios que existiesen en la tabla empleados  
              st.executeUpdate("DELETE FROM usuarios");  
           // Varios usuarios de prueba  
              st.executeUpdate("INSERT INTO usuarios (user_ID, password, nombre) VALUES ('jpms', '4367',  'Juan Pedro Marquez Sevilla')");
              st.executeUpdate("INSERT INTO usuarios (user_ID, password, nombre) VALUES ('ja', '5367',  'Jose Angel')");  
      			st.executeUpdate("INSERT INTO usuarios (user_ID, password, nombre) VALUES ('jj', '6367',  'Juan Jose')");  
	// Mostramos por pantalla todos los usuarios de la tabla  
            rst1 = st.executeQuery("SELECT * FROM usuarios");  
            while (rst1.next()){  
                log.info("In CreaBDAction --> "+ rst1.getString("user_ID") + " " + rst1.getString("password") + " " + rst1.getString("nombre") );  
            }  
              // Enviamos el comando para que salve todos los datos temporales de forma permanente  
 //             st = con.createStatement();  
 //             st.executeUpdate("SHUTDOWN");  
              
              // Liberamos recursos y cerramos la conexion  
 //             st.close();  
 //             con.close();  
          } catch (Exception ex){  
              // La tabla ya existia  
          }finally{  
    
        
          }
          log.info("In CreaBDAction --> Base de datos creada");
          
          return mapping.findForward("Ok");
          
	 }

}
