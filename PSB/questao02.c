#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#define n 64

// Projeto desenvolvido por: Artur Oscar Silva Santos Junior
// Disciplina: Programacao de Software Basico
// Professor: Tiago Oliveira
// Paradigma: POG - Programacao Orientada a Gambiarra

int printMenu();
int pow(int, int);
void print_Decimal_To_Hexadecimal(long long);
long long print_Binario_To_Decimal(char *);
char *print_Base2_To_Base1(char *);
char *print_Base1_To_Binario(char *, int);
void print_Base1_To_Base2(char *);
char *print_Decimal_To_Binario(long long);
long long print_Hexadecimal_To_Decimal(char *);
//char *print_Binario_To_Base1(char *);

int main(){

  int opcao = printMenu();
  char hexadecimal[n], resHexa[n], resBin[n*2];
  long long  valor=0;
  int i =0, aux = 1, cpValor,k=0,l=0,pot=0, aux2=0;

  printf("Digite o número: ");
  if (opcao == 4)
    scanf("%lld", &valor);
  else if(opcao == 5)
    scanf("%s",&hexadecimal);
  else
    scanf("%s", &resBin);

  printf("\n");

  if((opcao == 4 && valor == 0)){
    printf("Hexadecimal: 0\n");
    printf("Binario: 0\n");
    printf("Complemento de 1: 1\n");
    printf("Complemento de 2: 10\n");
    return 0;
  }
  else if(opcao == 5 && hexadecimal[0] == 0){
      printf("Decimal: 0\n");
      printf("Binario: 0\n");
      printf("Complemento de 1: 1\n");
      printf("Complemento de 2: 10\n");
      return 0;
  }
  if(opcao <4){
    int a=0,b=0;
    while(resBin[b] != '\0'){
      if(resBin[b] == '1'){
        a = 1;
        break;
      }
      b++;
    }
    if(a == 0){
      printf("Hexadecimal: 0\n");
      printf("Decimal: 0\n");
      printf("Binario: 0\n");
      printf("Complemento de 1: 1\n");
      printf("Complemento de 2: 10\n");
      return 0;
    }
  }
  char *binario, *binario2;

  if(opcao == 1){
    valor = print_Binario_To_Decimal(resBin);
    print_Decimal_To_Hexadecimal(valor);
    binario2 = print_Base1_To_Binario(resBin, 2); //binario para complemento1. Gambiarra!
    print_Base1_To_Base2(binario2);
  }
  else if(opcao == 2){
    print_Base1_To_Base2(resBin);
    binario = print_Base1_To_Binario(resBin, 1); // imprime binario
    valor = print_Binario_To_Decimal(binario); // imprime decimal
    print_Decimal_To_Hexadecimal(valor); //imprime hexadecimal
  }
  else if(opcao == 3){
    binario = print_Base2_To_Base1(resBin); // imprime complemento 1
    binario2 = print_Base1_To_Binario(binario, 1); //imprime binario
    valor = print_Binario_To_Decimal(binario2); //imprime decimal
    print_Decimal_To_Hexadecimal(valor); //imprime Hexadecimal
  }
  else if(opcao == 4){
    print_Decimal_To_Hexadecimal(valor);
    binario = print_Decimal_To_Binario(valor);
    binario2 = print_Base1_To_Binario(binario, 2); //binario para complemento1. Gambiarra!
    print_Base1_To_Base2(binario2);
  }
  else{
    valor = print_Hexadecimal_To_Decimal(hexadecimal);
    binario = print_Decimal_To_Binario(valor);
    binario2 = print_Base1_To_Binario(binario, 2); //binario para complemento1. Gambiarra!
    print_Base1_To_Base2(binario2);
  }

}

//Declaracao das Funcoes
long long print_Hexadecimal_To_Decimal(char *hexadecimal){
  long long valor=0;
  int k=0, pot=0,aux;
  while(hexadecimal[k] != '\0')
    k++;
  k--;
  while(k>=0){
    if(hexadecimal[k] == 'A' || hexadecimal[k] == 'a')
      aux = 10;
      else if(hexadecimal[k] == 'B' || hexadecimal[k] == 'b')
        aux = 11;
      else if(hexadecimal[k] == 'C' || hexadecimal[k] == 'c')
        aux = 12;
      else if(hexadecimal[k] == 'D' || hexadecimal[k] == 'd')
        aux = 13;
      else if(hexadecimal[k] == 'E' || hexadecimal[k] == 'e')
        aux = 14;
      else if(hexadecimal[k] == 'F' || hexadecimal[k] == 'f')
        aux = 15;
      else
        aux = ((int)hexadecimal[k])-48;
        valor += (aux*pow(16, pot));

    k--;
    pot++;
  }
  printf("Decimal: %lld\n", valor);
  return valor;
}
char *print_Decimal_To_Binario(long long valor){
  long long cpValor = valor;
  char *binario = malloc(sizeof(char)*n*2);
  char temp[n*2];
  int k=0, aux;
  while(cpValor > 0 && k<n){
    aux = cpValor%2;
    temp[k++] = (char)(48+aux);
    cpValor /= 2;
  }
  printf("Binario: ");
  if(valor == 0) printf("0");
  for(int j=k-1; j>=0;j--)
    printf("%c",temp[j]);
  printf("\n" );
  int j=0;
  for(int i=k-1;i>=0;i--)
    binario[i] = temp[j++];

  return binario;
}

