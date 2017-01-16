#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>

int main(){
  pid_t pid = fork();
  if(pid == 0){//子
    printf("子进程开始运行，将休眠3秒\n");
    sleep(3);
    printf("子进程%d结束运行\n",getpid());
    exit(100);//不超过255
  }
  printf("父进程准备wait\n");
  int status;  pid_t res = wait(&status);
  printf("等待结束\n");
  printf("结束子进程的pid=%d\n",res);
  printf("status=%d\n",status);
  if(WIFEXITED(status))//如果是正常结束
   printf("code=%d\n",WEXITSTATUS(status));
}

