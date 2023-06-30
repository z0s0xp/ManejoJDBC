
package datos;

import domain.PersonaDTO;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author z0s0xp
 */
public interface IPersonaDAO {
    public List<PersonaDTO> seleccionar()throws SQLException;
    public int insertar(PersonaDTO persona) throws SQLException;
    public int actualiazar(PersonaDTO persona)throws SQLException;
    public int eliminar(PersonaDTO persona)throws SQLException;
}
