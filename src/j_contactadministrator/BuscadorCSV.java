/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.io.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Franco Gallo
 */
public class BuscadorCSV extends Thread{
    
    boolean continuador = true;
    
    @Override
    public void run() {
    
    while(continuador){
    
        //----------------------------------------------------------------------
        //---------------------DETECTOR DE ARCHIVOS-----------------------------
//        try{
//            System.out.println("Se estan buscando archivos de extension .csv ...");
            
        File ruta = new File("D:\\Franco\\JAVA\\Proyectos\\J_ContactAdministrator");
        String[] archivos = ruta.list();
        
        int contador = 0;//variable auxiliar   
        for(String directorio : archivos){
//            BuscadorCSV.sleep(500);
            if(directorio.contains(".csv")){
                contador++;
//                System.out.println(directorio);
            }
        }
//        }catch(InterruptedException e){
//            e.getMessage();
//        }
        
//        System.out.println("Cantidad de archivos .csv encontrados :" + contador);
//        System.out.println("-------------------------------------------------");
       
        //----------------------------------------------------------------------
        //---------------------------IMPORTACION--------------------------------
        
        //Se crea una instancia de la clase encargada de la persistencia de datos
        JavaDB_AgendaDAOFactory factory = new JavaDB_AgendaDAOFactory();
        AgendaDAO agendaParaImportaciones = factory.createJavaDB_AgendaDAO();
        
        BufferedReader br = null;

        try{
          File ruta2 = new File("D:\\Franco\\JAVA\\Proyectos\\J_ContactAdministrator\\Contactos.csv");  
          FileReader fr = new FileReader(ruta2);
          br = new BufferedReader(fr);
          
          boolean salidor = true;
//          System.out.println("Nos conectaremos a la base de datos para insertar la nueva informacion..");
          while(salidor){
              //Lectura de la linea entera
              String line = br.readLine();
              
              if(line != null){
              //division de la linea por coma mediante el metodo split
              String[] campos = line.split(";");
              
//              System.out.println("Datos encontrados en el archivo: ");
//              System.out.println(Arrays.toString(campos));
              
              String nombre = campos[0];
              String apellido = campos[1];
              String alias = campos[2];
              String mail = campos[3];
              String direccion = campos[4];
              String numero = campos[5];
              
              //Se instancia un Contacto con las variables reunidas del array campos 
              Contacto contactoImportado = new Contacto(nombre, apellido, alias, mail, direccion, numero);
              //Se agrega el contacto al sistema de persistencia del programa
//                  System.out.println("Nos conectaremos a la base de datos para insertar la nueva informacion..");
              agendaParaImportaciones.addContacto(contactoImportado);
            
                } else {
//                  System.out.println("Se instertaron los datos a la DB ");
                salidor = false;
                }
          }
            //------------------------------------------------------------------  
              //Nos preparamos para realizar la copia del archivo ya almacenado
              File rutaOriginalFichero;
              File rutaDestinoFichero;
              rutaOriginalFichero= new File("D:\\Franco\\JAVA\\Proyectos\\J_ContactAdministrator\\Contactos.csv");
              rutaDestinoFichero = new File("D:\\Franco\\JAVA\\Proyectos\\J_ContactAdministrator\\ContactosLeidos\\Contactos.csv");
              
              InputStream in = new FileInputStream(rutaOriginalFichero);
              OutputStream out = new FileOutputStream(rutaDestinoFichero);
              //Usamos un buffer para la copia
              byte[] buf = new byte[1024];
              int len;
              while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
              }
              in.close();
              out.close();
              
              fr.close();//cerramos el FileReader para poder borrar el archivo
            //------------------------------------------------------------------    
              //Aqui generamos el delete para no volver a importar el mismo archivo
              boolean borrarOriginal = rutaOriginalFichero.delete();
              if(borrarOriginal){
//                      System.out.println("Se borro el archivo original de manera satisfactoria");
//                      System.out.println("");
              }else
                      System.err.println("-----*No se pudo borrar el archivo*-----");
        
        }catch(FileNotFoundException e){
            e.getMessage();
        }catch (IOException | InvalidEmailException | InvalidTelephoneNumberException | InvalidNameException ex) {
            ex.getMessage();
        }finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
        //----------------------------------------------------------------------
        try {
            //Hacemos descansar 1 segundo al hilo para no gastar recursos inecesarios a nuestra maquina
            BuscadorCSV.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BuscadorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    /*
    ****************************************************************************
    */
    public void detener(){
    continuador = false;
    }
}