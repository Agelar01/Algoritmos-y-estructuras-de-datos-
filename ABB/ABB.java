package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo root;
    private int size;
    
    private class Nodo {
        // Agregar atributos privados del Nodo
       private T value;
       private Nodo left;
       private Nodo right;

        
        // Crear Constructor del nodo
        Nodo (T v){
            this.value = v;
            this.left = null;
            this.right = null;

        }
    }

    public ABB() {
        root = null;
        size = 0;
    }

    public int cardinal() {
        return size;
    }

    public T minimo(){
        Nodo raizActual = root;
        if (size == 0){
            return root.value;
        }
        while (raizActual.left != null){
            raizActual = raizActual.left;
        } 
        return raizActual.value;
    }

    public T maximo(){
        Nodo raizActual = root;
        if( size == 0){
            return root.value;
        }
        while (raizActual.right != null){
            raizActual = raizActual.right;
        }
         
        return raizActual.value;
    }

    public void insertar(T elem){
        if (size == 0){
            root = new Nodo (elem);
            size ++;
            return;
        }

        Nodo raizActual = root;
        Nodo prev = null;
        Nodo lastNode = null;
        while (raizActual != null){
            prev = raizActual;

            if (raizActual.value.compareTo(elem) == 0){
                lastNode = raizActual;
                return;
            } else {
                if (raizActual.value.compareTo(elem) > 0){
                    raizActual = raizActual.left;
                } else {
                    raizActual = raizActual.right;
                }
            }
            lastNode = prev;
        }
        if (lastNode.value.compareTo(elem) !=0){
        Nodo newNode = new Nodo (elem);
            if(lastNode.value.compareTo(elem) > 0){
            lastNode.left = newNode;
            } else {
            lastNode.right = newNode;
        }
    }
        size ++;
    }

    public boolean pertenece(T elem){
        Nodo raizActual = root;
        while (raizActual != null){
            if (raizActual.value.compareTo(elem) == 0){
                return true;
            } else {
                if (raizActual.value.compareTo(elem) > 0){
                    raizActual = raizActual.left;
                } else {
                    raizActual = raizActual.right;
                }
            }
        }
        return false;
    }

    public void eliminar(T elem){
        root = auxEliminar(root, elem);
        size--;
    }

    private Nodo auxEliminar(Nodo raizActual, T elem) {
        if (raizActual == null){
            return raizActual;
        }

        int compare = elem.compareTo(raizActual.value);

        if (compare < 0) {
            raizActual.left = auxEliminar(raizActual.left, elem);
        }
        else if (compare > 0) {
            raizActual.right = auxEliminar(raizActual.right, elem);
        }
        else {
            if (raizActual.left == null){
                return raizActual.right;
            }
            else if (raizActual.right == null) {
                return raizActual.left;
            }

            raizActual.value = min(raizActual.right);
            raizActual.right = auxEliminar(raizActual.right, raizActual.value);
        }

        return raizActual;
    }

    private T min (Nodo node){
        T minN = node.value;
        while (node.left != null){
            minN = node.left.value;
            node = node.left;
        }
        return minN;
    }

    public String toString(){
       String treeString = inOrder(root, "");
       treeString = treeString.substring(0, treeString.length()-1);
       return "{" + treeString + "}";
    }
    public String inOrder(Nodo raizActual, String treeString){
        if (raizActual == null) {
            return treeString;
        }

        treeString = inOrder(raizActual.left, treeString);
        treeString += raizActual.value + ",";
        treeString = inOrder(raizActual.right, treeString);

        return treeString;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Stack <Nodo> stack;

        ABB_Iterador(){
            stack = new Stack <>();
            Nodo node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            } 
        }

        public boolean haySiguiente() {            
            return !stack.isEmpty();
        }
    
        public T siguiente() {
            Nodo raizActual = stack.pop();
            T value = raizActual.value;

            if (raizActual.right != null){
                Nodo node = raizActual.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
            return value;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
