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
bool isEmpty(queue_t *);
void display(queue_t *);
element_t *dequeue(queue_t *);
queue_t *newQueue();
bool enqueue(element_t *, queue_t *);

int main(){
  queue_t *fila = newQueue();
  element_t *x;
  int valor = 5;
  x =  &valor;
  //printf("%d\n", *x);
  enqueue(x, fila);
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
