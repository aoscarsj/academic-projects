#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <omp.h>
#include <sys/timeb.h>

#define SEED 0
#define MIN -20
#define MAX 20
typedef enum{false,true} bool;


unsigned long long system_current_time_millis(){
#if defined(_WIN32) || defined(_WIN64)
    struct _timeb timebuffer;
    _ftime(&timebuffer);
    return (unsigned long long)(((timebuffer.time * 1000) + timebuffer.millitm));
#else
    struct timeb timebuffer;
    ftime(&timebuffer);
    return (unsigned long long)(((timebuffer.time * 1000) + timebuffer.millitm));
#endif
}


typedef struct matrizlida {
  int x;
  int y;
  float **m;
} mtl;

mtl * initializeMtx(int x, int y){  // inicializa a matriz (todas os valores da matriz serao 0 na matriz retornada).
  mtl *mat = malloc(sizeof(mtl)); if(!mat) return NULL; // aloca a estrutura

  mat->x = x;
  mat->y = y;

  mat->m = malloc(x * sizeof(float*)); if(!(mat->m)) return NULL;  // aloca as linhas
  for (int i = 0; i < x; i++) {        // esse FOR aloca as colunas da matriz, porem se alguma linha falhar a alocaçao, ela desaloca tudo.
    mat->m[i] = malloc(y * sizeof(float));

    if(!(mat->m[i])) {     // protocolo deu ruim, se alguma alocaçao falhou, desaloca tudo.
      while (--i != -1) {
        free((mat->m[i]));
      }
      free(mat->m);
      free(mat);
      break;
    }
    for (size_t j = 0; j < y; j++) {
      mat->m[i][j] = 0;
    }
  }

  return mat;  // vai retornar uma matriz valida se a alocaçao deu certo, se nao retorna NULL;
}

float randF(long long min, long long max) { // gera floats aleatorios entre min e max
  return (float) ( (double)min + ( (rand() / (double)RAND_MAX) * (double)(max - min)));
}


mtl * readMatrix(FILE * arquivo){ // lê a matriz do arquivo, retornando um mtl* completo utilizavel
   if(!arquivo) return NULL;
   int x, y;
   fscanf(arquivo, "%d %d", &x,&y);
   mtl * mat = initializeMtx(x,y);
   if(!mat) return NULL;
   int i,j, read;
   float value;

   while ( fscanf(arquivo, "%d %d %f\n",&i, &j, &value) == 3 )
        mat->m[i][j] = value;

  return mat;

}

void generateV(float * v, int size, int seed){ // gera o vetor a ser multiplicado pela matriz
    srand(seed);
    for (size_t i = 0; i < size; i++) {
      v[i] = randF(MIN,MAX);
  }
}

int main(int argc, char const *argv[]) {
    int Tend,Tbegin = system_current_time_millis();
    if (argc < 3) {
      printf("Poucos argumentos! Programa terminará!\nDica: Escreva ./executavel CPU small.csr\n");
      return 0;
    }
    if (!strcmp(argv[1],"GPU")) {
        printf("Calculo em CUDA nao implementado, por favor execute-o em modo CPU. O programa sera terminado.\n");
        return 0;
    }
    int NUM_T, NTIMES;
    if (argc == 5) {
        sscanf(argv[3],"%d ",&NUM_T);
        sscanf(argv[4],"%d ",&NTIMES);
        if (!NUM_T) NUM_T = 1;
        if (!NTIMES) NTIMES = 1;
    }else{
        NUM_T = omp_get_num_procs(), NTIMES = 1;
    }

    FILE * csrfile = NULL;
    csrfile = fopen(argv[2], "r"); if (!csrfile) printf("Erro: arquivo nao encontrado.\n");
    mtl * mA = readMatrix(csrfile); if (!mA) printf("Erro na leitura/alocaçao da matriz.\n");

    for (size_t i = 0; i < mA->x; i++) {
      for (size_t j = 0; j < mA->y; j++) {
        printf("%8.3f ", mA->m[i][j]);
      }
      printf("\n");
    }

    float v[mA->y], r[mA->x];
    generateV(v,mA->y,SEED);
    for (size_t i = 0; i < mA->y; i++) {
        printf("%8.3f\n", v[i]);
    }
    printf("\n\n\n");

    int avg = 0;
    for (size_t k = 0; k < NTIMES; k++) {
        int i, j, begin, end;
        begin = system_current_time_millis();
        #pragma omp parallel private(i,j) shared(mA,r,v) num_threads(NUM_T)
        {
            #pragma omp for
            for (i = 0; i < mA->x; i++) {
                r[i] = 0;
                for (j = 0; j < mA->y; j++) {
                    r[i] += mA->m[i][j] * v[j];
                }
            }
        }
        end = system_current_time_millis();


        avg += end - begin;
        // printf("\nTime elapsed: %d\n", end - begin);
    }
    for (int i = 0; i < mA->x; i++) {
        printf("%12.5f\n",r[i]);
    }
    printf("\n");

    return 0;
    if(NTIMES > 1) printf("Tempo medio do Kernel 1 com %d threads: %d ms.\nComputado %d vez(es).\n", NUM_T,avg / NTIMES, NTIMES);
    else printf("Tempo do Kernel 1 com %d threads: %d ms.", NUM_T, avg);
    Tend = system_current_time_millis();
    printf("Tempo de execucao total da aplicacao: %d ms.\n\n", Tend - Tbegin);

    printf("Para testar o programa com diferente numeros de threads, ou computar a media com precisao diferente, os seguintes argumentos devem ser passados:\n");
    printf(".\\executavel DEVICE FILENAME NTHREADS AVGPRECISION\n\n");

    printf("DEVICE: \"GPU\" ou \"CPU\".\n");
    printf("FILENAME: nome do arquivo que contem a matriz esparsa.\n");
    printf("NTHREADS: numero de threads que dividirao o trabalho.\n");
    printf("AVGPRECISION: numero de vezes que sera repetido o calculo para aumentar a precisao da media calculada.\n" );

  return 0;
}
