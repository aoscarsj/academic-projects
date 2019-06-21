#include <stdio.h>
#include <stdlib.h>
#define MAX 30
typedef int element_t;
typedef enum{false, true}bool;
typedef struct cell{
	element_t el;
	struct cell *next;
}cell_t;
typedef struct object{
	unsigned int size, maxSize;
	cell_t *first, *last;
}Queue;

//----- Assinatura das Funcoes -----
	cell_t * newCell(void); // OK
	Queue * newQueue(void); // OK
	bool Enqueue(element_t, Queue *); // OK
	bool Dequeue(Queue *); // OK
	bool Empty(Queue *); // OK
	bool Full(Queue *); // OK
	int Size(Queue *); // OK
	void Display(Queue *); // OK
	element_t Front(Queue *); // OK
	element_t Back(Queue *); // OK
//----------------------------------
int main(){
	
}

//----- Declaracao das Funcoes -----
element_t Back(Queue *q){
	if(!q || q->size == 0)exit(-1);
	return (q->last->el);
}
element_t Front(Queue *q){
	if(!q || q->size == 0) exit(0);
	return (q->first->el);
}
void Display(Queue *q){
	if(!q || Empty(q)) return ;
	cell_t *p = q->first;
	printf("------ PRINT FILA ------ \n\n");
	printf("SIZE: %d\n",Size(q));
	printf("Elementos:");
	while(p){
		printf(" %d", p->el);
		p = p->next;
	}
	printf("\n\n------ END FILA ------\n");
}
bool Dequeue(Queue *q){
	if(!q || Empty(q)) return false;
	cell_t *p;
	p = q->first;
	if(Size(q) == 1)
		q->first = q->last = NULL;
	else
		q->first = q->first->next;
	free(p);
	q->size--;
	return true;
}
bool Enqueue(element_t x, Queue *q){
	if(!q || Full(q)) return false;
	cell_t *p = newCell();
	if(Size(q) == 0) // Caso 1
		q->first = p;
	else
		q->last->next = p;
	q->last = p;
	p->el = x;
	q->size++;
	return true;
}
Queue * newQueue(){
	Queue *p = (Queue*)malloc(sizeof(Queue));
	if(p){
		p->size = 0;
		p->maxSize = MAX;
		p->first = p->last = NULL;
	}
	return p;
}
int Size(Queue *q){
	return (q->size);
}
bool Full(Queue *q){
	return (q->size == q->maxSize);
}
bool Empty(Queue *q){
	return (q->size == 0);
}
cell_t * newCell(){
	cell_t *p = (cell_t*)malloc(sizeof(cell_t));
	if(p){
		p->el = (element_t)0;
		p->next = NULL;
	}
	return p;
}