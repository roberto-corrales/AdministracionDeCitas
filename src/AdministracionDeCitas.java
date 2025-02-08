import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdministracionDeCitas {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Doctor doctor = new Doctor("Roberto", "123", "oftalmologo");

    public void iniciarSesion() throws IOException {
        String nombre = "";
        String contrasena = "";

        boolean esAdmin;
        boolean esUsuarioValido;
        do {
            System.out.println("Ingresa tu nombre");
            nombre = br.readLine();
            System.out.println("Ingresa tu contraseña");
            contrasena = br.readLine();
            esUsuarioValido = esUsuarioValido(nombre, contrasena);
            if (!esUsuarioValido) {
                System.out.println("Tus credenciales no son válidas, intenta de nuevo.");
            }

        } while (!esUsuarioValido);
        System.out.println("¡Bienvenido " + nombre + "!");
    }



    public void altaDoctor(){
        System.out.println("Crear un doctor");
    }

    public void altaPaciente() {
        System.out.println("Crear un paciente");
    }

    public void hacerAdministrador(Usuario usuario){
        System.out.println("Dar privilegios de administrador");
    }

    public void removerAdministrador(Usuario usuario){
        System.out.println("Eliminar privilegios de administrador");
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
        System.out.println("Iniciando flujo de Creacion de cita");
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

    public static void main(String[] args) throws IOException {

        AdministracionDeCitas programa = new AdministracionDeCitas();

        programa.iniciarSesion();


        programa.crearCita();
    }


}
