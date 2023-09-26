package aed;

import java.util.Vector;

public class Agenda {
    private Fecha fecha;
    private Vector<Recordatorio> recordatorios = new Vector<Recordatorio>(1);
    private String texto;

    public Agenda(Fecha fechaActual) {
        this.fecha = fechaActual;
        this.texto = this.fecha.toString() + "\n=====" +"\n";
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.add(recordatorio);   
    }

    @Override
    public String toString() {
        StringBuffer nue = new StringBuffer();
        nue.append(texto);
        int i = 0;
        while(i<recordatorios.size()){
            if(recordatorios.elementAt(i).fecha().dia() == fecha.dia() && recordatorios.elementAt(i).fecha().mes() == fecha.mes()){
                nue.append(recordatorios.elementAt(i).toString());
                nue.append("\n");
            }
            i++;
        }
        return nue.toString();
    }

    public void incrementarDia() {
        fecha.incrementarDia();
        texto = fecha.toString() + "\n=====" +"\n";
    }

    public Fecha fechaActual() {
        Agenda nue = new Agenda(this.fecha);
        return nue.fecha;
    }

}
