/**
 * Guía 5. BST II: eliminación de nodos.
 *
 * Se prueban de forma independiente los tres casos:
 * 1. eliminación de una hoja;
 * 2. eliminación de un nodo con un hijo;
 * 3. eliminación de un nodo con dos hijos.
 *
 * El tercer caso elimina la raíz, cumpliendo además
 * el ejercicio adicional de la guía.
 */
public class Main {

    public static void main(String[] args) {

        probarCasoHoja();
        probarCasoUnHijo();
        probarCasoDosHijosYRaiz();
        probarValorInexistente();
    }

    // ==========================================================
    // CASO 1: ELIMINAR UNA HOJA
    // ==========================================================

    private static void probarCasoHoja() {

        System.out.println(
                "========================================"
        );
        System.out.println(
                "CASO 1: ELIMINAR NODO HOJA"
        );
        System.out.println(
                "========================================"
        );

        ArbolBST arbol = crearArbolBase();

        System.out.println(
                "\nANTES de eliminar 30:"
        );
        arbol.imprimirArbol();

        System.out.println(
                "\nInorden antes:"
        );
        arbol.mostrarInorden();

        arbol.eliminar(30);

        System.out.println(
                "\nDESPUÉS de eliminar 30:"
        );
        arbol.imprimirArbol();

        System.out.println(
                "\nInorden después:"
        );
        arbol.mostrarInorden();

        System.out.println(
                "¿BST válido?: "
                        + arbol.esBSTValido()
        );

        System.out.println(
                "¿30 existe?: "
                        + arbol.buscar(30)
        );

        System.out.println();
    }

    // ==========================================================
    // CASO 2: ELIMINAR UN NODO CON UN HIJO
    // ==========================================================

    private static void probarCasoUnHijo() {

        System.out.println(
                "========================================"
        );
        System.out.println(
                "CASO 2: ELIMINAR NODO CON UN HIJO"
        );
        System.out.println(
                "========================================"
        );

        /*
         * Se agrega 75 como hijo derecho de 70.
         *
         * Antes:
         *
         *        80
         *       /
         *      70
         *        \
         *         75
         *
         * Al eliminar 70, la referencia de 80
         * debe pasar directamente a 75.
         */
        ArbolBST arbol = crearArbolConNodoDeUnHijo();

        System.out.println(
                "\nANTES de eliminar 70:"
        );
        arbol.imprimirArbol();

        System.out.println(
                "\nInorden antes:"
        );
        arbol.mostrarInorden();

        arbol.eliminar(70);

        System.out.println(
                "\nDESPUÉS de eliminar 70:"
        );
        arbol.imprimirArbol();

        System.out.println(
                "\nInorden después:"
        );
        arbol.mostrarInorden();

        System.out.println(
                "¿BST válido?: "
                        + arbol.esBSTValido()
        );

        System.out.println(
                "¿70 existe?: "
                        + arbol.buscar(70)
        );

        System.out.println(
                "¿75 sigue existiendo?: "
                        + arbol.buscar(75)
        );

        System.out.println();
    }

    // ==========================================================
    // CASO 3: ELIMINAR UN NODO CON DOS HIJOS
    // Y, AL MISMO TIEMPO, ELIMINAR LA RAÍZ
    // ==========================================================

    private static void probarCasoDosHijosYRaiz() {

        System.out.println(
                "========================================"
        );
        System.out.println(
                "CASO 3: DOS HIJOS / ELIMINAR RAÍZ"
        );
        System.out.println(
                "========================================"
        );

        ArbolBST arbol = crearArbolBase();

        System.out.println(
                "\nANTES de eliminar la raíz 60:"
        );
        arbol.imprimirArbol();

        System.out.println(
                "\nInorden antes:"
        );
        arbol.mostrarInorden();

        /*
         * 60 tiene dos hijos.
         * Su sucesor inorden es el mínimo
         * del subárbol derecho: 70.
         */
        int sucesor =
                arbol.minValor(
                        arbol.getRaiz().getDerecho()
                );

        System.out.println(
                "\nSucesor inorden de 60: "
                        + sucesor
        );

        arbol.eliminar(60);

        System.out.println(
                "\nDESPUÉS de eliminar la raíz 60:"
        );
        arbol.imprimirArbol();

        System.out.println(
                "\nInorden después:"
        );
        arbol.mostrarInorden();

        System.out.println(
                "Nueva raíz: "
                        + arbol.getRaiz().getDato()
        );

        System.out.println(
                "¿BST válido?: "
                        + arbol.esBSTValido()
        );

        System.out.println(
                "¿60 existe?: "
                        + arbol.buscar(60)
        );

        System.out.println();
    }

    // ==========================================================
    // PRUEBA EXTRA: VALOR INEXISTENTE
    // ==========================================================

    private static void probarValorInexistente() {

        System.out.println(
                "========================================"
        );
        System.out.println(
                "PRUEBA EXTRA: ELIMINAR VALOR INEXISTENTE"
        );
        System.out.println(
                "========================================"
        );

        ArbolBST arbol = crearArbolBase();

        int antes = arbol.contarNodos();

        arbol.eliminar(500);

        int despues = arbol.contarNodos();

        System.out.println(
                "Nodos antes: " + antes
        );

        System.out.println(
                "Nodos después: " + despues
        );

        System.out.println(
                "¿BST válido?: "
                        + arbol.esBSTValido()
        );
    }

    // ==========================================================
    // ÁRBOLES DE PRUEBA
    // ==========================================================

    /**
     * BST base:
     *
     *          60
     *        /    \
     *      40      80
     *     /  \    /  \
     *   30   50  70   90
     */
    private static ArbolBST crearArbolBase() {

        int[] valores = {
                60, 40, 80, 30, 50, 70, 90
        };

        ArbolBST arbol = new ArbolBST();

        for (int valor : valores) {
            arbol.insertar(valor);
        }

        return arbol;
    }

    /**
     * BST con un nodo que tiene exactamente un hijo:
     *
     *          60
     *        /    \
     *      40      80
     *     /  \    /  \
     *   30   50  70   90
     *               \
     *                75
     *
     * El nodo 70 tiene un único hijo: 75.
     */
    private static ArbolBST crearArbolConNodoDeUnHijo() {

        int[] valores = {
                60, 40, 80, 30,
                50, 70, 90, 75
        };

        ArbolBST arbol = new ArbolBST();

        for (int valor : valores) {
            arbol.insertar(valor);
        }

        return arbol;
    }
}
