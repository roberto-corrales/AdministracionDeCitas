public class AdministracionDeCitas {

    Doctor doctor = new Doctor("Roberto", "123", "oftalmologo");

    public void crearDoctor(){
        System.out.println("Crear un doctor");
    }

    public void crearPaciente() {
        System.out.println("Crear un paciente");
    }

    public void crearAdministrador(Usuario usuario){
        System.out.println("Dar privilegios de administrador");
    }

    public boolean esUsuarioValido (String usuario, String contrasena){
        System.out.println("Aqui validamos al usuario");
        return true;
    }

    public void mostrarEspecialidades() {
        System.out.println("Muestra las especialidades");
    }

    public void mostrarDoctores(String especialidad) {
        System.out.println("Muestra los doctores de la especialidad elegida");
    }

    public boolean hayDisponibilidad (Doctor doctor, String hora) {
        System.out.println("Validamos si hay disponibilidad con este doctor en esta hora");
        return true;
    }

    public void confirmarCita(){
        System.out.println("Confirmar cita");
    }

    public void crearCita(){

        mostrarEspecialidades();
        String especialidad = "oftalmologo";
        mostrarDoctores(especialidad);
        boolean disponible;
        do {
            String horario = "12:00 pm";
            disponible = hayDisponibilidad(doctor, horario);
        } while (!disponible);
        confirmarCita();
    }

    public static void main(String[] args) {
        AdministracionDeCitas programa = new AdministracionDeCitas();
        programa.crearCita();
    }


}
