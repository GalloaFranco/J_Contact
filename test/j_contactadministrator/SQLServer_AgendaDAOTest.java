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
    Contacto testContact; 
    
    public SQLServer_AgendaDAOTest() {
    }
    
    @Before
    public void setUp() throws InvalidEmailException,InvalidTelephoneNumberException,InvalidNameException {
        testSchedule = new SQLServer_AgendaDAO();
        testContact = new Contacto("Testito", "Eltesteado", "Test", "Testito@test.com", "ambienteTestin10", "351616456");
    }


    @Test
    public void testAddContacto() {

        testSchedule.addContacto(testContact);

        Pattern pattern = Pattern.compile("TESTITO");
        Matcher matcher = pattern.matcher(testSchedule.getByName("TESTITO"));

        assertTrue(matcher.find());

        testSchedule.eliminarContacto(testContact.getNombre());
    }

    @Test
    public void testModificarContacto() throws Exception {
        
        testSchedule.addContacto(testContact);
        testSchedule.modificarContacto("Testitoo", "Eltestiao", "Test", "Testito@gmail.com", "ambienteTestin10", "3516163584", "Testito");
        
        Pattern pattern = Pattern.compile("TESTITOO");
        Matcher matcher = pattern.matcher(testSchedule.getByName("TESTITOO"));
        
        assertTrue(matcher.find());

        testSchedule.eliminarContacto(testContact.getNombre());
    }

    @Test
    public void testEliminarContacto() {
        
        testSchedule.addContacto(testContact);
        testSchedule.eliminarContacto(testContact.getNombre());

        Pattern pattern = Pattern.compile("TESTITO");
        Matcher matcher = pattern.matcher(testSchedule.getByName("TESTITO"));
        
        assertFalse(matcher.find());
    }

}
