# Guía 4 – BST I: inserción y búsqueda

**Asignatura:** Estructura de Datos II  
**Programas:** Ingeniería de Software – Ingeniería de Sistemas  
**Semestre:** IV  
**Ecosistema:** Java / GitHub

## Objetivo

Implementar inserción y búsqueda recursiva en un Árbol Binario de Búsqueda y analizar su eficiencia.

## Propiedad BST

- menor que el nodo actual → izquierda;
- mayor o igual → derecha.

## Ejercicio base

Valores:

```text
60, 40, 80, 30, 50, 70, 90
```

Árbol esperado:

```text
        60
       /  \
     40    80
    / \    / \
   30 50  70 90
```

Buscar `70` recorre:

```text
60 -> 80 -> 70
```

Buscar `75` recorre:

```text
60 -> 80 -> 70 -> null
```

## Archivos

- `NodoArbol.java`
- `ResultadoBusqueda.java`
- `ArbolBST.java`
- `Main.java`
- `salida_esperada.txt`
- `comparacion_bst.csv`

## Compilar

```bash
javac NodoArbol.java ResultadoBusqueda.java ArbolBST.java Main.java
```

## Ejecutar

```bash
java Main
```

## Análisis esperado

Un BST razonablemente balanceado puede aproximar sus búsquedas e inserciones a `O(log n)`.  
Si los datos se insertan ya ordenados, el árbol puede degenerarse y su altura acercarse a `n - 1`, por lo que las operaciones pueden acercarse a `O(n)`.
