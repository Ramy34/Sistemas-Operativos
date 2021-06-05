//Ejercicio 2
#include <stdio.h>
#include <unistd.h>

int main(){
    int pid;
    printf("\nPrueba de procesos:\n");
    
    fork();
    printf("\tSe ha creado un proceso: padre = %i, yo = %i\n",getppid(),getpid());
    //waitpid(-1,NULL,0);
    return 1;

}
