package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
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
         PersonaDAO personajdbc= new PersonaDAO(con);
         Persona cambioPersona=new Persona();
         
         cambioPersona.setIdPersona(2);
         cambioPersona.setNombre("KARLA 3");
         cambioPersona.setApellido("Lara");
         cambioPersona.setEmail("Klara@gmail.com");
         cambioPersona.setTelefono("5563132122");
         personajdbc.actualiazar(cambioPersona);
          
         
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