void print_Base1_To_Base2(char *bin){
  int k=0;
  char binario[n*2];
  while(bin[k] != '\0'){
    binario[k] = bin[k];
    k++;
  }
  for(int j=k-1;j>=0;j--){
    if(binario[j] == '0'){
      binario[j] = '1';
      for(int l=j+1; l<k; l++)
        binario[l] = '0';
      break;
    }
  }
  printf("Binario Complemento de 2: ");
  for(int j=0; j<k; j++)
    printf("%c",binario[j]);
  printf("\n");
}

void print_Decimal_To_Hexadecimal(long long valor){
    long long cpValor = valor;
    char resHexa[n];
    int i=0, aux;
    while(cpValor > 0 && i < n*2){
      aux = (int)cpValor % 16;
      if(aux < 10)
        resHexa[i] = (char)(48+aux); //ascII table
      else if(aux == 10) resHexa[i] = 'A';
      else if(aux == 11) resHexa[i] = 'B';
      else if(aux == 12) resHexa[i] = 'C';
      else if(aux == 13) resHexa[i] = 'D';
      else if(aux == 14) resHexa[i] = 'E';
      else if(aux == 15) resHexa[i] = 'F';
      cpValor /= 16;
      i++;
    }
    printf("Hexadecimal: ");
    if(valor == 0) printf("0");
    for(int j=i-1; j>=0;j--)
      printf("%c",resHexa[j] );
    printf("\n" );
}



char *print_Base2_To_Base1(char *binario){
  int k=0;
  while(binario[k] != '\0')
    k++;
  k--;
  for(int j=k;j>=0;j--){
    if(binario[j] == '1'){
      binario[j] = '0';
      for(int l=j+1; l<=k; l++)
        binario[l] = '1';
      break;
    }
  }
  printf("Binario Complemento de 1: " );
  for(int i=0;i<=k;i++)
    printf("%c",binario[i]);
  printf("\n");
  return binario;
}

char *print_Base1_To_Binario(char *binario, int op){
    int i=0;
    if(op == 1)
      printf("Binario: ");
    else
      printf("Complemento de 1: ");
    while(binario[i] != '\0'){
      if( binario[i] == '0'){
         printf("1");
         binario[i] = '1';
      }
      else{
        printf("0");
        binario[i] = '0';
      }
      i++;
    }
    printf("\n");
    return binario;
}

long long print_Binario_To_Decimal(char *binario){
  long long valor = 0;
  int k=0,temp,j=0;
  while(binario[k] != '\0') k++;
  for(int i=k-1;i>=0;i--){
    temp = (int)binario[i] - 48;
    valor += temp*pow(2,j);
    j++;
  }

  printf("Decimal: %lld\n",valor);
  return valor;
}

int pow(int base, int expoente){
  if(expoente == 0) return 1;
  int resultado = base;
  for(int i=1;i<expoente;i++)
    resultado *= base;
  return resultado;
}
int printMenu(){
  printf("          #########################################\n" );
  printf("          #                  MENU                 #\n" );
  printf("          #                                       #\n" );
  printf("          #  Informe a Opcao desejada:            #\n" );
  printf("          #                                       #\n" );
  printf("          # 1 - Binario                           #\n" );
  printf("          # 2 - Binario Complemento de 1          #\n" );
  printf("          # 3 - Binario Complemento de 2          #\n" );
  printf("          # 4 - Decimal                           #\n" );
  printf("          # 5 - hexadecimal                       #\n" );
  printf("          #                                       #\n" );
  printf("          #########################################\n" );
  int entrada;
  do{
    scanf("%d", &entrada);
    bool condicao= (entrada > 5 || entrada < 1);
    if(condicao) printf("Opcao invalida, digite uma opcao válida!\n");
  }while(entrada > 5 || entrada < 1);

  return entrada;
}
/*
Exibir menu (modo texto) que pode receber binário, binário complemento de 1, binário complemento de 2, decimal ou hexadecimal.
 Após recebe uma das opções, imprima as demais correspondentes.
*/
