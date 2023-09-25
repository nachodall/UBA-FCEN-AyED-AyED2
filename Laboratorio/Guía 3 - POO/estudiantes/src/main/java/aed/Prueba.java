package aed;

public class Prueba {
    public static void main(String[] args) {
        int dia = 10;
        int mes = 11;
            if (dia == 31){
                dia = 1;
                if (mes == 12){
                    mes = 1;
                } else{
                    mes ++;
                }
            } else if (dia == 28){ //febrero
                dia = 1;
                mes = 3;
            } else if (dia == 30){
                dia = 1;
                mes = mes + 1;
            } else{
                dia = dia +1;
            }

        System.out.println(dia);
        System.out.println(mes);

     }

    
}
