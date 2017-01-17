#include <stdio.h>
#include <pthread.h>

void* task(void* p){
  int i;
  for(i=0;i<20;i++){
    printf("i=%d\n",i);
    usleep(100000);  }  }
int main(){
  pthread_t id;
  pthread_create(&id,0,task,0);
  pthread_detach(id);
  pthread_join(id,0);
  int i;
  for(i=0;i<20;i++){
    printf("main=%d\n",i);
    usleep(100000);  }  
}
