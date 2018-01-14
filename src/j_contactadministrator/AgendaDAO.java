/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

/**
 *
 * @author Franco Gallo
 */
public interface AgendaDAO {
    
    //METODO QUE AÑADE UN CONTACTO A LA AGENDA
    public void addContacto(Contacto c);
    
    //METODO QUE NOS PERMITE MODIFICAR UN CONTACTO YA AGREGADO
    public void modificarContacto(String nombre, String apellido, String alias, String email, String direccionpostal,
                                  String numerotelefonico, String indice) throws InvalidEmailException, InvalidTelephoneNumberException, InvalidNameException;
    
    //METODO QUE ELIMINA CONTACTOS DE LA AGENDA
    public void eliminarContacto(String c);
    
    //METODO QUE ELIMINA TODOS LOS DATOS ALMACENADOS
    public void eliminarLista();
    
    //METODO QUE ORDENARA NUESTRA AGENDA POR ORDEN ALFABETICO.
    public void ordenarAgenda();
    
    //METODO DE BUSQUEDA POR NOMBRE
    public void getByName(String nom);
    
    //METODO QUE NOS MUESTRA TODA LA LISTA DE CONTACTOS
    public void mostrar();
    
    //METODO QUE NOS PERMITE EXPORTAR LA AGENDA  EN FORMATO CSV
    public void exportarLista();
    
}