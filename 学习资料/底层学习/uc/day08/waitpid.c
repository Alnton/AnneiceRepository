#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
  pid_t pid1,pid2;
  pid1 = fork();//2个进程 pid1 和 父进程
  if(pid1>0)pid2 = fork();//pid1>0只父进程执行
  //printf("test\n");
  if(pid1 ==0){//子进程pid1
    printf("子进程一%d开始执行\n",getpid());
    sleep(3); printf("子进程一结束\n");
    exit(100);  }
  if(pid2 == 0){
    printf("子进程二%d开始执行\n",getpid());
    sleep(1); printf("子进程二结束\n");
    exit(200);  }
  printf("父进程开始等待\n");
  int status; waitpid(pid1/*-1*/,&status,0);
  if(WIFEXITED(status)) 
    printf("code=%d\n",WEXITSTATUS(status));
}


