
package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author z0s0xp
 */
public interface IUsuarioDAO {
    
    public List<UsuarioDTO> seleccionar()throws SQLException; 
    
    public int insertar(UsuarioDTO usuario)throws SQLException;
    
    public int eliminar(UsuarioDTO usuario)throws SQLException;
    
    public int actualiazar(UsuarioDTO usuario)throws SQLException;
    
    
}
