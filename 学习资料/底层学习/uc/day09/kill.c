#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void fa(int signo){
  printf("捕获了信号%d\n",signo);
}
int main(){
  pid_t pid = fork();
  if(pid == 0){
    signal(50,fa);
    while(1);
  }
  printf("父进程发送信号\n");
  kill(pid,50);
}


