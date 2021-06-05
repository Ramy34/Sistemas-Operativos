#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
    pid_t pid;
    int hijo;
    printf("Dame el número de hijos: ");
    scanf("%i",&hijo);
    printf("\nSoy el proceso principal: %i", getpid());
    printf("\nNúmero de hijos: %i\n",hijo);
    while(hijo > 0){
        switch(pid = fork()){
            case -1: printf("\nError al crear el proceso");
                    exit(0);
                    break;
            case 0: printf("Soy el proceso hijo (pid = %i) y mi padre es (pid = %i)\n",getpid() ,getppid() );
                    exit(0);
                    break;
            default:
                    hijo --;
                    sleep(2);
                    break;


























}
    










}
