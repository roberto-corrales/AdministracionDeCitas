public class Cita {
    private int year;
    private int mes;
    private int dia;
    private int hora;
    private String motivo;
    private String nombreDoctor;
    private String nombrePaciente;

    public Cita(int year, int mes, int dia, int hora, String motivo, String nombreDoctor, String nombrePaciente) {
        this.year = year;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.motivo = motivo;
        this.nombreDoctor = nombreDoctor;
        this.nombrePaciente = nombrePaciente;
    }

    public int getYear() {
        return year;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
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
