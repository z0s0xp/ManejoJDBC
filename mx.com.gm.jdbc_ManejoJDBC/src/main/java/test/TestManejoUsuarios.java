
package test;

import datos.Conexion;
import datos.IUsuarioDAO;
import datos.UsuarioDAO;
import domain.UsuarioDTO;
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
            IUsuarioDAO usu=new UsuarioDAO();
            UsuarioDTO nuevoUsuario=new UsuarioDTO();
            List<UsuarioDTO> usuarios= usu.seleccionar();
            
            for(UsuarioDTO usuario:usuarios){
                System.out.println("Usuarios DTO : = " + usuario);
            }

            
            
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
