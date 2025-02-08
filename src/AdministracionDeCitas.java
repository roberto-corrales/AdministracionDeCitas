import java.io.*;
import java.util.HashSet;

public class AdministracionDeCitas {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final String fileUsuarios = "usuarios.txt";
    private final String fileCitas = "citas.txt";
    private final HashSet<Usuario> usuarios = new HashSet<>();
    private final HashSet<Cita> citas = new HashSet<>();

    Doctor doctor1 = new Doctor("Roberto", "123", "oftalmologo");
    Paciente paciente1 = new Paciente("Gabriel", "123");


    public void loadUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileUsuarios))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    if (data[0].trim().equals("Doctor")) {
                        usuarios.add(new Doctor(Integer.parseInt(data[1]), data[2], data[3], Boolean.parseBoolean(data[4]) , data[5]));

                    } else {
                        usuarios.add(new Paciente(Integer.parseInt(data[1]), data[2], data[3], Boolean.parseBoolean(data[4])));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista de usuarios. ");
        }
    }

    public void loadCitas() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileCitas))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    citas.add(new Cita("12/10/2025", "12:00", "motivo", doctor1.getId(), paciente1.getId()));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista de usuarios. ");
        }
    }

    public void saveUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileUsuarios))) {
            for (Usuario usuario : usuarios) {
                String tipoDeUsuario = "Paciente";
                String especialidad ;
                if (usuario instanceof Doctor) {
                    Doctor doctor = (Doctor) usuario;
                    especialidad = doctor.getEspecialidad();
                    tipoDeUsuario = "Doctor";
                } else {
                    especialidad = "ninguna";
                }

                bw.write(
                        tipoDeUsuario + "," +
                                usuario.getId() + "," +
                                usuario.getNombre() + "," +
                                usuario.getContrasena() + "," +
                                usuario.esAdmin() + "," +
                                especialidad
                );
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información.");
        }
    }

    public void saveCitas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileCitas))) {
            for (Cita cita : citas) {
                bw.write(
                        cita.getId() + "," +
                                cita.getDoctorID() + "," +
                                cita.getPacienteID() + "," +
                                cita.getFecha() + "," +
                                cita.getHora() + "," +
                                cita.getMotivo()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información.");
        }
    }

    public void iniciarSesion() throws IOException {

        String nombre;
        String contrasena;

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
        System.out.println("");

    }

    public void printUsuarios(){
        System.out.println(usuarios);
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
        for (Usuario user : usuarios){
            String nombre = user.getNombre();
            String pw = user.getContrasena();
            if (nombre.equals(usuario) && pw.equals(contrasena)  ){
                return  true;
            }
        }
        System.out.println("Tus credenciales no son validas, intenta de nuevo");
        return false;
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
            disponible = hayDisponibilidad(doctor1, horario);
        } while (!disponible);
        confirmarCita();
    }

    public static void main(String[] args) throws IOException {

        AdministracionDeCitas programa = new AdministracionDeCitas();
        programa.loadUsuarios();
        programa.printUsuarios();

        programa.iniciarSesion();


        programa.crearCita();
    }


}
