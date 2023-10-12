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
        int cont = 0;
        Nodo aux = this.primero;

        while(cont < indice){
            aux = aux.sig;
            cont++;
        }
        
        aux.dato = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nue = new ListaEnlazada<T>();
        Nodo aux = this.primero;

        while(aux!=null){
            nue.agregarAtras(aux.dato);
            aux = aux.sig;
        }

        return nue;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> copia = lista.copiar();
        this.longitud = copia.longitud;
        this.primero = copia.primero;
        this.ultimo = copia.ultimo;
    }
    
    @Override
    public String toString() {
        String str = "[";
        Nodo aux = this.primero;

        while(aux != null){
            str = str + aux.dato +", ";
            aux = aux.sig;
        }

        str = str.substring(0, str.length()-2); // le saco el ultimo ", "
        str = str +"]";

        return str;
    }

    private class ListaIterador implements Iterador<T> {
    	private int apuntador;
        private ListaEnlazada<T> l;

        public ListaIterador(ListaEnlazada<T> lista){
            l = lista;
            apuntador = 0;
        }

        public boolean haySiguiente() {
            return apuntador != l.longitud;
        }
        
        public boolean hayAnterior() {
            return apuntador != 0;
        }

        public T siguiente() {
            apuntador ++;
            return l.obtener(apuntador);
        }
        

        public T anterior() {
	        apuntador --;
            return l.obtener(apuntador);
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador(this);
    }

}
