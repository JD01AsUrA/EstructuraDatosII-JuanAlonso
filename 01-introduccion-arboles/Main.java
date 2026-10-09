public class Main {
    public static void main(String[] args) {
        // Nivel 0: raíz
        NodoGeneral<String> raiz = new NodoGeneral<>("Empresa");
        // Nivel 1
        NodoGeneral<String> tecnologia = new NodoGeneral<>("Tecnología");
        NodoGeneral<String> finanzas = new NodoGeneral<>("Finanzas");
        NodoGeneral<String> rrhh = new NodoGeneral<>("RRHH");
        raiz.agregarHijo(tecnologia);
        raiz.agregarHijo(finanzas);
        raiz.agregarHijo(rrhh);

        // Nivel 2
        NodoGeneral<String> desarrollo = new NodoGeneral<>("Desarrollo");
        NodoGeneral<String> infra = new NodoGeneral<>("Infraestructura");
        tecnologia.agregarHijo(desarrollo);
        tecnologia.agregarHijo(infra);
        finanzas.agregarHijo(new NodoGeneral<>("Contabilidad"));
        finanzas.agregarHijo(new NodoGeneral<>("Tesorería"));

        // Nivel 3
        NodoGeneral<String> backend = new NodoGeneral<>("Backend");
        NodoGeneral<String> frontend = new NodoGeneral<>("Frontend");
        desarrollo.agregarHijo(backend);
        desarrollo.agregarHijo(frontend);

        // Nivel 4
        NodoGeneral<String> apiPagos = new NodoGeneral<>("API de Pagos");
        NodoGeneral<String> autenticacion = new NodoGeneral<>("Servicio de Autenticación");
        NodoGeneral<String> appWeb = new NodoGeneral<>("Aplicación Web");
        backend.agregarHijo(apiPagos);
        backend.agregarHijo(autenticacion);
        frontend.agregarHijo(appWeb);

        // Nivel 5
        NodoGeneral<String> equipoPasarela = new NodoGeneral<>("Equipo Pasarela");
        NodoGeneral<String> equipoUI = new NodoGeneral<>("Equipo UI");
        apiPagos.agregarHijo(equipoPasarela);
        appWeb.agregarHijo(equipoUI);

        // Nivel 6
        NodoGeneral<String> celulaIntegraciones = new NodoGeneral<>("Célula Integraciones");
        NodoGeneral<String> celulaComponentes = new NodoGeneral<>("Célula Componentes");
        equipoPasarela.agregarHijo(celulaIntegraciones);
        equipoUI.agregarHijo(celulaComponentes);

        // Nivel 7
        celulaIntegraciones.agregarHijo(new NodoGeneral<>("Desarrollador Senior"));
        celulaIntegraciones.agregarHijo(new NodoGeneral<>("Desarrollador Junior"));
        celulaComponentes.agregarHijo(new NodoGeneral<>("Diseñador UI"));

        System.out.println("Raíz: " + raiz.getDato());
        imprimir(raiz, 0);
    }

    // Recorrido recursivo: imprime el nodo y luego cada hijo con más sangría
    private static <T> void imprimir(NodoGeneral<T> nodo, int nivel) {
        System.out.println("  ".repeat(nivel) + "- " + nodo.getDato());
        for (NodoGeneral<T> hijo : nodo.getHijos()) {
            imprimir(hijo, nivel + 1);
        }
    }
}