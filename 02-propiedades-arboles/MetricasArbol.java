import java.util.ArrayList;
import java.util.List;

/**
 * Algoritmos recursivos para medir un árbol general (n-ario).
 *
 * Convenciones:
 *  - La raíz tiene profundidad 0 y el nivel es igual a la profundidad.
 *  - Una hoja tiene altura 0.
 *  - La altura y la profundidad se miden en número de aristas.
 */
public class MetricasArbol {

    // ============================================================
    // GRADO
    // ============================================================

    /** Grado de un nodo = número de hijos directos. */
    public static int gradoNodo(NodoGeneral<?> nodo) {
        return nodo.getHijos().size();
    }

    /** Grado del árbol = el mayor grado que tenga alguno de sus nodos. */
    public static int gradoArbol(NodoGeneral<?> nodo) {
        // Se parte del grado del nodo actual
        int max = gradoNodo(nodo);

        // Se compara con el grado del árbol que cuelga de cada hijo
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            max = Math.max(max, gradoArbol(hijo));
        }
        return max;
    }

    // ============================================================
    // ALTURA
    // ============================================================

    /** altura(hoja) = 0; altura(nodo) = 1 + máxima altura de sus hijos. */
    public static int altura(NodoGeneral<?> nodo) {
        // Caso base: una hoja no tiene hijos, su altura es 0
        if (nodo.getHijos().isEmpty()) return 0;

        // Se busca el hijo con mayor altura
        int max = 0;
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            max = Math.max(max, altura(hijo));
        }

        // Se suma 1 por la arista que une al nodo con ese hijo
        return 1 + max;
    }

    // ============================================================
    // CONTEOS
    // ============================================================

    /** Total de nodos = 1 (el nodo actual) + los nodos de cada subárbol. */
    public static int contarNodos(NodoGeneral<?> nodo) {
        int total = 1;
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            total += contarNodos(hijo);
        }
        return total;
    }

    /** Hojas = nodos sin hijos. */
    public static int contarHojas(NodoGeneral<?> nodo) {
        // Caso base: el propio nodo es una hoja
        if (nodo.getHijos().isEmpty()) return 1;

        // Si tiene hijos, se suman las hojas de cada subárbol
        int total = 0;
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            total += contarHojas(hijo);
        }
        return total;
    }

    // ============================================================
    // PROFUNDIDAD Y CAMINOS
    // ============================================================

    /** Profundidad = aristas desde la raíz hasta el nodo (-1 si no está en el árbol). */
    public static int profundidad(NodoGeneral<?> raiz, NodoGeneral<?> nodo) {
        return profundidad(raiz, nodo, 0);
    }

    // Versión recursiva: "nivel" lleva la cuenta de las aristas recorridas
    private static int profundidad(NodoGeneral<?> actual, NodoGeneral<?> nodo, int nivel) {
        // Si el nodo actual es el buscado, el nivel acumulado es su profundidad
        if (actual == nodo) return nivel;

        // Si no, se busca en cada hijo sumando una arista
        for (NodoGeneral<?> hijo : actual.getHijos()) {
            int p = profundidad(hijo, nodo, nivel + 1);
            if (p != -1) return p;
        }
        return -1; // no está en este subárbol
    }

    /** Camino desde la raíz hasta el destino, como lista de nombres. */
    public static List<String> camino(NodoGeneral<?> raiz, NodoGeneral<?> destino) {
        List<String> ruta = new ArrayList<>();
        buscarCamino(raiz, destino, ruta);
        return ruta;
    }

    private static boolean buscarCamino(NodoGeneral<?> actual, NodoGeneral<?> destino, List<String> ruta) {
        // Se agrega el nodo actual al camino
        ruta.add(String.valueOf(actual.getDato()));

        // Si es el destino, el camino está completo
        if (actual == destino) return true;

        // Se intenta por cada hijo
        for (NodoGeneral<?> hijo : actual.getHijos()) {
            if (buscarCamino(hijo, destino, ruta)) return true;
        }

        // Este nodo no lleva al destino: se quita del camino y se retrocede
        ruta.remove(ruta.size() - 1);
        return false;
    }

    /** Longitud del camino = número de aristas = número de nodos - 1. */
    public static int longitudCamino(NodoGeneral<?> raiz, NodoGeneral<?> destino) {
        return camino(raiz, destino).size() - 1;
    }

    /** Convierte la lista del camino en un texto: A -> B -> C. */
    public static String rutaComoTexto(List<String> ruta) {
        return String.join(" -> ", ruta);
    }

    // ============================================================
    // IMPRESIÓN
    // ============================================================

    /** Imprime el árbol con sangría según el nivel (recorrido en preorden). */
    public static void mostrarArbol(NodoGeneral<?> nodo, int nivel) {
        // Dos espacios de sangría por cada nivel
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + nodo.getDato());

        // Se imprime cada hijo un nivel más adentro
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            mostrarArbol(hijo, nivel + 1);
        }
    }

    /** Imprime una tabla con tipo, grado, profundidad y altura de todos los nodos. */
    public static void mostrarTablaMetricas(NodoGeneral<?> raiz) {
        System.out.printf("%-26s %-9s %-6s %-12s %-6s%n",
                "Nodo", "Tipo", "Grado", "Profundidad", "Altura");
        recorrerTabla(raiz, raiz);
    }

    private static void recorrerTabla(NodoGeneral<?> raiz, NodoGeneral<?> nodo) {
        // Tipo del nodo: raíz, hoja o interno
        String tipo;
        if (nodo == raiz) {
            tipo = "Raíz";
        } else if (nodo.getHijos().isEmpty()) {
            tipo = "Hoja";
        } else {
            tipo = "Interno";
        }

        System.out.printf("%-26s %-9s %-6d %-12d %-6d%n",
                nodo.getDato(), tipo, gradoNodo(nodo), profundidad(raiz, nodo), altura(nodo));

        // Se continúa con los hijos
        for (NodoGeneral<?> hijo : nodo.getHijos()) {
            recorrerTabla(raiz, hijo);
        }
    }
}
