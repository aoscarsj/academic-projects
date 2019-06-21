#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <omp.h>

float randF(long long min, long long max) { // gera floats aleatorios entre min e max
  return (float) ( (double)min + ( (rand() / (double)RAND_MAX) * (double)(max - min)));
}

int main(int argc, char const *argv[]) {
    srand(omp_get_wtime() * 50);
    int a = 10000, b = 50;
    if(argc > 2){
      sscanf(argv[1],"%d",&a);
      sscanf(argv[2],"%d",&b);
    }
    else {
      printf("comando para gerar: generate MAXDIM PERIODOFREQ > ARQUIVODESTINO\n\n");
      printf("MAXDIM: dimensão máxima da matriz desejada (será aleatoriamente gerada)\nPERIODOFREQ: numero inteiro, quanto maior, mais esparsa (menos numeros validos) tera a matriz gerada\n\nFim do programa.\n");
      return 0;
    }
    int x = (rand() % (((a-1) / 2))) + ((a-1) / 2) + 1, y =  1 + (rand() % (((a-1) / 2))) + ((a-1) / 2) + 1;
    printf("%d %d\n", x,y);
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            if (!(rand() % b)) printf("%d %d %.2f\n", i,j, randF(-50,50));
        }
    }
    return 0;
}
