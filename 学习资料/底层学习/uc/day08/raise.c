#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
void fa(int signo){
  printf("信号%d被捕获\n",signo);
}
int main(){
  signal(SIGINT,fa);
  int res = sleep(10);
  printf("res=%d\n",res);
  raise(3);//打印退出并退出进程
  while(1);
}


