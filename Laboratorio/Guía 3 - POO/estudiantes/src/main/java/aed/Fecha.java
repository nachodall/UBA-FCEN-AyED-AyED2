package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) { //me deshago de las dir. de memoria de la fecha q entra x parametro
        int nuevoDia = fecha.dia;
        int nuevoMes = fecha.mes;
        this.dia = nuevoDia;
        this.mes = nuevoMes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    @Override
    public String toString() {
        String strDia = dia+"";
        String strMes = mes+"";
        return strDia+"/"+strMes;
    }

    @Override
    public boolean equals(Object otra) {
        if (otra == null || otra.getClass() != this.getClass()){
            return false;
        }

        Fecha otraFecha = (Fecha) otra;
        return this.dia == otraFecha.dia && this.mes == otraFecha.mes;
    }

    public void incrementarDia() {
        if (this.dia == 31){
            this.dia = 1;
            if (this.mes == 12){
                this.mes = 1;
            } else{
                this.mes ++;
            }
        } else if (this.dia == 30){
            this.dia = 1;
            this.mes = mes + 1;
        } else if (this.dia == 28 && this.mes == 2){ //febrero
            this.dia = 1;
            this.mes = 3;
        } else{
            this.dia = dia +1;
        }
    }
        
    

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
