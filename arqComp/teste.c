#include <stdio.h>
#include <math.h>
#include <omp.h>
/* compile
   export OMP_NUM_THREADS=4
   time ./codigo3-16 < in10000000 
*/
int main(int argc, char *argv[]) {
   
    // #pragma omp nome [cláusulas] 
    //bloco
    int nthreads, tid;
    // if verifica se a condicao eh verdadeira antes de criar, se sim cria
    // num_threads(int n) cria n threads
    
//    #pragma omp parallel private(nthreads, tid) num_threads(8) /*if(1==0)*/
//    { //descobre e imprime o id do Thread
//      tid = omp_get_thread_num();
//      printf("Alo da thread = %d\n", tid);
//      if (tid == 0){ // apenas o master thread faz isto
//         nthreads = omp_get_num_threads();
//         printf("Msg do Master: Existem + %d\n", nthreads);
//      }
//    } //sincronismo de todos os threads.
    
//    int i;
//    #pragma omp for ordered
//      for(i=0;i<5000;i++){
//         int a = i * i / 2;
//        // printf("%d ", (i+1)); 
//      }   
//    printf("\n");
    int aux;
    int vet_a[100],vet_b[100];
    #pragma omp parallel private(aux)
    {
    aux = 5;
    #pragma omp for
      for (int i=0; i<100; i++)
         vet_a[i]= vet_b[i] + aux *(i+1);
    } //Sincronismo de todos os threads 
    
    
} 
