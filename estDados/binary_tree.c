#include <stdio.h>
#include <stdlib.h>
#define MAX(a,b)((a)>(b)?(a):(b))
#define debug printf("Foi\n");
typedef struct node node_t;
typedef enum {false, true}bool;
typedef node_t element_t;
struct node {
   int element;
   node_t *left, *right;
};
typedef struct cell{
  element_t *element;
  struct cell *next;
}cell_t;
typedef struct queue{
    cell_t *first, *last;
    unsigned int size, maxsize;
}queue_t;

//queue
cell_t *newCell();
element_t *front(queue_t *);
bool isEmpty(queue_t *);
element_t *dequeue(queue_t *);
bool enqueue(element_t *, queue_t *);
queue_t *newQueue();
//-------------------

int height(node_t *);
node_t *insert(int, node_t *);
node_t *search(int, node_t *);
node_t *newNode();
void BFS(node_t *); // Nao funciona
void DFS(node_t *, int);

int main(){
  node_t *tree;
  //for(int i='a';i<'m';i++) tree = insert(i, tree);
  tree = insert(97,tree); tree = insert(90,tree); tree = insert(100,tree); tree = insert(70,tree); tree = insert(95,tree); tree = insert(99,tree);
  tree = insert(110,tree); tree = insert(60,tree);tree = insert(75,tree); tree =insert(92,tree);tree = insert(96,tree);
  //node_t *t = search(97, tree);
  //DFS(tree,1);
  printf("\n------------\n" );
  //DFS(tree,2);
  BFS(tree);
  printf("\n------------\n" );
//  DFS(tree,3);
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
//  node_t *aux = t;
  queue_t *q = newQueue();
  enqueue(t, q);
  while(q->size>0){
    if(q->first->element->left)  enqueue(q->first->element->left,q); //Erro ao entrar aqui
    if(q->first->element->right) enqueue(q->first->element->right, q);
    printf("%d ", q->first->element->element);
    dequeue(q);
  }
  printf("\n");
}
element_t *dequeue(queue_t *q){
  if(isEmpty(q)) return NULL;
  cell_t *p = q->first;
  q->first = q->first->next;
  if(q->last == p) q->last = NULL;
  element_t *el = p->element;
  free(p);
  q->size--;
  return el;
}
bool enqueue(element_t *x, queue_t *q){
  cell_t *p = newCell();
  if(!p) return false;
  if(isEmpty(q)) q->first = p;
  else q->last->next = p;
  q->last = p;
  (q->size)++;
  p->element = x;
  return true;
}bool isEmpty(queue_t *q){
  return (!q->last);
}
queue_t *newQueue(){
  queue_t *q = (queue_t*)malloc(sizeof(queue_t));

  if(q){
    q->size = 0;
    q ->first = q ->last = NULL;
  }
  return q;
}
cell_t *newCell(){
  cell_t *q = (cell_t*)malloc(sizeof(cell_t));
  if(q){
    //*(q->element) = -1;
    q->next = (cell_t*)NULL;
    return q;
  }
  return (cell_t*)NULL;
}
element_t *front(queue_t *q){
  if(isEmpty(q)) return NULL;
  return q->first->element;
}
