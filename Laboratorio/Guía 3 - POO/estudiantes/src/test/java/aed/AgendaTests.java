package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AgendaTests {

    @Test
    void fechaTieneMesYDia() {
        Fecha fecha = new Fecha(10, 6);

        assertEquals(6, fecha.mes());
        assertEquals(10, fecha.dia());

    }

    @Test
    void fechaComoString() {
        Fecha fecha = new Fecha(10, 6);
        String esperado = "10/6";

        assertEquals(esperado, fecha.toString());
    }

    @Test
    void igualdadDeFechas() {
        Fecha f = new Fecha(6, 10);
        Fecha f2 = new Fecha(6, 10);
        Fecha f3 = new Fecha(7, 10);
        Fecha f4 = new Fecha(6, 11);

        String fstring = "6/10";

        assertEquals(f, f2);
        assertNotEquals(f, f3);
        assertNotEquals(f, f4);
        assertNotEquals(fstring, f);
        assertNotEquals(f, fstring);

    }

    @Test
    void incrementarDia() {

        Fecha f = new Fecha(28, 6);
        f.incrementarDia();

        assertEquals(29, f.dia());
        assertEquals(6, f.mes());

        f.incrementarDia();
        assertEquals(30, f.dia());
        assertEquals(6, f.mes());

        f.incrementarDia();
        assertEquals(1, f.dia());
        assertEquals(7, f.mes());

        Fecha f2 = new Fecha(28, 2);
        assertEquals(28, f2.dia());
        assertEquals(2, f2.mes());

        f2.incrementarDia();
        assertEquals(1, f2.dia());
        assertEquals(3, f2.mes());

    }

    @Test
    void incrementarUltimoDiaDelAnio() {

        Fecha f = new Fecha(31, 12);

        f.incrementarDia();

        assertEquals(1, f.dia());
        assertEquals(1, f.mes());

    }

    @Test
    void crearHorario() {
        Horario h = new Horario(10, 30);

        assertEquals(10, h.hora());
        assertEquals(30, h.minutos());
    }

    @Test
    void horarioToString() {
        Horario h = new Horario(10, 30);

        assertEquals("10:30", h.toString());
    }

    @Test
    void horarioEquals() {
        Horario h = new Horario(10, 30);
        Horario h2 = new Horario(10, 30);
        Horario h3 = new Horario(10, 35);
        Horario h4 = new Horario(11, 30);
        String hstring = "10:35";

        assertEquals(h, h2);
        assertNotEquals(h, h3);
        assertNotEquals(h, h4);
        assertNotEquals(hstring, h);
        assertNotEquals(h, hstring);
    }

    @Test
    void crearRecordatorio() {
        Fecha f = new Fecha(10, 6);
        Horario h = new Horario(9, 45);
        String mensaje = "Consulta con dentista";

        Recordatorio recordatorio = new Recordatorio(mensaje, f, h);

        assertEquals(h, recordatorio.horario());
        assertEquals(f, recordatorio.fecha());
        assertEquals(mensaje, recordatorio.mensaje());

        // Evitar aliasing.
        f.incrementarDia();
        Fecha f2 = recordatorio.fecha();
        f2.incrementarDia();
        assertEquals(new Fecha(10, 6), recordatorio.fecha());

    }

    @Test
    void imprimirRecordatorio() {
        Fecha f = new Fecha(10, 6);
        Horario h = new Horario(9, 45);
        String mensaje = "Consulta con dentista";

        Recordatorio recordatorio = new Recordatorio(mensaje, f, h);

        assertEquals("Consulta con dentista @ 10/6 9:45", recordatorio.toString());

    }

    @Test
    void crearAgenda() {
        Agenda a = new Agenda(new Fecha(10, 05));

        assertEquals(new Fecha(10, 05), a.fechaActual());

    }

    @Test
    void agregarRecordatorios() {
        Agenda a = new Agenda(new Fecha(10, 05));

        a.agregarRecordatorio(new Recordatorio("Clase Algoritmos", new Fecha(10, 05), new Horario(17, 00)));
        a.agregarRecordatorio(new Recordatorio("Labo Algoritmos", new Fecha(10, 05), new Horario(19, 00)));

        String esperado = "10/5\n"
                .concat("=====\n")
                .concat("Clase Algoritmos @ 10/5 17:0\n")
                .concat("Labo Algoritmos @ 10/5 19:0\n");

        assertEquals(esperado, a.toString());

    }

    @Test
    void incrementarDiaModificaRecordatorios() {
        Agenda a = new Agenda(new Fecha(10, 05));

        a.agregarRecordatorio(new Recordatorio("Clase Algoritmos", new Fecha(10, 05), new Horario(17, 00)));
        a.agregarRecordatorio(new Recordatorio("Partido de Fútbol", new Fecha(11, 05), new Horario(19, 00)));
        a.agregarRecordatorio(new Recordatorio("Labo Algoritmos", new Fecha(10, 05), new Horario(19, 00)));

        String esperado = "10/5\n"
                .concat("=====\n")
                .concat("Clase Algoritmos @ 10/5 17:0\n")
                .concat("Labo Algoritmos @ 10/5 19:0\n");

        assertEquals(esperado, a.toString());

        a.incrementarDia();

        assertEquals(new Fecha(11, 05), a.fechaActual());

        String esperado2 = "11/5\n"
                .concat("=====\n")
                .concat("Partido de Fútbol @ 11/5 19:0\n");

        assertEquals(esperado2, a.toString());

    }

}
