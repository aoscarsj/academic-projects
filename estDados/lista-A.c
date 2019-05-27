#include <stdio.h>
#include <stdlib.h>

typedef struct cell cell_t;
struct cell{
   int element;
   cell_t *next;
};
cell_t *newCell();
void insert(int, cell_t *);
void delete(int, cell_t *);
int /*cell_t * */search(int, cell_t *);

int main(){ // A - Lista com Encadeamento Simples
   cell_t *l = newCell();
   for(int i=0;i<10;i++) insert(i+1,l);
  //delete(10, l);
   //printf("%d\n", l->next->element);
  // int t = search(10,l);
   //for(int i=-1;i<15;i++) printf("%d existe? %d\n", i, search(i,l));
   //printf("%d\n", t);
   return 0;
}
/*cell_t * */int search(int x, cell_t *l){
   if(!l) return 0;
   while(l->next && l->next->element != x){
      l = l->next;
   }
   if(l->next && l->next->element == x) return 1;
   return 0;
}
void delete(int x, cell_t *l){
   if(l){
      while(!l->next && l->next->element != x){
         l = l->next;
      }
      cell_t *p = l->next;
      l->next = l->next->next;
      free(p);
   }
}
void insert(int x, cell_t *l){
  if(l){
      cell_t *p = newCell();
      if(p){
         p->next = l->next;
         l->next = p;
         p->element = x;
      }
   }
}
cell_t *newCell(){
   cell_t *p = (cell_t*)malloc(sizeof(cell_t));
   if(!p) return (cell_t*)NULL;
   p->element = -1;
   p->next = (cell_t*)NULL;
   return p;
}
