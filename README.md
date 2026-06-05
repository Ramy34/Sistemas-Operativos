# Proyectos de Sistemas Operativos

Este repositorio contiene varios proyectos y prácticas desarrolladas en Java orientados a la comprensión funcional de los Sistemas Operativos. Los proyectos abarcan la creación de simuladores de planificación de procesos, manejo de concurrencia mediante hilos y problemas clásicos de sincronización concurrente (Productor-Consumidor).

## Contenido del Repositorio

### 1. Simulador de Planificación de Procesos (Proyecto 1)
Este módulo simula la administración de la CPU y la memoria en un sistema, administrando múltiples procesos con base en su tamaño, tiempo de llegada y tiempos de ejecución.
* **Algoritmos implementados:**
  * **Round Robin:** Asignación equitativa de tiempo de CPU a cada proceso usando un *quantum* definido por el usuario.
  * **Planificador por Prioridades Apropiativo:** Asignación de CPU donde los procesos con mayor prioridad interrumpen y desplazan a procesos de menor prioridad en ejecución.
* **Características:**
  * Gestión y validación de memoria RAM simulada (comprobando que el proceso "quepa" en memoria para ser admitido).
  * Cálculos estadísticos: tiempo promedio de ejecución, tiempo de espera y tiempo de respuesta.

### 2. Multiplicación de Matrices Concurrente (Examen 1)
Aplicación que divide y paraleliza el esfuerzo de operaciones matriciales haciendo uso intensivo de la clase `Thread` en Java.
* Generación de datos de matrices gestionada por hilos individuales por cada renglón/columna.
* Cálculo simultáneo para la trasposición de las matrices `A` y `B`.
* Multiplicación final ejecutada y sincronizada de forma concurrente, usando `join()` para asegurar la correcta secuenciación temporal.

### 3. Sincronización de Línea de Ensamblaje Automotriz (Examen 2)
Simulación del problema clásico del *Productor-Consumidor* aplicado a una cadena de montaje de autos.
* **Componentes:**
  * **Robots Generadores:** Hilos independientes que actúan como "productores" creando cajuelas, defensas, puertas y parabrisas a distintos ritmos.
  * **Robots Pintores:** Toman las piezas generadas para prepararlas y pasarlas a la siguiente cola de producción.
  * **Robots Ensambladores:** Reúnen las 4 piezas necesarias para construir un automóvil y lo envían a la bodega final.
  * **Bodega Segura (`ColaBodega`):** Actúa como un monitor de recurso compartido con capacidad máxima. Emplea bloques `synchronized` y los métodos `wait()` y `notifyAll()` para pausar la producción si la bodega está llena y despertarla al vaciarse, evitando condiciones de carrera.

### 4. Estructuras de Datos Base
Implementación de estructuras TDA en Java (como `Cola_LSE` basada en listas simplemente ligadas con referencias frontales y traseras) para manejar de forma robusta las colas de espera en los diferentes planificadores y fábricas de autos.

## Tecnologías y Conceptos Clave
* **Lenguaje:** Java (SE)
* **Programación:** Orientada a Objetos (POO)
* **Concurrencia:** Multithreading y ciclos de vida de hilos (`start()`, `join()`).
* **Sincronización Avanzada:** Monitores, bloqueo de estado (`synchronized`), y comunicación inter-hilos (`wait()`, `notifyAll()`).

## Ejecución
Cada módulo se puede ejecutar de forma independiente desde su respectiva clase con método `main()` (por ejemplo, los archivos `Menu.java` o `SimuladorMejorado.java`). Se debe compilar usando `javac` e iniciar en la JVM con `java`.