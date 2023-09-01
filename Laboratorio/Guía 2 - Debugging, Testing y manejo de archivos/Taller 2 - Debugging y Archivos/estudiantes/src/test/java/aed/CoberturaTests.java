package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals("Buzz",cobertura.fizzBuzz(5));
        assertEquals("Fizz",cobertura.fizzBuzz(3));
        assertEquals("FizzBuzz",cobertura.fizzBuzz(15));
        assertEquals("7",cobertura.fizzBuzz(7));
        assertEquals("FizzBuzz",cobertura.fizzBuzz(0));
    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(1,cobertura.numeroCombinatorio(15,0));
        assertEquals(0,cobertura.numeroCombinatorio(2,3));
        assertEquals(10,cobertura.numeroCombinatorio(5,3));
        assertEquals(1,cobertura.numeroCombinatorio(150,150));
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertEquals(1,cobertura.repeticionesConsecutivas(new int[]{1,2,3,4}));
        assertEquals(2,cobertura.repeticionesConsecutivas(new int[]{1,2,2,3,4}));
        assertEquals(0,cobertura.repeticionesConsecutivas(new int[]{}));
        assertEquals(2,cobertura.repeticionesConsecutivas(new int[]{1,1,2,2,3,4}));

    }
}
