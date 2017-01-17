#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
  //access()经常用于判断文件是否存在
  if(access("a.txt",R_OK)==0)printf("可读\n");
  if(access("a.txt",W_OK)==0)printf("可写\n");
  if(access("a.txt",X_OK)==0)printf("执行\n");
  if(access("a.txt",F_OK)==0)
    printf("文件存在\n");
}


