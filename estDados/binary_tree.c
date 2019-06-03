#include <stdio.h>
#include <stdlib.h>
#define MAX(a,b)((a)>(b)?(a):(b))
typedef struct node node_t;
struct node {
   int element;
   node_t *left, *right;
};
void print_BFS(node_t *); // BFS
int height(node_t *);
node_t *insert(int, node_t *);
node_t *search(int, node_t *);
node_t *newNode();
void print_in_order(node_t *);   // DFS
void print_pre_order(node_t *);  // DFS
void print_pos_order(node_t *);  // DFS

int main(){
  node_t *tree;
  for(int i=0;i<10;i++) tree = insert(i, tree);
  print_pos_order(tree);
  printf("\n" );
   return 0;
}
void print_BFS(node_t *t){

}
node_t *newNode(){
  node_t *t = malloc(sizeof(node_t));
  return t;
}
node_t *insert(int x, node_t *t){
  if(!t){
    t = newNode();
    t->element = x;
  }
  else if(t->element > x)
    t->left = insert(x,t->left);
  else
    t->right = insert(x, t->right);
  return t;
}
node_t *search(int x, node_t *t){
   //iterativa (Melhor)
   while(t && t->element != x){
     if(t->element > x)
      t = t->left;
     else
      t = t->right;
   }
   return t;
   /* //recursiva
   if(t == NULL || t->element == x)
     return t;
   else if(t->element > x)
     return search(x, t->left);
   else
     return search(x, t->right);

  */
}
int height(node_t *t){
  if(!t) return -1;
  return (1+ MAX(height(t->left),height(t->right)));
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
      print_pre_order(t->right);
   }
}
void print_pos_order(node_t *t){
   if(t){
      print_pos_order(t->left);
      print_pos_order(t->right);
      printf("%d ", t->element);
   }
}
