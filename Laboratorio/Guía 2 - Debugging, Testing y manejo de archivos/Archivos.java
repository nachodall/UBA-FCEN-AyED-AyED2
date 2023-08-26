package aed;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintStream;

class Archivos {
    float[] leerVector(Scanner entrada, int largo) {
        float[] a = new float[largo];

        for (int i=0; i<a.length; i++){
            a[i] = entrada.nextFloat();
        }

        return a;
    }

    float[][] leerMatriz(Scanner entrda, int filas, int columnas) {
        float[][] m = new float[filas][columnas];
        for (int i=0; i<filas; i++){
            for (int j=0; j<columnas; j++){
                m[i][j] = entrda.nextFloat();
            }
        }
        return m;
    }

    void imprimirPiramide(PrintStream salida, int alto) {
        int espacios = alto-1;
        int piso = (2*alto)-1;
        
        while(espacios >= 0){
            for(int i=0; i<espacios; i++){ //primeros espacios
                salida.print(" ");
            }

            int cantAsteriscos = piso - 2*espacios; //asteriscos
            for(int i=0; i<cantAsteriscos; i++){
                salida.print("*");
            }

            for(int i=0; i<espacios; i++){ //segundos espacios
                salida.print(" ");
            }

            salida.println();
            espacios--;
        }
        salida.close();
    }
}

