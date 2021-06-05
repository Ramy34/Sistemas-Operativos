#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
	pid_t pid;
	int proceso,hijo=2;
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
            		while(hijo > 0){
            			switch(pid = fork()){
            				case -1: printf("\nError al crear el proceso");
            					exit(0);
            					break;
            				case 0: printf("Soy el proceso nieto (pid = %i) y mi padre es (pid = %i)\n",getpid() ,getppid() );
            						exit(0);
            						break;
            				default :
            				hijo --;
            				sleep(2);
            				break;
            			}
            		}
                    //proceso --;
            		exit(0);
                    break;
            default :
            	proceso --;
            	sleep(4);
            	break;
		}
	}
	printf("\n\n");
	return 0;
}