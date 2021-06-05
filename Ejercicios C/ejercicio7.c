#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
	pid_t pid;
	int proceso;
	printf("Dame el número de procesos: ");
	scanf("%i",&proceso);
	printf("\nSoy el proceso principal: %i", getpid());
	printf("\nNúmero de procesos: %i\n",proceso);
	while(proceso > 0){
		switch(pid = fork()){
			case -1: printf("\nError al crear el proceso");
                    exit(0);
                    break;
            case 0: printf("Soy el proceso hijo (pid = %i) y mi padre es (pid = %i)\n",getpid() ,getppid() );
                    proceso --;
                    break;
            default :
            	sleep(2);
            	exit(0);
            	break;
		}
	}
	//printf("\n\n");
	return 0;
}