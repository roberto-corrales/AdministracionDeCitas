public class Paciente extends Usuario {
    public Paciente( String nombre, String contrasena) {
        super(nombre, contrasena );
    }

    public Paciente(int id, String nombre, String contrasena, boolean esAdmin){
        super(nombre, contrasena);
        this.id = id;
        this.esAdmin = esAdmin;
    }
}
