#include <stdio.h>
#include <pthread.h>

void* task(void* p){
  int* pi = p;
  printf("*pi=%d\n",*pi);
  *pi = 200;
}//练习：1 传入半径，打印圆的面积
void* task2(void* p){
  double* r = p;
  printf("s=%lf\n",3.14*(*r)*(*r));
}
struct param{
  int x;
  int y;
  int z;
};
void* task3(void* p){
  struct param* pp = p;
  pp->z = pp->x + pp->y;
}
int main(){
  pthread_t id1,id2,id3;
  int x = 100;
  pthread_create(&id1,0,task,&x);
  pthread_join(id1,0);//主线程等待id1的结束
  printf("x=%d\n",x);
  double d = 1.0;
  pthread_create(&id2,0,task2,&d);
  pthread_join(id2,0);
  struct param pa = {1,2,0};
  pthread_create(&id3,0,task3,&pa);
  pthread_join(id3,0);
  printf("sum=%d\n",pa.z);
}//练习：2 传入一个结构{int,int}，计算两个成员
//之和，并想办法返回(加第三个成员做返回)


