public class   Usuario {

    private String nombre;
    private String contrasena;
    private boolean esAdmin;
    private boolean esDoctor;
    private String especialidad;

    public Usuario( String nombre, String contrasena, boolean esAdmin, boolean esDoctor, String especialidad) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
        this.esDoctor = esDoctor;
        this.especialidad = especialidad;
    }

//    constructor para dar de alta un paciente
    public Usuario(String nombre, String contrasena) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = false;
        this.esDoctor = false;
        this.especialidad = "ninguna";
    }

    //constructor para dar de alta un doctor
    public Usuario(String nombre, String contrasena, String especialidad) {
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.esDoctor = true;

    }


    public String getNombre() {
        return nombre;
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

    public void makeAdmin() {
        this.esAdmin = true;
    }

    public void removeAdmin() {
        this.esAdmin = false;
    }

    @Override
    public String toString() {
        return  "Usuario: " +
                (esDoctor ? "Doctor " + nombre + ", " + especialidad : " " + nombre ) +
                (esAdmin? " tiene privilegios de administrador" : "")
                ;
    }
}
