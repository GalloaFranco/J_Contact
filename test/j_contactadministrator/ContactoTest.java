/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FrancoDesk
 */
public class ContactoTest {
    
    private final Contacto rightContact = new Contacto("Fernandito","12345678", "fernandito@gmail.com");
    private final Contacto wrongContact = new Contacto("12345678","Fernandito", "123.@fdss,com");
    
    public ContactoTest() {
    }
    
    @Test
    public void testValidateEmailFlase() {

        boolean actual = wrongContact.validateEmail(wrongContact.getEmail());
        
        assertFalse(actual);
    }
    
    @Test
    public void testValidateEmailTrue() {

        boolean actual = rightContact.validateEmail(rightContact.getEmail());
        
        assertTrue(actual);
    }
    
        @Test
    public void testValidateNumerFalse() {

        boolean actual = wrongContact.validateNumer(wrongContact.getNumeroTelefonico());
        
            assertFalse(actual);
    }

    @Test
    public void testValidateNumerTrue() {

        boolean esperado = true;
        boolean actual = rightContact.validateNumer(rightContact.getNumeroTelefonico());
        
        assertTrue(actual);
    }


    @Test
    public void testValidateNamesTrue() {
        
        boolean esperado = true;
        boolean actual = rightContact.validateNames(rightContact.getNombre());
        
        assertTrue(actual);
    }
    
    @Test
    public void testValidateNamesFalse() {

        boolean actual = wrongContact.validateNames(wrongContact.getNombre());
        
         assertFalse(actual);
    }
    
}
