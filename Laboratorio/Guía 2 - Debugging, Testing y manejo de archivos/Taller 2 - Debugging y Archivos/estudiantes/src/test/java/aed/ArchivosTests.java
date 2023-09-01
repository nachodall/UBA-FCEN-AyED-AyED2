package aed;

import java.util.Locale;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ArchivosTests {
    Archivos archivos = new Archivos();

    @Test
    void testLeerVectorVacio() throws FileNotFoundException {
        Scanner entrada = new Scanner("");

        float[] vec = archivos.leerVector(entrada, 0);
        assertEquals(0, vec.length);
    }

    @Test
    void testLeerVectorNoVacio() throws FileNotFoundException {
        Scanner entrada = new Scanner(new File("vec5.txt"));
        entrada.useLocale(Locale.ENGLISH);

        float[] vec = archivos.leerVector(entrada, 5);
        assertEquals(5, vec.length);
        assertEquals(0.5, vec[0], 10e-5);
        assertEquals(3.14, vec[1], 10e-5);
        assertEquals(2.71, vec[2], 10e-5);
        assertEquals(3.33, vec[3], 10e-5);
        assertEquals(-9.8, vec[4], 10e-5);
    }

    @Test
    void testLeerMatrizVacia() throws FileNotFoundException {
        Scanner entrada = new Scanner("");

        float[][] vec = archivos.leerMatriz(entrada, 0, 0);
        assertEquals(0, vec.length);
    }

    @Test
    void testLeerMatrizNoVacia() throws FileNotFoundException {
        Scanner entrada = new Scanner(new File("mat3x2.txt"));
        entrada.useLocale(Locale.ENGLISH);

        float[][] vec = archivos.leerMatriz(entrada, 3, 2);
        assertEquals(3, vec.length);
        assertEquals(2, vec[0].length);
        assertEquals(0.45, vec[0][0], 10e-5);
        assertEquals(-9.8, vec[0][1], 10e-5);
        assertEquals(3.33, vec[1][0], 10e-5);
        assertEquals(2.71, vec[1][1], 10e-5);
        assertEquals(4.01, vec[2][0], 10e-5);
        assertEquals(3.14, vec[2][1], 10e-5);
    }

    @Test
    void testImprimirPiramideVacia() throws FileNotFoundException {
        PrintStream salida = new PrintStream("piramideVacia.txt");
        Scanner entrada = new Scanner(new File("piramideVacia.txt"));

        archivos.imprimirPiramide(salida, 0);

        assertFalse(entrada.hasNextLine());
    }

    @Test
    void testImprimirPiramideNoVacia() throws FileNotFoundException {
        PrintStream salida = new PrintStream("piramide5.txt");
        Scanner entrada = new Scanner(new File("piramide5.txt"));

        archivos.imprimirPiramide(salida, 5);

        assertTrue(entrada.hasNextLine());
        assertEquals("    *    ", entrada.nextLine());

        assertTrue(entrada.hasNextLine());
        assertEquals("   ***   ", entrada.nextLine());

        assertTrue(entrada.hasNextLine());
        assertEquals("  *****  ", entrada.nextLine());

        assertTrue(entrada.hasNextLine());
        assertEquals(" ******* ", entrada.nextLine());

        assertTrue(entrada.hasNextLine());
        assertEquals("*********", entrada.nextLine());
    }
}
