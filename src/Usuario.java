public abstract class   Usuario {
    protected int id;
    protected String nombre;
    protected String contrasena;
    protected boolean esAdmin;

    public Usuario(String nombre, String contrasena) {
        this.id = 1;
        this.nombre = nombre;
        this.esAdmin = false;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String contrasena, boolean esAdmin) {

        this.id = 1;
        this.nombre = nombre;
        this.esAdmin = esAdmin;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean esAdmin() {
        return esAdmin;
    }
}
