#include <stdio.h>
#include <stdlib.h>

typedef int element_t;
typedef element_t *heap_t;
typedef struct q{
	size_t size,maxSize;
	heap_t priority;
	element_t key;
}p_Queue;
#define LEFT(i) 2*i+1
#define RIGHT(i) 2*i+2;
#define PARENT(i) (i-1)/2

//----- ASSIGNATURES FUNCTIONS -----
void h_insert(int, int *,heap_t);
void h_deleteMax(int *,heap_t);
void h_heapFy(int, heap_t);
int maxChild(int, int, heap_t);
void h_bubbleUp(int, heap_t);
void h_bubbleDown(int, int, heap_t);
void h_swap(int, int, heap_t);
void heapSort(int, int *);
//----- END ASSIGNATURES -----

int main(){

}
void heapSort(int n, element_t v[]){
	h_heapFy(n,v);
	while(n)
		h_deleteMax(&n, v);

}
void h_heapFy(int n, heap_t h){
	for(int i=(n/2); i>=0; i--)
		h_bubbleDown(i,n,h);
}

void h_insert(int x, int *pm, heap_t h){
	h[*pm]= x;
	h_bubbleUp(*pm,h);
	(*pm)++;
}
void h_deleteMax(int *pm, heap_t h){
	if(*pm > 0){
		h_swap(0,(*pm)-1,h);
		(*pm)--;
		h_bubbleDown(0, *pm, h);
	}
}


int maxChild(int i, int n, heap_t h){
	int imax = LEFT(i);
	if(imax<n-1 && h[RIGHT(i)] > h[imax])
		imax = RIGHT(i);
	return imax;
}
void h_bubbleDown(int i, int n, heap_t h){
	int imax = maxChild(i,n,h);
	while((imax<n) && (h[i]<h[imax])){
		h_swap(i,imax,h);
		i = imax;
		imax = maxChild(i,n,h);
	}
}
void h_bubbleUp(int i, heap_t h){
	while(i> 0 && h[i]> h[PARENT(i)]){
		h_swap(PARENT(i),i,h);
		i = PARENT(i);
	}
}
void h_swap(int i, int j, heap_t h){
	int k = h[i];
	h[i] = h[j];
	h[j] = k;
}