#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void fa(int signo){
  printf("捕获了信号%d\n",signo);
  alarm(1);
}
int main(){
  signal(SIGALRM,fa);
  alarm(5);//5秒后发送SIGALRM信号
  sleep(2);
  int res = alarm(6);//返回之前没有响的闹钟的剩余秒数，如果之前没有闹钟，返回0
  printf("res=%d\n",res);
  //alarm(0);//取消之前的闹钟
  while(1);
}


