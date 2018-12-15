/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_contactadministrator;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
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

        while (continuador) {
            importFileAndDelete();
            sleeper();
        }
    }

    private void importFileAndDelete() {
        //---------------------------IMPORTACION--------------------------------
        //Se crea una instancia de la clase encargada de la persistencia de datos
        AgendaDAOFactory factory = new AgendaDAOFactory();
        AgendaDAO agendaParaImportaciones = factory.createSQLServer_AgendaDAO();

        BufferedReader br = null;

        try {
            File ruta2 = new File("D:\\Franco\\JAVA\\PROYECTOS NETBEANS\\J_ContactAdministrator\\Contactos.csv");
            File rutaOriginalFichero;
            try (FileReader fr = new FileReader(ruta2)) {
                br = new BufferedReader(fr);
                boolean salidor = true;
                while (salidor) {
                    //Lectura de la linea entera
                    String line = br.readLine();

                    if (line != null) {

                        //division de la linea por coma mediante el metodo split
                        String[] campos = line.split(";");

                        String nombre = campos[0];
                        String apellido = campos[1];
                        String alias = campos[2];
                        String mail = campos[3];
                        String direccion = campos[4];
                        String numero = campos[5];

                        //Se instancia un Contacto con las variables reunidas del array campos
                        Contacto contactoImportado = new Contacto(nombre, apellido, alias, mail, direccion, numero);
                        //Se agrega el contacto al sistema de persistencia del programa
                        agendaParaImportaciones.addContacto(contactoImportado);

                    } else {
                        salidor = false;
                    }
                }
                rutaOriginalFichero = copyFile();
            }

            //----------------------BORRAR ARCHIVO ORIGINAL---------------------
            //Aqui generamos el delete para no volver a importar el mismo archivo
            Files.delete(rutaOriginalFichero.toPath());

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException | InvalidEmailException | InvalidTelephoneNumberException | InvalidNameException ex) {
            ex.getMessage();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    private File copyFile() throws IOException {
        File rutaOriginalFichero;
        //-------------------------COPIA DEL ARCHIVO----------------
        File rutaDestinoFichero;
        rutaOriginalFichero = new File("D:\\Franco\\JAVA\\PROYECTOS NETBEANS\\J_ContactAdministrator\\Contactos.csv");
        rutaDestinoFichero = new File("D:\\Franco\\JAVA\\PROYECTOS NETBEANS\\J_ContactAdministrator\\ContactosLeidos\\Contactos.csv");
        try (InputStream in = new FileInputStream(rutaOriginalFichero);
                OutputStream out = new FileOutputStream(rutaDestinoFichero)) {
            
            //Usamos un buffer para la copia
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        return rutaOriginalFichero;
    }
    /*
    ****************************************************************************
    */
    private void sleeper()  {

        try {
            //Hacemos descansar 1 segundo al hilo para no gastar recursos inecesarios a nuestra maquina
            BuscadorCSV.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BuscadorCSV.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
    }
    /*
    ***************************************************************************
    */
    public void detener(){
    continuador = false;
    }
}