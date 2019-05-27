#include <stdio.h>
#include <stdlib.h>

typedef struct node node_t;
struct node {
   int element;
   node_t *left, *right;
};

void print_in_order(node_t *);   // BFS   
void print_pre_order(node_t *);  // BFS     
void print_pos_order(node_t *);  // BFS     

int main(){

   return 0;
}

void print_in_order(node_t *t){
   if(t){
      print_in_order(t->left);
      printf("%d ", t->element);
      print_in_order(t->right);
   }
}
void print_pre_order(node_t *t){
   if(t){
      printf("%d ", t->element);
      print_pre_order(t->left);
      printf_pre_order(t->right);
   }
}
void print_pos_order(node_t *t){
   if(t){
      print_pos_order(t->left);
      print_pos_order(t->right);
      printf("%d ", t->element);
   }
}


