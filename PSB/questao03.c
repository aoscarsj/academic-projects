//Multiplicacao de matrizAes n x n utilizando ponteiros

#include <stdio.h>
#include <stdlib.h>
#define N 3
//int **alocarmatrizA();
int main(){
	int **matrizA, **matrizB, i , j,k, resultado;

	matrizA = malloc (N * sizeof(int *));
	matrizB = malloc (N * sizeof(int *));
	if(matrizA == NULL || matrizB == NULL){
		printf("Falha na alocacao de memoria!\n" );
		return 0;
	}
	for(int i=0;i<N;i++){
		*(matrizA+i) = malloc (N*sizeof(int));
		*(matrizB+i) = malloc(N*sizeof(int));

		if( *(matrizA+i)  == NULL || *(matrizB+i)  == NULL ){
			printf("Falha na alocacao de memoria! Programa esta sendo encerrado!\n");
			return 0;
		}
	}
	//lendo valores da matriz A
	for(i=0;i<N;i++)
		for(j=0;j<N;j++)
			scanf("%d", &*(*(matrizA+i)+j));

	//lendo valores da matriz B
	for(i=0;i<N;i++)
		for(j=0;j<N;j++)
			scanf("%d", &*(*(matrizB+i)+j));
	// pensar na logica da mult de matrizes.
	for(k = 0;k<N;k++){
		resultado = 0;
		for(i=0;i<N;i++){
			resultado += ( (*(*(matrizA+k)+i)) * (*( *(matrizB+i) +k)) );

		}
		printf("%d\n", resultado);

	}
	for(int i =0 ;i<N;i++){
		for(int j =0; j<N;j++){

			printf("%d ",  *(*(matrizA+i)+j)   );
		}
		printf("\n" );
	}
	// int cont = 0;
	// for(int i = 0 ; i< N; i ++){
	// 	for(int j=0;j<N;j++){
	// 		(*( (*(matrizA+i)) + j) )= cont++;
	// 	}
	// }
	return 0;
}

/*int **alocarmatrizAA(){
	int **p;

}*/
/* caso 1 res esperado
30	36	42
66	81	96
102	126	150
*/
