//Ejercicio 1
#include <stdio.h>
#include <unistd.h>

int main(){
    printf("\nPrueba de procesos:\n");
    fork();
    printf("\tSe ha creado un proceso\n");
    return 1;
}

