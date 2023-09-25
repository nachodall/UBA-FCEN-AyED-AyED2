package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha); //saco la referencia de la fecha
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha(this.fecha); //hago esto para devolver una copia de fecha y no su dir. de memoria pues fecha es modificable
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        String str = this.mensaje + " @ " + this.fecha.toString() + " " + this.horario.toString();
        return str;
    }

}
