package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DebuggingTests {
    Debugging debugging = new Debugging();

    @Test
    void testXOR() {
        assertFalse(debugging.xor(false, false));
        assertTrue(debugging.xor(false, true));
        assertTrue(debugging.xor(true, false));
        assertFalse(debugging.xor(true, true));
    }

    @Test
    void testIguales() {
        assertTrue(debugging.iguales(new int[0], new int[0]));
        assertTrue(debugging.iguales(new int[]{1,2,3}, new int[]{1,2,3}));
        assertFalse(debugging.iguales(new int[]{1,2,3}, new int[]{1,2,4}));
        assertFalse(debugging.iguales(new int[]{1,2,3}, new int[]{3,2,1}));
        assertFalse(debugging.iguales(new int[]{1,2,3}, new int[]{1,2,3,4}));
        assertFalse(debugging.iguales(new int[]{1,2,3,4}, new int[]{1,2,3}));
    }

    @Test
    void testOrdenado() {
        assertTrue(debugging.ordenado(new int[0]));
        assertTrue(debugging.ordenado(new int[]{5}));
        assertTrue(debugging.ordenado(new int[]{7,7,7}));
        assertTrue(debugging.ordenado(new int[]{4,5,6}));
        assertTrue(debugging.ordenado(new int[]{6,20,31,98}));
        assertFalse(debugging.ordenado(new int[]{4,5,4}));
        assertFalse(debugging.ordenado(new int[]{3,2,1}));
        assertFalse(debugging.ordenado(new int[]{8, 14, 12, 25}));
    }

    @Test
    void testMaximo() {
        assertEquals(debugging.maximo(new int[]{0}), 0);
        assertEquals(debugging.maximo(new int[]{1}), 1);
        assertEquals(debugging.maximo(new int[]{4, 8, 10}), 10);
        assertEquals(debugging.maximo(new int[]{40, 8, 10}), 40);
        assertEquals(debugging.maximo(new int[]{40, 80, 10}), 80);
        assertEquals(debugging.maximo(new int[]{-6, -2, -5}), -2);
    }

    @Test
    void testTodosPositivos() {
        assertTrue(debugging.todosPositivos(new int[0]));
        assertTrue(debugging.todosPositivos(new int[]{4}));
        assertTrue(debugging.todosPositivos(new int[]{5, 8, 3}));
        assertFalse(debugging.todosPositivos(new int[]{7, 4, 0}));
        assertFalse(debugging.todosPositivos(new int[]{7, -2, 4}));
    }
}