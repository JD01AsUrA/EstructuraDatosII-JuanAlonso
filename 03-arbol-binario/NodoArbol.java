/**
 * Nodo de un árbol binario.
 *
 * Cada nodo guarda:
 *  - un dato de tipo genérico T,
 *  - una referencia al hijo izquierdo,
 *  - una referencia al hijo derecho.
 *
 * Si un hijo no existe, su referencia vale null.
 *
 * @param <T> tipo del dato almacenado en el nodo
 */
public class NodoArbol<T> {

    // ============================================================
    // ATRIBUTOS
    // ============================================================

    private T dato;                    // información que guarda el nodo
    private NodoArbol<T> izquierdo;    // hijo izquierdo (null si no existe)
    private NodoArbol<T> derecho;      // hijo derecho (null si no existe)

    // ============================================================
    // CONSTRUCTORES
    // ============================================================

    /** Crea un nodo hoja: tiene dato, pero no tiene hijos. */
    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    /** Crea un nodo indicando también sus dos hijos (pueden ser null). */
    public NodoArbol(T dato, NodoArbol<T> izquierdo, NodoArbol<T> derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    // ============================================================
    // GETTERS Y SETTERS
    // ============================================================

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol<T> derecho) {
        this.derecho = derecho;
    }

    // ============================================================
    // MÉTODOS BÁSICOS
    // ============================================================

    /** Una hoja es un nodo sin hijos. */
    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }

    /** ¿Tiene hijo izquierdo? */
    public boolean tieneIzquierdo() {
        return izquierdo != null;
    }

    /** ¿Tiene hijo derecho? */
    public boolean tieneDerecho() {
        return derecho != null;
    }

    /** Grado = número de hijos del nodo (en un árbol binario va de 0 a 2). */
    public int grado() {
        int grado = 0;
        if (izquierdo != null) grado++;
        if (derecho != null) grado++;
        return grado;
    }

    /** Permite imprimir el nodo directamente: muestra su dato (o "null"). */
    @Override
    public String toString() {
        return String.valueOf(dato);
    }
}