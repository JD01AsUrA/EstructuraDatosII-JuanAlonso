# Guía 1: De lo lineal a lo jerárquico

**Asignatura:** Estructura de Datos II – Ingeniería de Software, IV semestre
**Autor:** _Juan David Alonso_

## Objetivo

Reconocer la necesidad de las estructuras de datos no lineales y representar un problema real (un organigrama) mediante una estructura jerárquica implementada en Java.

## Clasificación de escenarios

| Escenario | Tipo | Justificación |
|---|---|---|
| Sistema de archivos | Jerárquico | Una carpeta contiene varias carpetas y archivos, y cada elemento está dentro de una sola carpeta. |
| Organigrama | Jerárquico | Un jefe tiene varios subordinados y cada empleado reporta a un único jefe. |
| Menú de aplicación | Jerárquico | Las opciones se ramifican en submenús; solo las opciones de un mismo nivel forman una secuencia. |
| Árbol genealógico | Mixto | Desde un ancestro hacia abajo parece árbol, pero cada persona tiene dos padres, por lo que es un grafo. |

## Contenido

- `NodoGeneral.java`: nodo genérico con un dato y una lista de hijos.
- `Main.java`: construye una jerarquía de 20 nodos y 8 niveles (0 a 7) y la imprime.
- `diagrama.drawio`: árbol del organigrama modelado en Draw.io.

## Cómo ejecutar (Java 11 o superior)

```bash
javac *.java
java Main
```

## Resultado de la ejecución

_Pega aquí una captura de pantalla de la consola con la salida del programa._

Salida esperada:

```
Raíz: Empresa
- Empresa
  - Tecnología
    - Desarrollo
      - Backend
        - API de Pagos
          - Equipo Pasarela
            - Célula Integraciones
              - Desarrollador Senior
              - Desarrollador Junior
        - Servicio de Autenticación
      - Frontend
        - Aplicación Web
          - Equipo UI
            - Célula Componentes
              - Diseñador UI
    - Infraestructura
  - Finanzas
    - Contabilidad
    - Tesorería
  - RRHH
```

## Decisiones de diseño

- `NodoGeneral<T>` es genérico para poder reutilizarlo con cualquier tipo de dato.
- Los hijos se guardan en un `ArrayList`, porque un nodo puede tener un número variable de hijos.
- `imprimir` es recursivo: muestra el nodo y luego cada hijo con una sangría mayor según el nivel.

## Respuestas a los ejercicios

1. **Ventajas del árbol frente a una lista:** (a) la relación padre-hijo queda explícita en la estructura; (b) permite buscar solo en la rama necesaria en lugar de revisar todos los elementos.
2. **Nodo con más de un padre:** dejaría de ser un árbol y pasaría a ser un grafo: no habría raíz única, aparecerían varios caminos hacia un mismo nodo y posibles ciclos, y los recorridos recursivos tendrían que registrar nodos visitados.

## Reflexión

Al comparar los cuatro escenarios entendí que las estructuras lineales funcionan bien cuando los datos tienen un orden único, como una cola de turnos o una pila de acciones. Sin embargo, cuando un elemento puede tener varios descendientes, como una carpeta con subcarpetas o un jefe con varios subordinados, una lista obliga a recorrer todo o a duplicar información. El árbol resuelve esto porque cada nodo guarda sus hijos y la relación padre-hijo queda explícita. Además, permite recorrer solo la rama necesaria y representar niveles de profundidad. Implementé NodoGeneral de forma genérica, con una lista de hijos, lo que permite reutilizarlo con cualquier tipo de dato. También noté que el árbol genealógico no es un árbol estricto, pues cada persona tiene dos padres, lo que rompe la regla de un único padre y lo convierte en un grafo. Esto me mostró que elegir la estructura correcta depende de las relaciones reales del problema y que los árboles son la base de estructuras posteriores como los árboles binarios.
