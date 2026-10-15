public class Main {

    public static void main(String[] args) {

        // ============================================================
        // 1. CREACIÓN DE LOS NODOS
        // ============================================================

        // Nivel 0: la raíz (no tiene padre)
        NodoGeneral<String> rectoria =
                new NodoGeneral<>("Rectoría");

        // Nivel 1
        NodoGeneral<String> facIngenieria =
                new NodoGeneral<>("Facultad de Ingeniería");

        NodoGeneral<String> facCiencias =
                new NodoGeneral<>("Facultad de Ciencias");

        NodoGeneral<String> administracion =
                new NodoGeneral<>("Administración");

        // Nivel 2
        NodoGeneral<String> progSoftware =
                new NodoGeneral<>("Programa de Software");

        NodoGeneral<String> progSistemas =
                new NodoGeneral<>("Programa de Sistemas");

        NodoGeneral<String> matematicas =
                new NodoGeneral<>("Matemáticas");

        NodoGeneral<String> fisica =
                new NodoGeneral<>("Física");

        NodoGeneral<String> talentoHumano =
                new NodoGeneral<>("Talento Humano");

        NodoGeneral<String> finanzas =
                new NodoGeneral<>("Finanzas");

        // Nivel 3
        NodoGeneral<String> coordinacion =
                new NodoGeneral<>("Coordinación Académica");

        NodoGeneral<String> laboratorios =
                new NodoGeneral<>("Laboratorios");

        // Nivel 4
        NodoGeneral<String> docente =
                new NodoGeneral<>("Docente");

        NodoGeneral<String> monitor =
                new NodoGeneral<>("Monitor");

        // ============================================================
        // 2. CONSTRUCCIÓN DE LA JERARQUÍA
        // (agregarHijo(x) crea la relación padre -> hijo)
        // ============================================================

        // La raíz tiene tres hijos
        rectoria.agregarHijo(facIngenieria);
        rectoria.agregarHijo(facCiencias);
        rectoria.agregarHijo(administracion);

        // Hijos de la Facultad de Ingeniería
        facIngenieria.agregarHijo(progSoftware);
        facIngenieria.agregarHijo(progSistemas);

        // Hijos de la Facultad de Ciencias
        facCiencias.agregarHijo(matematicas);
        facCiencias.agregarHijo(fisica);

        // Hijos de Administración
        administracion.agregarHijo(talentoHumano);
        administracion.agregarHijo(finanzas);

        // Hijos del Programa de Software
        progSoftware.agregarHijo(coordinacion);
        progSoftware.agregarHijo(laboratorios);

        // Hijos de la Coordinación Académica
        coordinacion.agregarHijo(docente);
        coordinacion.agregarHijo(monitor);

        // ============================================================
        // 3. MOSTRAR EL ÁRBOL
        // ============================================================

        System.out.println("=== ÁRBOL ORGANIZACIONAL ===");
        MetricasArbol.mostrarArbol(rectoria, 0);

        // ============================================================
        // 4. PROPIEDADES GENERALES
        // ============================================================

        System.out.println();
        System.out.println("=== PROPIEDADES DEL ÁRBOL ===");

        System.out.println(
                "Raíz: " + rectoria.getDato()
        );

        System.out.println(
                "Número total de nodos: "
                        + MetricasArbol.contarNodos(rectoria)
        );

        System.out.println(
                "Número de hojas: "
                        + MetricasArbol.contarHojas(rectoria)
        );

        // Nodos internos = total de nodos - hojas
        System.out.println(
                "Número de nodos internos: "
                        + (MetricasArbol.contarNodos(rectoria)
                        - MetricasArbol.contarHojas(rectoria))
        );

        System.out.println(
                "Grado del árbol: "
                        + MetricasArbol.gradoArbol(rectoria)
        );

        System.out.println(
                "Altura del árbol: "
                        + MetricasArbol.altura(rectoria)
        );

        // Niveles = altura + 1, porque la raíz es el nivel 0
        System.out.println(
                "Número de niveles: "
                        + (MetricasArbol.altura(rectoria) + 1)
        );

        // ============================================================
        // 5. PROFUNDIDAD DE CINCO NODOS
        // (cuántas aristas hay entre la raíz y cada nodo)
        // ============================================================

        System.out.println();
        System.out.println("=== PROFUNDIDAD DE CINCO NODOS ===");

        mostrarProfundidad(rectoria, rectoria);
        mostrarProfundidad(rectoria, facCiencias);
        mostrarProfundidad(rectoria, progSoftware);
        mostrarProfundidad(rectoria, laboratorios);
        mostrarProfundidad(rectoria, docente);

        // ============================================================
        // 6. GRADO DE ALGUNOS NODOS
        // (grado = número de hijos del nodo)
        // ============================================================

        System.out.println();
        System.out.println("=== GRADO DE ALGUNOS NODOS ===");

        mostrarGrado(rectoria);
        mostrarGrado(facIngenieria);
        mostrarGrado(progSoftware);
        mostrarGrado(coordinacion);
        mostrarGrado(docente);

        // ============================================================
        // 7. TABLA COMPLETA DE MÉTRICAS
        // (se compara con la tabla calculada a mano)
        // ============================================================

        System.out.println();
        System.out.println("=== TABLA DE MÉTRICAS ===");
        MetricasArbol.mostrarTablaMetricas(rectoria);

        // ============================================================
        // 8. PROFUNDIDAD DE CADA HOJA (Ejercicio 1)
        // ============================================================

        System.out.println();
        System.out.println("=== PROFUNDIDAD DE CADA HOJA ===");

        mostrarProfundidad(rectoria, docente);
        mostrarProfundidad(rectoria, monitor);
        mostrarProfundidad(rectoria, laboratorios);
        mostrarProfundidad(rectoria, progSistemas);
        mostrarProfundidad(rectoria, matematicas);
        mostrarProfundidad(rectoria, fisica);
        mostrarProfundidad(rectoria, talentoHumano);
        mostrarProfundidad(rectoria, finanzas);

        // ============================================================
        // 9. DOS CAMINOS Y SU LONGITUD (Ejercicio 2)
        // (la longitud se mide en aristas)
        // ============================================================

        System.out.println();
        System.out.println("=== CAMINOS ===");

        mostrarCamino(rectoria, docente);
        mostrarCamino(rectoria, finanzas);

        // ============================================================
        // 10. COMPARACIÓN MANUAL VS. CÓDIGO
        // (los valores manuales salen de la tabla del README)
        // ============================================================

        System.out.println();
        System.out.println("=== COMPARACIÓN MANUAL VS. JAVA ===");

        comparar("Número de nodos", 14, MetricasArbol.contarNodos(rectoria));
        comparar("Número de hojas", 8, MetricasArbol.contarHojas(rectoria));
        comparar("Grado del árbol", 3, MetricasArbol.gradoArbol(rectoria));
        comparar("Altura del árbol", 4, MetricasArbol.altura(rectoria));
        comparar("Profundidad de Docente", 4, MetricasArbol.profundidad(rectoria, docente));
        comparar("Longitud camino a Finanzas", 2, MetricasArbol.longitudCamino(rectoria, finanzas));

        // ============================================================
        // 11. MODIFICACIÓN: AGREGAR UN NUEVO NIVEL (Ejercicio 3)
        // ============================================================

        System.out.println();
        System.out.println("=== MODIFICACIÓN DEL ÁRBOL ===");

        System.out.println(
                "Altura inicial: "
                        + MetricasArbol.altura(rectoria)
        );

        // Caso A: Laboratorios está en el nivel 3, su hijo quedaría en el
        // nivel 4. Ese nivel ya existe (Docente y Monitor), así que la
        // altura del árbol no debería cambiar.
        laboratorios.agregarHijo(new NodoGeneral<>("Equipo de Pruebas"));

        System.out.println(
                "Altura tras agregar un hijo a Laboratorios: "
                        + MetricasArbol.altura(rectoria)
        );

        // Caso B: Docente está en el nivel 4, su hijo quedaría en el
        // nivel 5. Ese nivel no existía, así que la altura aumenta en 1.
        docente.agregarHijo(new NodoGeneral<>("Asignatura"));

        System.out.println(
                "Altura tras agregar un hijo a Docente: "
                        + MetricasArbol.altura(rectoria)
        );

        System.out.println(
                "Número de niveles ahora: "
                        + (MetricasArbol.altura(rectoria) + 1)
        );

        System.out.println(
                "Número total de nodos ahora: "
                        + MetricasArbol.contarNodos(rectoria)
        );

        // Las alturas de los ancestros de Docente también aumentaron
        System.out.println("Alturas de los ancestros de Docente:");
        mostrarAltura(docente);
        mostrarAltura(coordinacion);
        mostrarAltura(progSoftware);
        mostrarAltura(facIngenieria);
        mostrarAltura(rectoria);
    }

    // ============================================================
    // MÉTODOS AUXILIARES DE IMPRESIÓN
    // ============================================================

    // Imprime la profundidad de un nodo respecto a la raíz
    private static void mostrarProfundidad(
            NodoGeneral<?> raiz,
            NodoGeneral<?> nodo) {

        System.out.printf(
                "%-28s -> %d%n",
                nodo.getDato(),
                MetricasArbol.profundidad(raiz, nodo)
        );
    }

    // Imprime el grado (número de hijos) de un nodo
    private static void mostrarGrado(
            NodoGeneral<?> nodo) {

        System.out.printf(
                "%-28s -> %d%n",
                nodo.getDato(),
                MetricasArbol.gradoNodo(nodo)
        );
    }

    // Imprime la altura de un nodo
    private static void mostrarAltura(
            NodoGeneral<?> nodo) {

        System.out.printf(
                "  %-26s -> %d%n",
                nodo.getDato(),
                MetricasArbol.altura(nodo)
        );
    }

    // Imprime el camino desde la raíz hasta el destino y su longitud
    private static void mostrarCamino(
            NodoGeneral<?> raiz,
            NodoGeneral<?> destino) {

        var ruta =
                MetricasArbol.camino(raiz, destino);

        System.out.println(
                MetricasArbol.rutaComoTexto(ruta)
        );

        System.out.println(
                "Longitud: "
                        + MetricasArbol.longitudCamino(
                                raiz,
                                destino
                        )
                        + " aristas"
        );
    }

    // Compara un valor calculado a mano con el que calcula Java
    private static void comparar(
            String metrica,
            int manual,
            int calculado) {

        System.out.printf(
                "%-28s manual: %-3d Java: %-3d %s%n",
                metrica,
                manual,
                calculado,
                manual == calculado ? "COINCIDEN" : "REVISAR CÁLCULO"
        );
    }
}
