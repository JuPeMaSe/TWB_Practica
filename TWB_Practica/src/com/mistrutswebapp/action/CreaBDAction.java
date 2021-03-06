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
              //System.out.println(con);
			  log.info("In LoginAction despues de connection");
         // try {  
              st  = con.createStatement();  
              //Creamos la tabla Usuario
              sql = "CREATE TABLE Usuario(" +
              		"User_ID VARCHAR(30) NOT NULL PRIMARY KEY," +
              		"	Password VARCHAR(30)," +
              		"	Nombre VARCHAR(50)," +
              		"	Apellidos VARCHAR(60)," +
              		"	Fe_Nac DATE," +
              		"	Tfno CHAR(9)," +
              		"	Email VARCHAR(60)," +
              		"	UserType VARCHAR(3));";
              st.executeUpdate(sql);
            //  log.info("In LoginAction despues de crear tabla Usuario");
              //Creamos la tabla Perfil
              sql="CREATE TABLE Perfil(" +
              		"	Profile_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	Pdf BLOB," +
              		"	Fotografia BLOB," +
              		"	Direccion VARCHAR(40)," +
              		"	Localidad VARCHAR(40)," +
              		"	Provincia VARCHAR(40)," +
              		"	Pais VARCHAR(40)," +
              		"	Cont_MeGusta INTEGER," +
              		"	User_ID VARCHAR(30)" +
              		");";
              st.executeUpdate(sql);
             // log.info("In LoginAction despues de crear tabla Perfil");
             // Creamos la table Tecnologia
             sql = "CREATE TABLE Tecnologia(	" +
              		"Tecnologia_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	Nombre_Tec VARCHAR(50)" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Tecnologia");
              //Creamos la tabla Perfil-Tec
             sql= "CREATE TABLE Perfil_Tec(" +
              		"	Tecnologia_ID INTEGER," +
              		"	Profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Perfil_Tec");
              //Creamos la tabla Titulacion
              sql="CREATE TABLE Titulacion(" +
              		"	Titulacion_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	Nombre_Tit VARCHAR(50)" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Titulación");
              //Creamos la tabla Perfil_Tit
              sql="CREATE TABLE Perfil_Tit(" +
              		"	Titulacion_ID INTEGER," +
              		"	Profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Perfil_Tit");
              //Creamos la tabla Experiencia
              sql="CREATE TABLE Experiencia(" +
              		"	Exp_ID INTEGER NOT NULL PRIMARY KEY," +
              		"	Empresa VARCHAR(60)," +
              		"	Cargo VARCHAR(50)," +
              		"	A_Inicio INTEGER," +
              		"	A_Fin INTEGER," +
              		"	Profile_ID INTEGER" +
              		");";
              st.executeUpdate(sql);
              //log.info("In LoginAction despues de crear tabla Experiencia");
              
              //Borramos los usuarios que existiesen en la tabla Usuario  
              st.executeUpdate("DELETE FROM Usuario");  
           // Varios usuarios de prueba  
              st.executeUpdate("INSERT INTO Usuario (User_ID, Password, Nombre, Apellidos, Tfno, Email, UserType) " +
              		"VALUES ('jpms', '4367',  'Juan Pedro', 'Marquez Sevilla','', '','adm')");
              //st.executeUpdate("INSERT INTO Usuario (User_ID, Password, Nombre) VALUES ('jpms', '4367',  'Juan Pedro')");
              st.executeUpdate("INSERT INTO Usuario (User_ID, Password, Nombre) VALUES ('ja', '5367',  'Jose Angel')");  
      			st.executeUpdate("INSERT INTO Usuario (User_ID, Password, Nombre) VALUES ('jj', '6367',  'Juan Jose')");  
	// Mostramos por pantalla todos los usuarios de la tabla  
            rst1 = st.executeQuery("SELECT * FROM Usuario");  
            while (rst1.next()){  
                log.info("In CreaBDAction --> "+ rst1.getString("User_ID") + " " + rst1.getString("Password") + " " + rst1.getString("Nombre") );  
            }  
              // Enviamos el comando para que salve todos los datos temporales de forma permanente  
 //             st = con.createStatement();  
 //             st.executeUpdate("SHUTDOWN");  
              
              // Liberamos recursos y cerramos la conexion  
             st.close();  
              con.close();  
          } catch (Exception ex){  
              log.error("BD no creada por --> "+ ex.getMessage());
          }finally{  
        	  
        
          }
          log.info("In CreaBDAction --> Base de datos creada");
          
          return mapping.findForward("Ok");
          
	 }

}
