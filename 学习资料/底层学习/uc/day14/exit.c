#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

void* task(void* p){
  int i;
  for(i=0;i<100;i++){
    if(i == 10) //return (void*)i;
      //pthread_exit((void*)i);//与return一样
      exit(0); //退出进程(所有线程)
  } }
int main(){
  pthread_t id;
  pthread_create(&id,0,task,0);
  int x;
  pthread_join(id,(void**)&x);
  printf("x=%d\n",x);
}


