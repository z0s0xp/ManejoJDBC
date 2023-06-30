
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Usuario;
import java.sql.*;
import java.util.*;



/**
 *
 * @author z0s0xp
 */
public class UsuarioDAO {
    
    private static final String SQL_SELECT="SELECT id_usuario, usuario, password  from test.usuario";
    private static final String SQL_INSERT="INSERT INTO usuario (usuario, password) VALUES (?,?)";
    private static final String SQL_UPDATE="UPDATE usuario SET usuario=?, password=? WHERE id_usuario=?";
    private static final String SQL_DELETE="DELETE FROM usuario WHERE id_usuario=?";
    
    private Connection conexionT;
    
    public UsuarioDAO (){
    
    }
    
    
     public UsuarioDAO(Connection conexionT){
        this.conexionT=conexionT;
        }
     
     public List<Usuario> seleccionar() throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usu = null;
        List<Usuario> usuarios = new ArrayList<>();
        
       

        try {
            con = this.conexionT  !=null ? this.conexionT: Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
     

                usu = new Usuario(idUsuario, usuario, password);

                usuarios.add(usu);

            }
        }  finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if(conexionT==null){
                Conexion.close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return usuarios;
    }
     
     
     public int insertar(Usuario usuario) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            con = this.conexionT  !=null ? this.conexionT: Conexion.getConnection();
            stmt=con.prepareStatement(SQL_INSERT);
            
            stmt.setString(1,usuario.getUsuario());
            stmt.setString(2,usuario.getPassword());
  
            registros=stmt.executeUpdate();
            
        } finally{
    
            try {
                close(stmt);
                if(conexionT==null){
                close(con);
                }
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }


}
        return registros;

    } 
     
     
     public int actualiazar(Usuario usuario) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            con = this.conexionT  !=null ? this.conexionT: Conexion.getConnection();
            stmt=con.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1,usuario.getUsuario());
            stmt.setString(2,usuario.getPassword());
            stmt.setInt(3, usuario.getId_usuario());
            registros=stmt.executeUpdate();
            
        } finally{
    
            try {
                close(stmt);
                if(conexionT==null){
                close(con);
                }
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }


}
        return registros;

    } 
     
         public int eliminar(Usuario usuario) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            con = this.conexionT  !=null ? this.conexionT: Conexion.getConnection();
            stmt=con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());
            registros=stmt.executeUpdate();
            
        } finally{
    
            try {
                close(stmt);
                if(conexionT==null){
                close(con);
                }
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }


}
        return registros;

    } 
}
