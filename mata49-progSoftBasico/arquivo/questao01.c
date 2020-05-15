#include <stdio.h>
#include<stdbool.h>


int main(){
  int n = 16, k = 16;
  // Conversor Decimal -> binario
  double valor, res;
  int i=0;
  bool vector[n];
  scanf("%lf", &valor);

  while(valor > 0 && i<k){
    valor *= 2;
    vector[i++]= (int)valor;
    if((int)valor == 1)
      valor -= 1;
  }
  printf("\n%d\n\n", i);
  for(;i<k;i++) vector[i] =0;
  printf("0.");
  for(i=0;i<k;i++)
    printf("%d", (int)vector[i]);
  printf("\n" );



  // Conversor binario -> Decimal

  double pot = 1;
  res = 0;
  for (size_t i = 0; i < k; i++) {
    pot/=2;
    res+= vector[i]*pot;
  }
  printf("%lf\n",res);


}
