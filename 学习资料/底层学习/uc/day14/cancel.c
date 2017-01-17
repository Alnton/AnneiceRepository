#include <stdio.h>
#include <pthread.h>
void* task1(void *p){//线程2取消线程1
  //设置可以取消
  pthread_setcancelstate(//换成DISABLE不能取消
    PTHREAD_CANCEL_ENABLE,0);
  //设置取消方式： 立即/下一个取消点
  pthread_setcanceltype(//立即,DEFERRED下一个
   PTHREAD_CANCEL_DEFERRED/*ASYNCHRONOUS*/,0);
  while(1) {
    printf("I am superman!\n");
    usleep(1); } }
void* task2(void *p){
  sleep(3); printf("开始取消线程1\n");
  pthread_cancel(*(pthread_t*)p);  }
int main(){
  pthread_t id1,id2;
  pthread_create(&id1,0,task1,0);
  pthread_create(&id2,0,task2,&id1);
  pthread_join(id1,0); pthread_join(id2,0);
}

