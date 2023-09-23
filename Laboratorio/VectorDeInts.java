package aed;

class VectorDeInts implements SecuenciaDeInts {
    private static final int CAPACIDAD_INICIAL = 1;
    private int[] arreglo;
    private int longitudVector;

    public VectorDeInts() { //incializa
        arreglo = new int[CAPACIDAD_INICIAL];
        longitudVector = 0;
    }

    public VectorDeInts(VectorDeInts vector) { //copia y lo devuelve
        arreglo = new int[vector.longitudVector];
        longitudVector = vector.longitudVector;

        int j = 0;
        while(j < longitudVector){
            arreglo[j] = vector.arreglo[j];
            j++;
        }
    }

    public int longitud() {
        return longitudVector;
    }

    public void agregarAtras(int i) {
        if (longitudVector < arreglo.length){
            arreglo[longitudVector] = i;

        } else{
            int[] nue = new int[longitudVector+1];
            
            int j = 0;
            while(j < arreglo.length){  
                nue[j] = arreglo[j];
                j++;
            }

            nue[longitudVector] = i;
            arreglo = nue;
        }
        longitudVector++;
    }

    public int obtener(int i) {
        return arreglo[i];
    }

    public void quitarAtras() {
        longitudVector--;
    }

    public void modificarPosicion(int indice, int valor) {
        arreglo[indice] = valor;
    }

    public VectorDeInts copiar() {
        VectorDeInts nue = new VectorDeInts();
        nue.arreglo = new int[longitudVector];
        nue.longitudVector = longitudVector;

        int j = 0;
        while(j < longitudVector){
            nue.arreglo[j] = arreglo[j];
            j++;
        }

        return nue;
    }

}
