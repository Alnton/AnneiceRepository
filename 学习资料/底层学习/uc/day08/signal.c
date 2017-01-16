#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
void fa(int signo){//signo就是信号值
  printf("发送了信号%d\n",signo);
  signal(signo,SIG_DFL);//信号恢复为默认处理
}
int main(){
  signal(2,SIG_IGN);//忽略信号2
  signal(3,fa);//信号3的处理方式改为调用fa()
  signal(9,fa);//信号9的处理方式无法改变
  while(1);
}

