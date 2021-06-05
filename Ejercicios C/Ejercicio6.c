//Ejercicio 6
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
    int hijo,i,padre,aux;
    printf("Dame el número de hijos: ");
    scanf("%i",&hijo);
    printf("\nSoy el proceso principal: %i", getpid());
    padre = getpid();
    printf("\nNúmero de hijos: %i\n",hijo);
    sleep(2);
    for(i=0; i<hijo; i++){
        fork();
        if(getpid() == padre){
            printf("Soy el proceso hijo (pid = %i) y mi padre es (pid = %i)\n",getpid() ,getppid() );
        }
    }
    return 1;
}
