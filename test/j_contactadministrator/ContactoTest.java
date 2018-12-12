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

        boolean esperado = false;
        boolean actual = wrongContact.validateNumer(wrongContact.getNumeroTelefonico());
        
        assertEquals(esperado, actual);
    }

    @Test
    public void testValidateNumerTrue() {

        boolean esperado = true;
        boolean actual = rightContact.validateNumer(rightContact.getNumeroTelefonico());
        
        assertEquals(esperado, actual);
    }


    @Test
    public void testValidateNamesTrue() {
        
        boolean esperado = true;
        boolean actual = rightContact.validateNames(rightContact.getNombre());
        
        assertEquals(esperado, actual);
    }
    
    @Test
    public void testValidateNamesFalse() {

        boolean esperado = false;
        boolean actual = wrongContact.validateNames(wrongContact.getNombre());
        
        assertEquals(esperado, actual);
    }
    
}
