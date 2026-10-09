# Guía 1: De lo lineal a lo jerárquico

**Asignatura:** Estructura de Datos II – Ingeniería de Software, IV semestre  
**Autor:** [Juan David Alonso Tiria]  
**Repositorio GitHub:** [Enlace a tu repositorio]  

---

##  Objetivo

Reconocer la necesidad de las estructuras de datos no lineales frente a las lineales y representar un problema del mundo real (un organigrama empresarial) mediante una estructura jerárquica implementada en Java.

---

##  Clasificación de Escenarios

| Escenario | Tipo de Estructura | Justificación Técnica |
| ------------------------------------------------------- |
| **Sistema de archivos** | Jerárquico | Un directorio o carpeta puede contener múltiples subcarpetas y archivos, pero cada elemento reside exclusivamente en una única ubicación contenedora (relación $1:N$ estricta). |
| **Organigrama empresarial** | Jerárquico | La autoridad y supervisión fluyen desde una raíz (Dirección/Gerencia). Un jefe puede supervisar a $N$ empleados, pero cada empleado reporta únicamente a un jefe directo. |
| **Menú de aplicación** | Jerárquico | Las opciones se ramifican en submenús mediante niveles de navegación jerárquicos. Aunque dentro del mismo nivel las opciones están ordenadas secuencialmente, la estructura global es un árbol. |
| **Árbol genealógico** | Mixto (Grafo) | Desde la perspectiva de descendencia parece un árbol; sin embargo, dado que cada individuo posee exactamente dos progenitores (múltiples padres), rompe la restricción de raíz única y se modela formalmente como un **Grafo**. |

---

##  Contenido del Proyecto

- `NodoGeneral.java`: Clase genérica `NodoGeneral<T>` que encapsula el dato y gestiona una colección dinámica de hijos (`List<NodoGeneral<T>>`).
- `Main.java`: Clase principal que instancia la estructura jerárquica (organigrama con 10 nodos distribuídos en 4 niveles) y ejecuta el recorrido en consola.
- `diagrama.drawio` / `diagrama.pdf`: Representación gráfica del árbol jerárquico diseñado en Draw.io.

---

##  Compilación y Ejecución

Para compilar y ejecutar el proyecto desde la terminal:

```bash
# Compilar el código fuente
javac *.java

# Ejecutar la aplicación
java Main
💻 Salida esperada en ConsolaPlaintextEstructura Jerárquica del Organigrama Empresarial:
- Empresa (Nivel 0 - Raíz)
  ├── Tecnología (Nivel 1)
  │   ├── Desarrollo (Nivel 2)
  │   │   ├── Backend (Nivel 3)
  │   │   └── Frontend (Nivel 3)
  │   └── Infraestructura (Nivel 2)
  ├── Finanzas (Nivel 1)
  │   ├── Contabilidad (Nivel 2)
  │   └── Tesorería (Nivel 2)
  └── RRHH (Nivel 1)
📐 Decisiones de Diseño e ImplementaciónUso de Genéricos (<T>): Permite reutilizar la estructura NodoGeneral con cualquier tipo de objeto (cadenas, objetos de tipo Empleado, números, etc.).Lista de Hijos Dinámica (ArrayList): Garantiza que un nodo pueda albergar desde cero hasta $N$ descendientes sin dimensiones fijas en memoria.Recorrido Recursivo: Se implementó un algoritmo de recorrido en profundidad (DFS) para imprimir la jerarquía y aplicar sangrado según el nivel de profundidad.