# Guía 5 – BST II: eliminación de nodos

**Asignatura:** Estructura de Datos II  
**Programas:** Ingeniería de Software – Ingeniería de Sistemas  
**Semestre:** IV  
**Ecosistema:** Java / GitHub

## Objetivo

Modificar un BST eliminando nodos sin romper su propiedad de ordenación.

## Casos de eliminación

### 1. Nodo hoja

Ejemplo: eliminar `30`.

Antes:

```text
        60
       /  \
     40    80
    / \    / \
   30 50  70 90
```

Después:

```text
        60
       /  \
     40    80
      \    / \
      50  70 90
```

La referencia del padre (`40`) hacia `30` pasa a `null`.

---

### 2. Nodo con un hijo

Para probar este caso se agrega `75` como hijo derecho de `70`.

Antes:

```text
        80
       /
      70
        \
         75
```

Al eliminar `70`:

```text
        80
       /
      75
```

La referencia izquierda de `80` pasa a apuntar directamente a `75`.

---

### 3. Nodo con dos hijos

Se elimina la raíz `60`.

Antes:

```text
        60
       /  \
     40    80
    / \    / \
   30 50  70 90
```

El sucesor inorden es `70`, porque es el mínimo del subárbol derecho.

Después:

```text
        70
       /  \
     40    80
    / \      \
   30 50      90
```

Pasos:

1. Buscar el sucesor inorden.
2. Copiar `70` en el nodo que contenía `60`.
3. Eliminar el `70` original del subárbol derecho.

## Archivos

- `NodoArbol.java`
- `ArbolBST.java`
- `Main.java`
- `salida_esperada.txt`

## Compilar

```bash
javac NodoArbol.java ArbolBST.java Main.java
```

## Ejecutar

```bash
java Main
```

## Método central

```java
public void eliminar(int valor) {
    raiz = eliminarRec(raiz, valor);
}
```

Es importante reasignar `raiz` porque el valor eliminado puede ser precisamente la raíz.

## Sucesor en inorden

```java
public int minValor(NodoArbol nodo) {
    NodoArbol actual = nodo;

    while (actual.getIzquierdo() != null) {
        actual = actual.getIzquierdo();
    }

    return actual.getDato();
}
```

## Cambios de referencias

- **Hoja:** la referencia del padre pasa a `null`.
- **Un hijo:** la referencia del padre pasa directamente al hijo del nodo eliminado.
- **Dos hijos:** el nodo conserva sus referencias principales, pero su dato se reemplaza por el sucesor; después se elimina la copia del sucesor.

## Validación

Después de cada prueba, el programa:

- imprime el árbol;
- ejecuta Inorden;
- confirma que el valor eliminado ya no existe;
- valida que la propiedad BST siga siendo correcta.
