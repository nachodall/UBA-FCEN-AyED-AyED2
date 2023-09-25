package aed;

interface SecuenciaDeInts {

    /**
     * Devuelve el largo de la secuencia.
     * 
     */
    public int longitud();

    /**
     * Agrega un elemento al final de la secuencia.
     * 
     */
    public void agregarAtras(int i);

    /**
     * Retorna el elemento en la i-esima posicion.
     * 
     */
    public int obtener(int i);

    /**
     * Quita el ultimo elemento de la secuencia.
     * 
     */
    public void quitarAtras();

    /**
     * Cambia el valor de la indice-esima posicion
     * por el valor dado por parametro.
     * 
     */
    public void modificarPosicion(int indice, int valor);

    /**
     * Retornar un vector con los mismos elementos
     * 
     */
    public VectorDeInts copiar();

}