#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#define n 64
int printMenu();

int main(){
  int opcao = printMenu();
  char hexadecimal[n], resHexa[n], resBin[n*2];
  long long  valor=0;
  int i =0, aux = 1, cpValor,k=0,l=0,pot=0, aux2=0;

  printf("Digite o número: ");
  if (opcao == 4)
    scanf("%lld", &valor);
  else if(opcao == 5)
    scanf("%s\n",&hexadecimal);
  else
    scanf("%s\n", &resBin);
  printf("\n" );

  if(opcao == 1 || opcao == 2 || opcao == 3){
    while(hexadecimal[k] != '\0')
      k++;
    k--;
    if(opcao == 3){
      for(int j=k;j>=0;j--){
        if(resBin[j] == '1'){
          resBin[j] = '0';
          for(l=j+1; l<=k; l++)
            resBin[l] = '1';
          break;
        }
      }
    }
    if(opcao >= 2){
      while(resBin[aux2] != '\0'){
        if(resBin[aux2] == '0')
          resBin[aux2] = '1';
        else
          resBin[aux2] = '0';
        aux2++;
      }
    }

    while(k>=0){
      aux = ((int)resBin[k])-48;
      valor += (aux* pow(2, pot));
      k--;
      pot++;
    }
  }
  if(opcao == 5){
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
  }
  if(opcao != 4){
    printf("Decimal: %lld\n",valor);
  }
  //decimal -> binario
  cpValor = valor;
  k=0;
  while(cpValor > 0 && k<n){
    aux = cpValor%2;
    resBin[k++] = (char)(48+aux);
    cpValor /= 2;
  }
  if(opcao != 1){
    printf("Binario: ");
    if(valor == 0) printf("0");
    for(int j=k-1; j>=0;j--){
      printf("%c",resBin[j]);
      if(resBin[j] == '0') resBin[j] = '1';
      else resBin[j] = '0';
    }
    printf("\n" );
  }
  if(opcao != 2){
    printf("Binario Complemento de 1: ");
    if(valor == 0) printf("1");
    for(int j=k-1; j>=0; j--)
      printf("%c",resBin[j]);
    printf("\n");
  }
  if(opcao != 3){
    for(int j=0;j<k;j++){
      if(resBin[j] == '0'){
        resBin[j] = '1';
        for(l=j-1; l>=0; l--)
          resBin[l] = '0';
        break;
      }
    }
    printf("Binario Complemento de 2: ");
    if(valor == 0) printf("10");
    for(int j=k-1; j>=0; j--)
      printf("%c",resBin[j]);
    printf("\n");
  }
  if(opcao != 5){
    cpValor = valor;
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
/*
  switch (opcao) {
    case 1:

      break;
    case 2:
      printf("%d\n",opcao );
      break;
    case 3:
      printf("%d\n",opcao );
      break;
    case 4:
      printf("%d\n",opcao );
      break;
    default:
      printf("%d\n",opcao );
      break;

  }
  */

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
