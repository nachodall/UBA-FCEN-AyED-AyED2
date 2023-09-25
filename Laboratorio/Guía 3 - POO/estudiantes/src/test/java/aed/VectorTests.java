package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VectorTests {

    @Test
    void nuevoVectorEstaVacio() {
        VectorDeInts vector = new VectorDeInts();

        assertEquals(0, vector.longitud());
    }

    @Test
    void agregarPocosElementos() {
        VectorDeInts vector = new VectorDeInts();

        vector.agregarAtras(0);
        vector.agregarAtras(5);
        vector.agregarAtras(98);
        vector.agregarAtras(36);
        vector.agregarAtras(90);

        assertEquals(5, vector.longitud());

        assertEquals(0, vector.obtener(0));
        assertEquals(5, vector.obtener(1));
        assertEquals(98, vector.obtener(2));
        assertEquals(36, vector.obtener(3));
        assertEquals(90, vector.obtener(4));

    }

    @Test
    void quitarElementos() {
        VectorDeInts vector = new VectorDeInts();

        vector.agregarAtras(0);
        vector.agregarAtras(5);
        vector.agregarAtras(98);
        vector.agregarAtras(36);
        vector.agregarAtras(90);

        vector.quitarAtras();

        assertEquals(4, vector.longitud());
        assertEquals(0, vector.obtener(0));
        assertEquals(5, vector.obtener(1));
        assertEquals(98, vector.obtener(2));
        assertEquals(36, vector.obtener(3));

        vector.quitarAtras();
        vector.quitarAtras();
        vector.quitarAtras();
        vector.quitarAtras();

        assertEquals(0, vector.longitud());

        vector.agregarAtras(36);

        assertEquals(1, vector.longitud());
        assertEquals(36, vector.obtener(0));

    }

    @Test
    void modificarPosición() {
        VectorDeInts vector = new VectorDeInts();

        vector.agregarAtras(0);
        vector.agregarAtras(5);
        vector.agregarAtras(98);
        vector.agregarAtras(36);
        vector.agregarAtras(90);

        vector.modificarPosicion(2, 105);

        assertEquals(5, vector.longitud());
        assertEquals(0, vector.obtener(0));
        assertEquals(5, vector.obtener(1));
        assertEquals(105, vector.obtener(2));
        assertEquals(36, vector.obtener(3));

    }

    @Test
    void copiarVector() {
        VectorDeInts vector = new VectorDeInts();

        vector.agregarAtras(0);
        vector.agregarAtras(5);
        vector.agregarAtras(98);
        vector.agregarAtras(36);
        vector.agregarAtras(90);

        VectorDeInts copiaDeVector = vector.copiar();

        vector.modificarPosicion(2, 105);

        assertEquals(5, copiaDeVector.longitud());
        assertEquals(0, copiaDeVector.obtener(0));
        assertEquals(5, copiaDeVector.obtener(1));
        assertEquals(98, copiaDeVector.obtener(2));
        assertEquals(36, copiaDeVector.obtener(3));

    }

    @Test
    void copiarVectorConstructor() {
        VectorDeInts vector = new VectorDeInts();

        vector.agregarAtras(0);
        vector.agregarAtras(5);
        vector.agregarAtras(98);
        vector.agregarAtras(36);
        vector.agregarAtras(90);

        VectorDeInts copiaDeVector = new VectorDeInts(vector);

        vector.modificarPosicion(2, 105);

        assertEquals(5, copiaDeVector.longitud());
        assertEquals(0, copiaDeVector.obtener(0));
        assertEquals(5, copiaDeVector.obtener(1));
        assertEquals(98, copiaDeVector.obtener(2));
        assertEquals(36, copiaDeVector.obtener(3));

    }

    /**
     * Se trata de una implementacion "generica",
     * en el sentido, de que no interesa
     * el tipo concreto de "s", sino que
     * unicamente se pide que "s" implemente
     * la interface "SecuenciaDeInts"
     */
    boolean contiene(SecuenciaDeInts s, int e) {
        int i = 0;
        for (; i < s.longitud() && s.obtener(i) != e; i++) {
        }

        return i < s.longitud();
    }

    @Test
    void vectorImplementaSecuencia() {
        SecuenciaDeInts v = new VectorDeInts();

        v.agregarAtras(1);
        v.agregarAtras(1);
        v.agregarAtras(2);
        v.agregarAtras(3);
        v.agregarAtras(5);

        assertTrue(contiene(v, 1));
        assertFalse(contiene(v, 4));
        assertTrue(contiene(v, 5));

    }

}
