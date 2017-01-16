#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>

int main(){
  key_t key = ftok(".",100);
  if(key == -1) perror("ftok"),exit(-1);
  int shmid = shmget(key,4,
    IPC_CREAT|IPC_EXCL|0660);
  if(shmid == -1) perror("shmget"),exit(-1);
  void* p = shmat(shmid,0,0);
  if(p == (void*)-1) perror("shmat"),exit(-1);
  int *pi = p;
  *pi = 100;
  shmdt(p);
}//练习：写一个shmb.c，把100取出来


