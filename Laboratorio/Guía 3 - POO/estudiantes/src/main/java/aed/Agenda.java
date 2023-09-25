package aed;

import java.util.Vector;

public class Agenda {
    private Fecha fecha;
    private Recordatorio[] recordatorios = new Recordatorio[365];

    public Agenda(Fecha fechaActual) {
        this.fecha = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public void incrementarDia() {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public Fecha fechaActual() {
        Agenda nue = new Agenda(this.fecha);
        return nue.fecha;
    }

}
