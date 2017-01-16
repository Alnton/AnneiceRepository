#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>

sem_t sem;
void* task(void* p){
  int i = (int)p;
  printf("第%d个线程启动，申请连接\n",i);
  sem_wait(&sem);
  printf("第%d个线程申请成功\n",i);
  sleep(10);
  printf("第%d个线程完成连接\n",i);
  sem_post(&sem);  }
int main(){
  sem_init(&sem,0,10);  int i;
  for(i=0;i<20;i++){
    pthread_t id;
    pthread_create(&id,0,task,(void*)(i+1)); }
  while(1);
}


