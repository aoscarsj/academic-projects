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

int main(){

}
