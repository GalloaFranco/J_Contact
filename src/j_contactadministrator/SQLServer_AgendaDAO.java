/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franco
 */
public class SQLServer_AgendaDAO implements AgendaDAO {
    
    static final String INSERT = "INSERT INTO CONTACTOS(NOMBRE,APELLIDO,ALIAS,MAIL,DIRECCION,NUMERO) VALUES(?,?,?,?,?,?)";
    static final String DELETE = "DELETE FROM CONTACTOS WHERE NOMBRE = ?";
    static final String DELETEALL = "DELETE FROM CONTACTOS";
    static final String UPDATE = "UPDATE CONTACTOS SET NOMBRE = ?, APELLIDO = ?, ALIAS = ?, MAIL = ?, DIRECCION = ?, NUMERO = ? WHERE NOMBRE = ?";
    static final String GETALL = "SELECT * FROM CONTACTOS";
     
    
/*
    ****************************************************************************
    */   
    @Override
    public void addContacto(Contacto c) {
        
        try (Connection con = Singleton_ConexionSQLServer.getSingleton_ConexionSQL().getConexionSQL();
            PreparedStatement stmt = con.prepareStatement(INSERT);){
            
            stmt.setString(1, c.getNombre());
            stmt.setString(2,c.getApellido());
            stmt.setString(3, c.getAlias());
            stmt.setString(4,c.getEmail());
            stmt.setString(5, c.getDireccionPostal());
            stmt.setString(6,c.getNumeroTelefonico());
            
            if(nullChecker(c)){
            stmt.executeUpdate();
            } else {
                System.err.println("Algunos datos del contacto son nulos, reviselo en :"
                + c.getNombre());
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(JavaDB_AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
/*
    ****************************************************************************
    */
    private static boolean nullChecker(Contacto c) {
        return c.getEmail() != null && c.getNumeroTelefonico() != null && c.getNombre()!= null && c.getApellido() != null;
    }
    
/*
    ****************************************************************************
    */
    @Override
    public void modificarContacto(String nombre, String apellido, String alias, String email, String direccionpostal,
    String numerotelefonico, String indice)throws InvalidEmailException, InvalidTelephoneNumberException, InvalidNameException {
            
            Contacto contacto = new Contacto(nombre, apellido, alias, email, direccionpostal, numerotelefonico);
            
        try (Connection con = Singleton_ConexionSQLServer.getSingleton_ConexionSQL().getConexionSQL();
            PreparedStatement stmt = con.prepareStatement(UPDATE);){
            
            stmt.setString(1,contacto.getNombre());
            stmt.setString(2,contacto.getApellido());
            stmt.setString(3,contacto.getAlias());
            stmt.setString(4,contacto.getEmail());
            stmt.setString(5,contacto.getDireccionPostal());
            stmt.setString(6,contacto.getNumeroTelefonico());
            stmt.setString(7,indice.toUpperCase());
            stmt.executeUpdate();
            System.out.println("Se modifico el contacto!");
        
        } catch (SQLException ex) {
            Logger.getLogger(JavaDB_AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
/*
    ****************************************************************************
    */
    @Override
    public void eliminarContacto(String c) {
        try(Connection con = Singleton_ConexionSQLServer.getSingleton_ConexionSQL().getConexionSQL();
            PreparedStatement stmt = con.prepareStatement(DELETE);){
        
        stmt.setString(1, c.toUpperCase());
        stmt.executeUpdate();
        }catch(SQLException se){
        se.getMessage();
        }   
        }
/*
    ****************************************************************************
    */
    @Override
    public void eliminarLista() {
        try(Connection con = Singleton_ConexionSQLServer.getSingleton_ConexionSQL().getConexionSQL();
            PreparedStatement stmt = con.prepareStatement(DELETEALL);){
        
        stmt.executeUpdate();
            System.out.println("Lista eliminada, te desconectaste del mundo!");
        }catch(SQLException se){
        se.getMessage();
        }   
        }
/*
    ****************************************************************************
    */
    @Override
    public void mostrar() {
        try(Connection con = Singleton_ConexionSQLServer.getSingleton_ConexionSQL().getConexionSQL();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(GETALL);){
            
            System.out.println("----------DATOS AlMACENADOS EN SQL Server----------");
            
            StringBuilder sb = new StringBuilder();

            while(rs.next()){
            String nombre = rs.getString("NOMBRE");
            String apellido = rs.getString("APELLIDO");
            String alias = rs.getString("ALIAS");
            String mail = rs.getString("MAIL");
            String direccion = rs.getString("DIRECCION");
            String numero = rs.getString("NUMERO");
                
                sb.append(nombre);
                sb.append("\n");
                sb.append(apellido);
                sb.append("\n");
                sb.append(alias);
                sb.append("\n");
                sb.append(mail);
                sb.append("\n");
                sb.append(direccion);
                sb.append("\n");
                sb.append(numero);
                sb.append("\n");
                sb.append("\n");
            }
            System.out.println(sb);

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
/*
    ****************************************************************************
    */
    @Override
    public void exportarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void ordenarAgenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    ****************************************************************************
    */
    @Override
    public String getByName(String nom) {
        try(Connection con = Singleton_ConexionSQLServer.getSingleton_ConexionSQL().getConexionSQL();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(GETALL);){
            
            StringBuilder sb = new StringBuilder();
            
            System.out.println("DATOS DEL CONTACTO:");
            while(rs.next()){
                
            String nombre = rs.getString("NOMBRE");
            String apellido = rs.getString("APELLIDO");
            String alias = rs.getString("ALIAS");
            String mail = rs.getString("MAIL");
            String direccion = rs.getString("DIRECCION");
            String numero = rs.getString("NUMERO");
            
            if(nombre.equalsIgnoreCase(nom)){
                sb.append(nombre);
                sb.append("\n");
                sb.append(apellido);
                sb.append("\n");
                sb.append(alias);
                sb.append("\n");
                sb.append(mail);
                sb.append("\n");
                sb.append(direccion);
                sb.append("\n");
                sb.append(numero);
                sb.append("\n");
                sb.append("\n");
            
            }
            }
             return sb.toString();
           
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
    
}
