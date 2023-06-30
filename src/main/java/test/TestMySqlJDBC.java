
package test;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author z0s0xp
 */
public class TestMySqlJDBC {
    public static void main(String[] args) {
        
      var url="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        //var url="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =  DriverManager.getConnection(url,"root", "admin");
            Statement instruccion= con.createStatement();
            var sql="SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado=instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id persona"+resultado.getInt("id_persona"));
                System.out.print(" Nombre: "+ resultado.getString("nombre"));
                System.out.print(" Apellido: "+resultado.getString("apellido"));
                System.out.print(" Emial: "+ resultado.getString("email"));
                System.out.print(" Telefono: "+resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            con.close();
        }  catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
