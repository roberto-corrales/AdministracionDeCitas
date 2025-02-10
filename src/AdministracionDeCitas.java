import java.io.*;
import java.util.HashSet;

public class AdministracionDeCitas {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final String fileUsuarios = "usuarios.txt";
    private final String fileCitas = "citas.txt";
    private final HashSet<Usuario> usuarios = new HashSet<>();
    private final HashSet<Cita> citas = new HashSet<>();

    public void loadUsuarios() {

        try (BufferedReader br = new BufferedReader(new FileReader(fileUsuarios))) {
            String line;
            int counter = 1;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    if (counter == 1) {
                        counter++;
                        continue;
                    }
                    usuarios.add(new Usuario(data[0], data[1], Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]), data[4]));
                    counter++;

                }

            }
            System.out.println("Base de datos de " + usuarios.size() + " usuarios cargados correctemente.");
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
                    //citas.add(new Cita("12/10/2025", "12:00", "motivo", "Roberto", "Gabriel"));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista de usuarios. ");
        }
    }

    public void saveUsuarios() {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileUsuarios))) {
            bw.write("Nombre,Contraseña,EsAdmin,EsDoctor,Especialidad");
            for (Usuario usuario : usuarios) {

                bw.write(

                                usuario.getNombre() + "," +
                                usuario.getContrasena() + "," +
                                usuario.esAdmin() + "," +
                                usuario.esDoctor() + "," +
                                usuario.getEspecialidad()

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
                                cita.getNombreDoctor() + "," +
                                cita.getNombrePaciente() + "," +
                                cita.getFechaHora() + "," +
                                cita.getMotivo()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información.");
        }
    }

    public Usuario iniciarSesion() throws IOException {

        String nombreIngresado;
        String contrasenaIngresada;

        do {
            System.out.println("Ingresa tu nombre");
            nombreIngresado = br.readLine();
            System.out.println("Ingresa tu contraseña");
            contrasenaIngresada = br.readLine();

            for (Usuario usuario : usuarios){
                String nombre = usuario.getNombre();
                String contrasena = usuario.getContrasena();
                if (nombre.equals(nombreIngresado) && contrasena.equals(contrasenaIngresada)  ){
                    System.out.println("¡Bienvenido " + nombreIngresado + "!");
                    System.out.println();
                    return  usuario;

                }
            }
            System.out.println("Tus credenciales no son validas, intenta de nuevo");


        } while (true );


    }

    public void printUsuarios(){
        System.out.println(usuarios);
    }

    public Usuario buscarUsuario() throws IOException {
        System.out.println("Por favor, ingresa el nombre del doctor");
        String nombre = br.readLine();
        for(Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)){
                return usuario;
            }
        }
        return null;
    }

    public void altaDoctor() throws IOException {
        System.out.println("----------Dar de alta un doctor ------------");
        System.out.println("Por favor, ingresa el nombre del doctor");
        String nombre = br.readLine();
        System.out.println("A continuación, ingresa la contraseña");
        String contrasena = br.readLine();
        System.out.println("Para finalizar, ingresa la especialidad del doctor");
        String especialidad = br.readLine();

        usuarios.add(new Usuario(nombre, contrasena, especialidad));
        saveUsuarios();

        System.out.println("Se ha agredado exitosamente a " + nombre + " a la base de datos.");
        System.out.println();

    }

    public void altaPaciente() throws IOException {
        System.out.println("----------Dar de alta un paciente ------------");
        System.out.println("Por favor, ingresa el nombre del paciente");
        String nombre = br.readLine();
        System.out.println("A continuación, ingresa la contraseña");
        String contrasena = br.readLine();

        usuarios.add(new Usuario(nombre, contrasena));
        saveUsuarios();

        System.out.println("Se ha agredado exitosamente a " + nombre + "a la base de datos.");
        System.out.println();
    }

    public void hacerAdministrador() throws IOException {
        System.out.println("------ Dar privilegios de administrador -----");
        Usuario usuario = buscarUsuario();
        if (usuario.esAdmin()){
            System.out.println(usuario.getNombre() + " actualmente es administrador.");
        } else {
            usuario.makeAdmin();
            System.out.println("¡Listo! " + usuario.getNombre() + " ahora tiene privilegios de administrador" );
        }
        saveUsuarios();
    }

    public void removerAdministrador()throws IOException {
        System.out.println("------ Quitar privilegios de administrador -----");
        Usuario usuario = buscarUsuario();
        if (!usuario.esAdmin()){
            System.out.println(usuario.getNombre() + " actualmente no es administrador.");
        } else {
            usuario.removeAdmin();
            System.out.println("¡Listo! Se removieron los privilegios de administrador de " + usuario.getNombre() );
        }
        saveUsuarios();
    }

    public void mostrarEspecialidades() {
        System.out.println("Muestra las especialidades");
    }

    public void mostrarDoctores(String especialidad) {
        System.out.println("Muestra los doctores de la especialidad elegida");
    }

    public boolean hayDisponibilidad (Usuario doctor, String hora) {
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

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdministracionDeCitas programa = new AdministracionDeCitas();

        programa.loadUsuarios();

        programa.printUsuarios();

        Usuario usuario = programa.iniciarSesion();
        boolean esOpcionValida;

        do {
            System.out.println("------------ Menú principal -------------");
            System.out.println("Selecciona una opción del siguiente menú:");
            System.out.println("1. Agendar una cita");
            if (usuario.esAdmin()){
                System.out.println("2. Agregar doctor a la base de datos");
                System.out.println("3. Agregar paciente a la base de datos");
                System.out.println("4. Dar privilegios de administrador");
                System.out.println("5. Remover privilegios de administrador");
                System.out.println("9. Salir del programa");
                }

            String opcionSeleccionada = br.readLine().substring(0,1).toUpperCase();

            switch (opcionSeleccionada) {
                case "1" -> programa.crearCita();
                case "2" -> programa.altaDoctor();
                case "3" -> programa.altaPaciente();
                case "4" -> programa.hacerAdministrador();
                case "5" -> programa.removerAdministrador();
                case "9" -> System.out.println("Salir del programa");
                default -> System.out.println("La opcion seleccionada no es válida");
                }

            }
        while (true);
        }



        //programa.crearCita();
    }



