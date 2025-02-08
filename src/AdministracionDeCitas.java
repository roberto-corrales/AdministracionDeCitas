public class AdministracionDeCitas {

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
        Doctor doctor = new Doctor();
        boolean disponible;
        do {
            String horario = "12:00 pm";
            disponible = hayDisponibilidad(doctor, horario);
        } while (disponible == false);
        confirmarCita();
    }

    public static void main(String[] args) {
        AdministracionDeCitas programa = new AdministracionDeCitas();
        programa.crearCita();
    }


}
