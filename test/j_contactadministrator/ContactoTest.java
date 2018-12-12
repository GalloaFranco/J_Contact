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
    
    public ContactoTest() {
    }

//    /**
//     * Test of getNombre method, of class Contacto.
//     */
//    @Test
//    public void testGetNombre() {
//    }
//
//    /**
//     * Test of getApellido method, of class Contacto.
//     */
//    @Test
//    public void testGetApellido() {
//    }
//
//    /**
//     * Test of getAlias method, of class Contacto.
//     */
//    @Test
//    public void testGetAlias() {
//    }
//
//    /**
//     * Test of getEmail method, of class Contacto.
//     */
//    @Test
//    public void testGetEmail() {
//    }
//
//    /**
//     * Test of getDireccionPostal method, of class Contacto.
//     */
//    @Test
//    public void testGetDireccionPostal() {
//    }
//
//    /**
//     * Test of getNumeroTelefonico method, of class Contacto.
//     */
//    @Test
//    public void testGetNumeroTelefonico() {
//    }
//
//    /**
//     * Test of setNombre method, of class Contacto.
//     */
//    @Test
//    public void testSetNombre() {
//    }
//
//    /**
//     * Test of setApellido method, of class Contacto.
//     */
//    @Test
//    public void testSetApellido() {
//    }
//
//    /**
//     * Test of setAlias method, of class Contacto.
//     */
//    @Test
//    public void testSetAlias() {
//    }
//
//    /**
//     * Test of setEmail method, of class Contacto.
//     */
//    @Test
//    public void testSetEmail() {
//    }
//
//    /**
//     * Test of setDireccionPostal method, of class Contacto.
//     */
//    @Test
//    public void testSetDireccionPostal() {
//    }
//
//    /**
//     * Test of setNumeroTelefonico method, of class Contacto.
//     */
//    @Test
//    public void testSetNumeroTelefonico() {
//    }
//
//    /**
//     * Test of validateEmail method, of class Contacto.
//     */
//    @Test
//    public void testValidateEmail() {
//        
//    }
    
        @Test
    public void testValidateNumerFalse() {
        Contacto c = new Contacto("Fernandito","Fernandito", "fernandito@gmail.com");
        boolean esperado = false;
        boolean actual = c.validateNumer(c.getNumeroTelefonico());
        
        assertEquals(esperado, actual);
    }

    @Test
    public void testValidateNumerTrue() {
        Contacto c = new Contacto("Fernandito","12345678", "fernandito@gmail.com");
        boolean esperado = true;
        boolean actual = c.validateNumer(c.getNumeroTelefonico());
        
        assertEquals(esperado, actual);
    }


    @Test
    public void testValidateNamesTrue() {
        Contacto c = new Contacto("Fernandito","12345678", "fernandito@gmail.com");
        boolean esperado = true;
        boolean actual = c.validateNames(c.getNombre());
        
        assertEquals(esperado, actual);
    }
    
    @Test
    public void testValidateNamesFalse() {
        Contacto c = new Contacto("12345678","12345678", "fernandito@gmail.com");
        boolean esperado = false;
        boolean actual = c.validateNames(c.getNombre());
        
        assertEquals(esperado, actual);
    }
    
}
