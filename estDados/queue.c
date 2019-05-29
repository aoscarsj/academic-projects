#include <stdio.h>
#include <stdlib.h>

typedef struct queue queue_t;
typedef int element_t;
typedef struct cell cell_t;
typedef enum {false, true} bool;

struct queue{
    cell_t *first, *last;
    unsigned int size, maxsize;
};
struct cell{
    element_t *element;
    cell_t *next;
};
cell_t *newCell();
int size(queue_t *);
int maxSize(queue_t *);
element_t *front(queue_t *);
element_t *back(queue_t *);
bool isEmpty(queue_t *);
void display(queue_t *);
element_t *dequeue(queue_t *);
queue_t *newQueue();
bool enqueue(element_t *, queue_t *);

int main(){
  queue_t *fila = newQueue();
  int v[5];
  for(int i=1;i<=5;i++){
    v[i-1] = i;
    enqueue(&v[i-1], fila);
  }
  display(fila);
  printf("\nPrimeiro elemento da fila: %d\n", *(front(fila)));
  printf("Ultimo elemento da fila: %d\n", *(back(fila)));

  printf("Size fila: %d\n", fila->size );
}
void display(queue_t *q){
  if(isEmpty(q))
    printf("Fila vazia, coloque preencha primeiro.\n");
  else {
    printf("Elementos da fila:" );
    while(q->first != q->last){
      printf(" %d", *(q->first->element));
      q->first = q->first->next;
    }
    printf(" %d\n", *q->last->element);
  }
}

element_t *front(queue_t *q){
  if(isEmpty(q)) return NULL;
  return q->first->element;
}
element_t *back(queue_t *q){
  if(isEmpty(q)) return NULL;
  return q->last->element;
}
int size(queue_t *q){
  return q->size;
}int maxSize(queue_t *q){
  return q->maxsize;
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
}
bool isEmpty(queue_t *q){
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
