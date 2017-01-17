#include <stdio.h>
#include <pthread.h>

char* data[5];//存数据
int size = 0;//人数，数组的下标
pthread_mutex_t lock;//1 定义
  //=PTHREAD_MUTEX_INITIALIZER;
void* task(void* p){
  pthread_mutex_lock(&lock);//3 上锁
  data[size] = (char*)p;
  usleep(100000);  size++;
  pthread_mutex_unlock(&lock);//5解锁
}
int main(){
  pthread_mutex_init(&lock,0);//2 初始化
  data[size] = "zhangfei";  size++;
  pthread_t id1,id2;
  pthread_create(&id1,0,task,"guanyu");
  pthread_create(&id2,0,task,"zhaoyun");
  pthread_join(id1,0); pthread_join(id2,0);
  pthread_mutex_destroy(&lock);//6删除
  int i;
  for(i=0;i<size;i++){
    printf("%s\n",data[i]);
  }
}


