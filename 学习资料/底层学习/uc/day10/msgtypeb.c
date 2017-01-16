#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/msg.h>

struct msg{
  long mtype;
  char buf[256];
}msg1;
int main(){
  key_t key = ftok(".",100);
  int msgid = msgget(key,0);
  int res = msgrcv(msgid,&msg1,sizeof(msg1)-4
    ,/*2*/0/*-2*/,0);
  printf("res=%d,buf=%s\n",res,msg1.buf); 
}
 
