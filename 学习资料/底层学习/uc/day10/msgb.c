#include <stdio.h>
#include <stdlib.h>
#include <sys/msg.h>
#include <sys/ipc.h>
#include <unistd.h>

int main(){
  key_t key = ftok(".",100);
  int msgid = msgget(key,0);
  if(msgid == -1) perror("msgget"),exit(-1);
  char buf[100] = {};
  int res = msgrcv(msgid,buf,100,0,0);
  if(res == -1) perror("msgrcv"),exit(-1);
  printf("接收了%d字节，内容:%s\n",res,buf);
}
