public class Cita {
    private int id;
    private String fecha;
    private String hora;
    private String motivo;
    private String nombreDoctor;
    private String nombrePaciente;

    public Cita(String fecha, String hora, String motivo, String nombreDoctor, String nombrePaciente) {
        this.id = 1;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }
}
