package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;


class InternetToolkitTests {
    private static <T extends Comparable<T>> boolean verificarOrden(T[] lista){
        for (int i = 0; i < lista.length-1; i++){
            if (lista[i].compareTo(lista[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    private static <T> boolean todosNull(T[] lista){
        for(int i = 0; i < lista.length;i++){
            if(lista[i] != null){
                return false;
            }
        }
        return true;
    }

    private static <T extends Comparable<T>> boolean mismosElementos(T[] a, T[] b){
        if(a.length != b.length){
            return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < a.length;i++){
            if(a[i].compareTo(b[i]) != 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void tcpReorderOrdenados(){
        InternetToolkit Herramientas = new InternetToolkit();
        int n = 100;
        Fragment[] paquetes = new Fragment[n];
        
        for(int i = 0; i < paquetes.length;i++){
            paquetes[i] = new Fragment(i);
        } 

        Collector.getInstance().reset();
        Fragment[] ordenados = Herramientas.tcpReorder(paquetes.clone());

        assertTrue(Collector.getInstance().getValue() == n-1); // Verifica que la complejidad sea lineal y se este revisando los valores
        assertTrue(verificarOrden(ordenados));
        assertTrue(mismosElementos(ordenados,paquetes));
        
    }

    @Test
    public void tcpReorderOrdenInverso(){
        // Para este test verificamos que reordene correctamente, no se espera que sea lineal la complejidad
        InternetToolkit Herramientas = new InternetToolkit();
        Fragment[] paquetes = new Fragment[100];

        for(int i = 0; i < paquetes.length;i++){
            paquetes[paquetes.length-1-i] = new Fragment(i);
        } 
        Fragment[] ordenados = Herramientas.tcpReorder(paquetes.clone());

        assertTrue(verificarOrden(ordenados));
        assertTrue(mismosElementos(ordenados,paquetes));
    }
    
    @Test
    public void tcpReorderAzar(){
        // Para este test verificamos que reordene correctamente, no se espera que sea lineal la complejidad
        InternetToolkit Herramientas = new InternetToolkit();
        int n = 20;
        Fragment[] paquetes = new Fragment[n];
        int[] numeros = new Random().ints(n, 0, 100).toArray();

        for(int i = 0; i < paquetes.length;i++){
            paquetes[paquetes.length-1-i] = new Fragment(numeros[i]);
        } 
        Fragment[] ordenados = Herramientas.tcpReorder(paquetes.clone());

        assertTrue(verificarOrden(ordenados));
        assertTrue(mismosElementos(ordenados,paquetes));
    }

    @Test
    public void tcpReorderComplejidadLineal(){
        InternetToolkit Herramientas = new InternetToolkit();
        int n = 1000;
        Fragment[] paquetes = new Fragment[n];
        
        for(int i = 0; i < paquetes.length;i++){
            paquetes[i] = new Fragment(i);
        } 
        
        int[] indexes_a_desordenar = new Random().ints(n/100, 0, n).toArray();
        
        for (int i = 0; i < indexes_a_desordenar.length; i++){
            Fragment t = paquetes[i];
            paquetes[i] = paquetes[indexes_a_desordenar[i]];
            paquetes[indexes_a_desordenar[i]] = t;
        }
        
        Collector.getInstance().reset();
        Fragment[] ordenados = Herramientas.tcpReorder(paquetes.clone());

        assertTrue(Collector.getInstance().getValue() <= 13*n); // Verifica que la complejidad sea lineal
        assertTrue(verificarOrden(ordenados));
        assertTrue(mismosElementos(ordenados,paquetes));
    }



    @Test
    public void kTopRoutersInstanciaChica(){
        int n = 10;
        Router[] routers = new Router[n];
        InternetToolkit Herramientas = new InternetToolkit();
        for (int i = 0; i < routers.length; i++){
            routers[i] = new Router(i, i);
        }

        Router[] mas_usado = Herramientas.kTopRouters(routers.clone(), 1, -1);
        assertTrue(mas_usado.length == 1);
        assertTrue(mas_usado[0].compareTo(routers[n-1]) == 0);

        Router[] ninguno_cumple = Herramientas.kTopRouters(routers.clone(), n-1, n+1);
        assertTrue(todosNull(ninguno_cumple) || ninguno_cumple.length == 0);

        Router[] todos_cumplen = Herramientas.kTopRouters(routers.clone(), n, -1);
        assertTrue(mismosElementos(todos_cumplen,routers));


        for(int k = 0; k <= n; k++){
            Router[] algunos_cumplen = Herramientas.kTopRouters(routers.clone(), k, -1);
            Router[] routers_ordenados = routers.clone();
            Arrays.sort(routers_ordenados);
            Router[] pedazo_ordenado = Arrays.copyOfRange(routers_ordenados, n-k, n);
            Router[] pedazo_respuesta = Arrays.copyOfRange(algunos_cumplen, 0, k);
            Router[] pedazo_respuesta_null = Arrays.copyOfRange(algunos_cumplen, k, algunos_cumplen.length);
            assertTrue(mismosElementos(pedazo_respuesta,pedazo_ordenado));
            assertTrue(todosNull(pedazo_respuesta_null));
        }

    }
    
    @Test
    public void kTopRoutersInstanciaGrande(){
        int n = 1000;
        Router[] routers = new Router[n];
        InternetToolkit Herramientas = new InternetToolkit();

        int[] param_a = new Random().ints(n, 0, n).toArray();
        int[] param_b = new Random().ints(n, 0, n).toArray();        
        for (int i = 0; i < routers.length; i++){
            routers[i] = new Router(param_a[i],param_b[i]);
        }

        for(int k = 0; k <= n; k++){
            Router[] algunos_cumplen = Herramientas.kTopRouters(routers.clone(), k, -1);
            Router[] routers_ordenados = routers.clone();
            Arrays.sort(routers_ordenados);
            Router[] pedazo_ordenado = Arrays.copyOfRange(routers_ordenados, n-k, n);
            Router[] pedazo_respuesta = Arrays.copyOfRange(algunos_cumplen, 0, k);
            Router[] pedazo_respuesta_null = Arrays.copyOfRange(algunos_cumplen, k, algunos_cumplen.length);
            assertTrue(mismosElementos(pedazo_respuesta,pedazo_ordenado));
            assertTrue(todosNull(pedazo_respuesta_null));
        }

    }

    @Test
    public void sortIPv4Test(){
        Vector<String> ips = new Vector<String>();
        InternetToolkit herramientas = new InternetToolkit();
        File archivo = new File("test_ej3.txt");
        Scanner lector;
        try{
            lector = new Scanner(archivo);
        }catch (FileNotFoundException e){
            fail(e);
            return;
        }
        while (lector.hasNextLine()) {
            String data = lector.nextLine();
            ips.addElement(data);
        }
        lector.close();

        String[] original = new String[ips.size()];
        ips.copyInto(original);
        Collections.shuffle(ips);

        String[] ordenar = new String[ips.size()];
        ips.copyInto(ordenar);

        IPv4Address[] ordenado = herramientas.sortIPv4(ordenar);

        assertTrue(ordenado.length == original.length);

        for(int i = 0; i < ordenado.length; i++){
            assertTrue(ordenado[i].toString().compareTo(original[i]) == 0);
        }
    }    


}
