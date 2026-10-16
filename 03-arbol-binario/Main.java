/**
 * Guía 3: construcción manual de un árbol binario de 7 nodos.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Crear los siete nodos.
        NodoArbol<String> a = new NodoArbol<>("Gerente General");
        NodoArbol<String> b = new NodoArbol<>("Director Técnico");
        NodoArbol<String> c = new NodoArbol<>("Director Comercial");
        NodoArbol<String> d = new NodoArbol<>("Desarrollo");
        NodoArbol<String> e = new NodoArbol<>("Soporte");
        NodoArbol<String> f = new NodoArbol<>("Ventas");
        NodoArbol<String> g = new NodoArbol<>("Marketing");

        /*
         * 2. Enlazar las referencias:
         *
         *                 Gerente General
         *                /               \
         *      Director Técnico     Director Comercial
         *        /         \            /          \
         *  Desarrollo   Soporte      Ventas     Marketing
         *
         * Es binario, lleno, completo y perfecto.
         */
        a.setIzquierdo(b);
        a.setDerecho(c);

        b.setIzquierdo(d);
        b.setDerecho(e);

        c.setIzquierdo(f);
        c.setDerecho(g);

        // 3. Crear el objeto árbol.
        ArbolBinario<String> arbol = new ArbolBinario<>(a);

        // 4. Método solicitado por la guía. 
        System.out.println("=== RAÍZ E HIJOS ===");
        arbol.imprimirRaizYHijos();

        // 5. Mostrar toda la estructura.
        System.out.println("\n=== ÁRBOL COMPLETO ===");
        arbol.imprimirArbol();

        // 6. Probar propiedades.
        System.out.println("\n=== PROPIEDADES ===");
        System.out.println("Nodos: " + arbol.contarNodos());
        System.out.println("Hojas: " + arbol.contarHojas());
        System.out.println("Altura: " + arbol.altura());
        System.out.println("Grado de Gerente General: " + a.grado());
        System.out.println("¿Desarrollo es hoja?: " + d.esHoja());

        // 7. Prueba segura con null.
        System.out.println("\n=== CONTROL DE NULL ===");

        System.out.println(
            "Hijo izquierdo de Desarrollo: " + d.getIzquierdo()
        );

        if (d.getIzquierdo() != null) {
            System.out.println(d.getIzquierdo().getDato());
        } else {
            System.out.println(
                "Desarrollo no tiene hijo izquierdo; la referencia es null."
            );
        }

        // 8. Probar un árbol vacío.
        System.out.println("\n=== ÁRBOL VACÍO ===");
        ArbolBinario<Integer> vacio = new ArbolBinario<>();
        vacio.imprimirRaizYHijos();
    }
}