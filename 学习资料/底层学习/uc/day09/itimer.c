#include <stdio.h>
#include <signal.h>
#include <sys/time.h>

void fa(int signo){
  printf("又执行了一次\n");
}
int main(){
  signal(SIGALRM,fa);
  struct itimerval timer;
  timer.it_interval.tv_sec = 1;//间隔时间
  timer.it_interval.tv_usec = 230000;
  timer.it_value.tv_sec = 5;//开始时间
  timer.it_value.tv_usec = 0;
  setitimer(ITIMER_REAL,&timer,0);
  while(1);
}
