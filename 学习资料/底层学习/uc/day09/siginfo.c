#include <stdio.h>
#include <signal.h>

void fa(int signo,siginfo_t* info,void* p){
  printf("进程%d发送了信号%d\n",
    info->si_pid,signo);
}
int main(){
  struct sigaction action = {};
  action.sa_flags = SA_SIGINFO;//与11行匹配
  action.sa_sigaction = fa;//与10行匹配
  sigaction(SIGINT,&action,0);
  printf("pid=%d\n",getpid());
  while(1);
}

