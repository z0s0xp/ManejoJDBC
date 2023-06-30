
package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author z0s0xp
 */
public class TestManejoUsuarios {
    public static void main(String[] args) {
        Connection con=null;
   
       
        try {
            con= Conexion.getConnection();
            if(con.getAutoCommit()){
            con.setAutoCommit(false);
            }
            UsuarioDAO usu=new UsuarioDAO();
            Usuario nuevoUsuario=new Usuario();
            
            nuevoUsuario.setUsuario("Javier");
            nuevoUsuario.setPassword("Javier123");
            usu.insertar(nuevoUsuario);
            con.commit();
            System.out.println("Se realizo el commit");
            
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
            System.out.println("Se entro a rollback");
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
               
            }
        }
        
        
    }
}
