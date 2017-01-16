#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
void fa(int signo,siginfo_t* info,void* p){
  printf("进程%d发送了信号%d,附带数据%d\n",
    info->si_pid,signo,info->si_value); }
int main(){
  struct sigaction action = {};
  action.sa_flags = SA_SIGINFO;
  action.sa_sigaction = fa;
  sigaction(/*2*/40,&action,0);//可靠信号
  pid_t pid = fork();
  if(pid == 0){
    int i;
    for(i=0;i<100;i++){
      union sigval v; v.sival_int = i;
      sigqueue(getppid(),40,v); }
    sleep(1); exit(1);  }
  while(1);
}


