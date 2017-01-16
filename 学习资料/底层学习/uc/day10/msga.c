#include <stdio.h>
#include <stdlib.h>
#include <sys/msg.h>
#include <sys/ipc.h>
#include <unistd.h>

int main(){
  key_t key = ftok(".",100);
  int msgid = msgget(key,IPC_CREAT|0660);
  if(msgid == -1) perror("msgget"),exit(-1);
  int res = msgsnd(msgid,"hello",5,
    0);//0代表满了等待，IPC_NOWAIT可以不等待
  if(res == -1) perror("msgsnd"),exit(-1);
  else printf("send ok!\n");
}//练习：写一个msgb.c 把队列中的消息取出来
//类型为0 即可
