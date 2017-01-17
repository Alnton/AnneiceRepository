#include <stdio.h>
#include <stdlib.h>
void fa(){
  printf("fa().....\n");
}
int main(){
  atexit(fa);
  printf("begin\n");
  //exit(0);//退出前会调用fa()
  _Exit(0);//立即退出
  printf("end\n");//不可能被打印
}


