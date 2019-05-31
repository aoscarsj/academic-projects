#include <stdio.h>
#include <stdlib.h>
typedef struct cell cell_t;
typedef int element_t;
typedef struct stack stack_t;
typedef enum {false, true}bool;
#define MAX_STACK 100
struct stack{
  cell_t *top;
  unsigned int size, maxSize;
};
struct cell{
  element_t el;
  cell_t *next;
};
stack_t *newStack();
void push(element_t, stack_t *);
int pop(stack_t *);
void display(stack_t *);
cell_t *top(stack_t *);
int size(stack_t *);
cell_t *newCell();
bool isFull(stack_t *);
bool isEmpty(stack_t *);
int main(){
  stack_t *pilha = newStack();
  for(int i =100; i>=1; i--) push(i, pilha);

  display(pilha);
  printf("top %d\n", top(pilha)->el );

//  printf("%d\n", size(pilha));
  return 0;
}
void display(stack_t *s){
  if(!isEmpty(s)){
    cell_t *c = s->top;
    while(c != NULL){
      printf("%d ",c->el);
      c = c->next;
    }
    printf("\n");
  }else {
    printf("Pilha vazia.\n");
  }

}
int pop(stack_t *s){
  if (!s || isEmpty(s)) return 0;
  cell_t *p = s->top;
  s->top = s->top->next;
  free(p);
  s->size--;
  return 1;
}
void push(element_t x, stack_t *s){
  if(!isFull(s)){
    cell_t *p = newCell();
    p->el = x;
    if(isEmpty(s)){
      s->top = p;
      p->next = NULL;
    }
    else{
      p->next = s->top;
      s->top = p;
    }
    s->size++;
  }
  else printf("Pilha cheia.\n");
}
stack_t *newStack(){
  stack_t *s = malloc(sizeof(stack_t));
  if(!s) return NULL;
  s->top = NULL;
  s->size = 0;
  s->maxSize = MAX_STACK;
  return s;
}
cell_t *newCell(){
    cell_t *p = malloc(sizeof(cell_t));
    if(p) p->next=NULL;
    return p;
}
cell_t *top(stack_t *s){
  return s->top;
}
int size(stack_t *s){
  return (s->size);
}
bool isFull(stack_t *s){
  return (s->size == s->maxSize);
}
bool isEmpty(stack_t *s){
  return (s->size == 0);
}
