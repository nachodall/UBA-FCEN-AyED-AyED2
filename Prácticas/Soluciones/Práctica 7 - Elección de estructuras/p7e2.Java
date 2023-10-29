//a) lista enlazada ordenada (supongo que es de int para hacer las comparaciones facilmente)
public listaEnlazada<int> interseccion(listaEnlazada<int> u, listaEnlazada<int> v){
    listaEnlazada<int> nue = new listaEnlazada();
    while (u != null){//O(n)
        if (u.dato <= v.ultimo){ //O(1)
            if (pertenece(u.dato,v)){ //O(n)
                agregarEnOrden(u.dato,nue) //O(m)
            }
        }
        u = u.sig;
    }
}
//Vemos que en peor caso si o si hacemos n*(n+m) con m siendo la cant. de elem de nue ==> complejidad?? O(n^3)?

//b) lista enlazada sin orden
public listaEnlazada<int> interseccion(listaEnlazada<int> u, listaEnlazada<int> v){
    listaEnlazada<int> nue = new listaEnlazada();
    while (u != null){//O(n)
        if (pertenece(u.dato,v)){ //O(n)
            agregar(u.dato,nue); //O(1)
        }
    }
        u = u.sig;
    return nue;
}
//Complejidad = O(n^2)

//c) ABBs
public ABB<int> interseccion(ABB<int> x, ABB<int> y){
    ABB<int> nue = new ABB();
    Stack<int> stack; //O(1) // vale usar stack??
    agregarElemsInOrder(stack, x); //O(n)
    while(!stack.empty()){ //O(1)
        int elem = stack.pop(); //O(1)
        if (pertenece(elem, y)){ //O(n)
            agregar(elem,nue); //O(n)
        }
    }
    return nue;
}
//Complejidad: ??

public ABB<int> interseccionRecursivo(ABB<int> x, ABB<int> y, ABB<int> res){
    if (x != null){
        interseccionRecursivo(x.hi, y, res);
        if (pertenece(x.dato,y)){ //O(n)
            agregar(x.dato,res); //O(m)
        }
        interseccionRecursivo(x.hd, y, res);
    }
}
//Complejidad: como es un recorrido inorder se recorren todos los elementos del arbol ==> O(n^2 + m), O(n^2 + nm)???? porque el agregar no es anidado
