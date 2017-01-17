#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void* task(void* p){//非常规用法
  printf("%d\n",(int)p);  }
void* task2(void* p){//必须保证指针的指向有效
  sleep(1);  int* pi = p;
  printf("*pi=%d\n",*pi);  }
int main(){
  pthread_t id; int x = 100;
  pthread_create(&id,0,task,(void*)x);
  pthread_join(id,0);
  int* pi = malloc(4); *pi = 300;
  pthread_create(&id,0,task2,pi);
  free(pi);
  pthread_join(id,0);
}

