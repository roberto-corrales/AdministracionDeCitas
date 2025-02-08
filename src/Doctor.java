public class Doctor extends  Usuario {
    private String especialidad;

    public Doctor( String nombre, String contrasena, String especialidad) {
        super(nombre, contrasena );
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
