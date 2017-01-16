#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
int i1 = 1;//全局
int main(){
  int i2 = 1;
  char *st = malloc(20); strcpy(st,"abcd");
  pid_t pid = fork();//fork有可能失败概率低
  if(pid == 0){//子进程
    i1 = 2; i2 = 2; st[0] = '1';
    int i3 = 20;//子进程的局部变量，父进程没有
    printf("child:i1=%d,i2=%d,st=%s,i3=%d\n",
      i1,i2,st,i3);
    exit(0);//子进程有exit，父进程不用else
  } sleep(1);
  printf("main:i1=%d,i2=%d,st=%s\n",
    i1,i2,st);
}

