public class Cita {
    private int id;
    private String fecha;
    private String hora;
    private String motivo;
    private int doctorID;
    private int pacienteID;

    public Cita(String fecha, String hora, String motivo, int doctorID, int pacienteID) {
        this.id = 1;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.doctorID = doctorID;
        this.pacienteID  = pacienteID;
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

    public int getDoctorID() {
        return doctorID;
    }

    public int getPacienteID() {
        return pacienteID;
    }
}
