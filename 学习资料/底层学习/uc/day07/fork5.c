#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
  printf("父进程%d开始运行\n",getpid());
  pid_t pid = fork();
  if(pid==0){//子进程
    printf("子进程%d开始运行，父进程%d\n",
      getpid(),getppid());
    sleep(3);
    printf("子进程%d开始运行，父进程%d\n",
      getpid(),getppid());
    exit(0);
  }
  printf("父进程继续运行\n");
  sleep(1);
  printf("父进程运行结束\n");
}


