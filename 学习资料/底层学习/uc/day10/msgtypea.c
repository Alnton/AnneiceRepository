#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <unistd.h>
#include <string.h>

struct msg{
  long mtype;//类型
  char buf[256];//数据区，任意类型都可以
};
int main(){
  key_t key = ftok(".",100);
  int msgid = msgget(key,IPC_CREAT|0660);
  if(msgid == -1) perror("msgget"),exit(-1);
  struct msg m1,m2;
  m1.mtype = 1; strcpy(m1.buf,"hello1");
  m2.mtype = 2; strcpy(m2.buf,"hello2");
  msgsnd(msgid,&m1,sizeof(m1)-4,0);//发送时
  msgsnd(msgid,&m2,sizeof(m2)-4,0);//不计算类型所占的空间
}

