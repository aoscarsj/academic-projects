#include <stdio.h>
#include <stdlib.h>
typedef int element_t;
typedef enum {false, true}bool;
typedef struct node{
	element_t key;
	struct node *left, *right;
}iTree;
typedef iTree* Tree;
// Arvore Binaria de Busca
Tree newTree();
Tree insert(element_t, Tree);

int main(){
	Tree arvore = newTree();
	arvore = insert(20, arvore);
	//arvore = insert(25, arvore);
	printf("%d\n",arvore->key );
	//printf("%d | %d \n",arvore );
	
	return 0;
}
Tree insert(element_t x, Tree t){
	if(t == NULL){
		t = newTree();
		t->key = x;
		return t;
	}
	else if(x < t->key)
		t->left =  insert(x, t->left);
	else if(x > t->key)
		t-> right = insert(x, t->right);

	return t;
}
Tree newTree(){
	Tree t = (Tree)malloc(sizeof(iTree));
	if(t){
		t->key   = -1;
		t->left  = NULL;
		t->right = NULL;
	}
	return t;
}
