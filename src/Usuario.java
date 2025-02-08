public class Usuario {
    protected int id;
    protected String nombre;
    protected boolean esAdmin;
    protected String contrasena;

    public Usuario(String nombre, String contrasena) {
        this.id = 1;
        this.nombre = nombre;
        this.esAdmin = false;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esAdmin() {
        return esAdmin;
    }
}
