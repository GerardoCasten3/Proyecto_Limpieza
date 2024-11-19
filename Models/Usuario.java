package Models;

public class Usuario implements Observer {

    private int id_usuario;
    private String username;
    private String password;
    private Rol rol;

    public Usuario(int id_usuario, String username, String password, Rol rol) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario(int id_usuario, String username, Rol rol) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.rol = rol;
    }
    
    public Usuario(String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public void actualizar(String mensaje) {
        if (this.rol == Rol.ADMINISTRADOR) { 
            System.out.println("Notificación para el administrador " + username + ": " + mensaje);
        }
    }
    
    
    @Override
    public String toString() {
        return "Usuario{"
                + "id='" + id_usuario + '\''
                + "username='" + username + '\''
                + ", rol=" + rol
                + '}';
    }
}
