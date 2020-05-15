#include <stdio.h>
#include <omp.h>

#define NRA 2      // number of rows in matrix A
#define NCA 2      // number of columns in matrix A

int main(int argc, char const *argv[]) {
    int tid, nthreads, i, j, k, chunk;
    double a[NRA][NCA], b[NCA], c[NRA];

    chunk = 10;

    #pragma omp parallel shared(a, b, c, nthreads, chunk) private(tid, i, j, k)
    {
        tid = omp_get_thread_num();
        if (tid == 0) {
            nthreads = omp_get_num_threads();
            printf("Iniciando exemplo de multiplicacao de matrizes com %d threads\n", nthreads);
            printf("Inicializando matrizes...\n");
        }

        // Inicializando matrizes
        #pragma omp for schedule(static, chunk)
        for (i = 0; i < NRA; i++)
            for (j = 0; j < NCA; j++)
                a[i][j] = i + j;

        #pragma omp for schedule(static, chunk)
        for (i = 0; i < NCA; i++)
			b[i] = i * (i+3);
		
        #pragma omp for schedule(static, chunk)
        for (i = 0; i < NRA; i++)
			c[i] = 0;

        printf("Thread %d iniciando a multiplicacao de matrizes\n", tid);
        #pragma omp for schedule(static, chunk)
		for (i = 0; i < NRA; i++)
           // for (j = 0; j < NRA; j++)
                for (k = 0; k < NCA; k++)
                    c[i] += a[i][k] * b[k];
    }

    // imprimindo resultados
    printf("\nResultado da multiplicacao:\n");
    for (i = 0; i < NRA; i++) 
        printf("%6.2f   ", c[i]);
    printf("\n");
    

    return 0;
}
