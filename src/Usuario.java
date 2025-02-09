public class   Usuario {
    protected int id;
    protected String nombre;
    protected String contrasena;
    protected boolean esAdmin;
    protected boolean esDoctor;
    protected String especialidad;

    public Usuario(int id, String nombre, String contrasena, boolean esAdmin, boolean esDoctor, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
        this.esDoctor = esDoctor;
        this.especialidad = especialidad;
    }

    public Usuario(String nombre, String contrasena) {
        this.id = 1;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = false;
        this.esDoctor = false;
        this.especialidad = "ninguna";
    }

    public Usuario(String nombre, String contrasena, boolean esDoctor, String especialidad) {
        this.id = 1;
        this.nombre = nombre;
        this.esAdmin = false;
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

    public boolean esDoctor() {
        return esDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
