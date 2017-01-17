#include <stdio.h>
#include <pthread.h>
void* task(void* p){//线程执行的代码
  int i;
  for(i=0;i<100;i++){
    printf("i=%d\n",i);  }  }
int main(){//主线程
  pthread_t id;
  pthread_create(&id,0,task,0);//创建线程
  int i;
  for(i=0;i<100;i++){
    printf("main=%d\n",i); }  sleep(1);
  pthread_t id2 = pthread_self();//取当前线程
  printf("id=%u,id2=%u\n",id,id2);
}


