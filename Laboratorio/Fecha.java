package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes();
    }

    @Override
    public String toString() {
        String strDia = dia+"";
        String strMes = mes+"";
        return strDia+"/"+strMes;
    }

    @Override
    public boolean equals(Object otra) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void incrementarDia() {
        if (this.dia == 31){
            this.dia = 1;
            if (this.mes == 12){
                this.mes = 1;
            } else{
                this.mes ++;
            }
        } else if (this.dia == 28){ //febrero
            this.dia = 1;
            this.mes = 3;
        } else if (this.dia == 30){
            this.dia = 1;
            this.mes = mes + 1;
        } else{
            this.dia = dia +1;
            this.mes = mes +1;
        }
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
