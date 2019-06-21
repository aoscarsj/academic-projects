#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <omp.h>

float randF(long long min, long long max) { // gera floats aleatorios entre min e max
  return (float) ( (double)min + ( (rand() / (double)RAND_MAX) * (double)(max - min)));
}

int main(int argc, char const *argv[]) {
    FILE * csrfile = NULL;
    int x, y;

    if (argc > 1) {
            csrfile = fopen(argv[1], "r");
    }else{
      csrfile = fopen("matrix.txt", "r");
    }
    fscanf(csrfile,"%d %d\n",&x,&y);
    printf("Tamanho da matriz: %d x %d\n",x,y);
    return 0;
}
