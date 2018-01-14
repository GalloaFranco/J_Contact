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
public class JavaDB_AgendaDAOFactory {
    
    public AgendaDAO createJavaDB_AgendaDAO(){
        return new JavaDB_AgendaDAO();
    }
}