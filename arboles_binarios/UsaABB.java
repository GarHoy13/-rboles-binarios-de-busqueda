public class UsaABB {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(69);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(13);
        arbol.insertarValor(27);

        System.out.println("Árbol de forma horizontal:");
        arbol.imprimirHorizontal();

        int valorBuscado = 29;
        Nodo nodoBuscado = arbol.buscarNodo(valorBuscado);
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado: " + nodoBuscado.dato);
        } else {
            System.out.println("Nodo no encontrado");
        }

        System.out.println("Recorrido en preorden:");
        arbol.preorden();

        System.out.println("\nRecorrido en inorden:");
        arbol.inorden();

        System.out.println("\nRecorrido en postorden:");
        arbol.postorden();

        int valorEliminar = 29;
        arbol.eliminarNodo(valorEliminar);

        System.out.println("\nÁrbol después de eliminar el nodo " + valorEliminar + ":");
        arbol.imprimirHorizontal();
    }
}