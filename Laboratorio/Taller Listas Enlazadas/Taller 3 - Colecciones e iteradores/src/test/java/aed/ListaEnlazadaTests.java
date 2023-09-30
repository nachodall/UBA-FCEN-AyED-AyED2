package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListaEnlazadaTests {

    @Test
    void nuevaListaEstaVacia() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        assertEquals(0, lista.longitud());
    }

    @Test
    void agregarUnElementoAdelante() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAdelante(42);

        assertEquals(1, lista.longitud());
        assertEquals(42, lista.obtener(0));
    }

    @Test
    void agregarUnElementoAtras() {
        ListaEnlazada<Boolean> lista = new ListaEnlazada<>();

        lista.agregarAtras(true);

        assertEquals(1, lista.longitud());
        assertEquals(true, lista.obtener(0));
    }

    @Test
    void agregarVariosElementosSoloAdelante() {
        ListaEnlazada<Float> lista = new ListaEnlazada<>();

        lista.agregarAdelante(42.0f);
        lista.agregarAdelante(41.0f);
        lista.agregarAdelante(40.0f);
        lista.agregarAdelante(39.0f);

        assertEquals(4, lista.longitud());
        assertEquals(39.0f, lista.obtener(0));
        assertEquals(40.0f, lista.obtener(1));
        assertEquals(41.0f, lista.obtener(2));
        assertEquals(42.0f, lista.obtener(3));
    }

    @Test
    void agregarVariosElementosSoloAtras() {
        ListaEnlazada<Character> lista = new ListaEnlazada<>();

        lista.agregarAtras('2');
        lista.agregarAtras('3');
        lista.agregarAtras('4');
        lista.agregarAtras('5');

        assertEquals(4, lista.longitud());
        assertEquals('2', lista.obtener(0));
        assertEquals('3', lista.obtener(1));
        assertEquals('4', lista.obtener(2));
        assertEquals('5', lista.obtener(3));
    }

    @Test
    void agregarVariosElementosAdelanteYAtras() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAdelante(42);
        lista.agregarAdelante(41);
        lista.agregarAtras(43);
        lista.agregarAdelante(40);
        lista.agregarAtras(44);

        assertEquals(5, lista.longitud());
        assertEquals(40, lista.obtener(0));
        assertEquals(41, lista.obtener(1));
        assertEquals(42, lista.obtener(2));
        assertEquals(43, lista.obtener(3));
        assertEquals(44, lista.obtener(4));
    }

    @Test
    void eliminarElementos() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAtras(44);
        lista.agregarAtras(45);

        lista.eliminar(1);

        assertEquals(3, lista.longitud());
        assertEquals(42, lista.obtener(0));
        assertEquals(44, lista.obtener(1));
        assertEquals(45, lista.obtener(2));

        lista.eliminar(2);

        assertEquals(2, lista.longitud());
        assertEquals(42, lista.obtener(0));
        assertEquals(44, lista.obtener(1));

        lista.eliminar(0);
        lista.eliminar(0);

        assertEquals(0, lista.longitud());
    }

    @Test
    void eliminarExtremos(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAdelante(43);
        lista.agregarAtras(44);
        lista.agregarAdelante(42);
        lista.agregarAtras(45);

        lista.eliminar(0);

        assertEquals(3, lista.longitud());
        assertEquals(43, lista.obtener(0));
        assertEquals(44, lista.obtener(1));
        assertEquals(45, lista.obtener(2));

        lista.eliminar(2);

        assertEquals(2, lista.longitud());
        assertEquals(43, lista.obtener(0));
        assertEquals(44, lista.obtener(1));

        lista.eliminar(1);

        assertEquals(1, lista.longitud());
        assertEquals(43, lista.obtener(0));

        lista.eliminar(0);
        assertEquals(0, lista.longitud());
    }

    @Test
    void modificarPosición() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAtras(44);
        lista.agregarAtras(45);

        lista.modificarPosicion(2, 27);

        assertEquals(4, lista.longitud());
        assertEquals(42, lista.obtener(0));
        assertEquals(43, lista.obtener(1));
        assertEquals(27, lista.obtener(2));
        assertEquals(45, lista.obtener(3));

    }

    @Test
    void copiarLista() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAtras(44);
        lista.agregarAtras(45);

        ListaEnlazada<Integer> copiaDeLista = lista.copiar();

        assertEquals(4, copiaDeLista.longitud());
        assertEquals(42, copiaDeLista.obtener(0));
        assertEquals(43, copiaDeLista.obtener(1));
        assertEquals(44, copiaDeLista.obtener(2));
        assertEquals(45, copiaDeLista.obtener(3));

        // Test aliasing interno
        lista.modificarPosicion(0, 99);
        assertEquals(42, copiaDeLista.obtener(0));

    }

    @Test
    void copiarListaConstructor() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAtras(44);
        lista.agregarAtras(45);

        ListaEnlazada<Integer> copiaDeLista = new ListaEnlazada<>(lista);

        assertEquals(4, copiaDeLista.longitud());
        assertEquals(42, copiaDeLista.obtener(0));
        assertEquals(43, copiaDeLista.obtener(1));
        assertEquals(44, copiaDeLista.obtener(2));
        assertEquals(45, copiaDeLista.obtener(3));

        // Test aliasing interno
        lista.modificarPosicion(0, 99);
        assertEquals(42, copiaDeLista.obtener(0));

        // Test pisar memoria preexistente
        lista.eliminar(0);
        copiaDeLista = lista;
        assertEquals(3, copiaDeLista.longitud());

        copiaDeLista = new ListaEnlazada<>();
        assertEquals(0, copiaDeLista.longitud());

    }

    @Test
    void listaDeElemComplejo() {
        class Punto2D {
            public Punto2D(int a, int b) {
                x = a;
                y = b;
            }

            public int x;
            public int y;
        }

        ListaEnlazada<Punto2D> lista = new ListaEnlazada<>();
        Punto2D p = new Punto2D(0, 1);
        lista.agregarAdelante(p);
        lista.agregarAtras(new Punto2D(4, 2));

        assertEquals(2, lista.longitud());
        assertEquals(0, lista.obtener(0).x);
        assertEquals(1, lista.obtener(0).y);
        assertEquals(4, lista.obtener(1).x);
        assertEquals(2, lista.obtener(1).y);

    }

    @Test
    void imprimirLista(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAdelante(41);
        lista.agregarAtras(44);
        lista.agregarAtras(45);
        lista.agregarAdelante(40);

        assertEquals("[40, 41, 42, 43, 44, 45]", lista.toString());
    }

    @Test
    void imprimirLuegoDeEliminar(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAdelante(41);
        lista.agregarAtras(44);
        lista.agregarAtras(45);
        lista.agregarAdelante(40);

        lista.eliminar(2);
        lista.eliminar(3);
        lista.eliminar(0);

        assertEquals("[41, 43, 45]", lista.toString());
    }

    @Test
    void iteradorListaVacia() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        Iterador<Integer> it = lista.iterador();

        assertFalse(it.haySiguiente());
        assertFalse(it.hayAnterior());
    }

    @Test
    void iteradorRecorreListaHaciaAdelante() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAtras(44);

        Iterador<Integer> it = lista.iterador();

        assertTrue(it.haySiguiente());
        assertEquals(42, it.siguiente());
        assertTrue(it.haySiguiente());
        assertEquals(43, it.siguiente());
        assertTrue(it.haySiguiente());
        assertEquals(44, it.siguiente());
        assertFalse(it.haySiguiente());
    }

    @Test
    void iteradorEsBidireccional(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        lista.agregarAtras(42);
        lista.agregarAtras(43);
        lista.agregarAtras(44);

        Iterador<Integer> it = lista.iterador();

        assertTrue(it.haySiguiente());
        assertFalse(it.hayAnterior());
        assertEquals(42, it.siguiente());
        assertTrue(it.haySiguiente());
        assertEquals(43, it.siguiente());
        assertTrue(it.hayAnterior());
        assertEquals(43, it.anterior());
        assertTrue(it.hayAnterior());
        assertEquals(42, it.anterior());
        assertFalse(it.hayAnterior());
        assertTrue(it.haySiguiente());
        assertEquals(42, it.siguiente());
        assertTrue(it.hayAnterior());
        assertTrue(it.haySiguiente());
        assertEquals(43, it.siguiente());
        assertTrue(it.hayAnterior());
        assertTrue(it.haySiguiente());
        assertEquals(44, it.siguiente());
        assertFalse(it.haySiguiente());
        assertTrue(it.hayAnterior());
        assertEquals(44, it.anterior());
    }

}
