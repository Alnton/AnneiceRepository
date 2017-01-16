#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <signal.h>
int semid;
void fa(int signo){
  semctl(semid,0,IPC_RMID);
  exit(0);
}
int main(){
  signal(SIGINT,fa);
  key_t key = ftok(".",100);
  semid = semget(key,1/*数组长度*/,
    IPC_CREAT|0660);
  if(semid == -1) perror("semget"),exit(-1);
  semctl(semid,0,SETVAL,5);//最大5个同时访问
  while(1);
}//练习：用信号2(ctrl+c)删除信号量集


