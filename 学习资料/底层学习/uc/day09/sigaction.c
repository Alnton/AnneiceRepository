#include <stdio.h>
#include <signal.h>

void fa(int signo){
  printf("捕获了信号%d\n",signo);
  sleep(5);  }
int main(){
  struct sigaction action = {};
  action.sa_handler = fa;//指定fa信号处理函数
  sigemptyset(&action.sa_mask);//信号处理期间屏蔽的信号，信号处理期间 自动屏蔽 相同信号
  sigaddset(&action.sa_mask,SIGQUIT);
  //action.sa_flags = SA_ONESHOT;//第二次默认
  action.sa_flags = SA_NOMASK;//相同信号不屏蔽
  sigaction(SIGINT,&action,0);
  while(1);
  //pause();//等待一个信号的到来信号处理完退出
}

