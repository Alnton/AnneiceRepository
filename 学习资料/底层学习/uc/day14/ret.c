#include <stdio.h>
#include <pthread.h>

void* task(void* p){
  char* s = "abcd";//可以,指向只读常量区
  //char s[] = "abcd";//不可以,指向栈区
  return s;//不能返回指向局部变量的地址
}
void* task2(void* p){//返回static的局部变量
  int i;static int sum=0;
  for(i=0;i<10;i++){ sum=sum+i; }
  return &sum;  }
int main(){
  pthread_t id; pthread_create(&id,0,task,0);
  char* st;  pthread_join(id,(void**)&st); 
  printf("st=%s\n",st);
  pthread_create(&id,0,task2,0);
  int* pi;//与函数的返回值的类型一致
  pthread_join(id,(void*)&pi);
  printf("*pi=%d\n",*pi);
}


