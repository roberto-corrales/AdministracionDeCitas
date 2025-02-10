import java.time.LocalDateTime;

public class Cita {
    private LocalDateTime fechaHora;
    private String motivo;
    private String nombreDoctor;
    private String nombrePaciente;

    public Cita(LocalDateTime fechaHora, String motivo, String nombreDoctor, String nombrePaciente) {
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
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
