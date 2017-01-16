#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

void fa(int signo){
  printf("捕获了信号%d\n",signo);
}
int main(){
  signal(SIGINT,fa); signal(SIGQUIT,fa);
  signal(50,fa);
  printf("pid=%d\n",getpid());
  printf("没有信号屏蔽\n"); sleep(20);
  printf("开始信号屏蔽\n");
  sigset_t set,old;
  sigemptyset(&set);
  sigaddset(&set,SIGINT); sigaddset(&set,3);
  sigaddset(&set,50);
 sigprocmask(SIG_SETMASK,&set,&old);//屏蔽信号
  sleep(20);
  printf("信号屏蔽解除\n");
  printf("----------------\n");
  //可以获取在信号屏蔽期间，真正来过的信号
  sigset_t pend;
  sigpending(&pend);//把被屏蔽的信号存入pend
  if(sigismember(&pend,SIGINT))
    printf("信号2来过\n");
  if(sigismember(&pend,SIGQUIT))
    printf("信号3来过\n");
 sigprocmask(SIG_SETMASK,&old,NULL);//解除屏蔽
}

