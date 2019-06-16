#include <stdio.h>
#include <stdlib.h>
#define MAX(a,b)((a)>(b)?(a):(b))
#define debug printf("Foi\n");
typedef struct node node_t;
typedef enum {false, true}bool;
typedef int element_t;
typedef struct cell{
  struct cell *next;
  node_t *el;
}cell_t;
struct node {
   int element;
   node_t *left, *right;
};
typedef struct queue{
  cell_t *first, *last;
  unsigned int size;
}queue_t;
bool enqueue(node_t *,queue_t *);
bool dequeue(queue_t *);
queue_t *newQueue();
int height(node_t *);
node_t *insert(int, node_t *);
node_t *search(int, node_t *);
node_t *newNode();
void BFS(node_t *); // Nao funciona
void DFS(node_t *, int);

int main(){
  node_t *tree;
  //for(int i='a';i<'m';i++) tree = insert(i, tree);
  tree = insert(97,tree); tree = insert(90,tree); tree = insert(100,tree); tree = insert(70,tree); tree = insert(95,tree); tree = insert(105,tree);
  tree = insert(110,tree); tree = insert(60,tree);tree = insert(75,tree); tree =insert(92,tree);tree = insert(96,tree);
  //node_t *t = search(97, tree);
  //DFS(tree,1);
  printf("\n------------\n" );
  //DFS(tree,2);
  //BFS(tree);
  printf("\n------------\n" );
  //DFS(tree,3);
  //printf("\n------------\n" );
  //printf("\n" );
  //printf("%c\n", tree->right->left->element);
   return 0;
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

void DFS(node_t *t, int opcao){
  if(t){
    if(opcao == 1 ){ // print in order
      DFS(t->left,1);
      printf("%d ",t->element);
      DFS(t->right,1);
    }
    else if(opcao == 2){ // print pre order
      printf("%d ", t->element);
      DFS(t->left,2);
      DFS(t->right,2);
    }
    else if(opcao == 3){ // print pos order
      DFS(t->left,3);
      DFS(t->right,3);
      printf("%d ",t->element);
    }
    else
      printf("Opcao invalida.\n");
  }
}


void BFS(node_t *t){
  node_t *aux = t;
  queue_t *q = newQueue();
  enqueue(aux, q);
  while(q->size>0){
    debug;
    if(aux->left)  enqueue(aux->left,q); //Erro ao entrar aqui
    if(aux->right) enqueue(aux->right, q);
    printf("%d ", q->first->el->element);
    dequeue(q);
  }
}
bool enqueue(node_t *x,queue_t *q){
  if(!q) return false;
  cell_t *cell;
  if(q->size == 0) q->first = cell;
  else q->last->next= cell;
  q->last = cell;
  cell->el = x;
  q->size++;
  return true;
}
bool dequeue(queue_t *q){
  if(q->size == 0) return false;
  cell_t *cell = q->first;
  q->first = q->first->next;
  if(q->last == cell) q->last=NULL;
  free(cell);
  q->size--;
  return true;
}
queue_t *newQueue(){ // OK
  queue_t *q = (queue_t*)malloc(sizeof(queue_t));
  if(q){
    q-> first = q-> last = NULL;
    q->size = 0;
  }
  return q;
}
