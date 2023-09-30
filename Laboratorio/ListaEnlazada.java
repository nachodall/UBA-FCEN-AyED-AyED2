package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        private T dato;
        private Nodo sig;
        private Nodo ant;

        public Nodo(T datos){
            this.dato = datos;
            this.sig = null;
            this.ant = null;
        }
    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nue = new Nodo(elem);

        if(primero == null){ //caso lista vacia
            primero = nue;
            ultimo = nue;
        } else{
            this.primero.ant = nue;
            nue.sig = primero;
            primero = nue;
        }
        this.longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nue = new Nodo(elem);

        if(ultimo == null){
            primero = nue;
            ultimo = nue;
        } else{
            this.ultimo.sig = nue;
            nue.ant = ultimo;
            ultimo = nue;
        }
        this.longitud++;
    }

    public T obtener(int i) {
        int cont = 0;
        Nodo aux = this.primero;
        
        while(cont < i){
            aux = aux.sig;
            cont++;
        }

        return aux.dato;
    }

    public void eliminar(int i) {
        int cont = 0;
        Nodo aux = this.primero;

        while(cont < i){
            aux = aux.sig;
            cont++;
        }

        if(aux == primero){
            primero = aux.sig;
        } else{
            if(aux == ultimo){
                ultimo = aux.ant;
            } 
            else{
                aux.ant.sig = aux.sig;
                aux.sig.ant = aux.ant;
            }
        } 

        this.longitud--;            
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
