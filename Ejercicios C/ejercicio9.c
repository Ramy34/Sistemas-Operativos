#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
	pid_t pid;
	int proceso,nieto=2,hijo=0;
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
            		
            		if(hijo == 0){
            			while(nieto > 0){
            			switch(pid = fork()){
            				case -1: printf("\nError al crear el proceso");
            					exit(0);
            					break;
            				case 0: printf("Soy el proceso nieto (pid = %i) y mi padre es (pid = %i)\n",getpid() ,getppid() );
            						exit(0);
            						break;
            				default :
            				nieto --;
            				sleep(2);
            				break;
            			}
            		}
            	}
            	exit(0);
            	break;
            default :
            	hijo ++;
            	proceso --;
            	sleep(4);
            	break;
		}
	}
	printf("\n\n");



	return 0;
}