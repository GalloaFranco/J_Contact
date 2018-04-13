/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author Franco
 */
public class Singleton_ConexionSQLServer {
    
    //CONSTANTE QUE INSTANCIA UNA NUEVA VERSION DE LA CONEXION CON SQL SERVER
    private static final Singleton_ConexionSQLServer INSTANCE = new Singleton_ConexionSQLServer();
    
    /*
    ****************************************************************************
    */
    //CONSTRUCTOR
    private Singleton_ConexionSQLServer (){
        try {
            DriverManager.registerDriver(new ClientDriver());
        } catch (SQLException ex) {
            Logger.getLogger(Singleton_ConexionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    ****************************************************************************
    */
    //METODO QUE DEVUELVE LA INSTANCIA UNICA DE LA CLASE SINGLETON_SQLSERVER
    public static Singleton_ConexionSQLServer getSingleton_ConexionSQL() {
     return INSTANCE;
    }
    
    /*
    ****************************************************************************
    */
    //METODO PARA CONECTAR CON SQL SERVER
    public Connection getConexionSQL() throws SQLException {
      Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-FRANCO:1433;databaseName=J_ContactAdministrator [sa on dbo]");
        try( 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CONTACTOS");){
      
        }catch (SQLException se){
                se.getMessage();
        }
        return con;
    }
    
    
}
