#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
  pid_t pid = vfork();
  if(pid==0){//子进程(非常规用法)
    printf("子进程运行\n");
    sleep(3);
    printf("子进程结束\n");
    exit(0);//vfork()的子进程占用父进程的空间
  }//所以父进程没有机会运行
  printf("父进程运行\n");
  printf("父进程结束\n");
}

