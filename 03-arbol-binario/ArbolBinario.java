/**
 * Árbol binario: guarda la referencia a la raíz y ofrece operaciones básicas.
 *
 * Convenciones:
 *  - La raíz tiene profundidad 0.
 *  - Una hoja tiene altura 0.
 *  - Un árbol vacío (raíz null) tiene altura -1 y 0 nodos.
 *
 * @param <T> tipo del dato almacenado en los nodos
 */
public class ArbolBinario<T> {

    // ============================================================
    // ATRIBUTO
    // ============================================================

    private NodoArbol<T> raiz;   // nodo superior del árbol (null si está vacío)

    // ============================================================
    // CONSTRUCTORES
    // ============================================================

    /** Crea un árbol vacío. */
    public ArbolBinario() {
        this.raiz = null;
    }

    /** Crea un árbol a partir de una raíz ya construida. */
    public ArbolBinario(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    // ============================================================
    // GETTER, SETTER Y ESTADO
    // ============================================================

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    /** El árbol está vacío cuando no tiene raíz. */
    public boolean estaVacio() {
        return raiz == null;
    }

    // ============================================================
    // IMPRESIÓN
    // ============================================================

    /** Imprime la raíz y sus dos hijos. */
    public void imprimirRaizYHijos() {
        // Si no hay raíz, no hay nada que mostrar (evita NullPointerException)
        if (estaVacio()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.out.println("Raíz: " + raiz.getDato());
        System.out.println("Hijo izquierdo: " + describir(raiz.getIzquierdo()));
        System.out.println("Hijo derecho: " + describir(raiz.getDerecho()));
    }

    // Devuelve el dato del nodo, o un texto si el nodo no existe (null)
    private String describir(NodoArbol<T> nodo) {
        return nodo == null ? "(sin hijo)" : String.valueOf(nodo.getDato());
    }

    /** Imprime todo el árbol con sangría, indicando si cada nodo es izq o der. */
    public void imprimirArbol() {
        if (estaVacio()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.out.println(raiz.getDato());
        imprimirHijos(raiz, "");
    }

    // Imprime los hijos de "nodo" (primero el izquierdo, luego el derecho).
    // "prefijo" acumula la sangría y las barras de las ramas superiores.
    private void imprimirHijos(NodoArbol<T> nodo, String prefijo) {
        boolean hayIzq = nodo.getIzquierdo() != null;
        boolean hayDer = nodo.getDerecho() != null;

        if (hayIzq) {
            // Si también hay hijo derecho, la rama del izquierdo sigue "abierta"
            String conector = hayDer ? "+-- " : "\\-- ";
            System.out.println(prefijo + conector + "(izq) " + nodo.getIzquierdo().getDato());
            imprimirHijos(nodo.getIzquierdo(), prefijo + (hayDer ? "|   " : "    "));
        }

        if (hayDer) {
            System.out.println(prefijo + "\\-- (der) " + nodo.getDerecho().getDato());
            imprimirHijos(nodo.getDerecho(), prefijo + "    ");
        }
    }

    // ============================================================
    // PROPIEDADES (recursivas)
    // ============================================================

    /** Total de nodos del árbol. */
    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoArbol<T> nodo) {
        // Caso base: una referencia null no aporta ningún nodo
        if (nodo == null) return 0;

        // 1 (el nodo actual) + nodos del subárbol izquierdo + nodos del derecho
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    /** Total de hojas (nodos sin hijos). */
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(NodoArbol<T> nodo) {
        // Caso base 1: referencia null, no hay hoja
        if (nodo == null) return 0;

        // Caso base 2: nodo sin hijos, es una hoja
        if (nodo.esHoja()) return 1;

        // Si tiene hijos, se suman las hojas de cada subárbol
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    /** Altura del árbol en aristas (hoja = 0, árbol vacío = -1). */
    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoArbol<T> nodo) {
        // Caso base: un subárbol vacío mide -1, así una hoja resulta 1 + (-1) = 0
        if (nodo == null) return -1;

        // 1 por la arista hacia el hijo + altura del hijo más alto
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }
}