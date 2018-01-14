/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Franco Gallo
 */
public class Contacto implements Serializable {
    
    private String nombre = null;
    private String apellido = null;
    private String alias = null;
    private String email = null;
    private String direccionPostal = null;
    private String numeroTelefonico = null;
    
    //Expresiones regulares de validacion
    private final String validadorMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private final String validadorNumero = "^[+-]?\\d+(\\.\\d+)?$";
    
    private final String validadorNombres = "[a-zA-Z]*";
/*
    ****************************************************************************
    */
    public Contacto(String nombre, String apellido, String alias, String email,
                    String direccionPostal, String numeroTelefonico)throws InvalidEmailException, InvalidTelephoneNumberException, InvalidNameException {    
        
        if(validateNames(nombre)){
            this.nombre = nombre.toUpperCase();
        }else{
            throw new InvalidNameException("Cargo un nombre de usuario no valido, reviselo");
        }
        
        if(validateNames(apellido)){
        this.apellido = apellido.toUpperCase();
        }else{
            throw new InvalidNameException("Cargo un apellido de usuario no valido, reviselo");
        }
        
        this.alias = alias.toUpperCase();
        
        if(validateEmail(email))
            this.email = email.toUpperCase();
        else
            throw new InvalidEmailException("Cargo datos invalidos en el e-mail, reviselo");
        
        this.direccionPostal = direccionPostal.toUpperCase();
        
        if(validateNumer(numeroTelefonico))
        this.numeroTelefonico = numeroTelefonico.toUpperCase();
        else
            throw new InvalidTelephoneNumberException("Cargo datos invalidos en el numero telefonico, reviselo");
        
    }
/*
     ***************************************************************************
     */

    public String getNombre() {
        return nombre;
    }
/*
    ****************************************************************************
    */
    public String getApellido() {
        return apellido;
    }
/*
    ****************************************************************************
    */
    public String getAlias() {
        return alias;
    }
/*
    ****************************************************************************
    */
    public String getEmail() {
        return email;
    }
/*
    ****************************************************************************
    */
    public String getDireccionPostal() {
        return direccionPostal;
    }
/*
    ****************************************************************************
    */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
/*
    ****************************************************************************
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*
    ****************************************************************************
    */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
/*
    ****************************************************************************
    */
    public void setAlias(String alias) {
        this.alias = alias;
    }
/*
    ****************************************************************************
    */
    public void setEmail(String email) {
        this.email = email;
    }
/*
    ****************************************************************************
    */
    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }
/*
    ****************************************************************************
    */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
/*
    ****************************************************************************
    */    
    public final boolean validateEmail(String email) {
 
        Pattern pattern = Pattern.compile(validadorMail);
 
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
/*
    ****************************************************************************
    */    
    public final boolean validateNumer(String numero){
        
        Pattern pattern = Pattern.compile(validadorNumero);
        
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }
/*
    ****************************************************************************
    */
    public final boolean validateNames(String nombre){
        Pattern pattern = Pattern.compile(validadorNombres);
        
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }
    
    
}
