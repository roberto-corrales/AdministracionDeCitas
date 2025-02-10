import java.io.*;
import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
                if (data.length == 7) {
                    citas.add(new Cita(Integer.parseInt( data[0]),Integer.parseInt( data[1]), Integer.parseInt(data[2]), Integer.parseInt( data[3]), data[4], data[5], data[6]));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista de usuarios. ");
        }
    }

    public void saveUsuarios() {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileUsuarios))) {

            bw.write("Nombre,Contraseña,EsAdmin,EsDoctor,Especialidad");
            bw.newLine();
            bw.write("Admin,Admin,true,false,Ninguna");
            bw.newLine();
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
                        cita.getYear() + "," +
                        cita.getMes() + "," +
                        cita.getDia() + "," +
                        cita.getHora() + "," +
                        cita.getMotivo() + "," +
                        cita.getNombreDoctor() + "," +
                        cita.getNombrePaciente()
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
        System.out.println("Por favor, ingresa el nombre del usuario");
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

    public void agendarCita() throws IOException {

        HashMap<Integer, String> especialidades = new HashMap<>();
        HashMap<Integer, String> doctores = new HashMap<>();
        String paciente ="";
        String motivo;
        boolean pacienteEncontrado = false;
        int opcion = 1;

        System.out.println("------- Agendar una cita ------");
        do {
            System.out.println("Ingresa el nombre del paciente");
            String nombre = br.readLine();
            for (Usuario usuario : usuarios){
                if (usuario.getNombre().equals(nombre) && !usuario.esDoctor()){
                    paciente = nombre;
                    System.out.println(paciente + " existe en la base de datos");
                    pacienteEncontrado = true;
                    break;
                }
            } if (pacienteEncontrado) {
                break;
            } else {
                System.out.println("No encontre un paciente con el nombre " + nombre);
            }
        } while (true);

        System.out.println("¿Cuál es el motivo de la cita?");
        motivo = br.readLine();


        for (Usuario usuario : usuarios) {
            if (usuario.esDoctor()) {
                if (especialidades.containsValue(usuario.getEspecialidad())) {
                    continue;
                }
                especialidades.put(opcion, usuario.getEspecialidad());
                opcion++;
            }
        }
        System.out.println("Actualmente contamos con las siguientes especialidades");
        for (Map.Entry<Integer, String> entry : especialidades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
        System.out.println("Selecciona alguna de nuestras especialidades");
        Integer especialidadSeleccionada = Integer.parseInt(br.readLine().substring(0, 1));

        System.out.println("Las siguientes opciones estan disponibles en " + especialidades.get(especialidadSeleccionada) + ":");
        opcion = 1;
        for (Usuario usuario : usuarios) {
            if (usuario.getEspecialidad().equals(especialidades.get(especialidadSeleccionada))) {
                doctores.put(opcion, usuario.getNombre());
                System.out.println(opcion + ": " + usuario.getNombre());
                opcion++;
            }
        }

        System.out.println();
        System.out.println("Selecciona alguna de nuestras especialidades");
        Integer doctorSeleccionado = Integer.parseInt(br.readLine().substring(0, 1));

        System.out.println("Has seleccionado " + doctores.get(doctorSeleccionado));

        int year = 0;
        int mes = 0;
        int dia = 0;
        int hora = 0;

        System.out.println("Elige el año");
        do {
            try {
                year = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Datos invalidos, intenta de nuevo");
            }
            if (year >= Year.now().getValue() && year <= Year.now().getValue() + 1) {
                break;
            } else {
                System.out.println("Año invalido. Solo pueden crearse citas en este año o el proximo");
            }
        } while (true) ;
        System.out.println("Elige el mes");
        do {
            try {
                mes = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Datos invalidos, intenta de nuevo");
            }
            if (mes >= 1 && mes <= 12) {
                break;
            } else {
                System.out.println("Mes invalido. Selecciona un valor entre 1 y 12");
            }
        } while (true) ;

        System.out.println("Elige el dia");
        do {
            try {
                dia = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Datos invalidos, intenta de nuevo");
            }
            int maxDate = switch (mes) {
                case 4, 6, 9, 11 -> 20;
                case 2 -> 28;
                default -> 31;
            };

            if (dia >= 1 && dia <= maxDate) {
                break;
            } else {
                System.out.println("Por favor selecciona un dia entre 1 y " + maxDate);
            }
        } while (true) ;

        System.out.println("Elige la hora (entre 8 y 17 hrs)");
        do {
            try {
                hora = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Datos invalidos, intenta de nuevo");
            }
            if (hora >= 8 && hora <= 17) {
                break;
            } else {
                System.out.println("Hora invalida. Selecciona un valor entre las 8 y 17 horas");
            }
        } while (true) ;

        citas.add(new Cita(year, mes, dia, hora, motivo, doctores.get(doctorSeleccionado), paciente ));
        System.out.println("Has elegido una cita para " + paciente + " con " + doctores.get(doctorSeleccionado) + " en la fecha " + year + "/" + mes + "/" + dia + " a las " + hora + ":00 hrs");
        saveCitas();


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdministracionDeCitas programa = new AdministracionDeCitas();

        programa.loadUsuarios();
        programa.loadCitas();
        programa.printUsuarios();

        Usuario usuario = programa.iniciarSesion();

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
                case "1" -> programa.agendarCita();
                case "2" -> programa.altaDoctor();
                case "3" -> programa.altaPaciente();
                case "4" -> programa.hacerAdministrador();
                case "5" -> programa.removerAdministrador();
                case "9" -> {
                    System.out.println("Saliendo del programa, hasta pronto");
                    return;
                }
                default -> System.out.println("La opcion seleccionada no es válida");
                }

            }
        while (true);
        }

    }



