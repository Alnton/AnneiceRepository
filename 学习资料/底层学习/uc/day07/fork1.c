#include <stdio.h>
#include <unistd.h>

int main(){
  printf("begin%d\n",getpid());
  pid_t pid = fork();//开始创建子进程,代码区在第6行
  printf("end:%d\n",pid);
}

