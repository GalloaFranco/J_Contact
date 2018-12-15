package j_contactadministrator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FrancoDesk
 */
public class SQLServer_AgendaDAOTest {
    
    SQLServer_AgendaDAO testSchedule;
    
    public SQLServer_AgendaDAOTest() {
    }
    
    @Before
    public void setUp() {
        testSchedule = new SQLServer_AgendaDAO();
    }


    @Test
    public void testAddContacto() {
        try {
            Contacto testContact = new Contacto("Testito", "Eltesteado", "Test", "Testito@test.com", "ambienteTestin10", "351616456");
            testSchedule.addContacto(testContact);
             
            Pattern pattern = Pattern.compile("(TESTITO)");
            Matcher matcher =  pattern.matcher(testSchedule.getByName("TESTITO"));
           
            Assert.assertEquals(false , matcher.matches());
            
            testSchedule.eliminarContacto(testContact.getNombre());
            
        } catch (InvalidEmailException | InvalidTelephoneNumberException | InvalidNameException ex) {
            Logger.getLogger(SQLServer_AgendaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of modificarContacto method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testModificarContacto() throws Exception {
    }

    /**
     * Test of eliminarContacto method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testEliminarContacto() {
    }

    /**
     * Test of eliminarLista method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testEliminarLista() {
    }

    /**
     * Test of mostrar method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testMostrar() {
    }

    /**
     * Test of exportarLista method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testExportarLista() {
    }

    /**
     * Test of ordenarAgenda method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testOrdenarAgenda() {
    }

    /**
     * Test of getByName method, of class SQLServer_AgendaDAO.
     */
    @Test
    public void testGetByName() {
    }
    
}
