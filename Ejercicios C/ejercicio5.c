//Ejercicio 5
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    switch(pid = fork()) {
        case - 1: printf("\nError al crear el proceso\n");
                  exit(0);
                  break;
        case 0: printf ("Soy el proceso hijo (pid = %i) y mi padre es (pid = %i)\n",getpid() ,getppid() );
                break;
        default:
                printf("Soy el proceso padre(pid = %i) y mi hijo es pid = %i)\n",getpid() , pid);
             break;
      }
    return 0;
}
