/**
 * Guía 4. BST I: inserción y búsqueda.
 * Compara un BST construido con datos distribuidos
 * frente a otro construido con datos ordenados.
 */
public class Main {

    public static void main(String[] args) {

        // ----------------------------------------------------------
        // EJERCICIO DE LA GUÍA: 60,40,80,30,50,70,90
        // ----------------------------------------------------------
        System.out.println("=== BST DE 7 NODOS ===");

        int[] valores = {60, 40, 80, 30, 50, 70, 90};
        ArbolBST bst = new ArbolBST();

        for (int v : valores) {
            bst.insertar(v);
        }

        bst.imprimirArbol();

        System.out.println("\nInorden:");
        bst.mostrarInorden();

        System.out.println("\nBuscar 70:");
        System.out.println(bst.buscarConTraza(70));

        System.out.println("\nBuscar 75:");
        System.out.println(bst.buscarConTraza(75));

        // ----------------------------------------------------------
        // 15 CÓDIGOS EN ORDEN RAZONABLEMENTE DISTRIBUIDO
        // ----------------------------------------------------------
        int[] distribuidos = {
            48, 24, 72, 12, 36,
            60, 84, 6, 18, 30,
            42, 54, 66, 78, 90
        };

        ArbolBST bstDistribuido = new ArbolBST();
        for (int v : distribuidos) {
            bstDistribuido.insertar(v);
        }

        // ----------------------------------------------------------
        // 15 CÓDIGOS YA ORDENADOS
        // ----------------------------------------------------------
        int[] ordenados = {
            6, 12, 18, 24, 30,
            36, 42, 48, 54, 60,
            66, 72, 78, 84, 90
        };

        ArbolBST bstOrdenado = new ArbolBST();
        for (int v : ordenados) {
            bstOrdenado.insertar(v);
        }

        int[] consultas = {6, 42, 66, 90, 100};

        System.out.println("\n=== DATOS DISTRIBUIDOS ===");
        int compDistribuido = probarBusquedas(bstDistribuido, consultas);

        System.out.println("\n=== DATOS ORDENADOS ===");
        int compOrdenado = probarBusquedas(bstOrdenado, consultas);

        // ----------------------------------------------------------
        // COMPARACIÓN FINAL
        // ----------------------------------------------------------
        System.out.println("\n=== COMPARACIÓN ===");
        System.out.println(
            "Altura distribuido: " + bstDistribuido.altura()
        );
        System.out.println(
            "Altura ordenado: " + bstOrdenado.altura()
        );
        System.out.println(
            "Comparaciones distribuidas: " + compDistribuido
        );
        System.out.println(
            "Comparaciones ordenadas: " + compOrdenado
        );

        System.out.printf(
            "Promedio distribuido: %.2f%n",
            compDistribuido / (double) consultas.length
        );

        System.out.printf(
            "Promedio ordenado: %.2f%n",
            compOrdenado / (double) consultas.length
        );

        System.out.println(
            "\nConclusión: insertar datos ya ordenados puede "
            + "degenerar el BST y acercar búsqueda/inserción a O(n)."
        );
    }

    private static int probarBusquedas(
            ArbolBST arbol,
            int[] consultas) {

        int total = 0;

        for (int valor : consultas) {
            ResultadoBusqueda r = arbol.buscarConTraza(valor);
            System.out.println("Buscar " + valor + " -> " + r);
            total += r.getComparaciones();
        }

        return total;
    }
}
