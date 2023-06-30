
package domain;

/**
 *
 * @author z0s0xp
 */
public class Usuario {
    private int id_usuario;
    private String usuario;
    private String password;
    
    public Usuario(){
    }
    
    public Usuario(int id_usuario){
        this.id_usuario=id_usuario;
    }
    
    public Usuario(String usuario, String password){
     
        this.usuario=usuario;
        this.password=password;
    
    }

    public Usuario(int id_usuario, String usuario, String password) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
    }
    


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}
