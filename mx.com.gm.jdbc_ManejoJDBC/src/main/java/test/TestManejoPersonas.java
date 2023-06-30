package test;

import datos.Conexion;
import datos.IPersonaDAO;
import datos.PersonaDAO;
import domain.PersonaDTO;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author z0s0xp
 */
public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection con= null;
        try {

            
             con= Conexion.getConnection();
            if(con.getAutoCommit()){
                con.setAutoCommit(false);
            }
         IPersonaDAO personaDao= new PersonaDAO(con);
         PersonaDTO cambioPersona=new PersonaDTO();
         List<PersonaDTO> personas=personaDao.seleccionar();
     
          for(PersonaDTO persona:personas){
              System.out.println("Persona DTO"+ persona);
          }
         
         con.commit();
            System.out.println("Se a realizado el commit");
                  
                  
         
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                con.rollback();
            } catch (SQLException ex1) {

                 ex.printStackTrace(System.out);
            }
        }
}
    
}
