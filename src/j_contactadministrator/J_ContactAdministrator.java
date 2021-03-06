/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Consola;

/**
 *
 * @author Franco Gallo
 */
public class J_ContactAdministrator {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //----------------------------------------------------------------------

        System.out.println("----------J_ContactAdministrator----------");

        AgendaDAOFactory factory = new AgendaDAOFactory();
        AgendaDAO agenda = factory.createSQLServer_AgendaDAO();
        BuscadorCSV buscadorCsv = new BuscadorCSV();

        boolean salirOp1 = false;
        buscadorCsv.start();

        do {
            boolean salirOp2 = false;

            try {
                System.out.println("1)Agregar un contacto");
                System.out.println("2)Ver lista de contactos");
                System.out.println("3)Modificar un contacto");
                System.out.println("4)Buscar un contacto");
                System.out.println("5)Eliminar un contacto");
                System.out.println("6)Eliminar lista completa");
                System.out.println("7)Salir de la agenda");

                int opcionMenuInicial = Consola.readInt();

                switch (opcionMenuInicial) {
//------------------------------------------------------------------------------                    
                    case 1:
                        salirOp2 = true;
                        cargarContacto(agenda);
                        break;
//------------------------------------------------------------------------------                        
                    case 2:
                        agenda.mostrar();
                        break;
//------------------------------------------------------------------------------                        
                    case 3:
                        System.out.println(" ");
                        System.out.println("Ingrese el nombre a modificar de su contacto:");
                        String nombre = Consola.readLine();
                        System.out.println("Ahora el apellido:");
                        String apellido = Consola.readLine();
                        System.out.println("Ahora el apodo, en caso de tenerlo:");
                        String alias = Consola.readLine();
                        System.out.println("Ahora el mail");
                        String email = Consola.readLine();
                        System.out.println("Ahora su direccion postal:");
                        String direccionPostal = Consola.readLine();
                        System.out.println("Ahora el numero de telefono:");
                        String numeroTelefonico = Consola.readLine();
                        System.out.println("Ahora el nombre del contacto que va a ser modificado:");
                        String indice = Consola.readLine();
                        System.out.println(" ");
                        
                        Contacto contacto = new Contacto(nombre,apellido,alias,email,direccionPostal,numeroTelefonico);
                        modificacionContacto(agenda,contacto, indice);

                        break;
//------------------------------------------------------------------------------
                    case 4:
                        System.out.println("Ingrese el nombre del contacto a buscar: ");
                        String nom = Consola.readLine();
                        agenda.getByName(nom);
                        System.out.println(" ");
                        break;
//------------------------------------------------------------------------------                        
                    case 5:

                        System.out.println("Ingrese el nombre del contacto que desea borrar:");
                        String nombree = Consola.readLine();

                        agenda.eliminarContacto(nombree);
                        break;
//------------------------------------------------------------------------------                        
                    case 6:
                        agenda.eliminarLista();
                        break;
//------------------------------------------------------------------------------                        
                    case 7:
                        buscadorCsv.detener();
                          salirOp1 = true;
                        break;
//------------------------------------------------------------------------------                        
                    default:
                        System.err.println("Debe ingresar un digito del 1 al 6 ");
                }

            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es válido, debe ingresar un numero");
                System.out.println("Vuelva a intentar....");
            } catch (InvalidEmailException | InvalidTelephoneNumberException | InvalidNameException ex) {
                Logger.getLogger(J_ContactAdministrator.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } while (!salirOp1);

    }

    private static void modificacionContacto(AgendaDAO agenda, Contacto contacto, String indice) {

        String nombre = contacto.getNombre();
        String apellido = contacto.getApellido();
        String alias = contacto.getAlias();
        String email = contacto.getEmail();
        String direccionPostal = contacto.getDireccionPostal();
        String numeroTelefonico = contacto.getNumeroTelefonico();
        try {
            agenda.modificarContacto(nombre, apellido, alias, email, direccionPostal, numeroTelefonico, indice);
        } catch (InvalidEmailException | InvalidTelephoneNumberException | InvalidNameException ex) {
            Logger.getLogger(J_ContactAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void cargarContacto(AgendaDAO agenda) {
        
        try{
            System.out.println(" ");
            System.out.println("Ingrese el nombre de su nuevo contacto:");
            String nombre = Consola.readLine();
            System.out.println("Ahora el apellido:");
            String apellido = Consola.readLine();
            System.out.println("Ahora el apodo, en caso de tenerlo:");
            String alias = Consola.readLine();
            System.out.println("Ahora el mail");
            String email = Consola.readLine();
            System.out.println("Ahora su direccion postal:");
            String direccionPostal = Consola.readLine();
            System.out.println("Por ultimo el numero de telefono:");
            String numeroTelefonico = Consola.readLine();
            System.out.println(" ");
            
            Contacto c = new Contacto(nombre, apellido, alias, email, direccionPostal, numeroTelefonico);
            agenda.addContacto(c);
            
        } catch(InvalidEmailException | InvalidTelephoneNumberException | InvalidNameException e){
            System.err.println(e.getMessage());
        }
    }

}

