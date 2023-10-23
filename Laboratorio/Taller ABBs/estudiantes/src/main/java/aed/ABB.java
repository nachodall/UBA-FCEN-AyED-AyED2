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


    public void insertar(T elem){
        if (!pertenece(elem)){
            
            Nodo nue = new Nodo(elem);
            Nodo aux = this.raiz;
            Nodo auxPadre = null;

            while(aux != null){ //me muevo hasta encontrar una hoja
                auxPadre = aux;
                if(aux.dato.compareTo(elem) > 0){
                    aux = aux.hi;
                }
                else{
                    aux = aux.hd;
                }
            }

            nue.padre = auxPadre; //ya encontre donde insertar

            if(auxPadre == null){ // el arbol era vacio
                this.raiz = nue;
            }

            else if(auxPadre.dato.compareTo(elem) > 0){ //el arbol no es vacio, me fijo si nue sera hi o hd
                auxPadre.hi = nue;
            }
            else{
                auxPadre.hd = nue;
            }

            this.cardinal++;
        }
    }


    public boolean busquedaRecursiva(Nodo actual, T elem){
        if (actual == null){
            return false;
        }

        if (actual.dato == elem){
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
        return busquedaRecursiva(this.raiz, elem);
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
        if (pertenece(elem)){
            Nodo actual = getNodo(elem);
                
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
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
