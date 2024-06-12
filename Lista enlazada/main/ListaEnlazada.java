package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    private Nodo first;
    private Nodo last;
    private int size; 

    private class Nodo {
        T data;
        Nodo next;
        Nodo prev;
        Nodo(T v){data = v; next = null; prev = null;}
    }

    public ListaEnlazada() {
        first = null;
        last = null;
        size = 0;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nodoNuevo = new Nodo(elem);
        if(size == 0){
            first = nodoNuevo;
        } else{
            if(size == 1){
                nodoNuevo.next = first;
                last = nodoNuevo.next;
                first = nodoNuevo;
            } else {
                first.prev = nodoNuevo;
                nodoNuevo.next = first;
                first = nodoNuevo;
            }
        }
        size++;
    }

    public void agregarAtras(T elem) {
        Nodo nodoNuevo = new Nodo(elem);
        if(size == 0) {
            first  = nodoNuevo;
            first.next = null;
            first.prev = null;            
        } else {
            if(size == 1){
                nodoNuevo.prev = first;
                last = nodoNuevo;
                first.next = last;
            } else {
                last.next = nodoNuevo;
                nodoNuevo.prev = last;
                last = nodoNuevo;
            }

        }
        size++;
    
    }

    public T obtener(int i) {
        Nodo nodoActual = first;
        for(int j = 0; j < i; j++){
            nodoActual = nodoActual.next;
        }
        return nodoActual.data;

    }

    public void eliminar(int i) {

        Nodo nodoActual = first;
        for(int j = 0; j < i; j++){
            nodoActual = nodoActual.next;
        }
        
        if(size == 1){
            first = null;
        } else {
            if(nodoActual.prev == null){
            first = nodoActual.next;
            first.prev = null;
            } else {
                if(nodoActual.next == null){
                   last = nodoActual.prev;
                   last.next = null;

                } else {
                   nodoActual.next.prev = nodoActual.prev;
                   nodoActual.prev.next = nodoActual.next;
                }
           }
        }
        
        size--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nodoActual = first;
        for(int j = 0; j < indice; j++){
            nodoActual = nodoActual.next;
        }
        nodoActual.data = elem;


    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> listaNueva = new ListaEnlazada<T>();
        int newSize = 0;
        Nodo nodoActual = first;
        while(nodoActual != null){
            listaNueva.agregarAtras(nodoActual.data);
            newSize++;
            nodoActual = nodoActual.next;
        }
        listaNueva.size = newSize;
        return listaNueva;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> listaNueva = lista.copiar();
        first = listaNueva.first;
        last = listaNueva.last;
        size = listaNueva.size;
    }
    
    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("[");
        sbuffer.append(first.data);
        while(first.next != null){
            sbuffer.append(", ");
            sbuffer.append(first.next.data);
            first = first.next;
        }
        sbuffer.append("]");
        return sbuffer.toString();

    }

    private class ListaIterador implements Iterador<T> {
        int iterador;
        ListaIterador(){ iterador = 0;  }

        public boolean haySiguiente() {
            return iterador < size;
        }
        
        public boolean hayAnterior() {
	        return iterador > 0;
        }

        public T siguiente() {
	        int i = iterador;
            iterador++;
            return obtener(i);
        }
        

        public T anterior() {
            iterador--;
            return obtener(iterador);
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
