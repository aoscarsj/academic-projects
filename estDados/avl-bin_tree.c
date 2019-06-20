#include <stdio.h>
#include <stdlib.h>
#define MAX(a,b)((a)>(b)?(a):(b))
typedef enum {false, true}bool;
typedef int element_t;
typedef struct node{
	element_t key;
	int height;
	struct node *left, *right;
}node_t;

//------ Assinaturas ---------
node_t *newNode(void); // OK
node_t *avl_rRight(node_t *); // OK 
node_t *avl_rLeft(node_t *); //  OK 
node_t *rebalance(node_t *); // OK
node_t *avl_insert(element_t, node_t *); //
node_t *avl_delete(element_t, node_t *); //
node_t *get_max(node_t *); // OK 
int Height(node_t *); // OK
//------ End Assinaturas -----------

int main(){

}
node_t * avl_insert(element_t x, node_t *v){
	if(v == NULL){
		v = newNode();
		v->key=x;
		return v;
	}
	else if(x < v->key)
		v->left = avl_insert(x, v->left);
	else if(x > v->key)
		v->right = avl_insert(x, v->right);
	return rebalance(v);
}
node_t *avl_delete(element_t x, node_t *v){
	node_t *p;
	if(v == NULL) return v;
	if(x < v->key)
		v->left = avl_delete(x, v->left);
	else if(x > v->key)
		v->right = avl_delete(x, v->right);
	else{
		if(v->left == NULL){
			p = v;
			v = v->right;
			free(p);
		}
		else if(v->right == NULL){
			p = v;
			v = v->left;
			free(p);
		}
		else{
			p = get_max(v->left);
			v->key = p->key;
			v->left = avl_delete(p->key,v->left);
		}	
		if(v) return rebalance(v);
		else return v;
	}

}
node_t *rebalance(node_t *t){
	int lh = Height(t->left);
	int rh = Height(t->right);
	int fator = lh - rh;
	r->height = MAX(lh,rh)+1;
	if(f == 2){
		if( (Height(t->left->left) - Height(t->left->right)) == -1)
			t->left = avl_rLeft(t->left);
		t = avl_rRight(t);
	}
	else if(f == -2){
		if( ( Height(t->right->left) - Height(t->right->right)) == 1 )
			t->right = avl_rRight(t->right);
		t = avl_rLeft(t);
	}
	return t; 
}
int Height(node_t *t){
	if(t) 
		return t->height;
	return -1; // Tá certo? Nao seria -1? Interfere em um caso se for zero. 
}
node_t *avl_rLeft(node_t *t){
	node_t *aux;
	aux = t->right;
	t->right = aux ->left;
	aux->left = t;
	t->height =  MAX(Height(t->left),Height(t->right))+1;
	aux->height = MAX(Height(t), Height(aux->right))+1;
	return aux;
}
node_t *avl_rRight(node_t *x){
	node_t *y = x->left;
	x->left = y->right;
	y->right = x;
	x->height= MAX(Height(x->left), Height(x->right))+1;
	y->height= MAX(Height(y->left), Height(x))+1;
	return y; 
}
node_t *newNode(){
	node_t *p = (node_t*)malloc(sizeof(node_t));
	p->key = -1;
	p->height = 0;
	p->left=p->right=NULL;
}
node_t *get_max(node_t *t){
	while(t->right)
		t = t->right;
	return t;
}
