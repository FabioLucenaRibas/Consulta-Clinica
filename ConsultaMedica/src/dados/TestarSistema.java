/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TestarSistema {
    public static void main(String[] a){
        try {
            new Dados().conectar();
            System.out.print("CONECTOU-SE\n");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestarSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestarSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
