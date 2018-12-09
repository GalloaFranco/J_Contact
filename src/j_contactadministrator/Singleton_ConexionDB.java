/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.sql.*;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author Franco Gallo
 */
public class Singleton_ConexionDB {

    //CONSTANTE QUE INSTANCIA UNA NUEVA CONEXIONDB
    private static final Singleton_ConexionDB INSTANCE = new Singleton_ConexionDB();

    /*
    ****************************************************************************
     */
    //CONSTRUCTOR PRIVADO PARA RESPETAR EL PATRON SINGLETON
    private Singleton_ConexionDB() {
        try {
            DriverManager.registerDriver(new ClientDriver());

        } catch (SQLException se) {
            System.err.println("Error al cargar el driver");
            se.getMessage();
        }
    }

    /*
    ****************************************************************************
     */
    public static Singleton_ConexionDB getConexionClass() {
        return INSTANCE;

    }

    /*
    ****************************************************************************
     */
    public Connection getConexionDB() throws SQLException {

        final String user = "Franco";
        final String password = "Franco";

        try (
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/J_ContactDB", user, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");) {

//            System.out.println("Conexion lista");
            return con;
        } catch (SQLException se) {
            System.err.println("Error al conectar con la base de datos");
            throw se;
        }
    }
}