#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
void fa(int signo){
  printf("信号%d被捕获\n",signo);
}
int main(){
  if(signal(SIGINT,fa)==SIG_ERR) 
   perror("signal 2"),exit(-1);
  signal(SIGQUIT,SIG_IGN);//信号3 被忽略
  pid_t pid = vfork();
  if(pid==0){
    printf("子进程pid=%d\n",getpid());
    execl("./proc","proc",NULL); 
  }
  printf("父进程结束\n");
}


