package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author z0s0xp
 */
public class PersonaDAO {
    
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERT="INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?) ";
    private static final String SQL_UPDATE="UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=? ";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    public PersonaDAO() {
    }
    
    
    
    public PersonaDAO(Connection conexionTransaccional){
    this.conexionTransaccional=conexionTransaccional;
    }
    
    
    public List<Persona> seleccionar() throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            con = this.conexionTransaccional != null? this.conexionTransaccional: Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);

            }
        }finally {
 
            try {
                
                Conexion.close(rs);
                Conexion.close(stmt);
                if(this.conexionTransaccional==null){
                
                Conexion.close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            con = this.conexionTransaccional != null? this.conexionTransaccional: Conexion.getConnection();
            stmt=con.prepareStatement(SQL_INSERT);
            
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            registros=stmt.executeUpdate();
            
        }finally{
    
            try {
                close(stmt);
                if(this.conexionTransaccional==null){
                
                Conexion.close(con);
                }            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }


}
        return registros;

    } 
    
     
    public int actualiazar(Persona persona) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
       try{
            con = this.conexionTransaccional != null? this.conexionTransaccional: Conexion.getConnection();
            stmt=con.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros=stmt.executeUpdate();
            
       
    }finally{
    
            try {
                close(stmt);
                if(this.conexionTransaccional==null){
                
                Conexion.close(con);
                }
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }


}
        return registros;

    } 
    
    public int eliminar(Persona persona) throws SQLException {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registros = 0;
        try {
            con = this.conexionTransaccional != null? this.conexionTransaccional: Conexion.getConnection();
            stmt=con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros=stmt.executeUpdate();
            
        } finally{
    
            try {
                close(stmt);
                if(this.conexionTransaccional==null){
                
                Conexion.close(con);
                }
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }


}
        return registros;

    } 
}
