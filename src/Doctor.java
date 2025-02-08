public class Doctor extends  Usuario {
    private String especialidad;

    public Doctor( String nombre, String contrasena, String especialidad) {
        super(nombre, contrasena );
        this.especialidad = especialidad;
    }

    public Doctor(int id, String nombre, String contrasena, boolean esAdmin, String especialidad) {
        super(nombre, contrasena );
        this.especialidad = especialidad;
        this.id = id;
        this.esAdmin = esAdmin;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
