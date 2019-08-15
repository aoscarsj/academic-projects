#include <stdio.h>
#include<stdbool.h>


int main(){
  double valor, res, pot;
  int i=0;
  bool vector[16];
  scanf("%lf", &valor);

  while(valor > 0 && i<16){
    valor *= 2;
    vector[i++]= (int)valor;
    if((int)valor == 1)
      valor -= 1;
  }
  for(;i<16;i++) vector[i] =0;
  printf("0.");
  for(i=0;i<16;i++)
    printf("%d", (int)vector[i]);
  printf("\n" );



  pot = 1;
  res = 0;
  for (size_t i = 0; i < 16; i++) {
    pot/=2;
    res+= vector[i]*pot;
  }
  printf("%lf\n",res);

}
