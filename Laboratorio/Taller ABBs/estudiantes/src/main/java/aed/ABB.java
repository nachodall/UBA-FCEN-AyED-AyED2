package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributpos privados del Conjunto
    private Nodo raiz;
    private int cardinal;


    private class Nodo {
        // Agregar atributos privados del Nodo
        Nodo hi;
        Nodo hd;
        Nodo padre;
        T dato;
        // Crear Constructor del nodo
        public Nodo(T valor){
            this.hi = null;
            this.hd = null;
            this.padre = null;
            this.dato = valor;
        }
    }


    public ABB() {
        this.raiz = null;
        this.cardinal = 0;
    }


    public int cardinal() {
        return this.cardinal;
    }


    public T minimoRecursivo(Nodo actual){
        if (actual.hi == null){
            return actual.dato;
        }
        return minimoRecursivo(actual.hi);
    }

    public T minimo(){
        if(this.raiz==null){
            return null;
        }
        Nodo aux = this.raiz;
        return minimoRecursivo(aux);
    }


    public T maximoRecursivo(Nodo actual){
        if (actual.hd == null){
            return actual.dato;
        }
        return maximoRecursivo(actual.hd);
    }

    public T maximo(){
        if(this.raiz==null){
            return null;
        }
        Nodo aux = this.raiz;
        return maximoRecursivo(aux);
    }

    private void insertarNodo(Nodo z){
        Nodo x = this.raiz;
        Nodo y = null;
        while (x != null){
            y = x;
            if (z.dato.compareTo(x.dato) < 0){
                x = x.hi;
            } else{
                x = x.hd;
            }
        }
        z.padre = y;
        if (y == null){
            this.raiz = z;
        } else if(z.dato.compareTo(y.dato) < 0){
            y.hi = z;
        } else {
            y.hd = z;
        }
    }

    public void insertar(T elem){
        if (!pertenece(elem)){
            Nodo nue = new Nodo(elem);
            insertarNodo(nue); 
            this.cardinal++;
        }
    }


    public boolean busquedaRecursiva(Nodo actual, T elem){
        if (actual == null){
            return false;
        }

        if (actual.dato.equals(elem)){
            return true;
        }

        if ((actual.dato).compareTo(elem) > 0){
            return busquedaRecursiva(actual.hi, elem);
        } 
        else{
            return busquedaRecursiva(actual.hd, elem);
        }
    }

    public boolean pertenece(T elem){
        Nodo aux = this.raiz;
        return busquedaRecursiva(aux, elem);
    }


    private void intercambiar(Nodo u, Nodo v) {
        if (u.padre == null) {
            this.raiz = v;
        } else if (u == u.padre.hi) {
            u.padre.hi = v;
        } else {
            u.padre.hd = v;
        }
    
        if (v != null) {
            v.padre = u.padre;
        }
    }

    private Nodo getNodo(T elem){
        Nodo aux = this.raiz;
        if (aux == null){
            return null;
        }
        while (aux.dato != elem){
            if (aux.dato.compareTo(elem) > 0){
                aux = aux.hi;
            } else{
                aux = aux.hd;
            }
        }
        return aux;
    }  

    public void eliminar(T elem) { //la explicacion del algoritmo esta en el Cormen
        Nodo actual = this.raiz;
            while (actual != null && !actual.dato.equals(elem)) {
                if (elem.compareTo(actual.dato) < 0) {
                    actual = actual.hi;
                } else {
                    actual = actual.hd;
                }
            } //aca lo busco
        
            if (actual == null) return; // El elemento no se encuentra en el árbol.
        
            if (actual.hi == null) {
                intercambiar(actual, actual.hd);
            } else if (actual.hd == null) {
                intercambiar(actual, actual.hi);
            } else {
                Nodo sucesor = getNodo(minimoRecursivo(actual.hd));
                if (sucesor.padre != actual) {
                    intercambiar(sucesor, sucesor.hd);
                    sucesor.hd = actual.hd;
                    sucesor.hd.padre = sucesor;
                }
                intercambiar(actual, sucesor);
                sucesor.hi = actual.hi;
                sucesor.hi.padre = sucesor;
            }
            cardinal--;
    }
       
    
    private String stringInOrder(Nodo actual){
        if (actual == null){
            return "";
        }

        String izquierda = stringInOrder(actual.hi);
        String derecha = stringInOrder(actual.hd);

        //este truquito de los isEmpty se fija si el string esta vacio, o sea si esta vacio es xq es el primer elemento entonces no pone coma.
        return izquierda + (izquierda.isEmpty() ? "" : ",") + actual.dato.toString() + (derecha.isEmpty() ? "" : ",") + derecha;
    }

    public String toString(){ 
        Nodo aux = this.raiz;
        String res = "{";
        res = res + stringInOrder(aux);
        res = res + "}";
        return res;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual;
        private Stack<Nodo> stack; //vamos a ir guardando todos los elementos aca ya que es facil para sacarlos
        
        public ABB_Iterador(){
            actual = raiz;
            stack = new Stack<Nodo>();
            Nodo aux = actual;
            cargarDatosInOrder(aux);
        }

        private void cargarDatosInOrder(Nodo x){
            if (x != null){
                cargarDatosInOrder(x.hd);
                stack.push(x);
                cargarDatosInOrder(x.hi);
            }
        }

        public boolean haySiguiente() {        
            return !(stack.isEmpty());
        }

        public T siguiente(){ 
            if (!haySiguiente()){
                return null;
            }
            Nodo siguiente = stack.pop();
            return siguiente.dato;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
